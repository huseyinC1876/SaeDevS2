package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonBombeNucleaire;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class TourCanonBombeNuclaire extends Tour{

    private ProjectileCanonBombeNucleaire projectile;

    public TourCanonBombeNuclaire(Environnement environnement, int x, int y) {
        super(environnement, x, y);
        this.projectile = new ProjectileCanonBombeNucleaire(environnement, 50, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1);
    }
    @Override
    public void attaquer() {
            this.projectile.attaquer();
    }
}


