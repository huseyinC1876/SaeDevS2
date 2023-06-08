package fr.montreuil.iut.CakarCassirame.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Projectile {

        private int degat;
        private IntegerProperty x, y;
        private String id;
        private int compteur = 0;

        public Projectile(int degat){
            this.id = "P"+compteur;
            compteur++;
            this.x = new SimpleIntegerProperty();
            this.y = new SimpleIntegerProperty();
            this.degat = degat;
        }

        public IntegerProperty XProperty(){return this.x;}
        public IntegerProperty YProperty(){return this.y;}

        public String getId(){return this.id;}
}
