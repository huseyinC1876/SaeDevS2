package fr.montreuil.iut.CakarCassirame.modele;

import fr.montreuil.iut.CakarCassirame.modele.ennemis.*;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.*;
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
    private IntegerProperty ressource = new SimpleIntegerProperty(4000);
    private int nbEnnemisParVague;
    private IntegerProperty vie = new SimpleIntegerProperty(3);
    private ObservableList<Projectile> listeProjectiles;
    private int[] debutMap;

    private IntegerProperty niveauCanonLaser = new SimpleIntegerProperty(1);
    private IntegerProperty niveauCanonMissile = new SimpleIntegerProperty(1);
    private IntegerProperty niveauChampForce = new SimpleIntegerProperty(1);
    private IntegerProperty niveauCanonNucleaire = new SimpleIntegerProperty(1);
    private final IntegerProperty niveauMaxCanon = new SimpleIntegerProperty(3);
    private final IntegerProperty niveauMaxChamp = new SimpleIntegerProperty(2);

    private int tempsLastEnnemiInVague;
    private int intervalleEnnemiParVague;
    private int tempsLastVague;
    private int intervalleVague;

    private boolean finJeu = false;

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
        this.tempsLastEnnemiInVague = 0;
        this.intervalleEnnemiParVague = 30;
        this.tempsLastVague = 0;
        this.intervalleVague = 1000;
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
        return niveauCanonLaser.getValue();
    }

    public int getNiveauCanonMissile() {
        return niveauCanonMissile.getValue();
    }

    public int getNiveauChampForce() {
        return niveauChampForce.getValue();
    }

    public int getNiveauCanonNucleaire() {
        return niveauCanonNucleaire.getValue();
    }
    public IntegerProperty niveauMaxCanonProperty(){ return this.niveauMaxCanon; }

    public IntegerProperty niveauMaxChampProperty(){ return this.niveauMaxChamp; }

    public int getNbEnnemisParVague() {
        return this.nbEnnemisParVague;
    }

    public int getIntervalleEnnemiParVague() {
        return this.intervalleEnnemiParVague;
    }

    public int getTempsLastVague() {
        return this.tempsLastVague;
    }

    public void setTempsLastVague(int temps) {
        this.tempsLastVague = temps;
    }

    public int getIntervalleVague() {
        return this.intervalleVague;
    }

    public void ameliorationCanonLaser() {
        this.niveauCanonLaser.setValue(this.niveauCanonLaser.getValue() + 1);
    }

    public void ameliorationCanonMissile() {
        this.niveauCanonMissile.setValue(this.niveauCanonMissile.getValue() + 1);
    }

    public void ameliorationChampForce() {
        this.niveauChampForce.setValue(this.niveauCanonMissile.getValue() + 1);
    }

    public void ameliorationCanonNucleaire() {
        this.niveauCanonNucleaire.setValue(this.niveauCanonNucleaire.getValue() + 1);
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

    public void ajouterProjectileBombeNucleaire(int typeProjectile, int x, int y) {
        if (typeProjectile == 3) {
            listeProjectiles.add(new ProjectileCanonBombeNucleaire(this, (Parametre.degatCanonNuclaire.getValue() + ((this.getNiveauCanonNucleaire() - 1)* 10)), new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 1));
        }
    }

    /**
     * Ajoute des projectiles missile ou laser dans l'environnement
     *
     * @param typeProjectile
     * @param ennemi --> ennemi à viser
     */
    //TODO : AJUSTER LES DEGATS SOUHAITES
    public void ajouterProjectileTeteChercheuse(int typeProjectile, int x, int y,int degat,  Ennemi ennemi) {
        if (typeProjectile == 1) {
            listeProjectiles.add(new ProjectileCanonLaser(this, degat, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 5, ennemi));
        }
        if (typeProjectile == 2) {
            listeProjectiles.add(new ProjectileCanonMissile(this, degat, new SimpleIntegerProperty(x), new SimpleIntegerProperty(y), 5, ennemi));
        }
    }

    public boolean verificationPlacement(double x, double y) {
        for (Tour tour : this.listeTours) {
            if (tour.XProperty().getValue() == (x + 16) && tour.YProperty().getValue() == (y + 16) ){
                return false;
            }
        }
        return true;
    }

    public void vendreTour(int x, int y) {
        Tour tour = tourPlacement(x, y);
        if (tour instanceof TourCanonLaser)
            this.ressource.setValue(this.ressource.getValue() + Parametre.prixTourCanonLaser.getValue() / 2);
        else if (tour instanceof TourCanonMissile)
            this.ressource.setValue(this.ressource.getValue() + Parametre.prixTourCanonMissile.getValue());
        else if (tour instanceof TourCanonBombeNuclaire)
            this.ressource.setValue(this.ressource.getValue() + Parametre.prixTourCanonNucleaire.getValue() / 2);
        else
            this.ressource.setValue(this.ressource.getValue() + Parametre.prixTourChampForce.getValue());
        this.listeTours.remove(tour);
    }

    public Tour tourPlacement(int x, int y) {
        for (Tour tour : this.listeTours) {
            if (tour.XProperty().getValue() == x && tour.YProperty().getValue() == y) {
                return tour;
            }
        }
        return null;
    }

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
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonLaser.getValue());
            this.ameliorationCanonLaser();
        } else if (choix == 2) {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonMissile.getValue());
            this.ameliorationCanonMissile();
        } else if (choix == 3) {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationCanonNucleaire.getValue());
            this.ameliorationCanonNucleaire();
        } else {
            this.ressource.setValue(this.ressource.getValue() - Parametre.prixAmeliorationChampForce.getValue());
            this.ameliorationChampForce();
            TourChampDeForce.amelioration();
        }
    }


    public void attaquer() {
        for (Tour listeTour : this.listeTours) {
            if(listeTour instanceof TourChampDeForce){
                ((TourChampDeForce) listeTour).reduireVitesse();
            }
        }
        for (int i = listeProjectiles.size()-1 ; i >= 0 ; i--){
            listeProjectiles.get(i).attaquer();
        }
    }

    /**
     * Vérifie si l'ennemi est dans un périmètre d'une tour champ de force
     * Si non et que sa vitesse actuelle est différente de sa vitesse initiale (il a donc une vitesse réduite) --> on remet sa vitesse à sa vitesse initiale
     */
    public void verifPerimetreChampDeForce() {
        for (int i = 0; i < this.getListeEnnemis().size(); i++) {
            boolean dansAucunPerimetreDeTourChampForce = true;
            Ennemi ennemi = this.getListeEnnemis().get(i);
            for (int j = 0; j < this.listeTours.size(); j++) {
                if (listeTours.get(j) instanceof TourChampDeForce && ((TourChampDeForce) listeTours.get(j)).hasEnnemiDansPerimetre(ennemi)) {
                    dansAucunPerimetreDeTourChampForce = false;
                }
            }
            //l'ennemi n'est pas présent dans un périmètre de tour champ de force --> on réinitialise sa vitesse si celle-ci était changée
            if (dansAucunPerimetreDeTourChampForce) {
                if (ennemi instanceof EnnemiExtraterrestre && ennemi.getV() != Parametre.vitesseInitExtraterrestre)
                    ennemi.setVitesse(Parametre.vitesseInitExtraterrestre);
                else if (ennemi instanceof EnnemiVaisseauSpatial && ennemi.getV() != Parametre.vitesseInitVaisseauSpatial)
                    ennemi.setVitesse(Parametre.vitesseInitVaisseauSpatial);
                else if (ennemi instanceof EnnemiSuperVaisseauSpatial && ennemi.getV() != Parametre.vitesseInitSuperVaisseauSpatial)
                    ennemi.setVitesse(Parametre.vitesseInitSuperVaisseauSpatial);
            }
        }
    }

    /**
     * Vérifie le que le nombre d'ennemis spawnés est inférieur au nombre d'ennemis max - 1 pour le boss
     * si oui --> on ajoute une
     */
    public void verifNbEnnemisParVague() {
        if (this.nbEnnemiSpawn > (nbEnnemiMax.getValue() - (nbEnnemisParVague + 1))) { //89
            this.nbEnnemisParVague = (nbEnnemiMax.getValue() - 1) - nbEnnemiSpawn;
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
                if (this.listeEnnemis.get(i) instanceof EnnemiDivise) {
                    this.listeEnnemis.remove(i);
                } else {
                    this.listeEnnemis.remove(i);
                    this.nbEnnemiTue.setValue(this.nbEnnemiTue.getValue() + 1);
                    if (this.listeEnnemis.get(i) instanceof EnnemiVaisseauSpatial) {
                        //Lorsqu'un ennemiVaisseauSpatial meurt, 2 nouveaux vaisseaux apparaissent (ils ne comptent pas dans les listes des ennemis ajoutés et morts)
                        listeEnnemis.add(new EnnemiDivise(this, this.debutMap[1], this.debutMap[0]));
                        listeEnnemis.add(new EnnemiDivise(this, this.debutMap[1] + 16, this.debutMap[0] + 16));
                    }
                }
            }
        }
    }

    /**
     * Vérifie aussi si les projectiles à tête chercheuse ont un ennemi cible
     * Si non (l'ennemi cible a été tué par un autre projectile) --> le projectile est supprimé de l'environnement
     */
    public void verifProjectileHasCible() {
        for (int i = listeProjectiles.size() - 1; i >= 0; i--) {
            if (listeProjectiles.get(i) instanceof ProjectileTeteChercheuse) {
                boolean hasTarget = false;
                for (int j = 0; j < listeEnnemis.size(); j++) {
                    if (((ProjectileTeteChercheuse) listeProjectiles.get(i)).getEnnemiCible() == listeEnnemis.get(j)) {
                        hasTarget = true;
                    }
                }
                if(!hasTarget){
                    listeProjectiles.remove(i);
                }
            }
        }
    }

    public void verificationFinPartie(){
        if(this.getVieProperty().getValue() < 1 || this.getNbEnnemiTue() > (this.nbEnnemiMax.getValue() - 1)){
            this.finJeu = true;
        }
    }


    /**
     * Gestion de ce qu'il se passe pendant un tour
     */
    public void unTour() {
        deplacementEnnemis();
        deplacementProjectiles();
        attaquer();
        verificationEnnemisMorts();
        verifPerimetreChampDeForce();
        verifNbEnnemisParVague();
        verifProjectileHasCible();
        verificationFinPartie();
    }

}
