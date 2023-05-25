package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tour {

    private IntegerProperty tempsRecharge;
    private int prix;
    private int coutAmelioration;
    private int rayonPerimetreAction;
    private IntegerProperty degat;
    private static int compteur = 0;
    private String id;
    private IntegerProperty x, y;

    public Tour(int tempsRecharge,int prix, int coutAmelioration, int rayonPerimetreAction, IntegerProperty degat, String id, IntegerProperty x, IntegerProperty y) {
        this.tempsRecharge = new SimpleIntegerProperty(tempsRecharge);
        this.prix = prix;
        this.coutAmelioration = coutAmelioration;
        this.rayonPerimetreAction = rayonPerimetreAction;
        this.degat = degat;
        this.id = id;
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();
    }

    public String getId() {
        return id;
    }

    public IntegerProperty XProperty(){ return this.x; }

    public IntegerProperty YProperty(){ return this.y; }
}
