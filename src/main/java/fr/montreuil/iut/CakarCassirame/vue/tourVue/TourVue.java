package fr.montreuil.iut.CakarCassirame.vue.tourVue;

import fr.montreuil.iut.CakarCassirame.modele.tours.Tour;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class TourVue {

    Pane pane;

    private String file;
    public TourVue(Pane pane, String file){
        this.pane = pane;
        this.file = file;
    }

    public void creerSprite(Tour tour) throws FileNotFoundException {
        ImageView imageViewsTour = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsTour.setId(tour.getId());
        imageViewsTour.translateXProperty().bind(tour.XProperty().subtract(16));
        imageViewsTour.translateYProperty().bind(tour.YProperty().subtract(16));
        imageViewsTour.setFitWidth(32);
        imageViewsTour.setFitHeight(32);
        this.pane.getChildren().add(imageViewsTour);

//        Circle r;
//        r = new Circle(tour.getRayonPerimetreAction());
//        r.setFill(Color.DARKBLUE);
//        r.setOpacity(0.3);
//        r.translateXProperty().bind(tour.XProperty());
//        r.translateYProperty().bind(tour.YProperty());
//        r.setId(tour.getId());
//        this.pane.getChildren().add(r);

    }

}
