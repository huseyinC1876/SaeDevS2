package fr.montreuil.iut.CakarCassirame.modele;

public class EnnemiVaisseauSpatial extends Ennemi {

    static double vitesseInitiale = 3;

    public EnnemiVaisseauSpatial(Environnement environnement, int x, int y) {
        super(environnement, 600, 3, 55, x, y);
    }
/*
    public EnnemiVaisseauSpatial(Environnement environnement, int pv, int gain){
        super(environnement,pv,3, gain);
    }

 */

    public void seDivise() {
        if (this.getPv() < 1) {
            for (int i = 0; i < 2; i++) {
                System.out.println("enter");
                Ennemi ennemiDivise = new EnnemiVaisseauSpacialDivise(this.getEnvironnement(), this.getPv() / 2, this.getV(), this.getGain() / 2, this.XProperty().getValue(), this.YProperty().getValue());
                this.getEnvironnement().ajouterEnnemiDivision(ennemiDivise);
            }
        }
    }


    public double getVitesseInitiale(){return vitesseInitiale;}

}
