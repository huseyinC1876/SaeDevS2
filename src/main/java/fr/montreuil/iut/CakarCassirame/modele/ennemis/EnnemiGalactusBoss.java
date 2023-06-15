package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiGalactusBoss extends Ennemi {

    public EnnemiGalactusBoss(Environnement environnement, int x, int y) {
        super(environnement, 1000, 2, 500, x, y, 1000);
    }

}

