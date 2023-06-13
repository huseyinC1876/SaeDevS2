package fr.montreuil.iut.CakarCassirame.modele.projectiles;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.beans.property.IntegerProperty;

public class ProjectileCanonMissile extends ProjectileTeteChercheuse{
    public ProjectileCanonMissile(Environnement env, int degat, IntegerProperty x, IntegerProperty y, int v, Ennemi ennemi) {
        super(env, degat, x, y, v, ennemi);
    }

}
