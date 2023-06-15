package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.modele.tours.*;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonBombeNucleaireVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonMissileVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourChampDeForceVue;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class ObsTours implements ListChangeListener<Tour> {

    private TourCanonLaserVue tourCanonLaserVue;
    private TourCanonMissileVue tourCanonMissileVue;
    private TourCanonBombeNucleaireVue tourCanonBombeNucleaireVue;
    private TourChampDeForceVue tourChampDeForceVue;
    private Pane pane;
    public ObsTours(Pane pane) {
        this.pane = pane;
        this.tourCanonLaserVue = new TourCanonLaserVue(pane);
        this.tourCanonMissileVue = new TourCanonMissileVue(pane);
        this.tourCanonBombeNucleaireVue = new TourCanonBombeNucleaireVue(pane);
        this.tourChampDeForceVue = new TourChampDeForceVue(pane);
    }

    @Override
    public void onChanged(Change<? extends Tour> change) {
        while (change.next()) {
            for (Tour tour : change.getAddedSubList()) {
                if (tour instanceof TourCanonLaser) {
                    try {
                        tourCanonLaserVue.creerSprite(tour);
                        tourCanonLaserVue.creerSprite((TourPerimetre) tour);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (tour instanceof TourCanonMissile) {
                    try {
                        tourCanonMissileVue.creerSprite(tour);
                        tourCanonMissileVue.creerSprite((TourPerimetre) tour);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else if (tour instanceof TourCanonBombeNuclaire) {
                    try {
                        tourCanonBombeNucleaireVue.creerSprite(tour);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        tourChampDeForceVue.creerSprite(tour);
                        tourChampDeForceVue.creerSprite((TourPerimetre) tour);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            for (Tour tour : change.getRemoved()){
                pane.getChildren().remove(pane.lookup("#" + tour.getId()));
                pane.getChildren().remove(pane.lookup("#" + tour.getId() + "perimetre"));
            }
        }
    }
}
