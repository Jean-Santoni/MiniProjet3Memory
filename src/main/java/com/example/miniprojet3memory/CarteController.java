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

public class CarteController {
    @FXML
    private Label titre;
    @FXML
    private GridPane plateau;
    @FXML
    private ImageView photo;



    @FXML
    protected void InitialisationTableau(MouseEvent event){

        plateau.getColumnConstraints().clear();
        plateau.getRowConstraints().clear();
        for (int c =0 ; c <= 2 ;c++){
            ColumnConstraints column = new ColumnConstraints( );
            column.setPercentWidth(100.0/2);
            plateau.getColumnConstraints().add(column);
        }
        for (int r =0 ; r <= 3 ;r++){
            RowConstraints row = new RowConstraints( );
            row.setPercentHeight(100.0/3);
            plateau.getRowConstraints().add(row);
        }
        int collIndex =0;
        int rowIndex = 0;
        for(collIndex=0;collIndex<=2;collIndex++){
            for (rowIndex=0;rowIndex<=3;rowIndex++){
                Button b = new Button();
                b.setText(";sfkdjhfl;khjqdfvgs;kdh");
                plateau.add(b,collIndex,rowIndex);
            }
        }
       // System.out.println(photo);
       // Image i = new Image("file:ressources/dog.JPG",240,240,false,false);
        //System.out.println(photo);
       titre.setText("coucou");
      //  this.photo.setImage(i);
    }


    @FXML
    protected void initCarte(Carte c){

    }
}
