package fr.montreuil.iut.CakarCassirame.vue.tourVue;

import fr.montreuil.iut.CakarCassirame.modele.tours.TourPerimetre;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;

public class TourCanonLaserVue extends TourPerimetreVue{

    public TourCanonLaserVue(Pane pane) {
        super(pane, "src/main/resources/fr/montreuil/iut/CakarCassirame/canonLaser.png");
    }
}
