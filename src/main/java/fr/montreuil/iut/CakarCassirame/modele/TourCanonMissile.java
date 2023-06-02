package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonMissile extends TourCanon{
    public TourCanonMissile(Environnement environnement, double x, double y) {
        super(environnement, x, y, 400, 20, new SimpleIntegerProperty(5), new SimpleIntegerProperty(20));
    }
}
