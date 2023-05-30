package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Ennemie;
import fr.montreuil.iut.CakarCassirame.modele.Tour;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TourVue {

    private Pane pane;
    public TourVue(Pane pane){
        this.pane = pane;
    }


    public void creerSprite(Tour tour) {

        Circle r;
        r = new Circle(4);
        r.setFill(Color.GREENYELLOW);

        r.translateXProperty().bind(tour.XProperty());
        r.translateYProperty().bind(tour.YProperty());
        r.setId(tour.getId());
        this.pane.getChildren().add(r);

        /*
        Image image;
        image = new Image("C:\\Users\\husey\\Downloads\\TowerDefense\\TowerDefense\\src\\main\\resources\\fr\\montreuil\\iut\\CakarCassirame\\bombeNucléaireDraw.jpg");
        ImageView imageView = new ImageView(image);
        imageView.translateXProperty().bind(tour.XProperty());
        imageView.translateYProperty().bind(tour.YProperty());
        imageView.setId(tour.getId());
        this.pane.getChildren().add(imageView);
        */
    }


}
