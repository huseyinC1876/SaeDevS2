module com.application.towerdefense {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.montreuil.iut.CakarCassirame to javafx.fxml;
    exports fr.montreuil.iut.CakarCassirame;
    exports fr.montreuil.iut.CakarCassirame.controller;
    opens fr.montreuil.iut.CakarCassirame.controller to javafx.fxml;
}