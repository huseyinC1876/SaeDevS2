package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiVaisseauSpatial extends Ennemi {

    static double vitesseInitiale = 3;

    public EnnemiVaisseauSpatial(Environnement environnement, int x, int y) {
        super(environnement, 600, 3, 55, x, y);
    }

    public static double getVitesseInitiale(){return vitesseInitiale;}


}
