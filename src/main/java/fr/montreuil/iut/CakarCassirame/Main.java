package fr.montreuil.iut.CakarCassirame;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pageAccueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defender");
        stage.setResizable(false);
        System.out.println(Platform.isSupported(ConditionalFeature.MEDIA));
        stage.setScene(scene);
        stage.show();

//         media = new Media(file.toURI().toString());

        /*
        File file = new File("C:\\Users\\Public\\Music\\Sample Music\\Kalimba.mp3");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
         */


        /*
        Media media = new Media();
        MediaPlayer mediaPlayeur = new MediaPlayer();

        */



//        String ssound = "sound.mp3";
//        Media sound = new Media(ssound);
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch();
    }
}