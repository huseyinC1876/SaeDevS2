package fr.montreuil.iut.CakarCassirame.vue;

import javafx.scene.layout.Pane;

public class ProjectileMissileVue extends ProjectileVue {

    Pane pane;

    private String file;
    public ProjectileMissileVue(Pane pane){
        super(pane, "src/main/resources/fr/montreuil/iut/CakarCassirame/projectile.png");
    }
}
