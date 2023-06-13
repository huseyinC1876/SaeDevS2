package fr.montreuil.iut.CakarCassirame.vue.infobulleVue;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonBombeNuclaire;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourChampDeForce;
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
        IntegerProperty degat = new SimpleIntegerProperty();
        degat.bind(TourCanonLaser.degat);
        IntegerProperty tempsRecharge = new SimpleIntegerProperty();
        degat.bind(TourCanonLaser.tempsRecharge);


        Tooltip tooltip = new Tooltip("Atq -> "+ degat  + "\n Temps de recharge -> " + tempsRecharge + "s");
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
