package model;


import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Card extends RectF{


    int cardID;       //캐릭터 종류

    int maxHp, damage, power, sensorRange , attackSpeed;

    public RectF sensor;

    public Card(int cardID,int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
        this.cardID = cardID;
    }

    void setStack() {

    }

    public int attack(){
        return power;
    }
    public void damaged(int power){
        damage += power;
    }
    public int getHp(){
        return maxHp - damage;
    }

}
