package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.modele.Projectile;
import fr.montreuil.iut.CakarCassirame.modele.ProjectileCanonBombeNucleaire;
import fr.montreuil.iut.CakarCassirame.modele.ProjectileCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.ProjectileCanonMissile;
import fr.montreuil.iut.CakarCassirame.vue.ProjectileBombeNuclaireVue;
import fr.montreuil.iut.CakarCassirame.vue.ProjectileBombeNucleaireExplosionVue;
import fr.montreuil.iut.CakarCassirame.vue.ProjectileLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.ProjectileMissileVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.FileNotFoundException;

public class ObsProjectiles implements ListChangeListener<Projectile> {

    private ProjectileLaserVue projectileLaserVue;
    private ProjectileMissileVue projectileMissileVue;
    private ProjectileBombeNuclaireVue projectileBombeNuclaireVue;
    private ProjectileBombeNucleaireExplosionVue projectileBombeNucleaireExplosionVue;
    private Pane pane;
    private TilePane tilePane;
    public ObsProjectiles(Pane pane, TilePane tilePane) {
        this.pane = pane;
        this.projectileLaserVue = new ProjectileLaserVue(pane);
        this.projectileMissileVue = new ProjectileMissileVue(pane);
        this.projectileBombeNuclaireVue = new ProjectileBombeNuclaireVue(pane);
        this.projectileBombeNucleaireExplosionVue = new ProjectileBombeNucleaireExplosionVue(tilePane);
    }
    @Override
    public void onChanged(Change<? extends Projectile> change) {
        while (change.next()) {
            for (Projectile projectile : change.getAddedSubList()) {
                if(projectile instanceof ProjectileCanonLaser) {
                    try {
                        projectileLaserVue.creerSprite(projectile);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (projectile instanceof ProjectileCanonMissile) {
                    try {
                        projectileMissileVue.creerSprite(projectile);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (projectile instanceof ProjectileCanonBombeNucleaire) {
                    try {
                        projectileBombeNuclaireVue.creerSprite(projectile);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            for (Projectile projectile : change.getRemoved()) {
                pane.getChildren().remove(pane.lookup("#" + projectile.getId()));
                try {
                    projectileBombeNucleaireExplosionVue.creerSprite(projectile);
//                                System.out.println("CREATION SPRITE SPRITE SPRITE SPRITE SPRITE SPRITE SPRITE");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

//TODO : il faut enlever l'image !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! (attention, pour l'instant, l'image est sur un 3ème tilepane et ça ne marche pas bien.
            }
        }
    }
}
