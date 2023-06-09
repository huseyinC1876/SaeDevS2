package fr.montreuil.iut.CakarCassirame.vue.ennemiVue;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.EnnemiDivise;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class EnnemieVue {
    private Pane pane;
    private String file;

    public EnnemieVue(Pane pane, String file) {
        this.pane = pane;
        this.file = file;
    }

    public void creerSprite(Ennemi ennemi) throws FileNotFoundException {
        ImageView imageViewsSpaceChip = new ImageView(new Image(new FileInputStream(this.file)));
        imageViewsSpaceChip.setId(ennemi.getId());
        imageViewsSpaceChip.translateXProperty().bind(ennemi.XProperty());
        imageViewsSpaceChip.translateYProperty().bind(ennemi.YProperty());
        if (ennemi instanceof EnnemiDivise) {
            imageViewsSpaceChip.setFitWidth(16);
            imageViewsSpaceChip.setFitHeight(16);
        }
        this.pane.getChildren().add(imageViewsSpaceChip);

        ProgressBar HP = new ProgressBar();
        HP.setId(ennemi.getId() + "-progress");
        HP.progressProperty().bind(ennemi.PVProperty().divide(ennemi.getPvMax()));
        HP.translateYProperty().bind(ennemi.YProperty().subtract(15));
        HP.translateXProperty().bind(ennemi.XProperty().add(2.5));
        HP.setPrefHeight(15);
        HP.setPrefWidth(28);
        this.pane.getChildren().add(HP);
    }
}