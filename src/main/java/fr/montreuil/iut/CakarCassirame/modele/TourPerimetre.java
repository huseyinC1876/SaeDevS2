package fr.montreuil.iut.CakarCassirame.modele;

public abstract class TourPerimetre extends Tour{
        private int rayonPerimetreAction;

        public TourPerimetre(Environnement environnement, double x, double y, int coutAmelioration, int rayonPerimetreAction) {

            super(environnement, x, y, coutAmelioration);
            this.rayonPerimetreAction = rayonPerimetreAction;
        }

    @Override
    public void attaquer(Ennemi ennemi) {}

    public int getRayonPerimetreAction(){return this.rayonPerimetreAction;}

    public boolean hasEnnemiDansPerimetre(Ennemi ennemi){
        return Math.sqrt(Math.pow(this.XProperty().getValue() - ennemi.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - ennemi.YProperty().getValue(), 2)) <= this.getRayonPerimetreAction();
    }
}
