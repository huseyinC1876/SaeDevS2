package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.EnnemiDivise;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.EnnemiExtraterrestre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.EnnemiVaisseauSpatial;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileTeteChercheuse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TourTeteChercheuseTest {

    @Test
    void recupererEnnemiCibleTest() throws IOException {
        //cas 1 : 2 ennemis sont présents dans le perimètre de la tour en même temps
        Environnement env = new Environnement(2);
        TourTeteChercheuse tour = new TourCanonMissile(env, 500, 560);
        Ennemi ennemi1 = new EnnemiExtraterrestre(env, 520, 550);
        Ennemi ennemi2 = new EnnemiVaisseauSpatial(env, 515, 555);
        env.getListeEnnemis().add(ennemi1);
        env.getListeEnnemis().add(ennemi2);
        int temps = 150;
        assertTrue(temps > Parametre.tempsRechargeCanonMissile.getValue());

        tour.recupererEnnemiCible(temps);

        assertTrue(env.getListeProjectiles().size() ==1);
        assertTrue(env.getListeProjectiles().get(0) instanceof ProjectileCanonMissile);
        assertTrue(((ProjectileCanonMissile) env.getListeProjectiles().get(0)).getEnnemiCible() == ennemi1);
        assertTrue(tour.getTempsLastEnnemi() == temps);

        //cas 2 : 1 ennemi est hors de portée de la tour
        TourTeteChercheuse tour2 = new TourCanonLaser(env, 420, 520);
        Ennemi ennemi3 = new EnnemiDivise(env, 350, 600);
        env.getListeEnnemis().add(ennemi3);
        int temps2 = 250;
        assertTrue(temps2 > Parametre.tempsRechargeCanonLaser.getValue());

        tour2.recupererEnnemiCible(temps2);

        assertTrue(env.getListeProjectiles().size() ==1);
        assertTrue(tour2.getTempsLastEnnemi() == 0);
        assertTrue(!(env.getListeProjectiles().get(0) instanceof ProjectileCanonLaser));


        //cas 3 : un ennemi est hors de portée, un deuxième ennemi est dans le perimètre de la tour
        Environnement env2 = new Environnement(1);
        TourTeteChercheuse tour3 = new TourCanonMissile(env2, 500, 560);
        Ennemi ennemi4 = new EnnemiExtraterrestre(env2, 200, 780);
        Ennemi ennemi5 = new EnnemiVaisseauSpatial(env2, 515, 555);
        env2.getListeEnnemis().add(ennemi4);
        env2.getListeEnnemis().add(ennemi5);
        int temps3 = 200;
        assertTrue(temps3 > Parametre.tempsRechargeCanonMissile.getValue());

        tour3.recupererEnnemiCible(temps3);

        assertTrue(env2.getListeProjectiles().size() ==1);
        assertTrue(env2.getListeProjectiles().get(0) instanceof ProjectileCanonMissile);
        assertTrue(((ProjectileCanonMissile) env2.getListeProjectiles().get(0)).getEnnemiCible() == ennemi5);
        assertTrue(tour3.getTempsLastEnnemi() == temps3);


    }

}