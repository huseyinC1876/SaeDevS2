package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemi {

    private int pv;
    private double v;
    private int gain;
    private IntegerProperty x,y;
    public static int compteur = 0;
    private String id;
    private int xBackUp, yBackUp;
    private int[]  positionBackUp = new int[2];
    private Environnement environnement;
    private boolean enter;


    public Ennemi(Environnement environnement, int pv, double v, int gain){
        this.pv = pv;
        this.v = v;
        this.gain = gain;
        this.x = new SimpleIntegerProperty(65);
        this.y = new SimpleIntegerProperty(135);
        compteur +=1;
        this.id = String.valueOf(compteur);
        this.environnement = environnement;
        positionBackUp[0] = this.y.getValue()/32;
        positionBackUp[1] = this.x.getValue()/32;
    }

    public IntegerProperty XProperty(){ return this.x;}

    public IntegerProperty YProperty(){ return this.y;}

    public String getId() { return this.id; }

    public int getPv() { return pv; }

    public int getGain() {
        return gain;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public boolean getEnter() { return this.enter; }

    public double getV() {
        return v;
    }

    public void seDeplacer(){

        if((positionBackUp[1] != this.x.getValue()/32+1)  && this.environnement.getMap().getTileMap()[this.y.getValue()/32][(this.x.getValue()/32)+ 1] == 2 && !enter){
            this.positionBackUp[0] = this.y.getValue()/32;
            this.x.setValue(this.x.getValue() + this.v);
            if(this.x.getValue()/32 - this.positionBackUp[1] == 2){
                this.positionBackUp[1]++;
            }
        }
        else if(this.environnement.getMap().getTileMap()[this.y.getValue()/32 + 1][(this.x.getValue()/32)] == 0){
            enter = true;
            this.y.setValue(this.y.getValue() - this.v);
            System.out.println("OK enter");
                this.pv = 0;
                this.gain = 0;

        }
        else if ((positionBackUp[0] != this.y.getValue()/32+1) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) + 1][(this.x.getValue()/32)] == 2) && !enter){
            this.y.setValue(this.y.getValue() + this.v);
            if(this.y.getValue()/32 - this.positionBackUp[0] == 2){
                this.positionBackUp[0]++;
            }
        }
        else if ((positionBackUp[0] != this.y.getValue()/32-1) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) - 1][(this.x.getValue()/32)] == 2) && !enter){
            this.positionBackUp[1] = this.x.getValue() /32;
            this.y.setValue(this.y.getValue() - this.v);
            if(this.positionBackUp[0] - this.y.getValue()/32 == 2){
                this.positionBackUp[0]--;
            }
        }
        else if((positionBackUp[1] != this.x.getValue()/32- 1) && this.environnement.getMap().getTileMap()[this.y.getValue()/32][(this.x.getValue()/32) - 1] == 2 && !enter){
            this.positionBackUp[0] = this.y.getValue() /32;
            this.x.setValue(this.x.getValue() - this.v);
            if(this.positionBackUp[1] - this.x.getValue()/32 == 2){
                this.positionBackUp[1]--;
            }
        }
    }

    public void décrémenterPV(int PV){
        this.pv = this.pv - PV;
    }


    public void setVitessePourcentage(double nb){ this.v =(int) (this.v * nb);}

    public void setVitesse(double v) {
        if(v >= 1)
            this.v = v;
    }

    public Environnement getEnvironnement(){return this.environnement;}


    //TODO : utiliser pythagore pr savoir si un point est dans un cercle
    public boolean estDansPerimetreTour(Tour tour){
        return Math.sqrt(Math.pow(this.XProperty().getValue() - tour.XProperty().getValue(), 2) + Math.pow(this.YProperty().getValue() - tour.YProperty().getValue(), 2)) <= tour.getRayonPerimetreAction();
    }




}
