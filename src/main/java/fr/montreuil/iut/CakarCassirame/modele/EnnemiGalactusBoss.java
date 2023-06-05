package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiGalactusBoss extends Ennemi {

    static int vitesseInitial = 3;
    public EnnemiGalactusBoss(Environnement environnement) {
        super(environnement, 1000, vitesseInitial, 500);
    }
}
