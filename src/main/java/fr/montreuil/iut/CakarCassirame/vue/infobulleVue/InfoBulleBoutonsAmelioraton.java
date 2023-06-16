package fr.montreuil.iut.CakarCassirame.vue.infobulleVue;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourChampDeForce;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class InfoBulleBoutonsAmelioraton extends InfoBulleBouton{
    public InfoBulleBoutonsAmelioraton(Button buttonCanonLaser, Button buttonCanonMissile, Button buttonChampDeForce, Button buttonCanonNucleaire, Environnement environnement) {
        super(buttonCanonLaser, buttonCanonMissile, buttonChampDeForce, buttonCanonNucleaire, environnement);
        infobulleLaser();
        infobulleMissile();
        infobulleChamp();
        infobulleNucleaire();
    }

    @Override
    public void infobulleLaser() {
        if(this.getEnvironnement().getNiveauCanonLaser() < this.getEnvironnement().niveauMaxCanonProperty().getValue()) {
            Tooltip tooltip = new Tooltip("Atq : " + (Parametre.degatCanonLaser.getValue() + ((this.getEnvironnement().getNiveauCanonLaser() - 1) * 10)) + "  ->  " + (Parametre.degatCanonLaser.getValue() + (this.getEnvironnement().getNiveauCanonLaser() * 10)) + "\n Temps de recharge : " + (Parametre.tempsRechargeCanonLaser.getValue() - (this.getEnvironnement().getNiveauCanonLaser() - 1) * 10) + "s   ->     " + (Parametre.tempsRechargeCanonLaser.getValue() - (this.getEnvironnement().getNiveauCanonLaser()) * 10) + "s");
            super.getButtonCanonLaser().setTooltip(tooltip);
        }
        else{
            Tooltip tooltip = new Tooltip("Niveau Max");
            super.getButtonCanonLaser().setTooltip(tooltip);
        }
    }

    @Override
    public void infobulleMissile() {
        if(this.getEnvironnement().getNiveauCanonMissile() < this.getEnvironnement().niveauMaxCanonProperty().getValue()) {
            Tooltip tooltip = new Tooltip("Atq : " + (Parametre.degatCanonMissile.getValue() + ((this.getEnvironnement().getNiveauCanonMissile() - 1) * 20)) + "  ->  " + (Parametre.degatCanonMissile.getValue() + (this.getEnvironnement().getNiveauCanonMissile() * 10)) + "\n Temps de recharge : " + (Parametre.tempsRechargeCanonMissile.getValue() - (this.getEnvironnement().getNiveauCanonMissile() - 1) * 10) + "s   ->     " + (Parametre.tempsRechargeCanonMissile.getValue() - (this.getEnvironnement().getNiveauCanonMissile()) * 10) + "s");
            super.getButtonCanonMissile().setTooltip(tooltip);
        }
        else{
            Tooltip tooltip = new Tooltip("Niveau Max");
            super.getButtonCanonMissile().setTooltip(tooltip);
        }
    }

    @Override
    public void infobulleChamp() {
        if(this.getEnvironnement().getNiveauChampForce() < this.getEnvironnement().niveauMaxChampProperty().getValue()) {
            Tooltip tooltip = new Tooltip("Reduc vitesse : "+(int) -(TourChampDeForce.pourcentageReduction * 100 - 100) +"%     ->  " + ((int) -((TourChampDeForce.pourcentageReduction -0.25) * 100 - 100)) + "%" );
            super.getButtonChampDeForce().setTooltip(tooltip);
        }
        else{
            Tooltip tooltip = new Tooltip("Niveau Max");
            super.getButtonChampDeForce().setTooltip(tooltip);
        }
    }

    @Override
    public void infobulleNucleaire() {
        if(this.getEnvironnement().getNiveauCanonNucleaire() < this.getEnvironnement().niveauMaxCanonProperty().getValue()) {
            Tooltip tooltip = new Tooltip("Atq : " + (Parametre.degatCanonNuclaire.getValue() + ((this.getEnvironnement().getNiveauCanonNucleaire() - 1) * 10)) + "  ->  " + (Parametre.degatCanonNuclaire.getValue() + (this.getEnvironnement().getNiveauCanonNucleaire() * 10)) + "\n Temps de recharge : " + (Parametre.tempsRechargeCanonNuclaire.getValue() - (this.getEnvironnement().getNiveauCanonNucleaire() - 1) * 10) + "s   ->     " + (Parametre.tempsRechargeCanonNuclaire.getValue() - (this.getEnvironnement().getNiveauCanonNucleaire()) * 10) + "s");
            super.getButtonCanonNucleaire().setTooltip(tooltip);
        }
        else{
            Tooltip tooltip = new Tooltip("Niveau Max");
            super.getButtonCanonNucleaire().setTooltip(tooltip);
        }
    }

    public void mAJ(){
        infobulleLaser();
        infobulleMissile();
        infobulleNucleaire();
        infobulleChamp();
    }
}
