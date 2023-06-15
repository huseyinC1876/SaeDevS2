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


    //Les projectiles et les ennemis ont une vitesse différentes --> ils ne seront jamais à la même position.
    //Si le projectile est situé à  - de 3 pixels de l'ennemi, l'ennemi est attaqué (PV décrémentés)
    @Override
    public void attaquer() {
        if (Math.abs(this.YProperty().getValue() - this.ennemiCible.YProperty().getValue()) < 3 && Math.abs(this.XProperty().getValue() - this.ennemiCible.XProperty().getValue()) < 3) {
            this.ennemiCible.décrémenterPV(this.getDegat());
            //hasAttacked devient true --> permet que le projectile soit supprimé de la liste et disparaisse de la Map
            setHasAttacked(true);
        }
    }

}
