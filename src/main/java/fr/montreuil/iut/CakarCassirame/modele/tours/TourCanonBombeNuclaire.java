package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonBombeNucleaire;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    public static IntegerProperty tempsRecharge = new SimpleIntegerProperty(10);
    //TODO : ajout projectile. Pr l'instant, j'ai créé la classe projectile et la classe ProjectileVue. j'ai initialize les vues dans le controller
    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, int x, int y) {
        super(environnement, x, y);
        tempsRecharge = new SimpleIntegerProperty(50);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, Parametre.degatCanonNuclaire.getValue(), new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1);
    }





    public static void amelioration() {

    }

    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }

}


