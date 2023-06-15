package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public abstract class TourTeteChercheuse extends TourPerimetre {
    public static IntegerProperty tempsRecharge;

    public static IntegerProperty degat;
    private int tempsLastEnnemi;

    public TourTeteChercheuse(Environnement environnement, int x, int y, int rayonPerimetreAction, int tempsRecharge, int degat) {
        super(environnement, x, y, rayonPerimetreAction);
        this.tempsRecharge = new SimpleIntegerProperty(tempsRecharge);
        this.degat = new SimpleIntegerProperty(degat);
        this.tempsLastEnnemi = 0;
    }

    public int getTempsRecharge() {
        return this.tempsRecharge.getValue();
    }

    /**
     * La méthode vérifie le temps de jeu
     * Si le temps est correct, on vérifie si un ennemi est présent dans le périmètre d'action de la tour
     * Dès qu'un ennemi est récupéré, on ajoute un nouveau projectile qui va viser cet ennemi.
     *
     * @param temps
     */
    public void recupererEnnemiCible(int temps) {
        boolean quit = false;
        Ennemi ennemi;
        for (int i = 0; i < this.getEnvironnement().getListeEnnemis().size(); i++) {
            ennemi = this.getEnvironnement().getListeEnnemis().get(i);
            if (Math.sqrt(Math.pow(this.XProperty().getValue() - ennemi.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - ennemi.YProperty().getValue(), 2)) <= this.getRayonPerimetreAction()) {
                if(this instanceof TourCanonLaser) {
                    this.getEnvironnement().ajouterProjectileTeteChercheuse(1, this.XProperty().getValue(), this.YProperty().getValue(), ennemi);
                }
                if(this instanceof TourCanonMissile){
                    this.getEnvironnement().ajouterProjectileTeteChercheuse(2, this.XProperty().getValue(), this.YProperty().getValue(), ennemi);
                }
                this.tempsLastEnnemi = temps;
                quit = true;
            }
            if (quit) break;
        }
    }


    public int getTempsLastEnnemi() {
        return tempsLastEnnemi;
    }
}
