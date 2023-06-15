package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourChampDeForce extends TourPerimetre {

    public static double pourcentageReduction = 0.75;

    public TourChampDeForce(Environnement environnement, int x, int y) {
        super(environnement, x, y,  100);
    }

    /**
     * La méthode ralenti la vitesse des ennemis lorsqu'ils arrivent dans le périmètre d'une tour Champ de force
     * Elle vérifie le type d'ennemi et récupère sa vitesse initiale
     * Si la vitesse actuelle de l'ennemi présent dans le périmètre est différente de sa vtesse initiale. L'ennemi voit sa vitesse baisser.
     * --> la vitesse des ennemis ne peut baisser que si elle est actuellement à son niveau max/initial.
     * Le boss (Ennemi Galactus) n'est pas affectée par le champ de force
     */
    public void attaquer() {
        double vitesseInit;
        for(int i = 0 ; i < this.getEnvironnement().getListeEnnemis().size() ; i++) {
            Ennemi ennemi = this.getEnvironnement().getListeEnnemis().get(i);
            if (ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = Parametre.vitesseInitExtraterrestre;
        else if (ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = Parametre.vitesseInitVaisseauSpatial;
        else
            vitesseInit = Parametre.vitesseInitSuperVaisseauSpatial;
            if (!(ennemi instanceof EnnemiGalactusBoss) && hasEnnemiDansPerimetre(ennemi) && ennemi.getV() == vitesseInit) {
                ennemi.setVitesse(ennemi.getV() - 1);
            }
        }
    }
}
