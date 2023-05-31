package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlacementVue {

    private TilePane tilePaneInterne;

    public PlacementVue(TilePane pane){
        this.tilePaneInterne = pane;
    }

    public void affichage(Map map) throws FileNotFoundException {



        int[][] terrain = map.getTileMap();
        for(int i = 0 ; i < terrain.length ; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if (terrain[i][j] == 3) {
                    Image image0 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/vertTrans.jpg"));
                    ImageView image0bis = new ImageView(image0);
                    image0bis.setOpacity(0.3);
                    tilePaneInterne.getChildren().add(image0bis);
                } else {
                    Image imageTrans= new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/vertTrans.jpg"));
                    ImageView imageTransbis = new ImageView(imageTrans);
                    imageTransbis.setOpacity(0);
                    tilePaneInterne.getChildren().add(imageTransbis);
                }
            }
        }
    }

    public void reset(){
        this.tilePaneInterne.getChildren().removeAll();
    }
}
