package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiExtraterrestre extends Ennemi {
    static double vitesseInitiale = 2;


    public EnnemiExtraterrestre(Environnement environnement, int x, int y) {
        super(environnement, 100, 2, 35, x, y);
    }

    public static double getVitesseInitiale(){return vitesseInitiale;}

}