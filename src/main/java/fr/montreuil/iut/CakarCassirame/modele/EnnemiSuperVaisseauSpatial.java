package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiSuperVaisseauSpatial extends Ennemi {
    private int bouclier;
    static double vitesseInitiale = 3;

    public EnnemiSuperVaisseauSpatial(Environnement environnement) {
        super(environnement, 500, 3, 80, 65, 135);
        this.bouclier = 100;
    }

    public EnnemiSuperVaisseauSpatial(Environnement env, int x, int y){
        super(env, 250, 3, 80, x, y);
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
