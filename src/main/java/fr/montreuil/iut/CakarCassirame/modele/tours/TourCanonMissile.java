package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;

public class TourCanonMissile extends TourTeteChercheuse{

    private ProjectileCanonMissile projectile;
    public TourCanonMissile(Environnement environnement, int x, int y) {
        super(environnement, x, y, 50, 500, Parametre.degatCanonMissile.getValue());
    }

    public static void amelioration(/*int nvDegat, int temps*/){
    }
}
