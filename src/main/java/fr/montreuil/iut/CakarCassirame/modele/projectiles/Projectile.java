package fr.montreuil.iut.CakarCassirame.modele.projectiles;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.beans.property.IntegerProperty;

public abstract class Projectile {
    private final Environnement env;
    private int degat;
    private IntegerProperty x, y;
    private final String id;
    private static int compteur = 0;
    private final int v;
    private boolean hasAttacked;

    public Projectile(Environnement env, int degat, IntegerProperty x, IntegerProperty y, int v){
        this.env = env;
        this.id = "P"+compteur;
        compteur++;
        this.x = x;
        this.y = y;
        this.degat = degat;
        this.v = v;
        this.hasAttacked = false;
    }

    public IntegerProperty XProperty(){return this.x;}
    public IntegerProperty YProperty(){return this.y;}
    public String getId(){return this.id;}
    public int getV(){return this.v;}
    public Environnement getEnv(){return this.env;}
    public int getDegat(){return this.degat;}

    public void setDegat(int degat) { this.degat = degat;}

    public abstract void seDeplacer();
    public abstract void attaquer();
    public void setHasAttacked(boolean b){
        hasAttacked = b;
    }
    public boolean getHasAttacked(){return hasAttacked;}

}
