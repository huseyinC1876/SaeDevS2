package fr.montreuil.iut.CakarCassirame.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private int x;
    private int y;
    private int nbEnnemiMax;

    private int nbEnnemiSpawn;

    private int nbEnnemiTue;
    private Map map;

    private ObservableList<Ennemi> listeEnnemis;

    private ObservableList<Tour> listeTours;

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = 1;
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

    public void verfication(){
        for (Ennemi ennemi : this.listeEnnemis){
            if(ennemi.getPv() < 1){
                this.listeEnnemis.remove(ennemi);
                this.nbEnnemiTue++;
            }
        }
    }

    public void ajouterEnnemie(){
        this.listeEnnemis.add(new EnnemiExtraterrestre( this));
        this.nbEnnemiSpawn++;
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
