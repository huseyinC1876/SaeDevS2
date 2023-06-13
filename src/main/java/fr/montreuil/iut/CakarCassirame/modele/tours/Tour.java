package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.beans.property.*;

public abstract class Tour {


    public IntegerProperty prix;
    private static int compteur = 0;
    private String id;
    private IntegerProperty x, y;
    private Environnement environnement;



    public Tour(Environnement environnement, int x, int y) {
        this.id = "T" + compteur;
        compteur++;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.environnement = environnement;
    }

    public String getId() {
        return id;
    }
    public IntegerProperty getPrixProperty(){
        return this.prix;
    }



    public double valAbs(double val){
        return (val < 0) ? -val : val;
    }
    public IntegerProperty XProperty(){ return this.x; }

    public IntegerProperty YProperty(){ return this.y; }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public abstract void attaquer();

}
