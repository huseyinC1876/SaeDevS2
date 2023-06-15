package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiDivise extends Ennemi{
    static double vitesseInitiale = 3;
    public EnnemiDivise(Environnement environnement, int x, int y) {
        super(environnement, 150, 3, 40, x, y, 150);
    }

    public static double getVitesseInitiale(){return vitesseInitiale;}

}
