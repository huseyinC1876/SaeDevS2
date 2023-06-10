package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat = new SimpleIntegerProperty(50);
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    public static IntegerProperty prixT = new SimpleIntegerProperty(1750);
    //TODO : ajout projectile. Pr l'instant, j'ai créé la classe projectile et la classe ProjectileVue. j'ai initialize les vues dans le controller
    private Projectile projectile;
    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y, 1750);
        tempsRecharge = new SimpleIntegerProperty(10);
        degat = new SimpleIntegerProperty(50);
    }

    public int getDegat(){return degat.getValue();}


    public void attaquer(Ennemi ennemi) {
        for(int i = 0 ; i < this.getEnvironnement().getListeEnnemis().size() ; i++){
            this.getEnvironnement().getListeEnnemis().get(i).décrémenterPV(getDegat());
        }
    }


    //public static int degat = 50;




    //public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    //public static IntegerProperty degat = new SimpleIntegerProperty();


    public static void amelioration(int nvDegat, int temps){
        degat.setValue(nvDegat);
        tempsRecharge.setValue(temps);
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
}


