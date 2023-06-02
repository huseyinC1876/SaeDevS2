package fr.montreuil.iut.CakarCassirame.modele;

public class TourChampDeForce extends Tour{
    public TourChampDeForce(Environnement environnement, double x, double y) {
        super(environnement, x, y, 750, 30);
    }

    public void attaquer(Ennemi ennemi) {
        if (valAbs(ennemi.XProperty().getValue() - this.XProperty().getValue()) <= this.getRayonPerimetreAction() && valAbs(ennemi.YProperty().getValue() - this.YProperty().getValue()) <= this.getRayonPerimetreAction()) {
            ennemi.setVitesse(0.75);
        }
    }
}
