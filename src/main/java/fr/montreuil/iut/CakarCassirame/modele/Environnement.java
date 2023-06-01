package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class Environnement {

    private int x;
    private int y;
    private int nbEnnemiMax;

    private int nbEnnemiSpawn;

    private int nbEnnemiTue;
    private Map map;

    private ObservableList<Ennemi> listeEnnemis;

    private ObservableList<Tour> listeTours;

    private IntegerProperty ressource = new SimpleIntegerProperty(125);

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = 100;
        this.nbEnnemiTue = 0;
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();

    }

    public Map getMap() {
        return map;
    }

    public int getNbEnnemiMax() { return this.nbEnnemiMax; }

    public int getNbEnnemiTue() { return this.nbEnnemiTue; }

    public int getNbEnnemiSpawn() { return nbEnnemiSpawn; }

    public ObservableList<Ennemi> getListeEnnemis() { return this.listeEnnemis; }

    public ObservableList<Tour> getListeTours(){ return  this.listeTours; }

    public IntegerProperty getRessource(){ return this.ressource; }

    public void verfication(){
        for (Ennemi ennemi : this.listeEnnemis){
            if(ennemi.getPv() < 1){
                this.listeEnnemis.remove(ennemi);
                this.nbEnnemiTue++;
                this.ressource.setValue(this.getRessource().getValue() + ennemi.getGain());
            }

        }
    }

    public void ajouterEnnemie(){
        if (this.nbEnnemiSpawn == nbEnnemiMax-1)
            this.listeEnnemis.add(new EnnemiGalactusBoss(this));

        double random = Math.random()*3;
        if(random < 1)
            this.listeEnnemis.add(new EnnemiExtraterrestre(this));
        else if (random < 2)
            this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
        else
            this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));

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
        }
    }


}
