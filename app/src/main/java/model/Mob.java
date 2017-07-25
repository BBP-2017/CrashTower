package model;


import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Mob extends RectF implements Runnable{

    int kind;       //캐릭터 종류

    int hp, power,speed, dx,dy;

    RectF target;

    boolean targetOn;

    public Mob(RectF r) {
        super(r);
    }
    public  Mob(int kind, RectF r, RectF target){
        this(r);
        this.kind = kind;
        if(target==null){
            targetOn = false;
        }else {
            targetOn = true;
            this.target = target;
        }

        setStack();

    }


    @Override
    public void run() {
        while (true){
            move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void setStack(){
        switch (kind){
            case 1:
                hp = 100;
                power = 10;
                speed = 30;
                dx = speed;
                dy = speed;
                break;
            case 2:
                hp = 200;
                power = 20;
                speed = 10;
                dx = -speed;
                dy = -speed;
                break;
            case 3:
                hp = 50;
                power = 10;
                speed = 200;
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
    private void move(){
        left += dx;    //수평으로 이동
        top += dy;    //수직으로 이동

        if(targetOn) {
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

    public void setTarget(RectF target){
        this.target = target;
    }

    public void changeDirDx(){
        dx = -dx;
    }
    public void changeDirDy(){
        dy = -dy;
    }

    public void setTargetOn(Boolean on){
        this.targetOn = on;
    }

}
