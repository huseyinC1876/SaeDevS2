package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.TourPerimetre;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileNotFoundException;

public class TourPerimetreVue extends TourVue{


    public TourPerimetreVue(Pane pane, String file) {
        super(pane, file);
    }

    public void creerSprite(TourPerimetre tour) throws FileNotFoundException {

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
