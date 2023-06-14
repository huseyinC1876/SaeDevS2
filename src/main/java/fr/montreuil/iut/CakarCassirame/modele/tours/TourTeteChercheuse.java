package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class TourTeteChercheuse extends TourPerimetre{
    public static IntegerProperty tempsRecharge;
    public static IntegerProperty degat;

    public TourTeteChercheuse(Environnement environnement, int x, int y, int rayonPerimetreAction, int tempsRecharge, int degat) {
        super(environnement, x, y, rayonPerimetreAction);
        this.tempsRecharge = new SimpleIntegerProperty(tempsRecharge);
        this.degat = new SimpleIntegerProperty(degat);
    }


    public int getDegat(){return this.degat.getValue();}

    public int getTempsRecharge(){return this.tempsRecharge.getValue();}

    public void recupererEnnemiCible(int temps) {
        if (temps % this.getTempsRecharge() == 0 && temps != 0) {
            boolean quit = false;
            Ennemi ennemi;
            for (int i = 0; i < this.getEnvironnement().getListeEnnemis().size(); i++) {
                ennemi = this.getEnvironnement().getListeEnnemis().get(i);
                if (Math.sqrt(Math.pow(this.XProperty().getValue() - ennemi.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - ennemi.YProperty().getValue(), 2)) <= this.getRayonPerimetreAction()) {
                    this.getEnvironnement().ajouterProjectileTeteChercheuse(1, this.XProperty().getValue(), this.YProperty().getValue(), ennemi);
//                    System.out.println("AJOUTER PROJECTILE AJOUTER PROJECTILE");
                    quit = true;
                }
                if (quit) break;
            }
        }
    }
}
