package model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import data.CardInfo;

/**
 * Created by dongbin on 2017-07-28.
 */

public class Unit extends Thread{

    int dx, dy, width, height;

    int moveSpeed, maxHp,power,sensorRange;

    boolean targetOn;

    Rect body, target, sensor;

    Bitmap bitmap;


    public Unit(CardInfo info,int x,int y) {
        setInfo(info);
        body.offsetTo(x,y);
        sensor.offsetTo(body.centerX(),body.centerY());
    }

    @Override
    public void run() {
        while (true) {
            move();
            if (targetOn) {
                if (!sensor.contains(target.centerX(),target.centerY())) {
                    targetOn = false;
                    target = null;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setTarget(Rect target) {
        this.target = target;
        targetOn = true;
    }

    void setInfo(CardInfo info) {

        width = info.width;
        height = info.height;
        maxHp = info.maxHp;
        power = info.power;
        moveSpeed = info.moveSpeed;
        dx = info.moveSpeed;
        dy = info.moveSpeed;
        sensorRange = info.sensorRange;

        body = info.body;
        sensor = info.sensor;

        bitmap = info.bitmap;
    }

    private void move() {
        body.offset(dx, dy); // 사각형 크기 유지 이동
        sensor.offsetTo(body.centerX(),body.centerY()); // 센서도 같이 이동


        if (targetOn) {
            if (body.centerX() < target.centerX()) {
                dx = moveSpeed;
            }else if (body.centerX() > target.centerX()) {
                dx = -moveSpeed;
            }else{
                dx = 0;
            }
            if (body.centerY() < target.centerY()) {
                dy = moveSpeed;
            }else if (body.centerY() > target.centerY()) {
                dy = -moveSpeed;
            }else{
                dy = 0;
            }
        }

    }

    public void changeDir() {
        dx = -dx;
        dy = -dy;
    }

    public  Rect getBody(){
        return body;
    }

    public  Rect getSensor(){
        return sensor;
    }

    public  Bitmap getBitmap(){
        return bitmap;
    }
}
