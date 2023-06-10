package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonLaser extends TourPerimetre{
    public static  IntegerProperty tempsRecharge;
    public static IntegerProperty degat;

    private ProjectileCanonLaser projectile;

    public TourCanonLaser(Environnement environnement, double x, double y) {
        super(environnement, x, y, 200, 50);
        tempsRecharge = new SimpleIntegerProperty(100);
        degat = new SimpleIntegerProperty(20);
        this.projectile = new ProjectileCanonLaser(environnement, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }

    public Projectile getProjectile() { return projectile;}

    public int getDegat(){return degat.getValue();}


    @Override
    public void attaquer() {

    }
}
