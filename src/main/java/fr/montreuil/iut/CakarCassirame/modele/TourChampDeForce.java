package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.vue.TourChampDeForceVue;
import fr.montreuil.iut.CakarCassirame.vue.TourVue;

public class TourChampDeForce extends Tour {

    public TourChampDeForce(Environnement environnement, double x, double y) {
        super(environnement, x, y, 750, 100);
    }


    public void attaquer(Ennemi ennemi) {
        double vitesseInit;
        if (ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = EnnemiExtraterrestre.vitesseInitiale;
        else if (ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = EnnemiVaisseauSpatial.vitesseInitiale;
        else
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitiale;

        if (!(ennemi instanceof EnnemiGalactusBoss) && ennemi.estDansPerimetreTour(this) && ennemi.getV() == vitesseInit) {
            ennemi.setVitesse(ennemi.getV()-1);
//            System.out.println("ennemi ID : "+ennemi.getId() + " - type : " + ennemi.getClass() + " - vitesse actuelle : " + ennemi.getV());
//            if (ennemi instanceof EnnemiExtraterrestre)
//                System.out.println("ennemi ID : "+ennemi.getId() + " - vitesse initiale : "+EnnemiExtraterrestre.vitesseInitiale);
//            else if (ennemi instanceof EnnemiVaisseauSpatial)
//                System.out.println("ennemi ID : "+ennemi.getId() + " - vitesse initiale : "+EnnemiVaisseauSpatial.vitesseInitiale);
//            else
//                System.out.println("ennemi ID : "+ennemi.getId() + " - vitesse initiale : "+EnnemiSuperVaisseauSpatial.vitesseInitiale);
//            System.out.println();
        }
    }
}
