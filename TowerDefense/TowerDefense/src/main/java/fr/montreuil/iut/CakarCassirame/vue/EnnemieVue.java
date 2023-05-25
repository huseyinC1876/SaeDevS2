package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Ennemie;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class EnnemieVue {

    private Pane pane;

    public EnnemieVue(Pane pane){
        this.pane = pane;
    }


    public void creerSprite(Ennemie ennemie) {
        Circle r;
        r = new Circle(3);
        r.setFill(Color.RED);

        r.translateXProperty().bind(ennemie.XProperty());
        r.translateYProperty().bind(ennemie.YProperty());
        r.setId(ennemie.getId());
        this.pane.getChildren().add(r);


    }

}