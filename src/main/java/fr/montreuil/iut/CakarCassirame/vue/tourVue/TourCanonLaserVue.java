package fr.montreuil.iut.CakarCassirame.vue.tourVue;

import javafx.scene.layout.Pane;

public class TourCanonLaserVue extends TourPerimetreVue{

    public TourCanonLaserVue(Pane pane) {
        super(pane, "src/main/resources/fr/montreuil/iut/CakarCassirame/canonLaser.png");
    }
    /*

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

     */
}
