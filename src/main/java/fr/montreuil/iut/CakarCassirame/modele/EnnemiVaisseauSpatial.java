package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.vue.EnnemiSuperVaisseauSpatialVue;
import fr.montreuil.iut.CakarCassirame.vue.EnnemiVaisseauSpatialVue;

public class EnnemiVaisseauSpatial extends Ennemi {
    public EnnemiVaisseauSpatial(Environnement environnement) {
        super(environnement, 600, 2, 55);
    }

    public void seDivise(){
        if(this.getPv() == 0){
            this.getEnvironnement().ajouterEnnemiDivision();
        }
    }
}
