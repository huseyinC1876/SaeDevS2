package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Ennemi;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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

//
//        Circle r;
//        r = new Circle(4);
//        r.setFill(Color.ORANGERED);
//        r.translateXProperty().bind(ennemi.XProperty());
//        r.translateYProperty().bind(ennemi.YProperty());
//        r.setId(ennemi.getId());
//        this.pane.getChildren().add(r);
    }


    public void reduireTaille(ImageView imageView){
        imageView.setScaleX(16);
        imageView.setScaleY(16);
        //imageView.setFitWidth(16);
        //imageView.setFitHeight(16);

    }

    public void rotation90(ImageView imageView){
        imageView.setRotate(90);

    }

    public void rotationM90(ImageView imageView){
        imageView.setRotate(-90);
    }

}