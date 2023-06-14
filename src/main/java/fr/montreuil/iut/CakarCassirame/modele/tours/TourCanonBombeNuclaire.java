package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonBombeNucleaire;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat = new SimpleIntegerProperty(50);
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(50);
    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, int x, int y) {
        super(environnement, x, y);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, 50, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1);
    }


    public int getDegat(){return degat.getValue();}



    public static void amelioration() {
        degat.setValue(degat.getValue() * 2);
        if (tempsRecharge.getValue() > 1)
            tempsRecharge.setValue(tempsRecharge.getValue() - 1);
    }

    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }

}


