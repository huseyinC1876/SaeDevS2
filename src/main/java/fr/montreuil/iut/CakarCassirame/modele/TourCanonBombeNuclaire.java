package fr.montreuil.iut.CakarCassirame.modele;

public class TourCanonBombeNuclaire extends TourCanon{
    public TourCanonBombeNuclaire(Environnement environnement, double x, double y, int tempsRecharge, int coutAmelioration, int rayonPerimetreAction, int degat) {
        super(environnement, x, y, 1750, 40, 10, 50);
    }
}
