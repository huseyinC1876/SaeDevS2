package fr.montreuil.iut.CakarCassirame.modele;

public class TourChampDeForce extends Tour{
    public TourChampDeForce(Environnement environnement, double x, double y) {
        super(environnement, x, y, 750, 30);
    }

    public void attaquer(Ennemi ennemi) {
        int vitesseInit;
        if(ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = EnnemiExtraterrestre.vitesseInitial;
        else if(ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = EnnemiVaisseauSpatial.vitesseInitial;
        else
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitial;

        if (!(ennemi instanceof EnnemiGalactusBoss) && valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction() && ennemi.getV() == vitesseInit){
            ennemi.setVitesse(0.75);
        }
    }
}
