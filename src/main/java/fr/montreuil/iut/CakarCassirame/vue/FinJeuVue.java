package fr.montreuil.iut.CakarCassirame.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FinJeuVue {

    private Pane pane;


    public FinJeuVue(Pane pane){
        this.pane = pane;
    }

    public void victoire() throws FileNotFoundException {
        Image imageVictoire = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/victoire.jpg"));
        ImageView imageViewVictoire = new ImageView(imageVictoire);
        //imageViewVictoire.setFitWidth(1300);
        //imageViewVictoire.setFitHeight(960);
        imageViewVictoire.setX(0);
        imageViewVictoire.setY(0);
        this.pane.getChildren().add(imageViewVictoire);
    }

    public void defaite() throws FileNotFoundException {
        Image imageDefaite = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/defaite.jpg"));
        ImageView imageViewDefaite = new ImageView(imageDefaite);
        //imageViewDefaite.setFitWidth(1300);
        //imageViewDefaite.setFitHeight(960);

        imageViewDefaite.setX(0);
        imageViewDefaite.setY(0);
        this.pane.getChildren().add(imageViewDefaite);
    }


}
