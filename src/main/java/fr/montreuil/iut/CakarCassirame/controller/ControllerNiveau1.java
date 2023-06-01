package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import fr.montreuil.iut.CakarCassirame.modele.*;
import fr.montreuil.iut.CakarCassirame.vue.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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

//    @FXML
//    private Button canonLaser;
//
//    @FXML
//    private Button canonMissile;
//
//    @FXML
//    private Button canonNucleaire;
//
//    @FXML
//    private Button champForce;

    @FXML
    private TilePane tilePaneInterne;

    private PlacementVue placementVue;

    private TourVue tourVue;

    private boolean placement = false;
    private EnnemiExtraterrestreVue ennemiExtraterrestreVue;
    private EnnemiVaisseauSpatialVue ennemiVaisseauSpatialVue;
    private EnnemiSuperVaisseauSpatialVue ennemiSuperVaisseauSpatialVue;
    private EnnemiGalactusBossVue ennemiGalactusBossVue;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.environnement = new Environnement();
        this.vueMap = new MapVue(this.tilePaneExterne);
      //  this.vueEnnemie = new EnnemieVue(this.pane);
        this.ennemiExtraterrestreVue = new EnnemiExtraterrestreVue(this.pane);
        this.ennemiVaisseauSpatialVue = new EnnemiVaisseauSpatialVue(this.pane);
        this.ennemiSuperVaisseauSpatialVue = new EnnemiSuperVaisseauSpatialVue(this.pane);
        this.ennemiGalactusBossVue = new EnnemiGalactusBossVue(this.pane);
        this.tourVue = new TourVue(pane);
        this.placementVue = new PlacementVue(tilePaneInterne);


        try {
            this.vueMap.creerMap(this.environnement.getMap());
            initAnimation();
            gameLoop.play();
            ListChangeListener<Ennemi> listenerEnnemie =  new ListChangeListener<Ennemi>() {
                @Override
                public void onChanged(Change<? extends Ennemi> change) {
                    while (change.next()) {
                        for(Ennemi ennemie : change.getAddedSubList()){
                            try {
//                                vueEnnemie.creerSprite(ennemie);
                                if(ennemie instanceof EnnemiExtraterrestre)
                                    ennemiExtraterrestreVue.creerSprite(ennemie);
                                else if(ennemie instanceof EnnemiVaisseauSpatial)
                                    ennemiVaisseauSpatialVue.creerSprite(ennemie);
                                else if (ennemie instanceof EnnemiSuperVaisseauSpatial)
                                    ennemiSuperVaisseauSpatialVue.creerSprite(ennemie);
                                else
                                    ennemiGalactusBossVue.creerSprite(ennemie);
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        for(Ennemi ennemie : change.getRemoved()){
                            pane.getChildren().remove(pane.lookup("#" + ennemie.getId()));

                        }
                    }
                }
            };
            this.environnement.getListeEnnemis().addListener(listenerEnnemie);


            ListChangeListener<Tour> listenerTours =  new ListChangeListener<Tour>() {
                @Override
                public void onChanged(Change<? extends Tour> change) {
                    while (change.next()) {
                        for(Tour tour : change.getAddedSubList()){
                            tourVue.creerSprite(tour);
                        }
                    }
                }
            };
            this.environnement.getListeTours().addListener(listenerTours);





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void initAnimation() {
        gameLoop = new Timeline();
        temps=0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.03),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev ->{
                    if(environnement.getNbEnnemiTue() == environnement.getNbEnnemiMax()){
                        System.out.println("fini");
                        gameLoop.stop();
                    } else if (temps%3 == 0) {
                        environnement.deplacement();

                    } else if (temps%23==0){
                        if(this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax()) {
                            environnement.ajouterEnnemie();
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

    @FXML
    public void affichagePlacement() throws FileNotFoundException {
        this.placementVue.affichage(this.environnement.getMap());
        this.placement = true;

    }


    @FXML
    public void placerTour(MouseEvent mouseEvent){
        double positionX = mouseEvent.getX();
        double positionY = mouseEvent.getY();
        if (positionY > -1 && positionY < 641 && positionX > -1 && positionX < 961) {
            if(this.environnement.getMap().getTile((int)positionY/32, (int)positionX/32) == 3 && placement){
                this.environnement.ajouterTour(positionX, positionY);

                this.placementVue.reset();

            }
        }
        placement = false;

    }



}


