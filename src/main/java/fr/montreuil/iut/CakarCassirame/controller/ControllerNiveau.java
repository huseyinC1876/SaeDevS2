package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import fr.montreuil.iut.CakarCassirame.modele.*;
import fr.montreuil.iut.CakarCassirame.modele.tours.*;
import fr.montreuil.iut.CakarCassirame.vue.*;
import fr.montreuil.iut.CakarCassirame.vue.ennemiVue.*;
import fr.montreuil.iut.CakarCassirame.vue.infobulleVue.InfoBulleBoutonsTours;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileBombeNuclaireVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileBombeNucleaireExplosionVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileMissileVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonBombeNucleaireVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonMissileVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourChampDeForceVue;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/*
import java.io.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

 */


public class ControllerNiveau implements Initializable {


    private Environnement environnement;

    @FXML
    private TilePane tilePaneExterne;

    @FXML
    private TilePane tilePaneBombe;

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
    private EnnemiDiviseVue ennemiDiviseVue;
    private EnnemiGalactusBossVue ennemiGalactusBossVue;
    private ProjectileMissileVue projectileMissileVue;
    private ProjectileLaserVue projectileLaserVue;
    private ProjectileBombeNuclaireVue projectileBombeNuclaireVue;
    private ProjectileBombeNucleaireExplosionVue projectileBombeNucleaireExplosionVue;
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
    private double oldGameloopFrame;

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

    private EnnemieVaisseauSpatialDiviseVue ennemieVaisseauSpatialDiviseVue;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.environnement = new Environnement(ControllerSelectionNiveau.choixNiveau);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.vueMap = new MapVue(this.tilePaneExterne);
        this.ennemiExtraterrestreVue = new EnnemiExtraterrestreVue(this.pane);
        this.ennemiVaisseauSpatialVue = new EnnemiVaisseauSpatialVue(this.pane);
        this.ennemiSuperVaisseauSpatialVue = new EnnemiSuperVaisseauSpatialVue(this.pane);
        this.ennemiDiviseVue = new EnnemiDiviseVue(pane);
        this.ennemiGalactusBossVue = new EnnemiGalactusBossVue(this.pane);
        this.tourCanonLaserVue = new TourCanonLaserVue(pane);
        this.tourCanonMissileVue = new TourCanonMissileVue(pane);
        this.tourCanonBombeNucleaireVue = new TourCanonBombeNucleaireVue(pane);
        this.tourChampDeForceVue = new TourChampDeForceVue(pane);
        this.placementVue = new PlacementVue(tilePaneInterne);
        this.nbEnnemiMax.textProperty().bind(this.environnement.getNbEnnemiMaxProperty().asString());
        this.nbEnnemiTue.textProperty().bind(this.environnement.getNbEnnemiTueProperty().asString());
        this.ennemieVaisseauSpatialDiviseVue = new EnnemieVaisseauSpatialDiviseVue(pane);

//        this.infoBulleBoutonsTours = new InfoBulleBoutonsTours(canonLaser, canonMissile, champForce, canonNucleaire);
        menuAmelioration1.setVisible(false);
        menuAmelioration2.setVisible(false);
        this.projectileBombeNuclaireVue = new ProjectileBombeNuclaireVue(pane);
        this.projectileLaserVue = new ProjectileLaserVue(pane);
        this.projectileMissileVue = new ProjectileMissileVue(pane);
        this.projectileBombeNucleaireExplosionVue = new ProjectileBombeNucleaireExplosionVue(tilePaneBombe);
        this.environnement.getListeTours().addListener(new ObsTours(pane));
        this.environnement.getListeEnnemis().addListener(new ObsEnnemis(pane));
        this.environnement.getListeProjectiles().addListener(new ObsProjectiles(pane, tilePaneBombe));
        //this.oldGameloopFrame = 0;


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

            prixCanonLaser.textProperty().bind(Parametre.prixTourCanonLaser.asString());
            prixCanonMissile.textProperty().bind(Parametre.prixTourCanonMissile.asString());
            prixChampDeForce.textProperty().bind(Parametre.prixTourChampForce.asString());
            prixCanonNucleaire.textProperty().bind(Parametre.prixTourCanonNucleaire.asString());
            nbRessources.textProperty().bind(this.environnement.getRessource().asString());
            prixAmeliorationLaser.textProperty().bind(Parametre.prixAmeliorationCanonLaser.add(Parametre.prixAmeliorationCanonLaser.getValue() * Math.pow (2, this.environnement.getNiveauCanonLaser() - 1)).asString());
            prixAmeliorationMissile.textProperty().bind(Parametre.prixTourCanonMissile.add(Parametre.prixTourCanonMissile.getValue() * Math.pow (2,this.environnement.getNiveauCanonMissile() - 1)).asString());


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
//                        try {
//                            chargerPageAcceuil();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
                        enter = true;
                        this.finPartie.setText("Victory");
                        this.finPartie.setVisible(true);
                        temps = 0;


                    } else if (this.environnement.getVieProperty().getValue() > 0) {

                        if (this.environnement.getListeTours().size() != 0) {
                            for (int i = 0; i < this.environnement.getListeTours().size(); i++) {
                                if (this.environnement.getListeTours().get(i) instanceof TourTeteChercheuse) {
                                    if (temps % ((TourTeteChercheuse) this.environnement.getListeTours().get(i)).getTempsRecharge() == 0 && temps != 0) {
                                        System.out.println("RECHERCHE CIBLE ENVIRONNEMENT");
                                        ((TourTeteChercheuse) this.environnement.getListeTours().get(i)).recupererEnnemiCible(temps);
                                        oldGameloopFrame = this.gameLoop.getCurrentRate();
                                    }
                                }
                                if (this.environnement.getListeTours().get(i) instanceof TourCanonBombeNuclaire) {
                                    if (temps % TourCanonBombeNuclaire.tempsRecharge.getValue() == 0 && temps != 0) {
                                        this.environnement.ajouterProjectile(3, this.environnement.getListeTours().get(i).XProperty().getValue(), this.environnement.getListeTours().get(i).YProperty().getValue());
//                                        System.out.println("ajouter proj 3 controller");
//                                            }
//                                        }
//                                    }
                                    }
                                }
                            }
                        }


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
                                environnement.ajouterEnnemi();
                            }
                        } else if (temps % 500 == 0 && temps != 0 && this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax()) {
                            System.out.println("VAGUE VAGUE VAGUE");
                            this.environnement.ajouterVagueEnnemis();
                        }
                        if(temps % 100 == 0){
                            this.tilePaneBombe.getChildren().removeAll();
                        }
                    } else if (this.environnement.getVieProperty().getValue() < 1 || this.environnement.getNbEnnemiTue() == this.environnement.getNbEnnemiMax()) {
                        if (temps > 100) {
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

    public void pause() {
        if (arretTemps)
            arretTemps = false;
        else {
            arretTemps = true;

        }
        if (gameLoop.getStatus() == Animation.Status.RUNNING) {
            gameLoop.pause();
        } else
            gameLoop.play();
    }

    public void affichageMenuAmelioration() {
        if (!affichageMenu) {
            menuAmelioration1.setVisible(true);
            menuAmelioration2.setVisible(true);
            affichageMenu = true;

        } else {
            menuAmelioration1.setVisible(false);
            menuAmelioration2.setVisible(false);
            affichageMenu = false;
        }
    }

    public void AffichageBoutonAmelioration(){
        if(this.environnement.getRessource().getValue() < Parametre.prixAmeliorationCanonLaser.getValue() * Math.pow(2, this.environnement.getNiveauCanonLaser() - 1)){
            ameliorationCanonLaser.setDisable(true);
        } else {
            ameliorationCanonLaser.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixAmeliorationCanonMissile.getValue() * Math.pow(2, this.environnement.getNiveauCanonMissile() - 1)){
            ameliorationCanonMissile.setDisable(true);
        } else {
            ameliorationCanonMissile.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixAmeliorationCanonNucleaire.getValue() * Math.pow(2, this.environnement.getNiveauCanonNucleaire() - 1)){
            ameliorationCanonNucleaire.setDisable(true);
        }
        else{
            ameliorationCanonNucleaire.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixAmeliorationChampForce.getValue() * Math.pow(2, this.environnement.getNiveauChampForce() - 1)){
            ameliorationChampDeForce.setDisable(true);
        }
        else{
            ameliorationChampDeForce.setDisable(false);
        }
    }

    public void AffichageBoutonTours(){
        if(this.environnement.getRessource().getValue() < Parametre.prixTourCanonLaser.getValue()){
            canonLaser.setDisable(true);
        } else {
            canonLaser.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixTourCanonMissile.getValue()){
            canonMissile.setDisable(true);
        } else {
            canonMissile.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixTourCanonNucleaire.getValue()){
            canonNucleaire.setDisable(true);
        } else {
            canonNucleaire.setDisable(false);
        }
        if(this.environnement.getRessource().getValue() < Parametre.prixTourChampForce.getValue()){
            champForce.setDisable(true);
        } else {
            champForce.setDisable(false);
        }
    }


    public void ameliorationTours() {
        int choix = (ameliorationCanonLaser.isArmed()) ? 1 : (ameliorationCanonMissile.isArmed()) ? 2 : (ameliorationCanonNucleaire.isArmed()) ? 3 : 4;
        if (choix == 1)
            this.environnement.ameliorationTour(choix);
        else if (choix == 2)
            this.environnement.ameliorationTour(choix);
        else if (choix == 3)
            this.environnement.ameliorationTour(choix);
        else
            this.environnement.ameliorationTour(choix);
    }


    @FXML
    public void affichagePlacement() throws FileNotFoundException {
        if (!arretTemps) {
            choixTour = (canonLaser.isArmed()) ? 1 : (canonMissile.isArmed()) ? 2 : (canonNucleaire.isArmed()) ? 3 : 4;
            int prix;
            if(choixTour == 1)
                prix = Parametre.prixTourCanonLaser.getValue();
            else if (choixTour == 2)
                prix = Parametre.prixTourCanonMissile.getValue();
            else if (choixTour == 3)
                prix = Parametre.prixTourCanonNucleaire.getValue();
            else
                prix = Parametre.prixTourChampForce.getValue();

            //int prix = (choixTour == 1) ? Parametre.prixTourCanonLaser.getValue() : (choixTour == 2) ? TourCanonMissile.prixT.getValue() : (choixTour == 3) ? TourCanonBombeNuclaire.prixT.getValue() : TourChampDeForce.prixT.getValue();
            if (this.environnement.getRessource().getValue() >= prix) {
                this.placementVue.affichaged();
                this.placement = true;

            }
        }
    }

    @FXML
    public void placerTour(MouseEvent mouseEvent) {
        if (!arretTemps) {
            double positionX = mouseEvent.getX();
            double positionY = mouseEvent.getY();
            if (positionY > -1 && positionY <= tilePaneInterne.getHeight() && positionX > -1 && positionX <= tilePaneInterne.getWidth()) {
                if (this.environnement.getMap().getTile((int) positionY / 32, (int) positionX / 32) == 3 && placement) {
                    positionX = ((int) positionX / 32) * 32;
                    positionY = ((int) positionY / 32) * 32;
                    if (this.environnement.verificationPlacement(positionX, positionY) == true) {
                        this.environnement.ajouterTour((int)positionX + 16, (int)positionY + 16, this.choixTour);
                        int prix;
                        if(choixTour == 1)
                            prix = Parametre.prixTourCanonLaser.getValue();
                        else if (choixTour == 2)
                            prix = Parametre.prixTourCanonMissile.getValue();
                        else if (choixTour == 3)
                            prix = Parametre.prixTourCanonNucleaire.getValue();
                        else
                            prix = Parametre.prixTourChampForce.getValue();
                        this.environnement.getRessource().setValue(this.environnement.getRessource().getValue() - prix);
                    }

                }
            }
            this.placementVue.reset();
            placement = false;
        }

    }
}


