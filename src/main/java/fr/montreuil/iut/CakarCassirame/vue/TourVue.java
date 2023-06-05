package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Ennemi;
import fr.montreuil.iut.CakarCassirame.modele.Tour;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class TourVue {

    private Pane pane;

    private String file;
    public TourVue(Pane pane, String file){
        this.pane = pane;
        this.file = file;
    }


//    public void creerSprite(Tour tour) {
//
//        Circle r;
//        r = new Circle(4);
//        r.setFill(Color.GREENYELLOW);
//
//        r.translateXProperty().bind(tour.XProperty());
//        r.translateYProperty().bind(tour.YProperty());
//        r.setId(tour.getId());
//        this.pane.getChildren().add(r);
//
//    }

    public void creerSprite(Tour tour) throws FileNotFoundException {
        ImageView imageViewsTour = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsTour.setId(tour.getId());
        imageViewsTour.translateXProperty().bind(tour.XProperty());
        imageViewsTour.translateYProperty().bind(tour.YProperty());
        imageViewsTour.setFitWidth(32);
        imageViewsTour.setFitHeight(32);
        this.pane.getChildren().add(imageViewsTour);
    }


}
