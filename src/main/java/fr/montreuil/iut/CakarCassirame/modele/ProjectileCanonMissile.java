package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.DoubleProperty;

public class ProjectileCanonMissile extends Projectile{
    public ProjectileCanonMissile(Environnement env, int degat, DoubleProperty x, DoubleProperty y, int v) {
        super(env, degat, x, y, v);
    }

    @Override
    public void seDeplacer() {

    }

    @Override
    public void attaquer() {

    }
}
