package fr.montreuil.iut.CakarCassirame.modele.tours;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import fr.montreuil.iut.CakarCassirame.modele.Parametre;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.Ennemi;
import fr.montreuil.iut.CakarCassirame.modele.ennemis.EnnemiExtraterrestre;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileCanonMissile;
import fr.montreuil.iut.CakarCassirame.modele.projectiles.ProjectileTeteChercheuse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TourTeteChercheuseTest {


//    public void recupererEnnemiCible(int temps) {
//        boolean quit = false;
//        Ennemi ennemi;
//        for (int i = 0; i < this.getEnvironnement().getListeEnnemis().size(); i++) {
//            ennemi = this.getEnvironnement().getListeEnnemis().get(i);
//            if (hasEnnemiDansPerimetre(ennemi)){
//                if (this instanceof TourCanonLaser) {
//                    this.getEnvironnement().ajouterProjectileTeteChercheuse(1, this.XProperty().getValue(), this.YProperty().getValue(), Parametre.degatCanonLaser.getValue() + ((this.getEnvironnement().getNiveauCanonLaser() - 1) * 10), ennemi);
//                }
//                if (this instanceof TourCanonMissile) {
//                    this.getEnvironnement().ajouterProjectileTeteChercheuse(2, this.XProperty().getValue(), this.YProperty().getValue(), Parametre.degatCanonMissile.getValue() + ((this.getEnvironnement().getNiveauCanonLaser() - 1) * 20), ennemi);
//                }
//                this.tempsLastEnnemi = temps;
//                quit = true;
//            }
//            if (quit) break;
//        }
    @Test
    void recupererEnnemiCibleTest() throws IOException {
        Environnement env = new Environnement(2);
        TourTeteChercheuse tour = new TourCanonMissile(env, 500, 560);
        Ennemi ennemi1 = new EnnemiExtraterrestre(env, 520, 550);
        env.getListeEnnemis().add(ennemi1);
        int temps = 150;
        assertTrue(temps > Parametre.tempsRechargeCanonMissile.getValue());

        tour.recupererEnnemiCible(temps);

        assertTrue(env.getListeProjectiles().size() ==1);
        assertTrue(env.getListeProjectiles().get(0) instanceof ProjectileCanonMissile);
        assertTrue(((ProjectileCanonMissile) env.getListeProjectiles().get(0)).getEnnemiCible() == ennemi1);
        assertTrue(tour.getTempsLastEnnemi() == temps);



    }

}