package fr.montreuil.iut.CakarCassirame.vue.tourVue;

import fr.montreuil.iut.CakarCassirame.modele.tours.TourPerimetre;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;

public class TourCanonMissileVue extends TourPerimetreVue{
    public TourCanonMissileVue(Pane pane) {
        super(pane, "src/main/resources/fr/montreuil/iut/CakarCassirame/canonMissile.jpg");
    }

    public void creerSpritePerimetre(TourPerimetre tour) throws FileNotFoundException {

        Circle r;
        r = new Circle(tour.getRayonPerimetreAction());
        r.setFill(Color.DARKBLUE);
        r.setOpacity(0.3);
        r.translateXProperty().bind(tour.XProperty());
        r.translateYProperty().bind(tour.YProperty());
        r.setId(tour.getId());
        this.pane.getChildren().add(r);
    }
}
