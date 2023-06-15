package fr.montreuil.iut.CakarCassirame.vue.ennemiVue;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EnnemiSuperVaisseauSpatialVue extends EnnemieVue {
    public EnnemiSuperVaisseauSpatialVue(Pane pane) {
        super(pane, "src/main/resources/fr/montreuil/iut/CakarCassirame/superVaisseauSpatial32.png");
    }


}
