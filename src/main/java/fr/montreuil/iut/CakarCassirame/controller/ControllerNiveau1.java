package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import fr.montreuil.iut.CakarCassirame.modele.*;
import fr.montreuil.iut.CakarCassirame.vue.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedReader;
import java.net.URL;
import java.util.ResourceBundle;
/*
import java.io.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

 */


public class ControllerNiveau1 implements Initializable {


    private Environnement environnement;

    @FXML
    private TilePane tilePaneExterne;

    @FXML
    private Pane pane;

    private Timeline gameLoop;

    private int temps;

    private MapVue vueMap;

    private EnnemieVue vueEnnemie;

    @FXML
    private Button canonLaser;

    @FXML
    private Button canonMissile;

    @FXML
    private Button canonNucleaire;

    @FXML
    private Button champForce;

    @FXML
    private TilePane tilePaneInterne;

    private PlacementVue placementVue;

    private TourCanonLaserVue tourCanonLaserVue;
    private TourChampDeForceVue tourChampDeForceVue;
    private TourCanonMissileVue tourCanonMissileVue;
    private TourCanonBombeNucleaireVue tourCanonBombeNucleaireVue;

    private boolean placement = false;
    private EnnemiExtraterrestreVue ennemiExtraterrestreVue;
    private EnnemiVaisseauSpatialVue ennemiVaisseauSpatialVue;
    private EnnemiSuperVaisseauSpatialVue ennemiSuperVaisseauSpatialVue;
    private EnnemiGalactusBossVue ennemiGalactusBossVue;
    private boolean vague = false;


    @FXML
    private Label prixCanonLaser;

    @FXML
    private Label prixCanonMissile;

    @FXML
    private Label prixChampDeForce;

    @FXML
    private Label prixCanonNucleaire;

    @FXML
    private Label nbRessources;

    @FXML
    private HBox hboxVie;

    @FXML
    private Label nbEnnemiTue;

    @FXML
    private Label nbEnnemiMax;

    @FXML
    private Label finPartie;

    private boolean enter = false;
    //private AudioInputStream media;
    private int choixTour = 0;

    private InfoBulleBoutonsTours infoBulleBoutonsTours;

    private boolean arretTemps = false;

    @FXML
    private HBox menuAmelioration1;

    @FXML
    private HBox menuAmelioration2;

    private boolean affichageMenu = false;

    @FXML
    private Button ameliorationCanonLaser;

    @FXML
    private Button ameliorationCanonMissile;

    @FXML
    private Button ameliorationChampDeForce;

    @FXML
    private Button ameliorationCanonNucleaire;

    @FXML
    private Label prixAmeliorationLaser;

    @FXML
    private Label prixAmeliorationMissile;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.environnement = new Environnement();
        this.vueMap = new MapVue(this.tilePaneExterne);
        //  this.vueEnnemie = new EnnemieVue(this.pane);
        this.ennemiExtraterrestreVue = new EnnemiExtraterrestreVue(this.pane);
        this.ennemiVaisseauSpatialVue = new EnnemiVaisseauSpatialVue(this.pane);
        this.ennemiSuperVaisseauSpatialVue = new EnnemiSuperVaisseauSpatialVue(this.pane);
        this.ennemiGalactusBossVue = new EnnemiGalactusBossVue(this.pane);
        this.tourCanonLaserVue = new TourCanonLaserVue(pane);
        this.tourCanonMissileVue = new TourCanonMissileVue(pane);
        this.tourCanonBombeNucleaireVue = new TourCanonBombeNucleaireVue(pane);
        this.tourChampDeForceVue = new TourChampDeForceVue(pane);
        this.placementVue = new PlacementVue(tilePaneInterne);
        this.nbEnnemiMax.textProperty().bind(this.environnement.getNbEnnemiMaxProperty().asString());
        this.nbEnnemiTue.textProperty().bind(this.environnement.getNbEnnemiTueProperty().asString());
        this.infoBulleBoutonsTours = new InfoBulleBoutonsTours(canonLaser,canonMissile,champForce,canonNucleaire);
        menuAmelioration1.setVisible(false);
        menuAmelioration2.setVisible(false);
        Tooltip tooltip = new Tooltip("atq -> 100");
        //tooltip.setText("atq -> 100");
        //this.canonLaser.setTooltip(tooltip);
        try {
            this.placementVue.affichage(this.environnement.getMap());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.placementVue.reset();


        try {
            this.vueMap.creerMap(this.environnement.getMap());
            initAnimation();
            gameLoop.play();
            ListChangeListener<Ennemi> listenerEnnemie = new ListChangeListener<Ennemi>() {
                @Override
                public void onChanged(Change<? extends Ennemi> change) {
                    while (change.next()) {
                        for (Ennemi ennemi : change.getAddedSubList()) {
                            try {
                                if (ennemi instanceof EnnemiExtraterrestre)
                                    ennemiExtraterrestreVue.creerSprite(ennemi);
                                else if (ennemi instanceof EnnemiVaisseauSpatial)
                                    ennemiVaisseauSpatialVue.creerSprite(ennemi);
                                else if (ennemi instanceof EnnemiSuperVaisseauSpatial)
                                    ennemiSuperVaisseauSpatialVue.creerSprite(ennemi);
                                else
                                    ennemiGalactusBossVue.creerSprite(ennemi);
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        for (Ennemi ennemie : change.getRemoved()) {
                            pane.getChildren().remove(pane.lookup("#" + ennemie.getId()));

                        }
                    }
                }
            };
            this.environnement.getListeEnnemis().addListener(listenerEnnemie);


            ListChangeListener<Tour> listenerTours = new ListChangeListener<Tour>() {
                @Override
                public void onChanged(Change<? extends Tour> change) {
                    while (change.next()) {
                        for (Tour tour : change.getAddedSubList()) {
                            if (tour instanceof TourCanonLaser) {
                                try {
                                    tourCanonLaserVue.creerSprite(tour);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            else if (tour instanceof TourCanonMissile) {
                                try {
                                    tourCanonMissileVue.creerSprite(tour);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            else if (tour instanceof TourCanonBombeNuclaire) {
                                try {
                                    tourCanonBombeNucleaireVue.creerSprite(tour);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            else {
                                try {
                                    tourChampDeForceVue.creerSprite(tour);
                                } catch (FileNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            };
            this.environnement.getListeTours().addListener(listenerTours);

            prixCanonLaser.textProperty().bind(TourCanonLaser.prixT.asString());
            prixCanonMissile.textProperty().bind(TourCanonMissile.prixT.asString());
            prixChampDeForce.textProperty().bind(TourChampDeForce.prixT.asString());
            prixCanonNucleaire.textProperty().bind(TourCanonBombeNuclaire.prixT.asString());
            nbRessources.textProperty().bind(this.environnement.getRessource().asString());
            prixAmeliorationLaser.textProperty().bind(TourCanonLaser.prixA.asString());
            prixAmeliorationMissile.textProperty().bind(TourCanonMissile.prixA.asString());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (environnement.getNbEnnemiTue() == environnement.getNbEnnemiMax() && enter == false) {
                        System.out.println("fini");
                        enter = true;
                        this.finPartie.setText("Victory");
                        this.finPartie.setVisible(true);
                        temps = 0;


                    } else if (this.environnement.getVieProperty().getValue() > 0) {
                        if (temps % 3 == 0) {
                            this.environnement.unTour();
                            AffichageBoutonAmelioration();
                            AffichageBoutonTours();

                            if (this.environnement.getVieProperty().getValue() < 3) {
                                this.hboxVie.getChildren().get(-(this.environnement.getVieProperty().getValue() + 1 - 3)).setVisible(false);
                            }
                            if (this.environnement.getVieProperty().getValue() < 1) {
                                this.finPartie.setText("You Dead");
                                this.finPartie.setAlignment(Pos.CENTER);
                                this.finPartie.setVisible(true);
                                temps = 0;
                            }
                        } else if (temps % 23 == 0) {
                            if (this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax()) {
                                environnement.ajouterEnnemie();
                            }
                        } else if (temps % 500 == 0 && temps != 0 && this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax()) {
                            System.out.println("VAGUE VAGUE VAGUE");
                            this.environnement.ajouterVagueEnnemis();
                        }
                    } else if (this.environnement.getVieProperty().getValue() < 1 || this.environnement.getNbEnnemiTue() == this.environnement.getNbEnnemiMax()) {
                        if (temps > 500) {
                            try {
                                chargerPageAcceuil();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            gameLoop.stop();
                        }
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);


    }


    public void chargerPageAcceuil() throws IOException {
        Scene scene = pane.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerPageAcceuil.load(stage);

    }

    public static void load(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageNiveau1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defencer");
        stage.setScene(scene);
        stage.show();
    }

    public void pause(){
        if(arretTemps)
            arretTemps = false;
        else {
            arretTemps = true;

        }
        if(gameLoop.getStatus() == Animation.Status.RUNNING){
            gameLoop.pause();
        }
        else
            gameLoop.play();
    }

    public void affichageMenuAmelioration(){
        if(!affichageMenu) {
            menuAmelioration1.setVisible(true);
            menuAmelioration2.setVisible(true);
            affichageMenu = true;

        }
        else{
            menuAmelioration1.setVisible(false);
            menuAmelioration2.setVisible(false);
            affichageMenu = false;
        }
    }

    public void AffichageBoutonAmelioration(){
        if(this.environnement.getRessource().getValue() < TourCanonLaser.prixA.getValue()){
            ameliorationCanonLaser.setDisable(true);
        }
        else{
            ameliorationCanonLaser.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < TourCanonMissile.prixA.getValue()){
            ameliorationCanonMissile.setDisable(true);
        }
        else{
            ameliorationCanonMissile.setDisable(false);
        }
    }

    public void AffichageBoutonTours(){
        if(this.environnement.getRessource().getValue() < TourCanonLaser.prixT.getValue()){
            canonLaser.setDisable(true);
        }
        else{
            canonLaser.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < TourCanonMissile.prixT.getValue()){
            canonMissile.setDisable(true);
        }
        else{
            canonMissile.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < TourCanonBombeNuclaire.prixT.getValue()){
            canonNucleaire.setDisable(true);
        }
        else{
            canonNucleaire.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < TourChampDeForce.prixT.getValue()){
            champForce.setDisable(true);
        }
        else{
            champForce.setDisable(false);
        }
    }


    public void ameliorationTours(){
        int choix = (ameliorationCanonLaser.isArmed()) ? 1 : (ameliorationCanonMissile.isArmed()) ? 2 : (ameliorationCanonNucleaire.isArmed()) ? 3 : 4;
        if(choix == 1)
            this.environnement.ameliorationTour(choix);
        else if(choix == 2)
            this.environnement.ameliorationTour(choix);
        else if (choix == 3)
            this.environnement.ameliorationTour(choix);
        else
            this.environnement.ameliorationTour(choix);
    }



    @FXML
    public void affichagePlacement() throws FileNotFoundException {
        if(!arretTemps) {
            choixTour = (canonLaser.isArmed()) ? 1 : (canonMissile.isArmed()) ? 2 : (canonNucleaire.isArmed()) ? 3 : 4;
            int prix = (choixTour == 1) ? TourCanonLaser.prixT.getValue() : (choixTour == 2) ? TourCanonMissile.prixT.getValue() : (choixTour == 3) ? TourCanonBombeNuclaire.prixT.getValue() : TourChampDeForce.prixT.getValue();
            if (this.environnement.getRessource().getValue() >= prix) {
                this.placementVue.affichaged();
                this.placement = true;

            }
        }
    }

    @FXML
    public void placerTour(MouseEvent mouseEvent) {
<<<<<<< HEAD
        if (!arretTemps) {
            double positionX = mouseEvent.getX();
            double positionY = mouseEvent.getY();
            if (positionY > -1 && positionY <= tilePaneInterne.getHeight() && positionX > -1 && positionX <= tilePaneInterne.getWidth()) {
                if (this.environnement.getMap().getTile((int) positionY / 32, (int) positionX / 32) == 3 && placement) {
                    positionX = ((int) positionX / 32) * 32;
                    positionY = ((int) positionY / 32) * 32;
                    if (this.environnement.verificationPlacement(positionX, positionY) == true) {
                        this.environnement.ajouterTour(positionX, positionY, this.choixTour);
                        int prix = (choixTour == 1) ? TourCanonLaser.prixT.getValue() : (choixTour == 2) ? TourCanonMissile.prixT.getValue() : (choixTour == 3) ? TourCanonBombeNuclaire.prixT.getValue() : TourChampDeForce.prixT.getValue();
                        this.environnement.getRessource().setValue(this.environnement.getRessource().getValue() - prix);
                    }
=======
        double positionX = mouseEvent.getX();
        double positionY = mouseEvent.getY();
        if (positionY > -1 && positionY <= tilePaneInterne.getHeight() && positionX > -1 && positionX <= tilePaneInterne.getWidth()) {
            if (this.environnement.getMap().getTile((int) positionY / 32, (int) positionX / 32) == 3 && placement) {
                positionX = ((int) positionX / 32) * 32;
                positionY = ((int) positionY / 32) * 32;
                if (this.environnement.verificationPlacement(positionX, positionY) == true) {
                    this.environnement.ajouterTour(positionX+16, positionY+16, this.choixTour);
                    this.environnement.getRessource().setValue(this.environnement.getRessource().getValue() - Tour.prix.getValue());
>>>>>>> c169cbce69f1aa029e4ec5b854e398af4b4ac8bb
                }
            }
            this.placementVue.reset();
            placement = false;
        }

    }


}


