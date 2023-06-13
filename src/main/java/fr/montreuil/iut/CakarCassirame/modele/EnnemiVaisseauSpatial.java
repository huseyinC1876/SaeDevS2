package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.vue.EnnemiSuperVaisseauSpatialVue;
import fr.montreuil.iut.CakarCassirame.vue.EnnemiVaisseauSpatialVue;

public class EnnemiVaisseauSpatial extends Ennemi {

    static double vitesseInitiale = 3;

    public EnnemiVaisseauSpatial(Environnement environnement) {
        super(environnement, 300, 3, 55, 65, 135);
    }
    public EnnemiVaisseauSpatial(Environnement env, int x, int y){
        super(env, 150, 3, 80, x, y);
    }

    public double getVitesseInitiale(){return vitesseInitiale;}

}
