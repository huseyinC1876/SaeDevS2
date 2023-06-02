package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonLaser extends TourCanon{
    public TourCanonLaser(Environnement environnement, double x, double y) {
        super(environnement, x, y, 200, 20, new SimpleIntegerProperty(3), new SimpleIntegerProperty(20));

    }
}
