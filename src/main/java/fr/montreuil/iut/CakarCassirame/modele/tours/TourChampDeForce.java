package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
public class TourChampDeForce extends Tour{

    public static double pourcentageReduction = 0.75;
    public static IntegerProperty prixT = new SimpleIntegerProperty(500);

    public TourChampDeForce(Environnement environnement, double x, double y) {
        super(environnement, x, y, 500,750 ,100);
*/

public class TourChampDeForce extends TourPerimetre {

    public static double pourcentageReduction = 0.75;
    public static IntegerProperty prixT = new SimpleIntegerProperty(500);

    public TourChampDeForce(Environnement environnement, int x, int y) {
        super(environnement, x, y, 750, 100);
    }

    public void attaquer() {
        double vitesseInit;
        for(int i = 0 ; i < this.getEnvironnement().getListeEnnemis().size() ; i++) {
            Ennemi ennemi = this.getEnvironnement().getListeEnnemis().get(i);
            if (ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = EnnemiExtraterrestre.getVitesseInitiale();
        else if (ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = EnnemiVaisseauSpatial.getVitesseInitiale();
        else
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitiale;
            if (!(ennemi instanceof EnnemiGalactusBoss) && hasEnnemiDansPerimetre(ennemi) && ennemi.getV() == vitesseInit) {
                ennemi.setVitesse(ennemi.getV() - 1);
            }
        }
    }

        public static void amelioration(double pourcentage){
            pourcentageReduction = pourcentage;
        }
}
