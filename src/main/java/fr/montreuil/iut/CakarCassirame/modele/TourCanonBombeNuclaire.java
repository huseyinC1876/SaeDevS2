package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat = new SimpleIntegerProperty(50);
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    public static IntegerProperty prixT = new SimpleIntegerProperty(1750);
    //TODO : ajout projectile. Pr l'instant, j'ai créé la classe projectile et la classe ProjectileVue. j'ai initialize les vues dans le controller
    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y);
        tempsRecharge = new SimpleIntegerProperty(50);
        degat = new SimpleIntegerProperty(50);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, 50, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1);
    }


    public int getDegat(){return degat.getValue();}



    //public static int degat = 50;




    //public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    //public static IntegerProperty degat = new SimpleIntegerProperty();


    public static void amelioration(){
        degat.setValue(degat.getValue() * 2);
        if (tempsRecharge.getValue() > 1)
            tempsRecharge.setValue(tempsRecharge.getValue() - 1);
    }

    /*
    public void attaquer(Ennemi ennemi) {
        if(valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction() ){
            if(ennemi instanceof EnnemiSuperVaisseauSpatial){
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat);
            }
            else
                ennemi.décrémenterPV(this.degat);

     */
    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }

}


