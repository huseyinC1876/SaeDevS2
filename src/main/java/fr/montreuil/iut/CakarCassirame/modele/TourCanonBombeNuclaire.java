package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat;
    public static IntegerProperty tempsRecharge;
    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y, 1750);
        tempsRecharge = new SimpleIntegerProperty(10);
        degat = new SimpleIntegerProperty(50);
    }

    public int getDegat(){return degat.getValue();}

    @Override
    public void attaquer(Ennemi ennemi) {

    }
}


