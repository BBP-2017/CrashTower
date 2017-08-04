package com.bbp.crashtower.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.bbp.crashtower.data.CardInfo;

import java.io.Serializable;

/**
 * Created by roto1 on 2017-07-12.
 */

public class Card implements Serializable{
    public String name;
    public int image;

    public int cardID, level;

    public int maxHp, power, moveSpeed,attackSpeed;


    public Card(Context context, int cardID, int level){
        this.cardID = cardID; this.level = level;
        setInfo(new CardInfo(context,cardID,level));

    }

    void setInfo(CardInfo info) {

        maxHp = info.maxHp;
        power = info.power;
        moveSpeed = info.moveSpeed;
        attackSpeed = info.attackSpeed;

        image = info.resID;
        name = info.name;
    }

    public int getImage(){
        return image;
    }
    public String getName(){
        return name;
    }

}
