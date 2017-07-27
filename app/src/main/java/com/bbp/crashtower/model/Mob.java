package com.bbp.crashtower.model;

/**
 * Created by dongbin on 2017-07-19.
 */

public class Mob implements Runnable{

    int x, y;       // 캐릭터의 현재 좌표
    int sx, sy;     // 캐릭터가 이동할 방향과 거리
    int rw, rh;     // 캐릭터의 중심점

    int hp, power, speed;
    int kind;

    int targetX, targetY;

    boolean targetOn;

    public Mob(int kind,int rw, int rh, int x, int y, int sx, int sy){
        this.kind = kind;
        this.rw = rw;
        this.rh = rh;
        this.x = x;
        this.y = y;
        this.sx  = sx;
        this.sy = sy;
        speed = Math.abs(sx);

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
                speed = 10;
                break;
            case 2:
                hp = 200;
                power = 20;
                speed = 5;
                break;
            case 3:
                hp = 50;
                power = 10;
                speed = 20;
                targetOn = true;
                break;
            default:
                hp = 100;
                power = 10;
                speed = 10;
                break;
        }
    }
    private void move(){
        x += sx;    //수평으로 이동
        y += sy;    //수직으로 이동

        if(targetOn) {
            if (x < targetX) {
                sx = speed;
            }
            if (x > targetX) {
                sx = -speed;
            }
            if (y < targetY) {
                sy = speed;
            }
            if (y > targetY) {
                sy = -speed;
            }
        }
    }

    public void setTarget(int x, int y){

        targetX = x;
        targetY = y;

    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDirSx(){
        this.sx = -sx;
    }
    public void setDirSy(){
        this.sy = -sy;
    }
//    public void setTargetOn(Boolean on){
//        this.targetOn = on;
//    }
    public int getX(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getRw(){
        return rw;
    }
    public int getRh(){
        return  rh;
    }

}
