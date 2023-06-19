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
        int positionX = environnement.getMap().debutMapEnnemie()[1];
        int positionY = environnement.getMap().debutMapEnnemie()[0];
        Assertions.assertEquals(positionX,ennemi.XProperty().getValue());
        Assertions.assertEquals(positionY, ennemi.YProperty().getValue());
        while (environnement.getMap().getTile(positionY/32, positionX / 32) != 0 ){
            ennemi.seDeplacer();
            Assertions.assertEquals(2,environnement.getMap().getTile(positionY/ 32, positionX/32));
            if(positionX < ennemi.XProperty().getValue()){
                positionX += ennemi.getV();
            }
            else if (positionX > ennemi.XProperty().getValue()){
                positionX -= ennemi.getV();
                if(positionX < ennemi.XProperty().getValue()){
                    positionY = ennemi.XProperty().getValue();
                }
            }
            if (positionY < ennemi.YProperty().getValue()){
                positionY += ennemi.getV();
            }
            else if (positionY > ennemi.YProperty().getValue()) {
                positionY -= ennemi.getV();
                if(positionY > ennemi.YProperty().getValue()){
                    positionY = ennemi.YProperty().getValue();
                }
            }
            Assertions.assertEquals(positionX,ennemi.XProperty().getValue());
            Assertions.assertEquals(positionY, ennemi.YProperty().getValue());
        }
        Assertions.assertEquals(0, environnement.getMap().getTile(positionY / 32, positionX / 32));


    }
}