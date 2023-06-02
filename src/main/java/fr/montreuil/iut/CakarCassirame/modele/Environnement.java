package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class Environnement {

    private int x;
    private int y;
    private IntegerProperty nbEnnemiMax;

    private int nbEnnemiSpawn;

    private IntegerProperty nbEnnemiTue;
    private Map map;

    private ObservableList<Ennemi> listeEnnemis;

    private ObservableList<Tour> listeTours;

    private IntegerProperty ressource = new SimpleIntegerProperty(125);

    private IntegerProperty vie = new SimpleIntegerProperty(3);

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = new SimpleIntegerProperty(10);
        this.nbEnnemiTue = new SimpleIntegerProperty(0);
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();

    }

    public Map getMap() {
        return map;
    }

    public int getNbEnnemiMax() { return this.nbEnnemiMax.getValue(); }

    public IntegerProperty getNbEnnemiMaxProperty(){ return this.nbEnnemiMax; }

    public int getNbEnnemiTue() { return this.nbEnnemiTue .getValue(); }

    public IntegerProperty getNbEnnemiTueProperty(){ return this.nbEnnemiTue; }

    public int getNbEnnemiSpawn() { return nbEnnemiSpawn; }

    public IntegerProperty getVieProperty(){ return this.vie; }

    public ObservableList<Ennemi> getListeEnnemis() { return this.listeEnnemis; }

    public ObservableList<Tour> getListeTours(){ return  this.listeTours; }

    public IntegerProperty getRessource(){ return this.ressource; }

    public void verfication(){
        for (int i = this.listeEnnemis.size() - 1 ; i >= 0 ; i-- ){
            if(this.listeEnnemis.get(i).getPv() < 1){
                this.ressource.setValue(this.getRessource().getValue() + this.listeEnnemis.get(i).getGain());
                this.listeEnnemis.remove(i);
                this.nbEnnemiTue.setValue(this.nbEnnemiTue.getValue() + 1);

            }

        }
    }

    public void ajouterEnnemie(){
        if(getNbEnnemiMax() > 1 && this.nbEnnemiSpawn < 100) {
            double random = Math.random() * 3;
            if (random < 1)
                this.listeEnnemis.add(new EnnemiExtraterrestre(this));
            else if (random < 2)
                this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
            else
                this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));
        }
        else
            this.listeEnnemis.add(new EnnemiGalactusBoss(this));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiDivision(){
        for(int i = 0 ; i <2 ; i++) {
            this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
        }
    }

    public void ajouterTour(double x, double y){
        this.listeTours.add(new Tour(this, x, y));
    }

    public void deplacement(){
        for(Ennemi ennemi : this.listeEnnemis){
            ennemi.seDeplacer();
            if(ennemi.getEnter()){
                this.getVieProperty().setValue(getVieProperty().getValue() - 1);
            }
            //ennemi.décrémenterPV(10);
        }

    }

    public void attaque(){
        for(int i = 0; i < this.getListeTours().size(); i++){
            for (int j = 0; j < this.getListeEnnemis().size(); j++){
                this.getListeTours().get(i).attaquer(this.listeEnnemis.get(j));
            }
        }
    }

    public void tour(){
        deplacement();
        attaque();
        verfication();
    }


}
