package fr.montreuil.iut.CakarCassirame.modele;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Map {

    private int[][] tileMap = new int[20][30];
            // 1 = base ennemie
            // 0 = notre base
            // 2 = chemin
            // 3 = vide intersideral
    public Map(String lien) throws IOException {
        this.tileMap = map(lien);


    }

    public int getTile(int x, int y){
        return this.tileMap[x][y];
    }

    public int[][] getTileMap(){
        return this.tileMap;
    }
    public int[] debutMapEnnemie(){
        int[] placement = new int[2];
        for (int i = 0; i < tileMap.length; i++){
            for (int j = 0; j < tileMap[i].length; j++){
                if(i < tileMap.length - 2 && tileMap[i][j] == 1 && tileMap[i + 1][j] == 2){
                    placement[0] = (i + 1) * 32;
                    placement[1] = j * 32;
                }
                else if(i > 0 && tileMap[i][j] == 1 && tileMap[i - 1][j] == 2){
                    placement[0] = (i - 1) * 32;
                    placement[1] = j * 32;
                }
                else if(j < tileMap.length - 2 && tileMap[i][j] == 1 && tileMap[i][j + 1] == 2){
                    placement[0] = i * 32;
                    placement[1] = (j + 1) * 32;
                }

                else if(j > 0 && tileMap[i][j] == 1 && tileMap[i][j - 1] == 2){
                    placement[0] = i * 32;
                    placement[1] = (j - 1) * 32;
                }
            }
        }
        return placement;
    }

    public int[][] map(String lien) throws IOException {
        //System.out.println(lien);
        int[][] map = new int[20][30];
        File file = new File(lien);
        // Créer l'objet File Reader
        FileReader fr = new FileReader(file);
        // Créer l'objet BufferedReader
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        int i = 0;

        String strng;
        while((strng = br.readLine()) != null) {
            sb.append(strng);
            sb.append("\n");
            //System.out.println(strng);
            //System.out.println(strng.length());
            //System.out.println(strng.charAt(1));
            //System.out.println(strng.indexOf(11));
            int c = 0;

            for(int j = 0; j < strng.length(); j++) {
                if (strng.charAt(j) != ',') {
                    String val = String.valueOf(strng.charAt(j));
                    map[i][c] = Integer.parseInt(val);
                    //System.out.println(map[i][c]);
                    c++;
                }
                //System.out.println(Arrays.toString(map));
            }


            //System.out.println(Arrays.toString(map));
            i++;

        }

        return map;
    }


}
