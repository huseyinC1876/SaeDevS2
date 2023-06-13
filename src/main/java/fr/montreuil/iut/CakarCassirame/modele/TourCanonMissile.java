package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
public class TourCanonMissile extends TourCanon{
    public static int degat = 20;
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(5);

    public static IntegerProperty prixT = new SimpleIntegerProperty(200);
    public static IntegerProperty prixA = new SimpleIntegerProperty(400);
    public TourCanonMissile(Environnement environnement, double x, double y) {
        super(environnement, x, y, 200, 400, 20);
    }

    public static void amelioration(){ //int nvDegat, int temps
        degat = degat* 2 ; //nvDegat * 2
        tempsRecharge.setValue(tempsRecharge.getValue() - 1);
        prixA.setValue(prixA.getValue() * 2);
    }

    @Override
    public void attaquer(Ennemi ennemi) {
        if (valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction()) {
            if (ennemi instanceof EnnemiSuperVaisseauSpatial) {
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat);
            } else
                ennemi.décrémenterPV(this.degat);
        }
    }
    */
public class TourCanonMissile extends TourPerimetre{

    public static IntegerProperty tempsRecharge  = new SimpleIntegerProperty(5);
    public static IntegerProperty degat = new SimpleIntegerProperty(20);
    public static IntegerProperty prixA = new SimpleIntegerProperty(400);
    public static IntegerProperty prixT = new SimpleIntegerProperty(200);

    private ProjectileCanonMissile projectile;
    public TourCanonMissile(Environnement environnement, double x, double y) {
        super(environnement, x, y, 20);
        tempsRecharge = new SimpleIntegerProperty(500);
        degat = new SimpleIntegerProperty(20);
        this.projectile = new ProjectileCanonMissile(environnement, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }

    public Projectile getProjectile() { return projectile;}

    public int getDegat(){return degat.getValue();}


    public void attaquer(Ennemi ennemi) {
        if (valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction()) {
            if (ennemi instanceof EnnemiSuperVaisseauSpatial) {
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat.getValue());
            } else
                ennemi.décrémenterPV(this.degat.getValue());
        }
    }

    public static void amelioration(/*int nvDegat, int temps*/){
        degat.setValue(degat.getValue() * 2); //nvDegat * 2
        if (tempsRecharge.getValue() > 0) {
            tempsRecharge.setValue(tempsRecharge.getValue() - 1);
        }
        prixA.setValue(prixA.getValue() * 2);
    }
}
