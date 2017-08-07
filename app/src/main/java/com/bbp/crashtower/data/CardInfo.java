package com.bbp.crashtower.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Card;

import java.util.ArrayList;

/**
 * Created by dongbin on 2017-07-31.
 */

public class CardInfo{

    public static ArrayList<Card>[] curDecks;
    public static int BattleDeckNum;

    public int cardID, level, width, height;

    public int maxHp, damage, power, sensorRange , attackSpeed, moveSpeed;

    public int dir;

    public String name;

    public Rect body, sensor;

    public Bitmap bitmap;

    public int resID;

    public CardInfo(Context context, int cardID, int level){
        this.cardID = cardID; this.level = level;
        setStack(context);
    }

    void setStack(Context context){
        switch (cardID){
            case 1:
                name = "검사";
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 200;
                        power = 20;
                        moveSpeed = 20;
                        attackSpeed = 20;
                        dir = 1;
                        resID =  R.drawable.cr_swordman;
                        break;
                }
            break;
            case 2:
                name = "기마병";
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 300;
                        power = 20;
                        moveSpeed = 30;
                        attackSpeed = 20;
                        dir = 1;
                        resID =  R.drawable.cr_cavalry;
                        break;
                }
                break;
            case 3:
                name = "자이언트";
                switch (level){
                    default:
                        width = 200;
                        height = 200;
                        maxHp = 600;
                        power = 40;
                        moveSpeed = 10;
                        attackSpeed = 10;
                        dir = -1;
                        resID =  R.drawable.ccr_giant;
                        break;
                }
                break;
            case 4:
                name = "아처";
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 200;
                        power = 20;
                        moveSpeed = 20;
                        attackSpeed = 20;
                        dir = 1;
                        resID =  R.drawable.cr_archer;
                        break;
                }
                break;
            case 5:
                name = "바바리안";
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 200;
                        power = 20;
                        moveSpeed = 20;
                        attackSpeed = 20;
                        dir = 1;
                        resID =  R.drawable.baba;
                        break;
                }
                break;
            case 6:
                name = "P.E.K.K.A";
                switch (level){
                    default:
                        width = 200;
                        height = 200;
                        maxHp = 400;
                        power = 70;
                        moveSpeed = 10;
                        attackSpeed = 10;
                        dir = -1;
                        resID =  R.drawable.pekka;
                        break;
                }
                break;
            case 7:
                name = "해골병사";
                switch (level){
                    default:
                        width = 50;
                        height = 50;
                        maxHp = 100;
                        power = 5;
                        moveSpeed = 30;
                        attackSpeed = 30;
                        dir = -1;
                        resID = R.drawable.bone;
                        break;
                }
                break;
            default:
                name = "공백";
                width = 100;
                height = 100;
                resID = R.drawable.card_background;
                break;

        }
        sensorRange = width;
        body = new Rect(0,0,width,height);
        sensor = new Rect(body.centerX()-sensorRange,body.centerY()-sensorRange,body.centerX()+sensorRange,body.centerY()+sensorRange);
        bitmap = BitmapFactory.decodeResource(context.getResources(),resID);
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }
}
