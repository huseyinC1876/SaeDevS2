package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiExtraterrestre extends Ennemi {

    static int vitesseInitial = 2;

    public EnnemiExtraterrestre(Environnement environnement) {
        super(environnement, 100, vitesseInitial, 35);
    }
}
