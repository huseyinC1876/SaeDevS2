package fr.montreuil.iut.CakarCassirame.vue.infobulleVue;


import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonBombeNuclaire;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourChampDeForce;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class InfoBulleBoutonsTours extends InfoBulleBouton{
    public InfoBulleBoutonsTours(Button buttonCanonLaser, Button buttonCanonMissile, Button buttonChampDeForce, Button buttonCanonNucleaire, Environnement environnement) {
        super(buttonCanonLaser, buttonCanonMissile, buttonChampDeForce, buttonCanonNucleaire, environnement);
        infobulleLaser();
        infobulleMissile();
        infobulleChamp();
        infobulleNucleaire();
    }

    @Override
    public void infobulleLaser() {
        Tooltip tooltip = new Tooltip("Atq -> "+ (Parametre.degatCanonLaser.getValue() + this.getEnvironnement().getNiveauCanonLaser() - 1)  + "\n Temps de recharge -> " + (Parametre.tempsRechargeCanonLaser.getValue() - (this.getEnvironnement().getNiveauCanonLaser() - 1) * 10) + "s");
        super.getButtonCanonLaser().setTooltip(tooltip);
    }

    @Override
    public void infobulleMissile() {
        Tooltip tooltip = new Tooltip("Atq -> "+ Parametre.degatCanonMissile.getValue() + this.getEnvironnement().getNiveauCanonMissile()  + "\n Temps de recharge -> " + Parametre.tempsRechargeCanonMissile.getValue() + "s");
        super.getButtonCanonMissile().setTooltip(tooltip);
    }

    @Override
    public void infobulleChamp() {
        Tooltip tooltip = new Tooltip("Reduc vitesse -> "+(int) -(TourChampDeForce.pourcentageReduction * 100 - 100) +"%");
        super.getButtonChampDeForce().setTooltip(tooltip);
    }

    @Override
    public void infobulleNucleaire() {
        Tooltip tooltip = new Tooltip("Atq -> "+ (Parametre.degatCanonNuclaire.getValue() + this.getEnvironnement().getNiveauCanonNucleaire())  + "\n Temps de recharge -> " + (Parametre.tempsRechargeCanonNuclaire.getValue() - this.getEnvironnement().getNiveauCanonNucleaire()) * 10 + "s");
        super.getButtonCanonNucleaire().setTooltip(tooltip);
    }

    public void mAJ(){
        infobulleLaser();
        infobulleMissile();
        infobulleChamp();
        infobulleNucleaire();
    }
}
