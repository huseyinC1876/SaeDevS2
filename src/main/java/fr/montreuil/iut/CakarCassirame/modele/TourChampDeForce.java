package fr.montreuil.iut.CakarCassirame.modele;

public class TourChampDeForce extends TourPerimetre {

//    private int rayonPerimetreAction;

    public TourChampDeForce(Environnement environnement, double x, double y) {

        super(environnement, x, y, 750, 100);
//        this.rayonPerimetreAction = 100;
    }


    public void attaquer() {
        double vitesseInit;
        for(int i = 0 ; i < this.getEnvironnement().getListeEnnemis().size() ; i++) {
            Ennemi ennemi = this.getEnvironnement().getListeEnnemis().get(i);
            if (ennemi instanceof EnnemiExtraterrestre)
            vitesseInit = EnnemiExtraterrestre.vitesseInitiale;
        else if (ennemi instanceof EnnemiVaisseauSpatial)
            vitesseInit = EnnemiVaisseauSpatial.vitesseInitiale;
        else
            vitesseInit = EnnemiSuperVaisseauSpatial.vitesseInitiale;

            if (!(ennemi instanceof EnnemiGalactusBoss) && hasEnnemiDansPerimetre(ennemi) && ennemi.getV() == vitesseInit) {
                ennemi.setVitesse(ennemi.getV() - 1);
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

//    public int getRayonPerimetreAction(){return this.rayonPerimetreAction;}

}
