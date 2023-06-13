package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.DoubleProperty;

public abstract class Projectile {
    private Environnement env;
    private int degat;
    private DoubleProperty x, y;
    private String id;
    private static int compteur = 0;
    private int v;
    private boolean hasAttacked;

    public Projectile(Environnement env, int degat, DoubleProperty x, DoubleProperty y, int v){
        this.env = env;
        this.id = "P"+compteur;
        compteur++;
        this.x = x;
        this.y = y;
        this.degat = degat;
        this.v = v;
        this.hasAttacked = false;
    }

    public DoubleProperty XProperty(){return this.x;}
    public DoubleProperty YProperty(){return this.y;}
    public String getId(){return this.id;}
    public int getV(){return this.v;}
    public Environnement getEnv(){return this.env;}
    public int getDegat(){return this.degat;}

    public abstract void seDeplacer();

    public abstract void attaquer();

    public void setHasAttacked(boolean b){
        hasAttacked = b;
    }

    public boolean getHasAttacked(){return hasAttacked;}

}
