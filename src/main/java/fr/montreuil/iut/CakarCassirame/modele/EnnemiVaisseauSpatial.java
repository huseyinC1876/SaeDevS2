package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.vue.EnnemiSuperVaisseauSpatialVue;
import fr.montreuil.iut.CakarCassirame.vue.EnnemiVaisseauSpatialVue;

public class EnnemiVaisseauSpatial extends Ennemi {

    static double vitesseInitiale = 3;

    public EnnemiVaisseauSpatial(Environnement environnement) {
        super(environnement, 600, 3, 55, 65, 135);
    }

    public double getVitesseInitiale(){return vitesseInitiale;}

}
