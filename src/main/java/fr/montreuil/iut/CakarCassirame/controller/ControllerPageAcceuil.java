package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPageAcceuil implements Initializable {

    @FXML
    private Pane paneExterne;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void quitter(){
        Platform.exit();
    }

    public void chargerPageNiveau() throws IOException {
        Scene scene = paneExterne.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerSelectionNiveau.load(stage);
    }

    public static void load(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageAcceuil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defencer");
        stage.setScene(scene);
        stage.show();
    }





}
