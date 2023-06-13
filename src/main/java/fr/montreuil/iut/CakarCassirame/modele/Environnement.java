package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class Environnement {

    private int x;
    private int y;
    private IntegerProperty nbEnnemiMax;
    private int nbEnnemiSpawn;

    private IntegerProperty nbEnnemiTue;
    private Map map;
    private ObservableList<Ennemi> listeEnnemis;

    private ObservableList<Tour> listeTours;

    private IntegerProperty ressource = new SimpleIntegerProperty(5000);
    private int nbEnnemisParVague;

    private IntegerProperty vie = new SimpleIntegerProperty(3);

    private int[] debutMap;

    public Environnement(int niveau) throws IOException {
        if(niveau == 1){
            this.map = new MapNiv1();
            this.nbEnnemiMax = new SimpleIntegerProperty(100);
            this.nbEnnemisParVague = 10;
        }
        else{
            this.map = new MapNiv2();
            this.nbEnnemiMax = new SimpleIntegerProperty(200);
            this.nbEnnemisParVague = 15;
        }
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiTue = new SimpleIntegerProperty(0);
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = 0;
        this.listeTours = FXCollections.observableArrayList();
        this.debutMap = this.map.debutMapEnnemie();
    }

    public int getNbEnnemisParVague() {
        return this.nbEnnemisParVague;
    }

    public Map getMap() {
        return map;
    }

    public int getNbEnnemiMax() {
        return this.nbEnnemiMax.getValue();
    }

    public IntegerProperty getNbEnnemiMaxProperty() {
        return this.nbEnnemiMax;
    }

    public int getNbEnnemiTue() {
        return this.nbEnnemiTue.getValue();
    }

    public IntegerProperty getNbEnnemiTueProperty() {
        return this.nbEnnemiTue;
    }

    public int getNbEnnemiSpawn() {
        return nbEnnemiSpawn;
    }

    public IntegerProperty getVieProperty() {
        return this.vie;
    }

    public ObservableList<Ennemi> getListeEnnemis() {
        return this.listeEnnemis;
    }

    public ObservableList<Tour> getListeTours() {
        return this.listeTours;
    }

    public IntegerProperty getRessource() {
        return this.ressource;
    }

    public void verfication() {

        int taille = this.listeEnnemis.size();
        for (int i = 0; i < taille; i++){
            if(this.listeEnnemis.get(i) instanceof EnnemiVaisseauSpatial){
                ((EnnemiVaisseauSpatial) this.listeEnnemis.get(i)).seDivise();
                //System.out.println("enter");
            }
            taille = this.listeEnnemis.size();
        }



        for (int i = this.listeEnnemis.size() - 1; i >= 0; i--) {
            if (this.listeEnnemis.get(i).getPv() < 1) {
                /*
                if(this.listeEnnemis.get(i) instanceof EnnemiVaisseauSpatial){
                    ((EnnemiVaisseauSpatial) this.listeEnnemis.get(i)).seDivise();
                }

                 */
                this.ressource.setValue(this.getRessource().getValue() + this.listeEnnemis.get(i).getGain());
                if(listeEnnemis.get(i) instanceof EnnemiVaisseauSpacialDivise){
                    this.listeEnnemis.remove(i);
                }
                else {
                    this.listeEnnemis.remove(i);
                    this.nbEnnemiTue.setValue(this.nbEnnemiTue.getValue() + 1);
                }
            }
        }
    }

    public void ajouterEnnemie() {
        if (this.nbEnnemiSpawn < nbEnnemiMax.getValue()) {
            if (getNbEnnemiSpawn() == getNbEnnemiMax() - 1) {
                ajouterEnnemiGalactus();
            } else {
                double random = Math.random() * 3;
                if (random < 1) {
                    ajouterEnnemiExtraterrestre();
                } else if (random < 2) {
                    ajouterEnnemiVaisseauSpatial();
                } else {
                    ajouterEnnemiSuperVaisseauSpatial();
                }
            }
        }
    }


    public void ajouterVagueEnnemis() {
        if (nbEnnemiSpawn < nbEnnemiMax.getValue() - 1) {
            verifNbEnnemisParVague();
            System.out.println("ENNEMIS PAR VAGUE : " + this.nbEnnemisParVague);
            for (int i = 0; i < this.nbEnnemisParVague; i++) {
                double random = Math.random() * 3;
//                System.out.println("RANDOM : " + random);
                if (random < 1) {
                    System.out.println("ajouter extraterrestre");
                    this.listeEnnemis.add(new EnnemiExtraterrestre(this , this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else if (random < 2) {
                    System.out.println("ajouter vaisseau");
                    this.listeEnnemis.add(new EnnemiVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else {
                    System.out.println("ajouter SUPER Vaisseau");
                    this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                }
            }
        }
    }


    public boolean verificationPlacement(double x, double y) {
        for (Tour tour : this.listeTours) {
            if (tour.XProperty().getValue() == x && tour.YProperty().getValue() == y) {
                return false;
            }
        }
        return true;
    }



    public void ajouterEnnemiExtraterrestre() {
        this.listeEnnemis.add(new EnnemiExtraterrestre(this, this.debutMap[1], this.debutMap[0]));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiVaisseauSpatial() {
        this.listeEnnemis.add(new EnnemiVaisseauSpatial(this , this.debutMap[1], this.debutMap[0]));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiSuperVaisseauSpatial() {
        this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this , this.debutMap[1], this.debutMap[0]));
        this.nbEnnemiSpawn++;
    }

    public void ajouterEnnemiGalactus() {
        this.listeEnnemis.add(new EnnemiGalactusBoss(this , this.debutMap[1], this.debutMap[0]));
        this.nbEnnemiSpawn++;
    }
    /*
    public void ajouterEnnemiDivision(int pv, int gain) {
        for (int i = 0; i < 2; i++) {
            Ennemi ennemiDivise = new EnnemiVaisseauSpacialDivise(this, pv, gain);
            //ennemiDivise.
            this.listeEnnemis.add(new EnnemiVaisseauSpacialDivise(this,pv, gain));
            //this.nbEnnemiSpawn++;
        }
    }

     */

    public void ajouterEnnemiDivision(Ennemi ennemi) {
        this.listeEnnemis.add(ennemi);
    }

    public void ajouterTour(double x, double y, int nbChoixTour) {
        if (nbChoixTour == 1)
            this.listeTours.add(new TourCanonLaser(this, x, y));
        else if (nbChoixTour == 2)
            this.listeTours.add(new TourCanonMissile(this, x, y));
        else if (nbChoixTour == 3)
            this.listeTours.add(new TourCanonBombeNuclaire(this, x, y));
        else this.listeTours.add(new TourChampDeForce(this, x, y));

    }

    public void deplacement() {
        for (Ennemi ennemi : this.listeEnnemis) {
            ennemi.seDeplacer();
            if (ennemi.getEnter()) {
                this.getVieProperty().setValue(getVieProperty().getValue() - 1);
            }
        }
    }

    public void verifNbEnnemisParVague() {
        if (this.nbEnnemiSpawn > 91) {
            this.nbEnnemisParVague = 99 - nbEnnemiSpawn;
        }

    }


    public void attaque() {
        for (int i = 0; i < this.getListeTours().size(); i++) {
            for (int j = 0; j < this.getListeEnnemis().size(); j++) {
                this.getListeTours().get(i).attaquer(this.listeEnnemis.get(j));

            }
        }
    }

    public void ameliorationTour ( int choix){
        if (choix == 1) {
            this.ressource.setValue(this.ressource.getValue() - TourCanonLaser.prixA.getValue());
            TourCanonLaser.amelioration();
        } else if (choix == 2) {
            this.ressource.setValue(this.ressource.getValue() - TourCanonMissile.prixA.getValue());
            TourCanonMissile.amelioration(/*35,4*/);
        } else if (choix == 3) {
            //this.ressource.setValue(this.ressource.getValue() - TourCanonBombeNuclaire.prixA.getValue());
            TourCanonBombeNuclaire.amelioration(300, 7);
        } else {
            //this.ressource.setValue(this.ressource.getValue() - TourChampDeForce.prixA.getValue());
            TourChampDeForce.amelioration(0.50);
        }


    }



    public void verifPerimetreChampDeForce(Ennemi ennemi) {
        boolean dansAucunPerimetreDeTourChampForce = true;
        for (int i = 0; i < this.listeTours.size(); i++) {
            if (listeTours.get(i) instanceof TourChampDeForce && ((TourChampDeForce) listeTours.get(i)).hasEnnemiDansPerimetre(ennemi)) {
                dansAucunPerimetreDeTourChampForce = false;
            }
        }
        if (dansAucunPerimetreDeTourChampForce) {
            if (ennemi instanceof EnnemiExtraterrestre && ennemi.getV() != EnnemiExtraterrestre.vitesseInitiale)
                ennemi.setVitesse(EnnemiExtraterrestre.vitesseInitiale);
            else if (ennemi instanceof EnnemiVaisseauSpatial && ennemi.getV() != EnnemiVaisseauSpatial.vitesseInitiale)
                ennemi.setVitesse(EnnemiVaisseauSpatial.vitesseInitiale);
            else if (ennemi instanceof EnnemiSuperVaisseauSpatial && ennemi.getV() != EnnemiSuperVaisseauSpatial.vitesseInitiale)
                ennemi.setVitesse(EnnemiSuperVaisseauSpatial.vitesseInitiale);
        }
    }



    public void unTour () {
        //System.out.println(this.listeEnnemis.size());
        for (int i = 0; i < this.listeEnnemis.size(); i++) {
            System.out.print(this.listeEnnemis.get(i) + "       ");
        }
        System.out.println();
        deplacement();
        attaque();
        verfication();
    }



}
