package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonBombeNuclaire extends TourCanon{

    public static int degat = 50;
    public static IntegerProperty prixT = new SimpleIntegerProperty(1750);
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    //public static IntegerProperty degat = new SimpleIntegerProperty();
    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y, 1750, 1000,50);
        //degat.addListener((observableValue, number, t1) -> this.setDegat((int)t1));
    }

    public static void amelioration(int nvDegat, int temps){
        degat = nvDegat;
        tempsRecharge.setValue(temps);
    }

    public void attaquer(Ennemi ennemi) {
        if(valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction() ){
            if(ennemi instanceof EnnemiSuperVaisseauSpatial){
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat);
            }
            else
                ennemi.décrémenterPV(this.degat);
        }
    }
}
