package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.scene.layout.Pane;

public class VenteVue {

    private Pane pane;
    private Environnement environnement;


    public VenteVue(Pane pane, Environnement environnement) {
        this.pane = pane;
        this.environnement = environnement;
    }

    public void reset(){
        for (int i = 0; i < environnement.getListeTours().size(); i++){
            pane.lookup("#" + environnement.getListeTours().get(i).getId()).setOpacity(1);
        }
    }

    public void affichaged(){
        //this.pane.setVisible(true);
        for (int i = 0; i < environnement.getListeTours().size(); i++){
            pane.lookup("#" + environnement.getListeTours().get(i).getId()).setOpacity(0.5);
        }
    }
}
