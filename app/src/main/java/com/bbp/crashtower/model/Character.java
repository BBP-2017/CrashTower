package com.bbp.crashtower.model;

import java.io.Serializable;

/**
 * Created by roto1 on 2017-07-12.
 */

public class Character implements Serializable{
    public String name;
    public int image;
    public int restriction;
    public int getImage(){
        return image;
    }
    public String getName(){
        return name;
    }
    public Character(int image, String name){
        this.name=name;
        this.image=image;
    }
    public Character(int image,String name,int restriction){
        this.image=image;
        this.name=name;
        this.restriction=restriction;
    }
}
