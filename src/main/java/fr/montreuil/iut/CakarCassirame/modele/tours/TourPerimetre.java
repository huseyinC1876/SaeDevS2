package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;

public abstract class TourPerimetre extends Tour{
        private static int rayonPerimetreAction;

        public TourPerimetre(Environnement environnement, int x, int y, int coutAmelioration, int rayonPerimetreAction) {

            super(environnement, x, y, coutAmelioration);
            this.rayonPerimetreAction = rayonPerimetreAction;
        }

    @Override
    public void attaquer() {}

    public static int getRayonPerimetreAction(){return rayonPerimetreAction;}

    public boolean hasEnnemiDansPerimetre(Ennemi ennemi){
        return Math.sqrt(Math.pow(this.XProperty().getValue() - ennemi.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - ennemi.YProperty().getValue(), 2)) <= this.getRayonPerimetreAction();
    }
}
