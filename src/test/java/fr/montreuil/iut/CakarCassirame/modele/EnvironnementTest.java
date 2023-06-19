package fr.montreuil.iut.CakarCassirame.modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Parameter;

class EnvironnementTest {

    @Test
    void vendreTour() throws IOException {
        Environnement environnement = new Environnement(1);
        if(environnement.verificationPlacement(300, 450))
            environnement.ajouterTour(300, 450, 1);
        Assertions.assertEquals(1, environnement.getListeTours().size());
        int ressource = environnement.ressourceProperty().getValue();

        environnement.vendreTour(300, 450);
        Assertions.assertEquals(0, environnement.getListeTours().size());
        Assertions.assertEquals(ressource + Parametre.prixTourCanonLaser.getValue()/2 , environnement.ressourceProperty().getValue());
        environnement.ajouterTour(300, 450, 1);
        ressource -= Parametre.prixTourCanonLaser.getValue();
        ressource += Parametre.prixTourCanonLaser.getValue() / 2;
        Assertions.assertEquals(1, environnement.getListeTours().size());
        environnement.vendreTour(301, 450);
        environnement.vendreTour(299, 450);
        environnement.vendreTour(300, 449);
        environnement.vendreTour(300, 451);
        environnement.vendreTour(301, 449);
        environnement.vendreTour(301, 451);
        environnement.vendreTour(299, 449);
        environnement.vendreTour(299, 451);
        Assertions.assertEquals(1, environnement.getListeTours().size());
        Assertions.assertEquals(ressource, environnement.ressourceProperty().getValue());
        environnement.vendreTour(300, 450);
        ressource += Parametre.prixTourCanonLaser.getValue() / 2;
        Assertions.assertEquals(0, environnement.getListeTours().size());
        Assertions.assertEquals(ressource , environnement.ressourceProperty().getValue());
        environnement.ajouterTour(300, 450, 2);
        ressource -= Parametre.prixTourCanonMissile.getValue();
        Assertions.assertEquals(1, environnement.getListeTours().size());
        environnement.vendreTour(300, 450);
        ressource += Parametre.prixTourCanonMissile.getValue()/2;
        Assertions.assertEquals(ressource , environnement.ressourceProperty().getValue());
        environnement.ajouterTour(300, 450, 3);
        ressource -= Parametre.prixTourCanonNucleaire.getValue();
        Assertions.assertEquals(1, environnement.getListeTours().size());
        environnement.vendreTour(300, 450);
        ressource += Parametre.prixTourCanonNucleaire.getValue()/2;
        Assertions.assertEquals(ressource , environnement.ressourceProperty().getValue());
        Assertions.assertEquals(0, environnement.getListeTours().size());

        environnement.ajouterTour(300, 450, 4);
        ressource -= Parametre.prixTourChampForce.getValue();
        Assertions.assertEquals(1, environnement.getListeTours().size());
        environnement.vendreTour(300, 450);
        ressource += Parametre.prixTourChampForce.getValue()/2;
        Assertions.assertEquals(ressource , environnement.ressourceProperty().getValue());
        Assertions.assertEquals(0, environnement.getListeTours().size());

    }

    @Test
    void ameliorationTour() throws IOException {
        Environnement environnement = new Environnement(1);
        environnement.ameliorationTour(1);
        Assertions.assertEquals(2, environnement.getNiveauCanonLaser());
        environnement.ameliorationTour(1);
        Assertions.assertEquals(3, environnement.getNiveauCanonLaser());
        int ressource = environnement.ressourceProperty().getValue();
        environnement.ameliorationTour(1);
        Assertions.assertEquals(3, environnement.getNiveauCanonLaser());
        Assertions.assertEquals(ressource, environnement.ressourceProperty().getValue());
        environnement.ameliorationTour(4);
        Assertions.assertEquals(2, environnement.getNiveauChampForce());
        environnement.ameliorationTour(4);
        Assertions.assertEquals(2, environnement.getNiveauChampForce());
        environnement.setRessource(100);
        environnement.ameliorationTour(3);
        Assertions.assertEquals(1, environnement.getNiveauCanonNucleaire());

    }
}