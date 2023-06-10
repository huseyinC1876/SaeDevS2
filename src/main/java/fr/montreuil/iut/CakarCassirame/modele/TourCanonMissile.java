package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonMissile extends TourPerimetre{

    public static IntegerProperty tempsRecharge;
    public static IntegerProperty degat;

    private ProjectileCanonMissile projectile;
    public TourCanonMissile(Environnement environnement, double x, double y) {
        super(environnement, x, y, 400, 20);
        tempsRecharge = new SimpleIntegerProperty(500);
        degat = new SimpleIntegerProperty(20);
        this.projectile = new ProjectileCanonMissile(environnement, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }

    public Projectile getProjectile() { return projectile;}

    public int getDegat(){return degat.getValue();}

    @Override
    public void attaquer() {

    }
}
