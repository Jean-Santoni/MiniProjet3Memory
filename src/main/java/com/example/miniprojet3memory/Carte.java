package com.example.miniprojet3memory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carte {

    private Image dos = new Image("file:ressources/téléchargement.png",240,240,false,false);
    private Image face ;

    public Carte(Image image){
        this.face=image;

    }



}
