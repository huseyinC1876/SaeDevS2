package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanon extends Tour{
    private IntegerProperty degat;
    private IntegerProperty tempsRecharge;




    public TourCanon(Environnement environnement, double x, double y, int coutAmelioration, int rayonPerimetreAction, IntegerProperty tempsRecharge, IntegerProperty degat) {
        super(environnement, x, y, coutAmelioration, rayonPerimetreAction);
        this.tempsRecharge = tempsRecharge;
        this.degat = degat;
    }

    public void setTempsRecharge(IntegerProperty temps){
        this.tempsRecharge = temps;
    }

    public void setDegat(IntegerProperty degat){
        this.degat = degat;
    }
}
