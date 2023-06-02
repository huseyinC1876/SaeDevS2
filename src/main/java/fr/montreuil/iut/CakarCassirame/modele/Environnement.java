package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private int nbEnnemisParVague;

    private IntegerProperty vie = new SimpleIntegerProperty(3);

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = new SimpleIntegerProperty(100);
        this.nbEnnemiTue = new SimpleIntegerProperty(0);
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();
        this.nbEnnemisParVague = 10;
    }

    public int getNbEnnemisParVague(){return this.nbEnnemisParVague;}

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

    public void ajouterEnnemie() {
        if (this.nbEnnemiSpawn < nbEnnemiMax.getValue()) {
            if (getNbEnnemiSpawn() == getNbEnnemiMax() - 1) {
                ajouterEnnemiGalactus();
            }
            double random = Math.random() * 3;
            if (random < 1) {
                ajouterEnnemiExtraterrestre();
            } else if (random < 2) {
                ajouterEnnemiVaisseauSpatial();
            } else {
                ajouterEnnemiSuperVaisseauSpatial();            }
        }
    }



    public void ajouterVagueEnnemis() {
        if(nbEnnemiSpawn < nbEnnemiMax.getValue() - 1) {
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

    public void ajouterTour(double x, double y, int nbChoixTour){
        if(nbChoixTour == 1)
            this.listeTours.add(new TourCanonLaser(this, x, y));
        else if(nbChoixTour == 2)
            this.listeTours.add(new TourCanonMissile(this, x, y));
       else if(nbChoixTour == 3)
            this.listeTours.add(new TourCanonBombeNuclaire(this, x, y));
        else this.listeTours.add(new TourChampDeForce(this, x, y));

    }

    public void deplacement(){
        for(Ennemi ennemi : this.listeEnnemis){
            ennemi.seDeplacer();
            if(ennemi.getEnter()){
                this.getVieProperty().setValue(getVieProperty().getValue() - 1);
            }
            ennemi.décrémenterPV(10);
        }
    }

    public void verifNbEnnemisParVague(){
        if(this.nbEnnemiSpawn > 91){
            this.nbEnnemisParVague = 99 - nbEnnemiSpawn;
        }

    }

    public void attaque(){
        for(int i = 0; i < this.getListeTours().size(); i++){
            for (int j = 0; j < this.getListeEnnemis().size(); j++){
                if(this.getListeTours().get(i) instanceof TourCanon) {
                    ((TourCanon) this.getListeTours().get(i)).attaquer(this.listeEnnemis.get(j));
                }
            }
        }
    }

    public void unTour(){
        deplacement();
        attaque();
        verfication();
    }



}
