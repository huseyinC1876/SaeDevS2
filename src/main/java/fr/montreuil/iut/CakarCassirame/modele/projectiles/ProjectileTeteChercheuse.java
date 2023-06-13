package fr.montreuil.iut.CakarCassirame.modele.projectiles;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import javafx.beans.property.IntegerProperty;

public abstract class ProjectileTeteChercheuse extends Projectile {

    private Ennemi ennemiCible;

    public ProjectileTeteChercheuse(Environnement env, int degat, IntegerProperty x, IntegerProperty y, int v, Ennemi ennemi) {
        super(env, degat, x, y, v);
        this.ennemiCible = ennemi;
    }

    @Override
    public void seDeplacer() {
        if (this.ennemiCible != null) {
            // x droite
            if (this.XProperty().getValue() < this.ennemiCible.XProperty().getValue()) {
                this.XProperty().setValue(this.XProperty().getValue() + this.getV());
            } else { // x gauche
                this.XProperty().setValue(this.XProperty().getValue() - this.getV());
            }

            // y haut
            if (this.YProperty().getValue() < this.ennemiCible.YProperty().getValue()) {
                this.YProperty().setValue(this.YProperty().getValue() + this.getV());
            } else { // y bas
                this.YProperty().setValue(this.YProperty().getValue() - this.getV());
            }
        }
    }

    @Override
    public void attaquer() {
        System.out.println("ATTAQUER PROJ ATTAQUER PROJ ATTAQUER PROJ ATTAQUER PROJ ATTAQUER PROJ ATTAQUER PROJ");
            if (Math.abs(this.YProperty().getValue() - this.ennemiCible.YProperty().getValue()) <3 && Math.abs(this.XProperty().getValue() - this.ennemiCible.XProperty().getValue()) <3) {
                System.out.println("DECREMENTE PV ENNEMI");
                this.ennemiCible.décrémenterPV(this.getDegat());
                setHasAttacked(true);
//            }
        }
    }

}
