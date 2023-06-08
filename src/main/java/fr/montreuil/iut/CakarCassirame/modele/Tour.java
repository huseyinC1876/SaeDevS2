package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.*;

public abstract class Tour {


    public IntegerProperty prix;
    private int coutAmelioration;
    private int rayonPerimetreAction;
    private static int compteur = 0;
    private String id;
    private DoubleProperty x, y;
    private Environnement environnement;

    public Tour(Environnement environnement, double x, double y,int prix,int coutAmelioration, int rayonPerimetreAction) {
        this.coutAmelioration = coutAmelioration;
        this.rayonPerimetreAction = rayonPerimetreAction;
        this.prix = new SimpleIntegerProperty(prix);
        compteur++;
        this.id = "A" + compteur;
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.environnement = environnement;
    }

    public String getId() {
        return id;
    }
    public IntegerProperty getPrixProperty(){
        return this.prix;
    }

    public DoubleProperty XProperty(){ return this.x; }

    public DoubleProperty YProperty(){ return this.y; }

    public double valAbs(double val){
        return (val < 0) ? -val : val;
    }

    public int getRayonPerimetreAction(){return this.rayonPerimetreAction;}

    public Environnement getEnvironnement() {
        return environnement;
    }

    public abstract void attaquer(Ennemi ennemi);
}
