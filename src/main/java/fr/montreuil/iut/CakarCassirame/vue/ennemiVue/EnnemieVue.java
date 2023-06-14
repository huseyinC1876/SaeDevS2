package fr.montreuil.iut.CakarCassirame.vue.ennemiVue;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class EnnemieVue {

    private Pane pane;
    private String file;
    public EnnemieVue(Pane pane, String file){
        this.pane = pane;
        this.file = file;
    }


    public void creerSprite(Ennemi ennemi) throws FileNotFoundException {
        ImageView imageViewsSpaceChip = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsSpaceChip.setId(ennemi.getId());
        imageViewsSpaceChip.translateXProperty().bind(ennemi.XProperty());
        imageViewsSpaceChip.translateYProperty().bind(ennemi.YProperty());
        this.pane.getChildren().add(imageViewsSpaceChip);
        System.out.println(ennemi.getId());

        ProgressBar HP = new ProgressBar();
        HP.setId(ennemi.getId());
        HP.progressProperty().bind(ennemi.PVProperty().divide(ennemi.getPvMax()));
        HP.translateYProperty().bind(ennemi.YProperty().subtract(15));
        HP.translateXProperty().bind(ennemi.XProperty().add(2.5));
        HP.setPrefHeight(15);
        HP.setPrefWidth(28);
        this.pane.getChildren().add(HP);
        System.out.println(HP.getId());
//
//        Circle r;
//        r = new Circle(4);
//        r.setFill(Color.ORANGERED);
//        r.translateXProperty().bind(ennemi.XProperty().add(16));
//        r.translateYProperty().bind(ennemi.YProperty().add(16));
//        r.setId(ennemi.getId());
//        this.pane.getChildren().add(r);
//        System.out.println(r.getId());
    }

    public void rotation90(ImageView imageView){
        imageView.setRotate(90);

    }

    public void rotationM90(ImageView imageView){
        imageView.setRotate(-90);
    }

}