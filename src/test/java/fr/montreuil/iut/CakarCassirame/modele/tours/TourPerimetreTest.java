package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import fr.montreuil.iut.CakarCassirame.vue.ennemiVue.EnnemiSuperVaisseauSpatialVue;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TourPerimetreTest {

    @Test
    void hasEnnemiDansPerimetreTest() throws IOException {
        Environnement env = new Environnement(1);

        //cas 1 : ennemi présent dans le périmètre
        TourPerimetre tour1 = new TourChampDeForce(env, 400, 350);
        Ennemi ennemi1 = new EnnemiGalactusBoss(env, 380, 355);

        assertTrue(Math.abs(tour1.XProperty().getValue()- ennemi1.XProperty().getValue()) < tour1.getRayonPerimetreAction());
        assertTrue(Math.abs(tour1.YProperty().getValue()- ennemi1.YProperty().getValue()) < tour1.getRayonPerimetreAction());
        assertTrue(tour1.hasEnnemiDansPerimetre(ennemi1));


        //cas 2 : ennemi pas dans le perimètre
        Ennemi ennemi2 = new EnnemiGalactusBoss(env, 560, 280);
        TourPerimetre tour2 = new TourCanonLaser(env, 850, 630);

        assertTrue(Math.abs(tour2.XProperty().getValue()- ennemi2.XProperty().getValue()) > tour2.getRayonPerimetreAction());
        assertTrue(Math.abs(tour2.YProperty().getValue()- ennemi2.YProperty().getValue()) > tour2.getRayonPerimetreAction());
        assertFalse(tour2.hasEnnemiDansPerimetre(ennemi2));

        //cas 3 : ennemi X dans perimètre, ennemi Y pas dans périmètre
        Ennemi ennemi3 = new EnnemiSuperVaisseauSpatial(env, 420, 402);
        TourPerimetre tour3 = new TourCanonMissile(env, 415, 300);

        assertTrue(Math.abs(tour3.XProperty().getValue()- ennemi3.XProperty().getValue()) < tour3.getRayonPerimetreAction());
        assertTrue(Math.abs(tour3.YProperty().getValue()- ennemi3.YProperty().getValue()) > tour3.getRayonPerimetreAction());
        assertFalse(tour3.hasEnnemiDansPerimetre(ennemi3));


    }

}