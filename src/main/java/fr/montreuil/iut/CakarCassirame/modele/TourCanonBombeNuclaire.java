package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.Period;
import java.util.ArrayList;

public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat;
    public static IntegerProperty tempsRecharge;
    //TODO : ajout projectile. Pr l'instant, j'ai créé la classe projectile et la classe ProjectileVue. j'ai initialize les vues dans le controller
    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y, 1750);
        tempsRecharge = new SimpleIntegerProperty(50);
        degat = new SimpleIntegerProperty(50);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, 50, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }


    public int getDegat(){return degat.getValue();}
    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }

}


