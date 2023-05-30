package fr.montreuil.iut.CakarCassirame.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private int x;
    private int y;
    private int nbEnnnemieMax;

    private int nbEnnemieSpawn;

    private int nbEnnemieTue;
    private Map map;

    private ObservableList<Ennemie> listeEnnemis;

    private ObservableList<Tour> listeTours;

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnnemieMax = 100;
        this.nbEnnemieTue = 0;
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemieSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();

    }

    public Map getMap() {
        return map;
    }

    public int getNbEnnnemieMax() { return this.nbEnnnemieMax; }

    public int getNbEnnemieTue() { return this.nbEnnemieTue; }

    public int getNbEnnemieSpawn() { return nbEnnemieSpawn; }

    public ObservableList<Ennemie> getListeEnnemis() { return this.listeEnnemis; }

    public ObservableList<Tour> getListeTours(){ return  this.listeTours; }

    public void verfication(){
        for (Ennemie ennemie : this.listeEnnemis){
            if(ennemie.getPv() < 1){
                this.listeEnnemis.remove(ennemie);
                this.nbEnnemieTue++;
            }
        }
    }

    public void ajouterEnnemie(){
        this.listeEnnemis.add(new Ennemie( this));
        this.nbEnnemieSpawn++;
    }

    public void ajouterTour(double x, double y){
        this.listeTours.add(new Tour(this, x, y));
    }

    public void deplacement(){
        for(Ennemie ennemie : this.listeEnnemis){
            ennemie.seDeplacer();
        }
    }


}
