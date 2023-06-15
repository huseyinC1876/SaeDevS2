package fr.montreuil.iut.CakarCassirame.vue.infobulleVue;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.scene.control.Button;

public abstract class InfoBulleBouton {

    private Button buttonCanonLaser;
    private Button buttonCanonMissile;
    private Button buttonChampDeForce;
    private Button buttonCanonNucleaire;

    private Environnement environnement;

    public InfoBulleBouton(Button buttonCanonLaser, Button buttonCanonMissile, Button buttonChampDeForce, Button buttonCanonNucleaire, Environnement environnement) {
        this.buttonCanonLaser = buttonCanonLaser;
        this.buttonCanonMissile = buttonCanonMissile;
        this.buttonChampDeForce = buttonChampDeForce;
        this.buttonCanonNucleaire = buttonCanonNucleaire;
        this.environnement = environnement;
        /*
        infobulleLaser();
        infobulleMissile();
        infobulleChamp();
        infobulleNucleaire();

         */
    }

    public Button getButtonCanonLaser() {
        return buttonCanonLaser;
    }

    public Button getButtonCanonMissile() {
        return buttonCanonMissile;
    }

    public Button getButtonChampDeForce() {
        return buttonChampDeForce;
    }

    public Button getButtonCanonNucleaire() {
        return buttonCanonNucleaire;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public abstract void infobulleLaser();
    /*
    {
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonLaser.degat);
        this.buttonCanonLaser.setTooltip(tooltip);
    }

     */

    public abstract void infobulleMissile();
    /*{
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonMissile.degat);
        this.buttonCanonMissile.setTooltip(tooltip);
    }

     */

    public abstract void infobulleChamp(); /*{
        Tooltip tooltip = new Tooltip("Reduc vitesse -> "+(int) -(TourChampDeForce.pourcentageReduction * 100 - 100) +"%");
        this.buttonChampDeForce.setTooltip(tooltip);
    }
    */

    public abstract void infobulleNucleaire(); /*{
        Tooltip tooltip = new Tooltip("Atq -> "+ TourCanonBombeNuclaire.degat);
        this.buttonCanonNucleaire.setTooltip(tooltip);
    }
    */
    public abstract void mAJ();


}
