package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiSuperVaisseauSpatial extends Ennemi {
    private int bouclier;
    public EnnemiSuperVaisseauSpatial(Environnement environnement) {
        super(environnement, 120, 3, 80);
        this.bouclier = 100;
    }

   public void décrémenterBouclier(int PV){
        this.bouclier = this.bouclier - PV;
   }
}