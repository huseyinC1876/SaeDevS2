package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ennemie {

    private int pv;
    private int v;
    private int gain;
    private IntegerProperty x,y;
    public static int compteur = 0;
    private String id;

    private int xBackUp, yBackUp;

    private int[]  positionBackUp = new int[2];

    private Environnement environnement;



    public Ennemie(Environnement environnement){
        this.pv = 30;
        this.v = 5;
        this.gain = 35;
        this.x = new SimpleIntegerProperty(80);
        this.y = new SimpleIntegerProperty(135);
        compteur +=1;
        this.id = String.valueOf(compteur);
        this.environnement = environnement;
        this.xBackUp = this.x.getValue()/32;
        this.yBackUp = this.y.getValue()/32;
        positionBackUp[0] = this.y.getValue()/32;
        positionBackUp[1] = this.x.getValue()/32;
    }

    public IntegerProperty XProperty(){ return this.x;}

    public IntegerProperty YProperty(){ return this.y;}

    public String getId() { return this.id; }

    public int getPv() { return pv; }

    public void seDeplacer(){
        /*
        for(int i = 0 ; i < this.environnement.getMap().getTileMap().length; i++ ){
            for(int j = 0; j < this.environnement.getMap().getTileMap()[0].length; j++){
                if(this.environnement.getMap().getTileMap()[i][j] - ((int)(this.x.getValue() /32) + 1 ) == 2) {
                    this.x.setValue(this.x.getValue() + this.v);
                }
                if(this.environnement.getMap().getTileMap()[i][j] - ((int)(this.y.getValue() /32) + 1 ) < 33) {
                    this.x.setValue(this.y.getValue() + this.v);
                }
            }
        }
        */

        /*
        System.out.println((int)this.x.getValue()/32);

        if(this.environnement.getMap().getTileMap()[((int)this.x.getValue()/32)+ 1][(int) this.y.getValue()/32] == 2){
            this.x.setValue(this.x.getValue() + this.v);
        }
        else if ((this.environnement.getMap().getTileMap()[((int)this.x.getValue()/32)][((int) this.y.getValue()/32) + 1] == 2)){
            this.y.setValue(this.y.getValue() + this.v);
        }
        else if ((this.environnement.getMap().getTileMap()[((int)this.x.getValue()/32)][((int) this.y.getValue()/32) - 1] == 2)){
            this.y.setValue(this.y.getValue() + this.v);
        }
        */






        if(!(positionBackUp[0] == this.y.getValue()/32 && positionBackUp[1] == this.x.getValue()/32+1)  && this.environnement.getMap().getTileMap()[this.y.getValue()/32][(this.x.getValue()/32)+ 1] == 2){
            this.xBackUp = this.x.getValue()/32;
            this.positionBackUp[1] = this.x.getValue()/32;
            this.x.setValue(this.x.getValue() + this.v);
        }
        else if (!(positionBackUp[0] == this.y.getValue()/32+1 && positionBackUp[1] == this.x.getValue()/32) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) + 1][(this.x.getValue()/32)] == 2)){
            this.yBackUp = this.y.getValue()/32;
            this.positionBackUp[0] = this.y.getValue()/32;
            this.y.setValue(this.y.getValue() + this.v);
            System.out.println(2);
        }
        else if (!(positionBackUp[0] == this.y.getValue()/32-1 && positionBackUp[1] == this.x.getValue()/32) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) - 1][(this.x.getValue()/32)] == 2)){
            this.yBackUp = this.y.getValue()/32;
            this.positionBackUp[0] = this.y.getValue()/32;
            this.y.setValue(this.y.getValue() - this.v);
            System.out.println(3);
        }

        else if(!(positionBackUp[0] == this.y.getValue()/32 && positionBackUp[1] == this.x.getValue()/32- 1) && this.environnement.getMap().getTileMap()[this.y.getValue()/32][(this.x.getValue()/32) - 1] == 2){
            this.xBackUp = this.x.getValue()/32;
            this.positionBackUp[1] = this.x.getValue()/32;
            this.x.setValue(this.x.getValue() - this.v);
        }



    }
}
