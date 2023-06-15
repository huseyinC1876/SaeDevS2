package fr.montreuil.iut.CakarCassirame.vue.projectileVue;

import fr.montreuil.iut.CakarCassirame.modele.projectiles.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private long lastDrop = 0;
    public void creerSprite(Projectile projectile) throws FileNotFoundException {
        lastDrop=System.currentTimeMillis();
        if(tilePaneBombe.lookup("bombeNuclaire") != null){
            return;
        }
        ImageView imageViewsTour = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsTour.setId("bombeNucleaire");
        imageViewsTour.translateXProperty().bind(projectile.XProperty().subtract(480));
        imageViewsTour.translateYProperty().bind(projectile.YProperty().subtract(320));
        imageViewsTour.setOpacity(0.5);
        imageViewsTour.setFitWidth(960);
        imageViewsTour.setFitHeight(640);
        this.tilePaneBombe.getChildren().add(imageViewsTour);
    }

    public void resetGIF(){
        if (System.currentTimeMillis()-this.lastDrop<2000) {
            return;
        }
        this.tilePaneBombe.getChildren().clear();
    }

}
