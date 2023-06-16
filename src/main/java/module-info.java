module com.application.towerdefense {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.media;

    opens fr.montreuil.iut.CakarCassirame to javafx.fxml;
    exports fr.montreuil.iut.CakarCassirame;
    exports fr.montreuil.iut.CakarCassirame.controller;
    opens fr.montreuil.iut.CakarCassirame.controller to javafx.fxml;
}