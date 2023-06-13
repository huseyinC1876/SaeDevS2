package fr.montreuil.iut.CakarCassirame.modele;

import java.io.IOException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        Map map = new MapNiv1();
        Map map2 = new MapNiv2();

        int[][] mapTab= map2.getTileMap();

        int[] placement = map2.debutMapEnnemie();

        System.out.println("Le placement est : " + Arrays.toString(placement));

        for(int i = 0; i < mapTab.length; i++){
            for (int j = 0; j < mapTab[i].length; j++){
                System.out.print(mapTab[i][j] + "   ");
            }
            System.out.println();
        }

        //System.out.println(Arrays.toString(AmapTab));
    }
}
