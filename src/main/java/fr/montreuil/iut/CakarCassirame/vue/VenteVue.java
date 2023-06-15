package fr.montreuil.iut.CakarCassirame.vue;

import fr.montreuil.iut.CakarCassirame.modele.Environnement;
import javafx.scene.layout.Pane;

public class VenteVue {

    private Pane pane;
    private Environnement environnement;


    public VenteVue(Pane pane, Environnement environnement){
        this.pane = pane;
        this.environnement = environnement;
        /*
        ListChangeListener<Tour> listenerListeTours = new ListChangeListener<Tour>() {
            @Override
            public void onChanged(Change<? extends Tour> change) {
                while (change.next()) {
                    for(Tour tour : change.getAddedSubList()){
                        try {
                            affichage(tour);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    for(Tour tour : change.getRemoved()){
                        pane.getChildren().remove(pane.lookup("#" + tour.getId()));
                        pane.getChildren().remove(pane.lookup("#" + tour.getId() + "perimetre"));
                    }
                }
            }

        };
        environnement.getListeTours().addListener(listenerListeTours);

         */
    }
    /*
    public void affichage(Tour tour) throws FileNotFoundException {
            Image imageVente = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/CakarCassirame/rouge32.jpg"));
            ImageView imageViewVente = new ImageView(imageVente);
            imageViewVente.translateXProperty().bind(tour.XProperty().add(- 16));
            imageViewVente.translateYProperty().bind(tour.YProperty().add(- 16));
            imageViewVente.setId(tour.getId());
            imageViewVente.setOpacity(0.5);
            this.pane.getChildren().add(imageViewVente);
    }

     */

    public void reset(){
        for (int i = 0; i < environnement.getListeTours().size(); i++){
            pane.lookup("#" + environnement.getListeTours().get(i).getId()).setOpacity(1);
        }
    }

    public void affichaged(){
        //this.pane.setVisible(true);
        for (int i = 0; i < environnement.getListeTours().size(); i++){
            pane.lookup("#" + environnement.getListeTours().get(i).getId()).setOpacity(0.5);
        }
    }
}
