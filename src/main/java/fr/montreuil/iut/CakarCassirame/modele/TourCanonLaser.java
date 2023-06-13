package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


        /*
public class TourCanonLaser extends TourCanon{
    public static int degat = 20;
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(3);
    public static IntegerProperty prixT = new SimpleIntegerProperty(100);

    public static IntegerProperty prixA = new SimpleIntegerProperty(200);
    public TourCanonLaser(Environnement environnement, double x, double y) {
        super(environnement, x, y, 100, 200, 100);


         */
public class TourCanonLaser extends TourPerimetre{
    public static  IntegerProperty tempsRecharge = new SimpleIntegerProperty(3);
    public static IntegerProperty degat = new SimpleIntegerProperty(9);


    private ProjectileCanonLaser projectile;

    public TourCanonLaser(Environnement environnement, double x, double y) {
        super(environnement, x, y, 100);
        this.projectile = new ProjectileCanonLaser(environnement, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }

    public Projectile getProjectile() { return projectile;}

    public int getDegat(){return degat.getValue();}



    public static void amelioration(){

    }


    public void attaquer(Ennemi ennemi) {
        if (valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction()) {
            if (ennemi instanceof EnnemiSuperVaisseauSpatial) {
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat.getValue());
            } else
                ennemi.décrémenterPV(this.degat.getValue());
        }
    }
}
