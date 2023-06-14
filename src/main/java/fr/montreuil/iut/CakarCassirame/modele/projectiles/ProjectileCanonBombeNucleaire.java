package fr.montreuil.iut.CakarCassirame.modele.projectiles;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public class ProjectileCanonBombeNucleaire extends Projectile {
    public ProjectileCanonBombeNucleaire(Environnement env, int degat, IntegerProperty x, IntegerProperty y, int v) {
        super(env, degat, x, y, v);
    }

    @Override
    public void seDeplacer() {
        // x droite
        if (this.XProperty().getValue() < this.getEnv().getMap().getTileMapWidth() * 32 / 2) {
            this.XProperty().setValue(this.XProperty().getValue() + this.getV());
        } else { // x gauche
            this.XProperty().setValue(this.XProperty().getValue() - this.getV());
        }

        // y haut
        if (this.YProperty().getValue() < this.getEnv().getMap().getTileMapHeight() * 32 / 2) {
            this.YProperty().setValue(this.YProperty().getValue() + this.getV());
        } else { // y bas
            this.YProperty().setValue(this.YProperty().getValue() - this.getV());
        }
    }


    @Override
    public void attaquer() {
        if(this.YProperty().getValue() == this.getEnv().getMap().getTileMapHeight() * 32 / 2 && this.XProperty().getValue() ==this.getEnv().getMap().getTileMapWidth() * 32 / 2 && getHasAttacked() == false) {
            for(int i = 0 ; i < this.getEnv().getListeEnnemis().size() ; i++) {
                this.getEnv().getListeEnnemis().get(i).décrémenterPV(this.getDegat());
            }
            setHasAttacked(true);
        }
    }
}
