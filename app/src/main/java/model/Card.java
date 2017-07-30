package model;


import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Card extends RectF {


    int cardID;       //캐릭터 종류

    int maxHp, damage, power, speed;

    public Card(int left, int top, int right, int bottom, int cardID) {
        super(left, top, right, bottom);
        this.cardID = cardID;
        setStack();
    }

    void setStack() {
        switch (cardID) {
            case 1:
                maxHp = 100;
                power = 10;
                speed = 20;
                break;
            case 2:
                maxHp = 200;
                power = 20;
                speed = 10;
                break;
            case 3:
                maxHp = 50;
                power = 10;
                speed = 30;
                break;
            default:
                maxHp = 100;
                power = 10;
                speed = 10;
                break;
        }
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
