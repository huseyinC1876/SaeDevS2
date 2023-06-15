package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.Projectile;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonBombeNucleaire;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.tours.*;
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
    private ObservableList<Projectile> listeProjectiles;

    private int[] debutMap;

    private int niveauCanonLaser = 1;
    private int niveauCanonMissile = 1;
    private int niveauChampForce = 1;
    private int niveauCanonNucleaire = 1;

    public Environnement(int niveau) throws IOException {
        if (niveau == 1) {
            this.map = new MapNiv1();
            this.nbEnnemiMax = new SimpleIntegerProperty(100);
            this.nbEnnemisParVague = 10;
        } else {
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
        this.listeProjectiles = FXCollections.observableArrayList();
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
    public ObservableList<Projectile> getListeProjectiles() {
        return this.listeProjectiles;
    }
    public IntegerProperty getRessource() {
        return this.ressource;
    }
    public int getNiveauCanonLaser() {
        return niveauCanonLaser;
    }
    public int getNiveauCanonMissile() {
        return niveauCanonMissile;
    }
    public int getNiveauChampForce() {
        return niveauChampForce;
    }
    public int getNiveauCanonNucleaire() {
        return niveauCanonNucleaire;
    }
    public void ameliorationCanonLaser(){
        this.niveauCanonLaser++;
    }
    public void ameliorationCanonMissile(){
        this.niveauCanonMissile++;
    }
    public void ameliorationChampForce(){
        this.niveauChampForce++;
    }
    public void ameliorationCanonNucleaire(){
        this.niveauCanonNucleaire++;
    }


    /**
     * Ajoute de manière aléatoire des ennemis tant que le nombre d'ennemis présents ne dépasse pas le nombre d'ennemis max.
     * S'il ne reste qu'un seul ennemi à ajouter : on ajoute le boss
     */
    public void ajouterEnnemi() {
        if (this.nbEnnemiSpawn < nbEnnemiMax.getValue()) {
            if (getNbEnnemiSpawn() == getNbEnnemiMax() - 1) {
                this.listeEnnemis.add(new EnnemiGalactusBoss(this, this.debutMap[1], this.debutMap[0]));
                this.nbEnnemiSpawn++;
            } else {
                double random = Math.random() * 3;
                if (random < 1) {
                    this.listeEnnemis.add(new EnnemiExtraterrestre(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else if (random < 2) {
                    this.listeEnnemis.add(new EnnemiVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else {
                    this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                }
            }
        }
    }


    public void ajouterVagueEnnemis() {
        if (nbEnnemiSpawn < nbEnnemiMax.getValue() - 1) {
            verifNbEnnemisParVague();
            for (int i = 0; i < this.nbEnnemisParVague; i++) {
                double random = Math.random() * 3;
                if (random < 1) {
//                    System.out.println("ajouter extraterrestre");
                    this.listeEnnemis.add(new EnnemiExtraterrestre(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else if (random < 2) {
//                    System.out.println("ajouter vaisseau");
                    this.listeEnnemis.add(new EnnemiVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                } else {
//                    System.out.println("ajouter SUPER Vaisseau");
                    this.listeEnnemis.add(new EnnemiSuperVaisseauSpatial(this, this.debutMap[1], this.debutMap[0]));
                    this.nbEnnemiSpawn++;
                }
            }
        }
    }

    /**
     * Ajoute des projectiles bombe Nucleaire dans l'environnement
     * @param typeProjectile
     * @param x --> position X du projectile dans la map
     * @param y --> position y du projectile dans la map
     */
    public void ajouterProjectileBombeNucleaire(int typeProjectile, int x, int y) {
        if (typeProjectile == 3) {
            listeProjectiles.add(new ProjectileCanonBombeNucleaire(this, 5, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1));
        }
    }

    /**
     * Ajoute des projectiles missile ou laser dans l'environnement
     * @param typeProjectile
     * @param x --> position X du projectile dans la map
     * @param y --> position y du projectile dans la map
     * @param ennemi --> ennemi à viser
     */
    //TODO : AJUSTER LES DEGATS SOUHAITES
    public void ajouterProjectileTeteChercheuse(int typeProjectile, int x, int y, Ennemi ennemi) {
        if (typeProjectile == 1) {
            listeProjectiles.add(new ProjectileCanonLaser(this, 10, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 5, ennemi));
        }
        if (typeProjectile == 2) {
            listeProjectiles.add(new ProjectileCanonMissile(this, 20, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 5, ennemi));
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

    /**
     * Ajoute un tour dans l'environnement
     * @param x
     * @param y
     * @param nbChoixTour
     */
    public void ajouterTour(int x, int y, int nbChoixTour) {
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

    public void ameliorationTour(int choix) {
        if (choix == 1) {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonLaser.getValue() * Math.pow(2,this.getNiveauCanonLaser() - 1));
            this.ameliorationCanonLaser();
            //TourCanonLaser.amelioration();
        } else if (choix == 2) {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonMissile.getValue() * Math.pow(2, this.getNiveauCanonMissile() - 1));
            this.ameliorationCanonMissile();
            //TourCanonMissile.amelioration(/*35,4*/);
        } else if (choix == 3) {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonNucleaire.getValue() * Math.pow(2, this.getNiveauCanonNucleaire() - 1));
            this.ameliorationCanonNucleaire();
            //TourCanonBombeNuclaire.amelioration();
        } else {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationChampForce.getValue() * Math.pow(2 ,this.getNiveauChampForce() - 1));
            this.ameliorationChampForce();
            //TourChampDeForce.amelioration(0.50);
        }


    }

    public void attaquer() {
        for (int i = 0; i < this.listeTours.size(); i++) {
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
            if (ennemi instanceof EnnemiExtraterrestre && ennemi.getV() != EnnemiExtraterrestre.getVitesseInitiale())
                ennemi.setVitesse(EnnemiExtraterrestre.getVitesseInitiale());
            else if (ennemi instanceof EnnemiVaisseauSpatial && ennemi.getV() != EnnemiVaisseauSpatial.getVitesseInitiale())
                ennemi.setVitesse(EnnemiVaisseauSpatial.getVitesseInitiale());
            else if (ennemi instanceof EnnemiSuperVaisseauSpatial && ennemi.getV() != EnnemiSuperVaisseauSpatial.vitesseInitiale)
                ennemi.setVitesse(EnnemiSuperVaisseauSpatial.vitesseInitiale);
        }
    }

    /**
     * Vérifie le que le nombre d'ennemis spawnés est inférieur au nombre d'ennemis max - 1 pour le boss
     * si oui --> on ajoute une
     */
    public void verifNbEnnemisParVague() {
        if (this.nbEnnemiSpawn > (nbEnnemiMax.getValue() - (nbEnnemisParVague + 1))) { //89
            this.nbEnnemisParVague = (nbEnnemiMax.getValue() - 1) - nbEnnemiSpawn;
            System.out.println("NB ENNEMIS / VAGUE : " + this.nbEnnemisParVague);
        }
    }

    /**
     * Supprime les ennemis de la liste des ennemis présents lorsque leurs PV sont inférieurs à 1
     * Selon le type d'ennemis morts, la méthode peut ajouter des nouveaux ennemis
     */
    public void verificationEnnemisMorts() {
        for (int i = this.listeEnnemis.size() - 1; i >= 0; i--) {
            if (this.listeEnnemis.get(i).getPv() < 1) {
                this.ressource.setValue(this.getRessource().getValue() + this.listeEnnemis.get(i).getGain());
                System.out.println(this.nbEnnemiSpawn < this.nbEnnemiMax.getValue() - 2);
                if (this.listeEnnemis.get(i) instanceof EnnemiVaisseauSpatial) {
//                    if (this.nbEnnemiSpawn.getValue() < this.nbEnnemiMax.getValue() - 2) {
//                    System.out.println("ENNEMIS SPAWN  BIS " + this.nbEnnemiSpawn);
//                    TODO : avec la condition ça marche pas, sans la condition, ça risque de dépasser qd on sera à 99, ça va faire 101
                    //Lorsqu'un ennemiVaisseauSpatial meurt, 2 nouveaux vaisseaux apparaissent (ils ne comptent pas dans la liste des ennemis ajoutés ou mort s'ils meurent)
                    listeEnnemis.add(new EnnemiDivise(this, listeEnnemis.get(i).XProperty().getValue() - 5, listeEnnemis.get(i).YProperty().getValue() - 5));
                    listeEnnemis.add(new EnnemiDivise(this, listeEnnemis.get(i).XProperty().getValue() + 5, listeEnnemis.get(i).YProperty().getValue() + 5));
//                    }
                }
                if (this.listeEnnemis.get(i) instanceof EnnemiDivise) {
                    this.listeEnnemis.remove(i);
                } else {
                    this.listeEnnemis.remove(i);
                    this.nbEnnemiTue.setValue(this.nbEnnemiTue.getValue() + 1);
                }
            }
        }
    }


    /**
     * Vérifie pour chaque projectile présent sur la map s'il a déjà attaqué ou non
     */
    public void verifProjectileHasAttacked() {
        for (int i = listeProjectiles.size() - 1; i >= 0; i--) {
//            System.out.println("projectile : " + listeProjectiles.get(i).getId() + " a attaqué : " + listeProjectiles.get(i).getHasAttacked());
            if (listeProjectiles.get(i).getHasAttacked()) {
                this.listeProjectiles.remove(i);
            }
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
