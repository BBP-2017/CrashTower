package model;

import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-28.
 */

public class Tower extends Card implements Runnable{

    public Tower(int left, int top, int right, int bottom, int cardID) {
        super(left, top, right, bottom, cardID);

    }

    @Override
    public void run() {

    }
}
