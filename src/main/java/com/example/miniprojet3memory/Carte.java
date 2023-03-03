package com.example.miniprojet3memory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carte {

    private Image dos = new Image("file:resources/3il.png",240,240,false,false);
    private Image valide = new Image("file:resources/téléchargement.png",240,240,false,false);
    private Image face ;

    private boolean clique = false;
    private boolean validation = false;


    public Carte(Image image){
        this.face=image;

    }
    public Image getDos(){
        return this.dos;
    }
    public Image getValide(){
        return this.valide;
    }
    public Image getFace(){
        return this.face;
    }
    public void CarteClique(){
        this.clique=true;
    }
    public void carteEstValide(){
        this.validation=true;
    }
    public void CarteFausse(){
        this.clique=false;
    }
    public boolean isClique(){
        return this.clique;
    }
    public boolean isValide(){
        return this.validation;
    }



}
