package fr.montreuil.iut.CakarCassirame.controller;

import fr.montreuil.iut.CakarCassirame.Main;
import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonBombeNuclaire;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourCanonLaser;
import fr.montreuil.iut.CakarCassirame.modele.tours.TourTeteChercheuse;
import fr.montreuil.iut.CakarCassirame.vue.FinJeuVue;
import fr.montreuil.iut.CakarCassirame.vue.MapVue;
import fr.montreuil.iut.CakarCassirame.vue.PlacementVue;
import fr.montreuil.iut.CakarCassirame.vue.VenteVue;
import fr.montreuil.iut.CakarCassirame.vue.ennemiVue.*;
import fr.montreuil.iut.CakarCassirame.vue.infobulleVue.InfoBulleBoutonsAmelioraton;
import fr.montreuil.iut.CakarCassirame.vue.infobulleVue.InfoBulleBoutonsTours;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileBombeNuclaireVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileBombeNucleaireExplosionVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.projectileVue.ProjectileMissileVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonBombeNucleaireVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonLaserVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourCanonMissileVue;
import fr.montreuil.iut.CakarCassirame.vue.tourVue.TourChampDeForceVue;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerNiveau implements Initializable {
    @FXML
    private TilePane tilePaneExterne;
    @FXML
    private TilePane tilePaneBombe;
    @FXML
    private Pane pane;
    @FXML
    private Button canonLaser;
    @FXML
    private Button canonMissile;
    @FXML
    private Button canonNucleaire;
    @FXML
    private Button champForce;
    @FXML
    private TilePane tilePaneInterne;
    @FXML
    private Button ameliorationCanonLaser;
    @FXML
    private Button ameliorationCanonMissile;
    @FXML
    private Button ameliorationChampDeForce;
    @FXML
    private Button ameliorationCanonNucleaire;
    @FXML
    private Label prixAmeliorationLaser;
    @FXML
    private Label prixAmeliorationMissile;
    @FXML
    private Label prixCanonLaser;
    @FXML
    private Label prixCanonMissile;
    @FXML
    private Label prixChampDeForce;
    @FXML
    private Label prixCanonNucleaire;
    @FXML
    private Label nbRessources;
    @FXML
    private HBox hboxVie;
    @FXML
    private Label nbEnnemiTue;
    @FXML
    private Label nbEnnemiMax;
    @FXML
    private HBox menuAmelioration1;
    @FXML
    private HBox menuAmelioration2;
    private MapVue vueMap;
    private Environnement environnement;
    private PlacementVue placementVue;
    private TourCanonLaserVue tourCanonLaserVue;
    private TourChampDeForceVue tourChampDeForceVue;
    private TourCanonMissileVue tourCanonMissileVue;
    private TourCanonBombeNucleaireVue tourCanonBombeNucleaireVue;
    private EnnemiExtraterrestreVue ennemiExtraterrestreVue;
    private EnnemiVaisseauSpatialVue ennemiVaisseauSpatialVue;
    private EnnemiSuperVaisseauSpatialVue ennemiSuperVaisseauSpatialVue;
    private EnnemiDiviseVue ennemiDiviseVue;
    private EnnemiGalactusBossVue ennemiGalactusBossVue;
    private ProjectileMissileVue projectileMissileVue;
    private ProjectileLaserVue projectileLaserVue;
    private ProjectileBombeNuclaireVue projectileBombeNuclaireVue;
    private ProjectileBombeNucleaireExplosionVue projectileBombeNucleaireExplosionVue;
    private Timeline gameLoop;
    private boolean placement = false;
    private int temps;
    private boolean arretTemps = false;
    private boolean enter = false;
    private int choixTour = 0;
    private boolean affichageMenu = false;
    private FinJeuVue finJeuVue;
    private VenteVue venteVue;
    private boolean autorisationVente = false;
    private InfoBulleBoutonsAmelioraton infoBulleBoutonsAmelioraton;
    private InfoBulleBoutonsTours infoBulleBoutonsTours;
    private int nbEnnemiACreer = 0;
    private int tempsLastEnnemiCree = 0;

    @FXML
    private Label prixAmeliorationNucleaire;

    @FXML
    private Label prixAmeliorationChamps;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.environnement = new Environnement(ControllerSelectionNiveau.choixNiveau);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.vueMap = new MapVue(this.tilePaneExterne);
        this.ennemiExtraterrestreVue = new EnnemiExtraterrestreVue(this.pane);
        this.ennemiVaisseauSpatialVue = new EnnemiVaisseauSpatialVue(this.pane);
        this.ennemiSuperVaisseauSpatialVue = new EnnemiSuperVaisseauSpatialVue(this.pane);
        this.ennemiDiviseVue = new EnnemiDiviseVue(pane);
        this.ennemiGalactusBossVue = new EnnemiGalactusBossVue(this.pane);
        this.tourCanonLaserVue = new TourCanonLaserVue(pane);
        this.tourCanonMissileVue = new TourCanonMissileVue(pane);
        this.tourCanonBombeNucleaireVue = new TourCanonBombeNucleaireVue(pane);
        this.tourChampDeForceVue = new TourChampDeForceVue(pane);
        this.placementVue = new PlacementVue(tilePaneInterne);
        this.nbEnnemiMax.textProperty().bind(this.environnement.getNbEnnemiMaxProperty().asString());
        this.nbEnnemiTue.textProperty().bind(this.environnement.getNbEnnemiTueProperty().asString());
        this.venteVue = new VenteVue(pane, this.environnement);


        this.infoBulleBoutonsTours = new InfoBulleBoutonsTours(canonLaser, canonMissile, champForce, canonNucleaire, environnement);
        this.infoBulleBoutonsAmelioraton = new InfoBulleBoutonsAmelioraton(ameliorationCanonLaser, ameliorationCanonMissile, ameliorationChampDeForce, ameliorationCanonNucleaire, environnement);
        menuAmelioration1.setVisible(false);
        menuAmelioration2.setVisible(false);
        this.projectileBombeNuclaireVue = new ProjectileBombeNuclaireVue(pane);
        this.projectileLaserVue = new ProjectileLaserVue(pane);
        this.projectileMissileVue = new ProjectileMissileVue(pane);
        this.projectileBombeNucleaireExplosionVue = new ProjectileBombeNucleaireExplosionVue(tilePaneBombe);
        this.environnement.getListeTours().addListener(new ObsTours(pane));
        this.environnement.getListeEnnemis().addListener(new ObsEnnemis(pane));
        this.environnement.getListeProjectiles().addListener(new ObsProjectiles(pane, tilePaneBombe));
        this.finJeuVue = new FinJeuVue(pane);

        try {
            this.placementVue.affichage(this.environnement.getMap());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.placementVue.reset();

        try {
            this.vueMap.creerMap(this.environnement.getMap());
            initAnimation();
            gameLoop.play();

            prixCanonLaser.textProperty().bind(Parametre.prixTourCanonLaser.asString());
            prixCanonMissile.textProperty().bind(Parametre.prixTourCanonMissile.asString());
            prixChampDeForce.textProperty().bind(Parametre.prixTourChampForce.asString());
            prixCanonNucleaire.textProperty().bind(Parametre.prixTourCanonNucleaire.asString());
            nbRessources.textProperty().bind(this.environnement.ressourceProperty().asString());
            prixAmeliorationLaser.textProperty().bind(Parametre.prixAmeliorationCanonLaser.asString());
            prixAmeliorationMissile.textProperty().bind(Parametre.prixAmeliorationCanonMissile.asString());
            prixAmeliorationNucleaire.textProperty().bind(Parametre.prixAmeliorationCanonNucleaire.asString());
            prixAmeliorationChamps.textProperty().bind(Parametre.prixAmeliorationChampForce.asString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.017),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (environnement.getNbEnnemiTue() == environnement.getNbEnnemiMax() && !enter) {
                        enter = true;
                        try {
                            //affichage de la page de victoire
                            this.finJeuVue.victoire();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        temps = 0;
                    }
                    else if (this.environnement.getVieProperty().getValue() < 1  && !enter) {
                        enter = true;
                        try {
                            //affichade de la page de défaite
                            this.finJeuVue.defaite();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        temps = 0;
                    }
                    if (enter) {
                        if (temps > 100) {
                            try {
                                chargerPageAcceuil();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            gameLoop.stop();
                        }
                    }

                        //Si l'ennemi a encore des vies
                     if (this.environnement.getVieProperty().getValue() > 0 && !enter) {
                        if (this.environnement.getListeTours().size() != 0) {
                            for (int i = 0; i < this.environnement.getListeTours().size(); i++) {
                                if (this.environnement.getListeTours().get(i) instanceof TourTeteChercheuse) {
                                    TourTeteChercheuse tour = (TourTeteChercheuse) this.environnement.getListeTours().get(i);
                                    //Ici, on vérifie si le temps de recharge de la tour a été dépassé. Si oui, on vérifie si un ennemi est présent dans le périmètre
                                    if (this.environnement.getListeTours().get(i) instanceof TourCanonLaser) {
                                        if (Math.abs(temps - tour.getTempsLastEnnemi()) >= (Parametre.tempsRechargeCanonLaser.getValue() - ((this.environnement.getNiveauCanonLaser() - 1) * 10))) {
                                            tour.recupererEnnemiCible(temps);
                                        }
                                    } else if (Math.abs(temps - tour.getTempsLastEnnemi()) >= (Parametre.tempsRechargeCanonMissile.getValue() - ((this.environnement.getNiveauCanonMissile() - 1) * 10))) {
                                        tour.recupererEnnemiCible(temps);
                                    }
                                }
                                //Les tours bombe nucléaires envoient une bombe si leur temps de recharge est passé
                                if (this.environnement.getListeTours().get(i) instanceof TourCanonBombeNuclaire) {
                                    if ((temps % Parametre.tempsRechargeCanonNuclaire.getValue() - ((this.environnement.getNiveauCanonNucleaire() - 1) * 10)) == 0 && temps != 0) {
                                        this.environnement.ajouterProjectileBombeNucleaire(3, this.environnement.getListeTours().get(i).XProperty().getValue(), this.environnement.getListeTours().get(i).YProperty().getValue());
                                    }
                                }
                            }
                        }

                        if (temps % 3 == 0 && !enter) {
                            this.environnement.unTour();
                            AffichageBoutonAmelioration();
                            AffichageBoutonTours();

                            if (this.environnement.getVieProperty().getValue() < 3) {
                                if (-(this.environnement.getVieProperty().getValue() + 1 - 3) > 2) {
                                    for (int i = 0; i < this.hboxVie.getChildren().size(); i++) {
                                        this.hboxVie.getChildren().get(i).setVisible(false);
                                    }
                                } else
                                    this.hboxVie.getChildren().get(-(this.environnement.getVieProperty().getValue() + 1 - 3)).setVisible(false);
                            }

                        }
                        //ajout d'ennemi à un rythme continu
                        if (temps % 100 == 0 && !enter) {
                            if (this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax()) {
                                environnement.ajouterEnnemi();
                            }
                            projectileBombeNucleaireExplosionVue.resetGIF();
                        }
                        //si le temps de "recharge vague" est passé, on doit creer nbEnnemisParVague
                        if (temps - this.environnement.getTempsLastVague() >= this.environnement.getIntervalleVague() && this.environnement.getNbEnnemiSpawn() < this.environnement.getNbEnnemiMax() && !enter) {
                            nbEnnemiACreer += this.environnement.getNbEnnemisParVague();
                            this.environnement.setTempsLastVague(temps);
                        }
                        //S'il y a des ennemis à créer, on les ajoute selon l'intervalle précisé pour constituer la vague d'ennemis
                        if(nbEnnemiACreer > 0 && temps - tempsLastEnnemiCree > this.environnement.getIntervalleEnnemiParVague() && !enter){
                            tempsLastEnnemiCree = temps;
                            this.environnement.ajouterEnnemi();
                            this.nbEnnemiACreer--;
                        }
                        //s'il ne reste plus de vie à l'ennemi ou que le joueur a tué tous les ennemis
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    /**
     * Permet de charger la page d'acceuil
     * @throws IOException
     */
    public void chargerPageAcceuil() throws IOException {
        Scene scene = pane.getScene();
        Stage stage = (Stage) scene.getWindow();
        ControllerPageAccueil.load(stage);
    }


    /**
     * Permet de charger la page du Jeu
     * @param stage
     * @throws IOException
     */
    public static void load(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pageNiveau.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 640);
        stage.setTitle("Space Defender");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Mets pause la partie lorsque le bouton Pause/Play est cliqué
     */
    public void pause() {
        arretTemps = !arretTemps;
        if (gameLoop.getStatus() == Animation.Status.RUNNING) {
            gameLoop.pause();
        } else
            gameLoop.play();
    }

    /**
     * affiche ou desaffiche le menu des amelioration lorsque le bouton amelioration est cliqué
     */
    public void affichageMenuAmelioration() {
        if (!affichageMenu) {
            menuAmelioration1.setVisible(true);
            menuAmelioration2.setVisible(true);
            affichageMenu = true;

        } else {
            menuAmelioration1.setVisible(false);
            menuAmelioration2.setVisible(false);
            affichageMenu = false;
        }
    }

    /**
     * Grise les image des bouton des amelioration si l'utilisateur n'a pas l'argent nécessaire
     */
    public void AffichageBoutonAmelioration() {
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixAmeliorationCanonLaser.getValue() || this.environnement.getNiveauCanonLaser() >= this.environnement.niveauMaxCanonProperty().getValue()) {
            ameliorationCanonLaser.setDisable(true);
        } else {
            ameliorationCanonLaser.setDisable(false);

        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixAmeliorationCanonMissile.getValue() || this.environnement.getNiveauCanonMissile() >= this.environnement.niveauMaxCanonProperty().getValue()) {
            ameliorationCanonMissile.setDisable(true);
        } else {
            ameliorationCanonMissile.setDisable(false);

        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixAmeliorationCanonNucleaire.getValue() || this.environnement.getNiveauCanonNucleaire() >= this.environnement.niveauMaxCanonProperty().getValue()) {
            ameliorationCanonNucleaire.setDisable(true);
        } else {
            ameliorationCanonNucleaire.setDisable(false);

        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixAmeliorationChampForce.getValue() || this.environnement.getNiveauChampForce() >= this.environnement.niveauMaxChampProperty().getValue()) {
            ameliorationChampDeForce.setDisable(true);
        } else {
            ameliorationChampDeForce.setDisable(false);
        }
    }
    /**
     * Grise les image des bouton d'achat des tours si l'utilisateur n'a pas l'argent nécessaire
     */
    public void AffichageBoutonTours() {
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixTourCanonLaser.getValue()) {
            canonLaser.setDisable(true);
        } else {
            canonLaser.setDisable(false);
        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixTourCanonMissile.getValue()) {
            canonMissile.setDisable(true);
        } else {
            canonMissile.setDisable(false);
        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixTourCanonNucleaire.getValue()) {
            canonNucleaire.setDisable(true);
        } else {
            canonNucleaire.setDisable(false);
        }
        if (this.environnement.ressourceProperty().getValue() < Parametre.prixTourChampForce.getValue()) {
            champForce.setDisable(true);
        } else {
            champForce.setDisable(false);
        }
    }

    /**
     * Appele la fonction de l'environnement qui ajoute 1 au niveau de la tour qui est ameliorer
     */
    public void ameliorationTours() {
        if(!arretTemps) {
            int choix = (ameliorationCanonLaser.isArmed()) ? 1 : (ameliorationCanonMissile.isArmed()) ? 2 : (ameliorationCanonNucleaire.isArmed()) ? 3 : 4;
            this.environnement.ameliorationTour(choix);
            this.infoBulleBoutonsTours.mAJ();
            this.infoBulleBoutonsAmelioraton.mAJ();
        }
    }


    /**
     * Affiche les emplacments disponibles pour placer une tour
     */
    @FXML
    public void affichagePlacement() throws FileNotFoundException {
        if (!arretTemps) {
            choixTour = (canonLaser.isArmed()) ? 1 : (canonMissile.isArmed()) ? 2 : (canonNucleaire.isArmed()) ? 3 : 4;
            int prix;
            if (choixTour == 1)
                prix = Parametre.prixTourCanonLaser.getValue();
            else if (choixTour == 2)
                prix = Parametre.prixTourCanonMissile.getValue();
            else if (choixTour == 3)
                prix = Parametre.prixTourCanonNucleaire.getValue();
            else
                prix = Parametre.prixTourChampForce.getValue();
            if (this.environnement.ressourceProperty().getValue() >= prix) {
                this.placementVue.affichaged();
                this.placement = true;
            }
        }
    }

    /**
     * Autorise la vente et et diminu l'opacite des tours de la map pour monter l'activation du bouton vente
     */
    public void affichagePlacementVente() {
        if (!arretTemps) {
            this.venteVue.affichaged();
            this.autorisationVente = true;
        }
    }

    /**
     * Récupère la position de la souris et place une tour à la position souhaitée
     * Récupère la position de la souris et vend la tour disponible à cette emplacement
     * @param mouseEvent
     */
    @FXML
    public void GestionTour(MouseEvent mouseEvent) throws FileNotFoundException {
        if (!arretTemps) {
            double positionX = mouseEvent.getX();
            double positionY = mouseEvent.getY();
            if (positionY > -1 && positionY <= tilePaneInterne.getHeight() && positionX > -1 && positionX <= tilePaneInterne.getWidth()) {
                if (this.environnement.getMap().getTile((int) positionY / 32, (int) positionX / 32) == 3 && placement) {
                    positionX = ((int) positionX / 32) * 32;
                    positionY = ((int) positionY / 32) * 32;
                    if (this.environnement.verificationPlacement(positionX, positionY)) {
                        this.environnement.ajouterTour((int) positionX + 16, (int) positionY + 16, this.choixTour);
                    }
                }
                if (autorisationVente) {
                    positionX = ((int) positionX / 32) * 32;
                    positionY = ((int) positionY / 32) * 32;
                    if (!this.environnement.verificationPlacement(positionX, positionY)) {
                        this.environnement.vendreTour((int) (positionX + 16), (int) (positionY + 16));
                    }
                }
            }
            this.placementVue.reset();
            placement = false;
            this.venteVue.reset();
            this.autorisationVente = false;
        }
    }
}


