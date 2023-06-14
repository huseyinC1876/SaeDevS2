package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiSuperVaisseauSpatial extends Ennemi {
    private int bouclier;
    public static double vitesseInitiale = 3;

    public EnnemiSuperVaisseauSpatial(Environnement environnement, int x, int y) {
        super(environnement, 500, 3, 80, x, y, 500);
        this.bouclier = 100;
    }


   public void décrémenterBouclier(int PV){
        this.bouclier = this.bouclier - PV;
   }

   public void décrémenterVie(int pv){
        if (this.bouclier > pv){
            this.bouclier -= pv;
        }
        else if(this.bouclier > 0){
            this.bouclier = 0;
        }
        else{
            this.décrémenterPV(pv);
        }
   }

    public double getVitesseInitiale(){return this.vitesseInitiale;}

}
