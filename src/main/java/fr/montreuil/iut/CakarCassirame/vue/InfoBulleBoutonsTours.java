package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.TourCanonBombeNuclaire;
import fr.montreuil.iut.CakarCassirame.modele.TourCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.TourCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.TourChampDeForce;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class InfoBulleBoutonsTours extends InfoBulleBouton{
    public InfoBulleBoutonsTours(Button buttonCanonLaser, Button buttonCanonMissile, Button buttonChampDeForce, Button buttonCanonNucleaire) {
        super(buttonCanonLaser, buttonCanonMissile, buttonChampDeForce, buttonCanonNucleaire);
        infobulleLaser();
        infobulleMissile();
        infobulleChamp();
        infobulleNucleaire();
    }

    @Override
    public void infobulleLaser() {
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonLaser.degat  + "\n Temps de recharge -> " + TourCanonLaser.tempsRecharge.getValue() + "s");
        super.getButtonCanonLaser().setTooltip(tooltip);
    }

    @Override
    public void infobulleMissile() {
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonMissile.degat  + "\n Temps de recharge -> " + TourCanonMissile.tempsRecharge.getValue() + "s");
        super.getButtonCanonMissile().setTooltip(tooltip);
    }

    @Override
    public void infobulleChamp() {
        Tooltip tooltip = new Tooltip("Reduc vitesse -> "+(int) -(TourChampDeForce.pourcentageReduction * 100 - 100) +"%");
        super.getButtonChampDeForce().setTooltip(tooltip);
    }

    @Override
    public void infobulleNucleaire() {
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonBombeNuclaire.degat  + "\n Temps de recharge -> " + TourCanonBombeNuclaire.tempsRecharge.getValue() + "s");
        super.getButtonCanonNucleaire().setTooltip(tooltip);
    }
}
