package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;


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

    public TourCanonLaser(Environnement environnement, int x, int y) {
        super(environnement, x, y, 50, 500, 2);
    }

    public static void amelioration() {

    }


}
