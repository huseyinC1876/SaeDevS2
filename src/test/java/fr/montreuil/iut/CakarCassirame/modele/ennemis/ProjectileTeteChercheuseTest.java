package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
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

    }
}
