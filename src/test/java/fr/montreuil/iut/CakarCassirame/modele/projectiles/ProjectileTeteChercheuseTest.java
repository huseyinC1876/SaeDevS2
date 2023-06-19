package fr.montreuil.iut.CakarCassirame.modele.projectiles;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileTeteChercheuse;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectileTeteChercheuseTest {

    @Test
    void seDeplacerTest() throws IOException {

        Environnement env = new Environnement(1);
        Ennemi ennemi = new EnnemiExtraterrestre(env, env.getMap().debutMapEnnemie()[1], env.getMap().debutMapEnnemie()[0]);
        ProjectileTeteChercheuse projectile = new ProjectileCanonLaser(env,  50, new SimpleIntegerProperty(130), new SimpleIntegerProperty(130), Parametre.degatCanonLaser.getValue(), ennemi);

        //cas 1 : les x et y du projectile sont supérieurs à ceux de l'ennemi
        assertTrue(130 > ennemi.XProperty().getValue());
        assertTrue(130 > ennemi.YProperty().getValue());

        projectile.seDeplacer();

        int xAttendu = 130 - projectile.getV();
        int yAttendu = 130 - projectile.getV();

        assertTrue(projectile.XProperty().getValue() == xAttendu);
        assertTrue(projectile.YProperty().getValue() == yAttendu);

        //cas 2 : les x et y du projectile sont inférieurs à ceux de l'ennemi
        Ennemi ennemi2 = new EnnemiExtraterrestre(env, 150, 150);
        ProjectileTeteChercheuse projectile2 = new ProjectileCanonMissile(env,  50, new SimpleIntegerProperty(130), new SimpleIntegerProperty(130), Parametre.degatCanonMissile.getValue(), ennemi2);

        assertTrue(projectile2.XProperty().getValue() < ennemi2.XProperty().getValue());
        assertTrue(projectile2.YProperty().getValue() < ennemi2.YProperty().getValue());

        int xAttendu2 = projectile2.XProperty().getValue() + projectile2.getV();
        int yAttendu2 = projectile2.YProperty().getValue() + projectile2.getV();

        projectile2.seDeplacer();

        assertTrue(projectile2.XProperty().getValue() == xAttendu2);
        assertTrue(projectile2.YProperty().getValue() == yAttendu2);


        //cas 3 : x du projectile inférieur à celui de l'ennemi, y du projectile supérieur à celui de l'ennemi
        Ennemi ennemi3 = new EnnemiExtraterrestre(env, 160, 140);
        ProjectileTeteChercheuse projectile3 = new ProjectileCanonMissile(env,  50, new SimpleIntegerProperty(150), new SimpleIntegerProperty(150), Parametre.degatCanonMissile.getValue(), ennemi3);

        int xAttendu3 = projectile3.XProperty().getValue() + projectile3.getV();
        int yAttendu3 = projectile3.YProperty().getValue() - projectile3.getV();

        projectile3.seDeplacer();

        assertTrue(projectile3.XProperty().getValue() == xAttendu3);
        assertTrue(projectile3.YProperty().getValue() == yAttendu3);

        //cas 4 : x du projectile supérieur à celui de l'ennemi, y du projectile inférieur à celui de l'ennemi
        Ennemi ennemi4 = new EnnemiExtraterrestre(env, 150, 150);
        ProjectileTeteChercheuse projectile4 = new ProjectileCanonMissile(env,  50, new SimpleIntegerProperty(160), new SimpleIntegerProperty(140), Parametre.degatCanonMissile.getValue(), ennemi4);

        int xAttendu4 = projectile4.XProperty().getValue() - projectile4.getV();
        int yAttendu4 = projectile4.YProperty().getValue() + projectile4.getV();

        projectile4.seDeplacer();

        assertTrue(projectile4.XProperty().getValue() == xAttendu4);
        assertTrue(projectile4.YProperty().getValue() == yAttendu4);

    }


    @Test
    void attaquerTest() throws IOException{
        Environnement env = new Environnement(2);

        //cas 1 : valAbs différence Xs et Ys supérieure à 3
        EnnemiVaisseauSpatial ennemi = new EnnemiVaisseauSpatial(env, 145, 145);
        ProjectileTeteChercheuse projectile = new ProjectileCanonLaser(env, Parametre.degatCanonLaser.getValue(), new SimpleIntegerProperty(152), new SimpleIntegerProperty(152), 2, ennemi);

        projectile.attaquer();

        assertTrue(ennemi.getPv() == ennemi.getPvMax());

        //cas 2 : valAbs différence Xs et Ys inférieure à 3
        EnnemiDivise ennemi1 = new EnnemiDivise(env, 150, 154);
        ProjectileTeteChercheuse projectile1 = new ProjectileCanonMissile(env, Parametre.degatCanonMissile.getValue(), new SimpleIntegerProperty(152), new SimpleIntegerProperty(152), 2, ennemi1);

        projectile1.attaquer();

        assertTrue(ennemi1.getPv() == ennemi1.getPvMax() - projectile1.getDegat());

        //cas 3 : valAbs différence Xs et Ys inférieure à 3 et ennemi instance of EnnemiSuperVaisseauSpatial
        EnnemiSuperVaisseauSpatial ennemi2 = new EnnemiSuperVaisseauSpatial(env, 150, 154);
        ProjectileTeteChercheuse projectile2 = new ProjectileCanonLaser(env, Parametre.degatCanonLaser.getValue(), new SimpleIntegerProperty(152), new SimpleIntegerProperty(152), 2, ennemi2);

        int bouclierMax = ennemi2.getBouclier();

        projectile2.attaquer();

        assertTrue(ennemi2.getPv() == ennemi2.getPvMax()); // les PV de l'ennemi n'ont pas été décrémentés
        assertTrue(ennemi2.getBouclier() == bouclierMax - projectile2.getDegat());


        //cas 4 : valAbs différence Xs supérieure à 3 et Ys inférieure à 3
        EnnemiExtraterrestre ennemi3 = new EnnemiExtraterrestre(env, 155, 152);
        ProjectileTeteChercheuse projectile3 = new ProjectileCanonLaser(env, Parametre.degatCanonLaser.getValue(), new SimpleIntegerProperty(150), new SimpleIntegerProperty(152), 2, ennemi3);

        projectile3.attaquer();

        assertTrue(ennemi3.getPv() == ennemi3.getPvMax());


        //cas 5 : valAbs différence Xs inférieure à 3 et Ys supérieure à 3
        EnnemiExtraterrestre ennemi4 = new EnnemiExtraterrestre(env, 155, 152);
        ProjectileTeteChercheuse projectile4 = new ProjectileCanonMissile(env, Parametre.degatCanonMissile.getValue(), new SimpleIntegerProperty(153), new SimpleIntegerProperty(160), 2, ennemi4);

        projectile4.attaquer();

        assertTrue(ennemi4.getPv() == ennemi4.getPvMax());
    }
}
