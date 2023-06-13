package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import fr.montreuil.iut.CakarCassirame.vue.ennemiVue.*;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class ObsEnnemis implements ListChangeListener<Ennemi> {

    private EnnemiExtraterrestreVue ennemiExtraterrestreVue;
    private EnnemiVaisseauSpatialVue ennemiVaisseauSpatialVue;
    private EnnemiSuperVaisseauSpatialVue ennemiSuperVaisseauSpatialVue;
    private EnnemiDiviseVue ennemiDiviseVue;
    private EnnemiGalactusBossVue ennemiGalactusBossVue;
    private Pane pane;

    public ObsEnnemis(Pane pane) {

        this.pane = pane;
        this.ennemiExtraterrestreVue = new EnnemiExtraterrestreVue(pane);
        this.ennemiVaisseauSpatialVue = new EnnemiVaisseauSpatialVue(pane);
        this.ennemiSuperVaisseauSpatialVue = new EnnemiSuperVaisseauSpatialVue(pane);
        this.ennemiDiviseVue = new EnnemiDiviseVue(pane);
        this.ennemiGalactusBossVue = new EnnemiGalactusBossVue(pane);
    }


    @Override
    public void onChanged(Change<? extends Ennemi> change){
        while (change.next()) {
            for (Ennemi ennemi : change.getAddedSubList()) {
                try {
                    if (ennemi instanceof EnnemiExtraterrestre)
                        ennemiExtraterrestreVue.creerSprite(ennemi);
                    else if (ennemi instanceof EnnemiVaisseauSpatial)
                        ennemiVaisseauSpatialVue.creerSprite(ennemi);
                    else if (ennemi instanceof EnnemiSuperVaisseauSpatial)
                        ennemiSuperVaisseauSpatialVue.creerSprite(ennemi);
                    else if(ennemi instanceof EnnemiDivise)
                        ennemiDiviseVue.creerSprite(ennemi);
                    else
                        ennemiGalactusBossVue.creerSprite(ennemi);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            for (Ennemi ennemie : change.getRemoved()) {
                pane.getChildren().remove(pane.lookup("#" + ennemie.getId()));

            }
        }
    }
}
