package fr.montreuil.iut.CakarCassirame;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pageAccueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defender");

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }





    public static void main(String[] args) {
        launch();
    }
}