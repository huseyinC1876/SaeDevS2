package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonBombeNucleaire;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty degat = new SimpleIntegerProperty(50);
    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    public static IntegerProperty prixT = new SimpleIntegerProperty(1750);
    //TODO : ajout projectile. Pr l'instant, j'ai créé la classe projectile et la classe ProjectileVue. j'ai initialize les vues dans le controller
    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, int x, int y) {
        super(environnement, x, y, 1750);
        tempsRecharge = new SimpleIntegerProperty(50);
        degat = new SimpleIntegerProperty(50);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, 50, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1);
    }

    public static void amelioration(int nvDegat, int temps){
        degat.setValue(nvDegat);
        tempsRecharge.setValue(temps);
    }

    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }

}


