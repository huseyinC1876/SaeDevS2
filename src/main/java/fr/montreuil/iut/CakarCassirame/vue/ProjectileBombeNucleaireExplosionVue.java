package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProjectileBombeNucleaireExplosionVue {

    TilePane tilePaneBombe;

    private String file;
    public ProjectileBombeNucleaireExplosionVue(TilePane tilePaneBombe){
        this.tilePaneBombe = tilePaneBombe;
        this.file = "src/main/resources/fr/montreuil/iut/CakarCassirame/explosionBombe.gif";
    }

    public void creerSprite(Projectile projectile) throws FileNotFoundException {

        ImageView imageViewsTour = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsTour.setId(projectile.getId());
//        imageViewsTour.translateXProperty().bind(projectile.XProperty().subtract(16));
//        imageViewsTour.translateYProperty().bind(projectile.YProperty().subtract(16));
        imageViewsTour.translateXProperty().bind(projectile.XProperty().subtract(128));
        imageViewsTour.translateYProperty().bind(projectile.YProperty().subtract(128));
        imageViewsTour.setOpacity(0.5);
        imageViewsTour.setFitWidth(256);
        imageViewsTour.setFitHeight(256);
        this.tilePaneBombe.getChildren().add(imageViewsTour);
    }

    public void resetGIF(){
        this.tilePaneBombe.setOpacity(0);
    }

    public void afficherGIF(){
        this.tilePaneBombe.setVisible(true);

    }
}
