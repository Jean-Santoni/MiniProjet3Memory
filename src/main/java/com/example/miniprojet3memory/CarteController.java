package com.example.miniprojet3memory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Delayed;

import static java.util.Collections.shuffle;

public class CarteController {
    private int nbClique=0;
    private int nbCarteVailde=0;
    @FXML
    private ArrayList<Carte> ListeCarte = new ArrayList<>();
    @FXML
    private Carte CartePrecedent ;
    @FXML
    private Carte CarteActuel ;
    @FXML
    private Label titre;
    @FXML
    private Label partieFinie;
    @FXML
    private GridPane plateau;
    @FXML
    private ImageView photo;

    @FXML
    protected void InitialisationJeu(MouseEvent event) {
        InitialisationListe();
        InitialisationTableau();
    }
    @FXML
    protected void InitialisationListe() {
        ListeCarte.clear();
        Carte m1 = new Carte(new Image("file:resources/c.png", 240, 240, false, false));
        Carte m2 = new Carte(new Image("file:resources/java.png", 240, 240, false, false));
        Carte m3 = new Carte(new Image("file:resources/chinois.png", 240, 240, false, false));
        Carte m4 = new Carte(new Image("file:resources/Electricité.png", 240, 240, false, false));
        Carte m5 = new Carte(new Image("file:resources/anglais.png", 240, 240, false, false));
        Carte m6 = new Carte(new Image("file:resources/maths.png", 240, 240, false, false));
        Carte m7 = new Carte(new Image("file:resources/c.png", 240, 240, false, false));
        Carte m8 = new Carte(new Image("file:resources/java.png", 240, 240, false, false));
        Carte m9 = new Carte(new Image("file:resources/chinois.png", 240, 240, false, false));
        Carte m10 = new Carte(new Image("file:resources/Electricité.png", 240, 240, false, false));
        Carte m11 = new Carte(new Image("file:resources/anglais.png", 240, 240, false, false));
        Carte m12 = new Carte(new Image("file:resources/maths.png", 240, 240, false, false));

        ListeCarte.add(m1);
        ListeCarte.add(m2);
        ListeCarte.add(m3);
        ListeCarte.add(m4);
        ListeCarte.add(m5);
        ListeCarte.add(m6);
        ListeCarte.add(m7);
        ListeCarte.add(m8);
        ListeCarte.add(m9);
        ListeCarte.add(m10);
        ListeCarte.add(m11);
        ListeCarte.add(m12);
        shuffle(ListeCarte);

    }




    @FXML
    protected void InitialisationTableau() {

        plateau.getColumnConstraints().clear();
        plateau.getRowConstraints().clear();
        for (int c = 0; c <= 2; c++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100.0 / 2);
            plateau.getColumnConstraints().add(column);
        }
        for (int r = 0; r <= 3; r++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 3);
            plateau.getRowConstraints().add(row);
        }
        int collIndex = 0;
        int rowIndex = 0;
        int listeIndex = 0;
        for (collIndex = 0; collIndex <= 2; collIndex++) {
            for (rowIndex = 0; rowIndex <= 3; rowIndex++) {
                ImageView n = new ImageView();
                if(ListeCarte.get(listeIndex).isClique()==false) {
                    n.setImage(ListeCarte.get(listeIndex).getDos());
                }else if(ListeCarte.get(listeIndex).isValide() && ListeCarte.get(listeIndex).isClique() ){
                    n.setImage(ListeCarte.get(listeIndex).getValide());
                }else {
                    n.setImage(ListeCarte.get(listeIndex).getFace());
                }
                n.setFitWidth(100.0);
                n.setFitHeight(100.0);
                Carte carteTampon = ListeCarte.get(listeIndex);
                n.setOnMouseClicked(event ->CliqueCase(carteTampon) );
                plateau.add(n, collIndex, rowIndex);
                listeIndex++;
            }
        }
        listeIndex=0;
        titre.setText("coucou");
    }


    @FXML
    protected void CliqueCase(Carte c) {

        if(nbClique<2){
            nbClique++;

        }else if (nbClique==2){
            if (CartePrecedent.getFace().getUrl().equals(CarteActuel.getFace().getUrl()) && CartePrecedent!= null &&CarteActuel!=null){
                CartePrecedent.carteEstValide();
                CarteActuel.carteEstValide();
                nbCarteVailde=nbCarteVailde+2;
                nbClique=1;
                 if (nbCarteVailde==12){
                    partieFinie.setVisible(true);
                 }
            }else{
                CartePrecedent.CarteFausse();
                CarteActuel.CarteFausse();
                nbClique=1;
            }
        }

        c.CarteClique();
        InitialisationTableau();

        if (CarteActuel != null) {
            CartePrecedent = CarteActuel;
        }
        CarteActuel = c;

       // InitialisationTableau();
    }


}
