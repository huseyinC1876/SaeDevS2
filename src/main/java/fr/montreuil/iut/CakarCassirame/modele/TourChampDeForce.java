package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourChampDeForce extends Tour{

    public static double pourcentageReduction = 0.75;
    public static IntegerProperty prixT = new SimpleIntegerProperty(500);

    public TourChampDeForce(Environnement environnement, double x, double y) {
        super(environnement, x, y, 500,750 ,100);
    }


    public void attaquer(Ennemi ennemi) {
        double vitesseInit;
        if (ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = EnnemiExtraterrestre.vitesseInitiale;
        else if (ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = EnnemiVaisseauSpatial.vitesseInitiale;
        else
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitiale;

        if (!(ennemi instanceof EnnemiGalactusBoss) && valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction() && ennemi.getV() == vitesseInit){
            ennemi.setVitessePourcentage(pourcentageReduction);
            System.out.println("enter1");
            System.out.println(ennemi.getV());
        }
        else if(valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) >= this.getRayonPerimetreAction() || valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) >= this.getRayonPerimetreAction() ) {
            ennemi.setVitesse(vitesseInit);
            System.out.println("enter2");
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitiale;


        }
    }

    public static void amelioration(double pourcentage){
        pourcentageReduction = pourcentage;
    }
}
