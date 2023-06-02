package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public abstract class Tour {


//    public static IntegerProperty prix = new SimpleIntegerProperty(100);
    private int coutAmelioration;
    private int rayonPerimetreAction;
    private static int compteur = 0;
    private String id;
    private DoubleProperty x, y;
    private Environnement environnement;

    public Tour(Environnement environnement, double x, double y, int coutAmelioration, int rayonPerimetreAction) {
        this.coutAmelioration = coutAmelioration;
        this.rayonPerimetreAction = rayonPerimetreAction;
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
