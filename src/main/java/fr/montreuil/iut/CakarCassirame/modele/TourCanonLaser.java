package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonLaser extends TourPerimetre{
    public static  IntegerProperty tempsRecharge;
    public static IntegerProperty degat;
//    private int rayonPerimetreAction = 50;

    public TourCanonLaser(Environnement environnement, double x, double y) {
        super(environnement, x, y, 200, 50);
        tempsRecharge = new SimpleIntegerProperty(3);
        degat = new SimpleIntegerProperty(20);
    }

    public int getDegat(){return degat.getValue();}

//    public int getRayonPerimetreAction(){return this.rayonPerimetreAction;}

    @Override
    public void attaquer(Ennemi ennemi) {

    }
}
