package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;

public abstract class TourPerimetre extends Tour{
    private static int rayonPerimetreAction;

    public TourPerimetre(Environnement environnement, int x, int y,int rayonPerimetreAction) {
        super(environnement, x, y);
        this.rayonPerimetreAction = rayonPerimetreAction;
    }


    public static int getRayonPerimetreAction(){return rayonPerimetreAction;}

    /**
     * Verifie si un ennemi est présent dans le périmètre de la tour
     */
    public boolean hasEnnemiDansPerimetre(Ennemi ennemi){
        return Math.sqrt(Math.pow(this.XProperty().getValue() - ennemi.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - ennemi.YProperty().getValue(), 2)) <= this.getRayonPerimetreAction();
    }
}
