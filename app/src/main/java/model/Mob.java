package model;


import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Mob extends RectF implements Runnable {

    int kind;       //캐릭터 종류

    int hp, power, speed, dx, dy;

    RectF target, display;

    boolean targetOn;

    public Mob(int kind, int left, int top, int right, int bottom, RectF target, RectF display) {
        super(left, top, right, bottom);
        this.kind = kind;
        if (target == null) {
            targetOn = false;
        } else {
            targetOn = true;
            this.target = target;
        }
        this.display = display;


        setStack();

    }


    @Override
    public void run() {
        while (true) {
            move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void setStack() {
        switch (kind) {
            case 1:
                hp = 100;
                power = 10;
                speed = 10;
                dx = speed;
                dy = speed;
                break;
            case 2:
                hp = 200;
                power = 20;
                speed = 5;
                dx = -speed;
                dy = -speed;
                break;
            case 3:
                hp = 50;
                power = 10;
                speed = 20;
                dx = -speed;
                dy = speed;
                break;
            default:
                hp = 100;
                power = 10;
                speed = 10;
                dx = speed;
                dy = speed;
                break;
        }
    }

    private void move() {
        offset(dx, dy); // 사각형 크기 유지 이동
        restrictMob();

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

    // mob들 제한 구역 설정
    public void restrictMob() {

        if (left < display.left) {
            dx = -dx;
            offset(dx,0);
        }
        if (right > display.right) {
            dx = -dx;
            offset(dx,0);
        }
        if (top < display.top) {
            dy = - dy;
            offset(0,dy);
        }
        if (bottom > display.bottom ) {
            dy = -dy;
            offset(0,dy);
        }
    }

    public void setTarget(RectF target) {
        this.target = target;
    }

    public void setTargetOn(Boolean on) {
        this.targetOn = on;
    }

}
