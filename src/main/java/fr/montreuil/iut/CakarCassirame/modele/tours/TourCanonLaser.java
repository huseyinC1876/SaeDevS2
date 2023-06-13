package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/*
public class TourCanonLaser extends TourCanon{
public static int degat = 20;
public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(3);
public static IntegerProperty prixT = new SimpleIntegerProperty(100);

public static IntegerProperty prixA = new SimpleIntegerProperty(200);
public TourCanonLaser(Environnement environnement, double x, double y) {
super(environnement, x, y, 100, 200, 100);


 */
public class TourCanonLaser extends TourTeteChercheuse {
    public static IntegerProperty prixA = new SimpleIntegerProperty(200);
    public static IntegerProperty prixT = new SimpleIntegerProperty(100);

    public TourCanonLaser(Environnement environnement, int x, int y) {
        super(environnement, x, y, 200, 50, 500, 2);
    }

    public static void amelioration() {
        degat.setValue(degat.getValue() + 1);
        if (tempsRecharge.getValue() > 0) {
            tempsRecharge.setValue(tempsRecharge.getValue() - 1);
        }
        prixA.setValue(prixA.getValue() * 2);
    }


}
