package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Ennemie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EnnemieVue {

    private Pane pane;

    public EnnemieVue(Pane pane){
        this.pane = pane;
    }


    public void creerSprite(Ennemie ennemie) throws FileNotFoundException {
        /*
        Circle r;
        r = new Circle(3);
        r.setFill(Color.RED);

        r.translateXProperty().bind(ennemie.XProperty());
        r.translateYProperty().bind(ennemie.YProperty());
        r.setId(ennemie.getId());
        this.pane.getChildren().add(r);


         */
        ImageView imageViewsSpaceChip = new ImageView(new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/vaisseau32.png")));
        imageViewsSpaceChip.setId(ennemie.getId());
        imageViewsSpaceChip.translateXProperty().bind(ennemie.XProperty());
        imageViewsSpaceChip.translateYProperty().bind(ennemie.YProperty());
        this.pane.getChildren().add(imageViewsSpaceChip);
    }

}