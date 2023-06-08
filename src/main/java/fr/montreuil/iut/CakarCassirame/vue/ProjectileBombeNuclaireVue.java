package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Projectile;
import fr.montreuil.iut.CakarCassirame.modele.Tour;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProjectileBombeNuclaireVue extends ProjectileVue{


    public ProjectileBombeNuclaireVue(Pane pane) {
        super(pane,"src/main/resources/fr/montreuil/iut/CakarCassirame/projectile.png");
    }
}
