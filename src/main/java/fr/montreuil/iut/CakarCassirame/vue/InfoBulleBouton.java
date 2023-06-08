package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.TourCanonBombeNuclaire;
import fr.montreuil.iut.CakarCassirame.modele.TourCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.TourCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.TourChampDeForce;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public abstract class InfoBulleBouton {

    private Button buttonCanonLaser;
    private Button buttonCanonMissile;
    private Button buttonChampDeForce;
    private Button buttonCanonNucleaire;

    public InfoBulleBouton(Button buttonCanonLaser, Button buttonCanonMissile, Button buttonChampDeForce, Button buttonCanonNucleaire) {
        this.buttonCanonLaser = buttonCanonLaser;
        this.buttonCanonMissile = buttonCanonMissile;
        this.buttonChampDeForce = buttonChampDeForce;
        this.buttonCanonNucleaire = buttonCanonNucleaire;
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


}
