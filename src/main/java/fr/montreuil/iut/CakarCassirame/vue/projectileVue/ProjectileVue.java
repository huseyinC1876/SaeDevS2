package fr.montreuil.iut.CakarCassirame.vue.projectileVue;

import fr.montreuil.iut.CakarCassirame.modele.projectiles.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProjectileVue {

    Pane pane;
    private String file;

    public ProjectileVue(Pane pane, String file){
        this.pane = pane;
        this.file = file;
    }

    public void creerSprite(Projectile projectile) throws FileNotFoundException {
        ImageView imageViewsTour = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsTour.setId(projectile.getId());
        imageViewsTour.translateXProperty().bind(projectile.XProperty().subtract(16));
        imageViewsTour.translateYProperty().bind(projectile.YProperty().subtract(16));
        imageViewsTour.setFitWidth(32);
        imageViewsTour.setFitHeight(32);
        this.pane.getChildren().add(imageViewsTour);
    }
}
