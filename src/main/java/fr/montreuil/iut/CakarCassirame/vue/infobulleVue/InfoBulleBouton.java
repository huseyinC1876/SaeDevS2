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

    public abstract void infobulleMissile();

    public abstract void infobulleChamp();

    public abstract void infobulleNucleaire();

    public abstract void mAJ();


}
