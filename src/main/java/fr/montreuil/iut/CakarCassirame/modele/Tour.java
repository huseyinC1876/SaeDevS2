package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class Tour {


    private IntegerProperty tempsRecharge;
    public static IntegerProperty prix = new SimpleIntegerProperty(100);
    private int coutAmelioration;
    private int rayonPerimetreAction;
    private IntegerProperty degat;
    private static int compteur = 0;
    private String id;
    private DoubleProperty x, y;
    private Environnement environnement;

    public Tour(Environnement environnement , double x, double y) {
        this.tempsRecharge = new SimpleIntegerProperty(5);
        this.coutAmelioration = 9000;
        this.rayonPerimetreAction = 100;
        this.degat = new SimpleIntegerProperty(20);
        compteur++;
        this.id = "A" + compteur;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.environnement = environnement;
    }

    public String getId() {
        return id;
    }

    public DoubleProperty XProperty(){ return this.x; }

    public DoubleProperty YProperty(){ return this.y; }

    public double valAbs(double val){
        return (val < 0) ? -val : val;
    }

    public void attaquer(Ennemi ennemi){
        if(valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= rayonPerimetreAction && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= rayonPerimetreAction ){
            if(ennemi instanceof EnnemiSuperVaisseauSpatial){
                ((EnnemiSuperVaisseauSpatial) ennemi).décrémenterVie(this.degat.getValue());
            }
            else
                ennemi.décrémenterPV(this.degat.getValue());
        }
    }
}
