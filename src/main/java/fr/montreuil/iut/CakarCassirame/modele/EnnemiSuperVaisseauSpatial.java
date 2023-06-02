package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiSuperVaisseauSpatial extends Ennemi {
    private int bouclier;
    public EnnemiSuperVaisseauSpatial(Environnement environnement) {
        super(environnement, 500, 3, 80);
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
}
