package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.beans.property.*;

public abstract class Tour {


    private static int compteur = 0;
    private final String id;
    private IntegerProperty x, y;
    private final Environnement environnement;

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

    public IntegerProperty XProperty(){ return this.x; }

    public IntegerProperty YProperty(){ return this.y; }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public abstract void attaquer();

}
