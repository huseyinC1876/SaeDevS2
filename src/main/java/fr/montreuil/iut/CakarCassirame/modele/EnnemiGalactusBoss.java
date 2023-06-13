package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiGalactusBoss extends Ennemi {
    static double vitesseInitiale = 3;


    public EnnemiGalactusBoss(Environnement environnement, int x, int y) {
        super(environnement, 1000, 3, 500, x, y);
    }

}

