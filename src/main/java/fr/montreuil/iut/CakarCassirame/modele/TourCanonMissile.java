package fr.montreuil.iut.CakarCassirame.modele;

public class TourCanonMissile extends TourCanon{
    public TourCanonMissile(Environnement environnement, double x, double y, int tempsRecharge, int coutAmelioration, int rayonPerimetreAction, int degat) {
        super(environnement, x, y, 400, 20, 5, 20);
    }
}
