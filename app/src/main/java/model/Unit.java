package model;

import android.graphics.RectF;
import android.util.Log;

/**
 * Created by dongbin on 2017-07-28.
 */

public class Unit extends Card implements Runnable{

    int dx, dy, runSpeed;

    boolean targetOn;

    public RectF display, target;

    public Unit( int cardID,int left, int top, int right, int bottom,RectF display) {
        super(cardID,left, top, right, bottom);

        this.display = display;

        setStack();
        sensor = new RectF(left - sensorRange, top - sensorRange, right + sensorRange, bottom + sensorRange);
    }

    @Override
    public void run() {
        while (true) {
            move();
            if (targetOn) {
                //if (!sensor.contains(target.centerX(),target.centerY())) {
                 //   targetOn = false;
                 //   target = null;
                //}
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setTarget(RectF target) {
        this.target = target;
        targetOn = true;
    }

    void setStack() {
        switch (cardID) {
            case 1:
                maxHp = 100;
                power = 10;
                runSpeed = 20;
                dx = runSpeed;
                dy = runSpeed;
                break;
            case 2:
                maxHp = 200;
                power = 20;
                runSpeed = 10;
                dx = -runSpeed;
                dy = -runSpeed;
                break;
            case 3:
                maxHp = 50;
                power = 10;
                runSpeed = 30;
                dx = -runSpeed;
                dy = runSpeed;
                break;
            default:
                maxHp = 100;
                power = 10;
                runSpeed = 20;
                dx = runSpeed;
                dy = runSpeed;
                break;
        }
        sensorRange = (int)width();
    }

    private void move() {
        offset(dx, dy); // 사각형 크기 유지 이동
        sensor.offset(dx,dy); // 센서도 같이 이동

        restrictUnit();

        if (targetOn) {
            if (left < target.centerX()) {
                dx = runSpeed;
            }
            if (left > target.centerX()) {
                dx = -runSpeed;
            }
            if (top < target.centerY()) {
                dy = runSpeed;
            }
            if (top > target.centerY()) {
                dy = -runSpeed;
            }
        }

    }

    // unit의 제한 구역 설정
    public void restrictUnit() {

        if (left < display.left) {
            dx = -dx;
        }
        if (right > display.right) {
            dx = -dx;
        }
        if (top < display.top) {
            dy = -dy;
        }
        if (bottom > display.bottom) {
            dy = -dy;
        }
    }

    public void changeDir() {
        dx = -dx;
        dy = -dy;
    }
}
