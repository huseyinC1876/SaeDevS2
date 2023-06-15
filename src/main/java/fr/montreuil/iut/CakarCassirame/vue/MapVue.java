package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapVue {

    private TilePane tilePane;
    public MapVue(TilePane tilePane){
        this.tilePane = tilePane;
    }


    public void creerMap(Map map) throws FileNotFoundException {
        int[][] terrain = map.getTileMap();
        for(int i = 0 ; i < terrain.length ; i++){
            for(int j = 0 ; j < terrain[i].length ; j++){
                if(terrain[i][j] == 0) {
                    Image image0 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/bleu32.jpg"));
                    ImageView image0bis = new ImageView(image0);
                    tilePane.getChildren().add(image0bis);
                }
                else if(terrain[i][j] == 1) {
                    Image image1 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/gris32.jpg"));
                    ImageView image1bis = new ImageView(image1);
                    tilePane.getChildren().add(image1bis);
                }
                else if(terrain[i][j] == 2) {
                    Image image2 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/arc32.jpg"));
                    ImageView image2bis = new ImageView(image2);
                    tilePane.getChildren().add(image2bis);
                }
                else{
                    Image image3 = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/Space32.jpg"));
                    ImageView image3bis = new ImageView(image3);
                    tilePane.getChildren().add(image3bis);
                }
            }
        }
    }
}
