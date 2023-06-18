package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;


public abstract class TourTeteChercheuse extends TourPerimetre {

    private int tempsLastEnnemi;

    public TourTeteChercheuse(Environnement environnement, int x, int y, int rayonPerimetreAction) {
        super(environnement, x, y, rayonPerimetreAction);
        this.tempsLastEnnemi = 0;
    }


    /**
     * On vérifie si un ennemi est présent dans le périmètre d'action de la tour
     * Dès qu'un ennemi est récupéré, on ajoute un nouveau projectile qui va viser cet ennemi + le tempsLastEnnemi est mis à jour
     *
     * @param temps
     */
    public void recupererEnnemiCible(int temps) {
        boolean quit = false;
        Ennemi ennemi;
        for (int i = 0; i < this.getEnvironnement().getListeEnnemis().size(); i++) {
            ennemi = this.getEnvironnement().getListeEnnemis().get(i);
            if (hasEnnemiDansPerimetre(ennemi)){
                if (this instanceof TourCanonLaser) {
                    this.getEnvironnement().ajouterProjectileTeteChercheuse(1, this.XProperty().getValue(), this.YProperty().getValue(), Parametre.degatCanonLaser.getValue() + ((this.getEnvironnement().getNiveauCanonLaser() - 1) * 10), ennemi);
                }
            if (this instanceof TourCanonMissile) {
                this.getEnvironnement().ajouterProjectileTeteChercheuse(2, this.XProperty().getValue(), this.YProperty().getValue(), Parametre.degatCanonMissile.getValue() + ((this.getEnvironnement().getNiveauCanonLaser() - 1) * 20), ennemi);
            }
            this.tempsLastEnnemi = temps;
            quit = true;
        }
        if (quit) break;
    }
}


    public int getTempsLastEnnemi() {
        return tempsLastEnnemi;
    }
}
