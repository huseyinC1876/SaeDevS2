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
    private int nbEnnemisParVague;

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = 100;
        this.nbEnnemiTue = 0;
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();
        this.nbEnnemisParVague = 10;
    }

    public int getNbEnnemisParVague(){return this.nbEnnemisParVague;}

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
        for(int i = listeEnnemis.size()-1 ; i > 0 ; i--){
            if(listeEnnemis.get(i).getPv() < 1){
                this.ressource.setValue(this.getRessource().getValue() + listeEnnemis.get(i).getGain());
                this.listeEnnemis.remove(i);
                this.nbEnnemiTue++;
            }
        }
    }

    public void ajouterVagueEnnemis() {
        if(nbEnnemiSpawn<99) {
            verifNbEnnemisParVague();
            System.out.println("ENNEMIS PAR VAGUE : " + this.nbEnnemisParVague);
            for (int i = 0; i < this.nbEnnemisParVague; i++) {
                double random = Math.random() * 3;
//                System.out.println("RANDOM : " + random);
                if (random < 1) {
                    System.out.println("ajouter extraterrestre");
                    this.listeEnnemis.add(new EnnemiExtraterrestre(this));
                    this.nbEnnemiSpawn++;
                } else if (random < 2) {
                    System.out.println("ajouter vaisseau");
                    this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
                    this.nbEnnemiSpawn++;
                } else {
                    System.out.println("ajouter SUPER Vaisseau");
                    this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));
                    this.nbEnnemiSpawn++;
                }
            }
        }
    }

    public void ajouterEnnemiExtraterrestre(){
        this.listeEnnemis.add(new EnnemiExtraterrestre(this));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiVaisseauSpatial(){
        this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiSuperVaisseauSpatial(){
        this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiGalactus(){
        this.listeEnnemis.add(new EnnemiGalactusBoss(this));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiDivision(){
        for(int i = 0 ; i <2 ; i++) {
            this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
            this.nbEnnemiSpawn++;
        }
    }

    public void ajouterTour(double x, double y){
//        this.listeTours.add(new Tour(this, x, y));
    }

    public void deplacement(){
        for(Ennemi ennemi : this.listeEnnemis){
            ennemi.seDeplacer();
//            ennemi.décrémenterPV(1);
        }
    }

    public void verifNbEnnemisParVague(){
        if(this.nbEnnemiSpawn > 91){
            this.nbEnnemisParVague = 99 - nbEnnemiSpawn;
        }
    }



}
