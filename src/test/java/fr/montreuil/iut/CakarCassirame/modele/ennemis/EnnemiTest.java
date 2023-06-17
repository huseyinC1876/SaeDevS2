package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class EnnemiTest {

    @Test
    void seDeplacer() throws IOException {

        Environnement environnement = new Environnement(1);
        Ennemi ennemi = new EnnemiExtraterrestre(environnement, environnement.getMap().debutMapEnnemie()[1], environnement.getMap().debutMapEnnemie()[0]);
        ennemi.seDeplacer();
        Assertions.assertEquals((environnement.getMap().debutMapEnnemie()[0] + ennemi.getV()),ennemi.YProperty().getValue());

    }
}