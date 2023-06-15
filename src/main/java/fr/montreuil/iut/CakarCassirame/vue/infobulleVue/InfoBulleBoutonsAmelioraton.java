package fr.montreuil.iut.CakarCassirame.vue.infobulleVue;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
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
        Tooltip tooltip = new Tooltip("Atq : "+ (Parametre.degatCanonLaser.getValue() + this.getEnvironnement().getNiveauCanonLaser() - 1) + "  ->  " + (Parametre.degatCanonLaser.getValue() + this.getEnvironnement().getNiveauCanonLaser())   + "\n Temps de recharge : " + (Parametre.tempsRechargeCanonLaser.getValue() - (this.getEnvironnement().getNiveauCanonLaser() - 1) * 10) + "s   ->     " + (Parametre.tempsRechargeCanonLaser.getValue() - (this.getEnvironnement().getNiveauCanonLaser()) * 10) +"s");
        super.getButtonCanonLaser().setTooltip(tooltip);
    }

    @Override
    public void infobulleMissile() {

    }

    @Override
    public void infobulleChamp() {

    }

    @Override
    public void infobulleNucleaire() {

    }

    public void mAJ(){
        infobulleLaser();
        infobulleMissile();
        infobulleNucleaire();
        infobulleChamp();
    }
}
