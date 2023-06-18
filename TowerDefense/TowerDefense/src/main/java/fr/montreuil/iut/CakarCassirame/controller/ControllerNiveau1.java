package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import fr.montreuil.iut.CakarCassirame.modele.Ennemie;
import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.vue.EnnemieVue;
import fr.montreuil.iut.CakarCassirame.vue.MapVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private Button canonLaser;

    @FXML
    private Button canonMissile;

    @FXML
    private Button canonNucleaire;

    @FXML
    private Button champForce;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.environnement = new Environnement();
        this.vueMap = new MapVue(this.tilePaneExterne);
        this.vueEnnemie = new EnnemieVue(this.pane);

        try {
            this.vueMap.creerMap(this.environnement.getMap());
            initAnimation();
            gameLoop.play();
            ListChangeListener<Ennemie> listenerEnnemie =  new ListChangeListener<Ennemie>() {
                @Override
                public void onChanged(Change<? extends Ennemie> change) {
                    while (change.next()) {
                        for(Ennemie ennemie : change.getAddedSubList()){
                            vueEnnemie.creerSprite(ennemie);
                        }
                        for(Ennemie ennemie : change.getRemoved()){
                            pane.getChildren().remove(pane.lookup("#" + ennemie.getId()));

                        }
                    }
                }
            };
            this.environnement.getListeEnnemis().addListener(listenerEnnemie);


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
                    if(environnement.getNbEnnemieTue() == environnement.getNbEnnnemieMax()){
                        System.out.println("fini");
                        gameLoop.stop();
                    } else if (temps%3 == 0) {
                        environnement.deplacement();

                    } else if (temps%5==0){
                        if(this.environnement.getNbEnnemieSpawn() < this.environnement.getNbEnnnemieMax()) {
                            System.out.println("un tour");

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



}

