package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

    private int x;
    private int y;
    private IntegerProperty nbEnnemiMax;
    private IntegerProperty nbEnnemiSpawn;

    private IntegerProperty nbEnnemiTue;
    private Map map;
    private ObservableList<Ennemi> listeEnnemis;

    private ObservableList<Tour> listeTours;
    private TourCanonMissile tourCanonMissile;
    private TourCanonLaser tourCanonLaser;
    private TourCanonBombeNuclaire tourCanonBombeNuclaire;


    private IntegerProperty ressource = new SimpleIntegerProperty(500);
    private int nbEnnemisParVague;

    private IntegerProperty vie = new SimpleIntegerProperty(3);
    private ObservableList<Projectile> listeProjectiles;

    public Environnement() {
        this.map = new Map();
        this.x = this.map.getTileMap().length;
        this.y = this.map.getTileMap()[0].length;
        this.nbEnnemiMax = new SimpleIntegerProperty(50);
        this.nbEnnemiTue = new SimpleIntegerProperty(0);
        this.listeEnnemis = FXCollections.observableArrayList();
        this.nbEnnemiSpawn = new SimpleIntegerProperty(0);
        this.listeTours = FXCollections.observableArrayList();
        this.nbEnnemisParVague = 10;
        this.listeProjectiles = FXCollections.observableArrayList();
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

    public IntegerProperty getNbEnnemisSpawnedProperty(){return this.nbEnnemiSpawn;}

    public IntegerProperty getNbEnnemiTueProperty() {
        return this.nbEnnemiTue;
    }

    public int getNbEnnemiSpawn() {
        return nbEnnemiSpawn.getValue();
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

    public ObservableList<Projectile> getListeProjectiles() {
        return this.listeProjectiles;
    }

    public void verificationEnnemisMorts() {
        for (int i = this.listeEnnemis.size() - 1; i >= 0; i--) {
            if (this.listeEnnemis.get(i).getPv() < 1) {
                this.ressource.setValue(this.getRessource().getValue() + this.listeEnnemis.get(i).getGain());
//                System.out.println("ENNEMIS SPAWN " + this.nbEnnemiSpawn);
                System.out.println(this.nbEnnemiSpawn.getValue() < this.nbEnnemiMax.getValue() - 2);
                if (this.nbEnnemiSpawn.getValue() < this.nbEnnemiMax.getValue() - 2) {
//                    System.out.println("ENNEMIS SPAWN  BIS " + this.nbEnnemiSpawn);
                    if (this.listeEnnemis.get(i) instanceof EnnemiSuperVaisseauSpatial) {
//                        System.out.println("AJOUT DE 2 ENNEMIS SUPER VAISSEAU SPATIALES");
                        listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this, listeEnnemis.get(i).XProperty().getValue() - 5, listeEnnemis.get(i).YProperty().getValue() - 5));
                        listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this, listeEnnemis.get(i).XProperty().getValue() + 5, listeEnnemis.get(i).YProperty().getValue() + 5));
                    }
                }
                this.listeEnnemis.remove(i);
                this.nbEnnemiTue.setValue(this.nbEnnemiTue.getValue() + 1);

            }
        }
    }

    public void verifProjectileHasAttacked() {
        for (int i = listeProjectiles.size() - 1; i >= 0; i--) {
            System.out.println("projectile : " + listeProjectiles.get(i).getId() + " a attaqué : " + listeProjectiles.get(i).getHasAttacked());
            if (listeProjectiles.get(i).getHasAttacked() == true) {
                this.listeProjectiles.remove(i);
            }
        }
    }


    //TODO : AJUSTER LES DEGATS SOUHAITES
    public void ajouterProjectile(int typeProjectile, double x, double y) {
        if (this.listeTours.size() > 0) {
            if (typeProjectile == 1) {
                listeProjectiles.add(new ProjectileCanonBombeNucleaire(this, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1));
//                System.out.println("ajouter proj 1 environnement");
            }
            if (typeProjectile == 2) {
                listeProjectiles.add(new ProjectileCanonBombeNucleaire(this, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1));
//                System.out.println("ajouter proj 2 environnement");
            }
            if (typeProjectile == 3) {
                listeProjectiles.add(new ProjectileCanonBombeNucleaire(this, 20, new SimpleDoubleProperty(x), new SimpleDoubleProperty(y), 1));
//                System.out.println("ajouter proj 3 environnement");
            }
        }
    }

    public void ajouterEnnemie() {
        if (this.nbEnnemiSpawn.getValue() < nbEnnemiMax.getValue()) {
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
        if (nbEnnemiSpawn.getValue() < nbEnnemiMax.getValue() - 1) {
            verifNbEnnemisParVague();
            System.out.println("ENNEMIS PAR VAGUE : " + this.nbEnnemisParVague);
            for (int i = 0; i < this.nbEnnemisParVague; i++) {
                double random = Math.random() * 3;
//                System.out.println("RANDOM : " + random);
                if (random < 1) {
                    System.out.println("ajouter extraterrestre");
                    this.listeEnnemis.add(new EnnemiExtraterrestre(this));
                    this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
                } else if (random < 2) {
                    System.out.println("ajouter vaisseau");
                    this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
                    this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
                } else {
                    System.out.println("ajouter SUPER Vaisseau");
                    this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));
                    this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
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
        this.listeEnnemis.add(new EnnemiExtraterrestre(this));
        this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
    }

    public void ajouterEnnemiVaisseauSpatial() {
        this.listeEnnemis.add(new EnnemiVaisseauSpatial(this));
        this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
    }

    public void ajouterEnnemiSuperVaisseauSpatial() {
        this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this));
        this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
    }

    public void ajouterEnnemiGalactus() {
        this.listeEnnemis.add(new EnnemiGalactusBoss(this));
        this.nbEnnemiSpawn.setValue(this.nbEnnemiSpawn.getValue()+1);
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

    public void deplacementEnnemis() {
        for (Ennemi ennemi : this.listeEnnemis) {
            ennemi.seDeplacer();
            if (ennemi.getEnter()) {
                this.getVieProperty().setValue(getVieProperty().getValue() - 1);
            }
        }
    }

    public void deplacementProjectiles() {
        for (Projectile projectile : this.listeProjectiles) {
            projectile.seDeplacer();
        }
    }

    public void verifNbEnnemisParVague() {
        if (this.nbEnnemiSpawn.getValue() > nbEnnemiMax.getValue() - nbEnnemisParVague + 1) { //91
            this.nbEnnemisParVague = (nbEnnemiMax.getValue() - 1) - nbEnnemiSpawn.getValue();
        }
    }

    public void attaquer() {
        for (int i = 0; i < this.listeTours.size(); i++) {
            if (listeTours.get(i) instanceof TourChampDeForce)
                listeTours.get(i).attaquer();
        }
        for (int j = 0; j < this.listeEnnemis.size(); j++) {
            verifPerimetreChampDeForce(listeEnnemis.get(j));
        }

        for (int i = 0; i < listeProjectiles.size(); i++) {
            listeProjectiles.get(i).attaquer();
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

    public void unTour() {
        deplacementEnnemis();
        deplacementProjectiles();
        attaquer();
        verificationEnnemisMorts();
        verifProjectileHasAttacked();
    }


}
