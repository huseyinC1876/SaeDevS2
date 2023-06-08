package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiExtraterrestre extends Ennemi {
    static double vitesseInitiale = 2;


    public EnnemiExtraterrestre(Environnement environnement) {
        super(environnement, 100, 2, 35);
    }

    public double getVitesseInitiale(){return vitesseInitiale;}

}
