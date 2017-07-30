package model;

import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-28.
 */

public class Unit extends Card implements Runnable{

    int speed, dx, dy, sensorRange;

    boolean targetOn;

    public RectF display, target, sensor;

    public Unit(int left, int top, int right, int bottom, int cardID) {
        super(left, top, right, bottom, cardID);
    }

    public Unit(int left, int top, int right, int bottom, int cardID, RectF display) {
        super(left, top, right, bottom, cardID);

        this.display = display;

        setStack();
        sensor = new RectF(left + sensorRange, top + sensorRange, right + sensorRange, bottom + sensorRange);
    }

    @Override
    public void run() {
        move();
        if(!sensor.contains(target)){
            targetOn = false;
            target = null;
        }
    }

    public void setTarget(RectF target) {
        this.target = target;
        targetOn = true;
    }

    @Override
    void setStack() {
        switch (cardID) {
            case 1:
                dx = speed;
                dy = speed;
                sensorRange = (int)width()*2;
                break;
            case 2:
                dx = -speed;
                dy = -speed;
                sensorRange = (int)width()*2;
                break;
            case 3:
                dx = -speed;
                dy = speed;
                sensorRange = (int)width()*2;
                break;
            default:
                dx = speed;
                dy = speed;
                break;
        }
    }

    private void move() {
        offset(dx, dy); // 사각형 크기 유지 이동
        sensor.offset(dx,dy); // 센서도 같이 이동

        restrictUnit();

        if (targetOn) {
            if (left < target.centerX()) {
                dx = speed;
            }
            if (left > target.centerX()) {
                dx = -speed;
            }
            if (top < target.centerY()) {
                dy = speed;
            }
            if (top > target.centerY()) {
                dy = -speed;
            }
        }
    }

    // unit의 제한 구역 설정
    public void restrictUnit() {

        if (left < display.left) {
            dx = -dx;
            offset(dx, 0);
        }
        if (right > display.right) {
            dx = -dx;
            offset(dx, 0);
        }
        if (top < display.top) {
            dy = -dy;
            offset(0, dy);
        }
        if (bottom > display.bottom) {
            dy = -dy;
            offset(0, dy);
        }
    }

    public void changeDir() {
        dx = -dx;
        dy = -dy;
    }


}
