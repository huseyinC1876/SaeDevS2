package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSelectionNiveau implements Initializable {

    @FXML
    private Pane paneExterneSelection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void chargerPageAccueil() throws IOException {
        Scene scene = paneExterneSelection.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerPageAcceuil.load(stage);

    }

    public void chargerNiveau1() throws IOException {
        Scene scene = paneExterneSelection.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerNiveau1.load(stage);

    }

    public void chargerNiveau2() throws IOException {
        Scene scene = paneExterneSelection.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerNiveau2.load(stage);

    }

    public static void load(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pageChoixNiveau.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defencer");
        stage.setScene(scene);
        stage.show();
    }
}
