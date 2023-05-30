package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tour {

    private IntegerProperty tempsRecharge;
    private int prix;
    private int coutAmelioration;
    private int rayonPerimetreAction;
    private IntegerProperty degat;
    private static int compteur = 0;
    private String id;
    private DoubleProperty x, y;
    private Environnement environnement;

    public Tour(Environnement environnement , double x, double y) {
        this.tempsRecharge = new SimpleIntegerProperty(5);
        this.prix = 100;
        this.coutAmelioration = 9000;
        this.rayonPerimetreAction = 50;
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
}
