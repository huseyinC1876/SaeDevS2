package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TourCanonMissile extends TourTeteChercheuse{
    public static IntegerProperty prixA = new SimpleIntegerProperty(400);
    public static IntegerProperty prixT = new SimpleIntegerProperty(200);

    private ProjectileCanonMissile projectile;
    public TourCanonMissile(Environnement environnement, int x, int y) {
        super(environnement, x, y, 200, 50, 500, 20);
    }

    public static void amelioration(/*int nvDegat, int temps*/){
        degat.setValue(degat.getValue() * 2); //nvDegat * 2
        if (tempsRecharge.getValue() > 0) {
            tempsRecharge.setValue(tempsRecharge.getValue() - 1);
        }
        prixA.setValue(prixA.getValue() * 2);
    }
}
