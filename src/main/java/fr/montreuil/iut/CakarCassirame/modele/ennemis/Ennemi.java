package fr.montreuil.iut.CakarCassirame.modele.ennemis;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourPerimetre;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemi {

    private Environnement environnement;
    private DoubleProperty pv;
    private double pvMax;
    private double v;
    private int gain;
    private IntegerProperty x,y;
    public static int compteur = 0;
    private String id;
    private int[]  positionBackUp = new int[2];
    private boolean enter;


    public Ennemi(Environnement environnement, double pv, double v, int gain, int x, int y, double pvMax){
        this.pv = new SimpleDoubleProperty(pv);
        this.pvMax = pvMax;
        this.v = v;
        this.gain = gain;
        this.environnement = environnement;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.id = "E" +compteur;
        compteur ++;
        positionBackUp[0] = this.y.getValue()/32;
        positionBackUp[1] = this.x.getValue()/32;
    }

    public IntegerProperty XProperty(){ return this.x;}

    public IntegerProperty YProperty(){ return this.y;}

    public String getId() { return this.id; }

    public double getPv() { return pv.getValue(); }
    public double getPvMax (){return pvMax;}

    public DoubleProperty PVProperty(){return this.pv;}

    public int getGain() {
        return gain;
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
            this.y.setValue(this.y.getValue() + this.v);
            //System.out.println("OK enter");
            this.pv.setValue(0);
            this.gain = 0;

        }
        else if(this.environnement.getMap().getTileMap()[this.y.getValue()/32 - 1][(this.x.getValue()/32)] == 0){
            enter = true;
            this.y.setValue(this.y.getValue() - this.v);
            System.out.println("OK enter");
            this.pv.setValue(0);
            this.gain = 0;

        }
        else if(this.environnement.getMap().getTileMap()[this.y.getValue()/32 ][(this.x.getValue()/32) + 1] == 0){
            enter = true;
            this.y.setValue(this.x.getValue() + this.v);
            System.out.println("OK enter");
            this.pv.setValue(0);
            this.gain = 0;

        }
        else if(this.environnement.getMap().getTileMap()[this.y.getValue()/32][(this.x.getValue()/32) - 1] == 0){
            enter = true;
            this.y.setValue(this.x.getValue() - this.v);
            System.out.println("OK enter");
            this.pv.setValue(0);
            this.gain = 0;

        }
        else if ((positionBackUp[0] != this.y.getValue()/32+1) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) + 1][(this.x.getValue()/32)] == 2) && !enter){
            this.positionBackUp[1] = this.x.getValue() /32;
            this.y.setValue(this.y.getValue() + this.v);
            if(this.y.getValue()/32 - this.positionBackUp[0] == 2){
                this.positionBackUp[0]++;
            }
        }
        else if ((positionBackUp[0] != this.y.getValue()/32-1) &&  (this.environnement.getMap().getTileMap()[(this.y.getValue()/32) - 1][(this.x.getValue()/32)] == 2) && !enter){
            this.positionBackUp[1] = this.x.getValue() /32;
            this.y.setValue(this.y.getValue() - this.v);
            if(this.environnement.getMap().getTileMap()[(this.y.getValue()/32) - 1][(this.x.getValue()/32)] == 3){
                int multiplicateur = (int) (32 - this.v);
                multiplicateur = (int) (multiplicateur / this.v) ;
                //System.out.println("multiplicateur = " + multiplicateur);
                //System.out.println("calcul = " + this.v * multiplicateur);
                this.y.setValue(this.y.getValue() - this.v * multiplicateur) ;
            }
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
        this.pv.setValue(this.pv.getValue() - PV);
    }

    public void setVitesse(double v) {
        if(v >= 1)
            this.v = v;
    }

    public Environnement getEnvironnement(){return this.environnement;}

}
