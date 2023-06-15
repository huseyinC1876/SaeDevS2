package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSelectionNiveau implements Initializable {

    @FXML
    private Pane paneExterneSelection;
    public static int choixNiveau;
    @FXML
    private Button boutonNiveau1;
    @FXML
    private Button boutonNiveau2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void chargerPageAccueil() throws IOException {
        Scene scene = paneExterneSelection.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerPageAcceuil.load(stage);
    }

    public void chargerNiveau() throws IOException {
        if(boutonNiveau1.isArmed())
            choixNiveau = 1;
        else if (boutonNiveau2.isArmed()) {
            choixNiveau = 2;
        }
        Scene scene = paneExterneSelection.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerNiveau.load(stage);
    }

    public static void load(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pageChoixNiveau.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defender");
        stage.setScene(scene);
        stage.show();
    }
}
