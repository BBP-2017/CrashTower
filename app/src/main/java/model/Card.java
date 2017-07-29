package model;


import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Card extends RectF implements Runnable {


    int kind;       //캐릭터 종류

    int maxHp, damage, power, speed, dx, dy;
    int sensorRange;

    final int SEANSOR_RANGE = 50;

    RectF target, display;
    public RectF sensorArea;

    boolean targetOn;

    public Card(int kind, int left, int top, int right, int bottom, RectF target, RectF display) {
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
                maxHp = 100;
                power = 10;
                speed = 20;
                dx = speed;
                dy = speed;
                sensorArea = new RectF(left+sensorRange+speed,top+sensorRange+speed,right+sensorRange+speed,bottom+sensorRange+speed);
                break;
            case 2:
                maxHp = 200;
                power = 20;
                speed = 10;
                dx = -speed;
                dy = -speed;
                sensorArea = new RectF(left+sensorRange+speed,top+sensorRange+speed,right+sensorRange+speed,bottom+sensorRange+speed);
                break;
            case 3:
                maxHp = 50;
                power = 10;
                speed = 30;
                dx = -speed;
                dy = speed;
                sensorArea = new RectF(left+sensorRange+speed,top+sensorRange+speed,right+sensorRange+speed,bottom+sensorRange+speed);
                break;

            default:
                maxHp = 100;
                power = 10;
                speed = 10;
                dx = speed;
                dy = speed;
                sensorArea = new RectF(left+sensorRange+speed,top+sensorRange+speed,right+sensorRange+speed,bottom+sensorRange+speed);
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

    public void changeDir(){
        dx = - dx;
        dy = -dy;
    }

    public void setTargetOn(Boolean on) {
        this.targetOn = on;
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
