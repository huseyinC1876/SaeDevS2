package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Parametre {

    public static final IntegerProperty prixAmeliorationCanonLaser = new SimpleIntegerProperty(200);

    public static final IntegerProperty prixAmeliorationCanonMissile = new SimpleIntegerProperty(400);

    public static final IntegerProperty prixAmeliorationCanonNucleaire = new SimpleIntegerProperty(1000);

    public static final IntegerProperty prixAmeliorationChampForce = new SimpleIntegerProperty(750);

    public static final IntegerProperty prixTourCanonLaser = new SimpleIntegerProperty(100);

    public static final IntegerProperty prixTourCanonMissile = new SimpleIntegerProperty(250);

    public static final IntegerProperty prixTourCanonNucleaire = new SimpleIntegerProperty(1500);

    public static final IntegerProperty prixTourChampForce = new SimpleIntegerProperty(500);

    public static final IntegerProperty tempsRechargeCanonLaser = new SimpleIntegerProperty(200);

    public static final IntegerProperty tempsRechargeCanonMissile = new SimpleIntegerProperty(130);

    public static final IntegerProperty tempsRechargeCanonNuclaire = new SimpleIntegerProperty(500);

    public static final IntegerProperty degatCanonLaser = new SimpleIntegerProperty(3);

    public static final IntegerProperty degatCanonMissile = new SimpleIntegerProperty(5);

    public static final IntegerProperty degatCanonNuclaire = new SimpleIntegerProperty(50);

    public static final int vitesseInitExtraterrestre = 2;

    public static final int vitesseInitVaisseauSpatial = 3;

    public static final int vitesseInitSuperVaisseauSpatial = 3;

}
