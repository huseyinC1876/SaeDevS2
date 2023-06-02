package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonBombeNuclaire extends TourCanon{
    public TourCanonBombeNuclaire(Environnement environnement, double x, double y) {
        super(environnement, x, y, 1750, 40, new SimpleIntegerProperty(10), new SimpleIntegerProperty(50));
    }
}
