package model;

import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-28.
 */

public class Tower extends Card implements Runnable{

    public Tower(int cardID, int left, int top, int right, int bottom) {
        super(cardID, left, top, right, bottom);

        setStack();
        sensor = new RectF(left-sensorRange,top-sensorRange,right+sensorRange,bottom+sensorRange);
    }

    @Override
    public void run() {

    }

    void setStack() {
        maxHp = 100;
        power = 10;
        attackSpeed = 20;
        sensorRange = (int)width();

    }
}
