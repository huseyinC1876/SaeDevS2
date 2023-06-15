package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;

public class EnnemiSuperVaisseauSpatial extends Ennemi {

    private int bouclier = 50;

    public EnnemiSuperVaisseauSpatial(Environnement environnement, int x, int y) {
        super(environnement, 400, 3, 150, x, y, 400);
    }


   public void décrémenterBouclier(int PV){
       //Si les PV du bouclier sont inférieurs aux dégats pris, on décrémente aussi les PV de l'ennemi
       if(this.getBouclier() < PV){
           int difference = PV - getBouclier();
           this.decrementerPV(difference);
       }
       else this.bouclier = this.bouclier - PV;
   }

   public int getBouclier(){return this.bouclier;}


}
