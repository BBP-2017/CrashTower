package com.bbp.crashtower.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import com.bbp.crashtower.R;

import com.bbp.crashtower.data.CardInfo;
import com.bbp.crashtower.model.Tower;
import com.bbp.crashtower.model.Unit;

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleGroundView extends View {

    static final int PADDING_BG = 50, MAX_UNITS = 5;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Rect displayRect;

    Paint paint;

    Bitmap backgroundBitmap;

    Unit[] units = new Unit[MAX_UNITS+1];

    Tower tower1;

    boolean gameOver;



    //초기화 영역
    public BattleGroundView(Context context, SharedPreferences pref) {
        super(context);

        this.pref = pref;
        editor = pref.edit();

        paint = new Paint();

        mHandler.sendEmptyMessageDelayed(0, 100);     // Handler 호출
    }


    // Timer Handler
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {

            invalidate();   // View를 다시 그림

            for (int i = 1; i <= MAX_UNITS; i++) {
                Unit unit = units[i];
                if (unit != null) {
                    restrictUnits(unit);
                    detectedUnits(unit); // Unit 감지 처리
                }
            }

            if(gameOver){
                // result 브랜치에서 구현
            }

            mHandler.sendEmptyMessageDelayed(0, 100);
        }
    };



    // view가 layout에 적용됬을때 호출됨
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        displayRect = new Rect(left+PADDING_BG, top+PADDING_BG, right-PADDING_BG, bottom-PADDING_BG);

        backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.battle_ground);
        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, right, bottom, true);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundBitmap, 0, 0, null);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        for (int i = 1; i <= MAX_UNITS; i++) {
            Unit unit = units[i];
            if(unit!=null) {

                canvas.drawRect(unit.getSensor(), paint);
                canvas.drawBitmap(unit.getBitmap(), unit.getBody().left, unit.getBody().top, null);
            }
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            int id = pref.getInt("cardID",0);
            int level = 1;
            if(id!=0){
                setUnits(id,id,level,x,y);

                editor.putInt("cardID",0);
                editor.commit();
            }
        }
        return super.onTouchEvent(event);
    }

    void restrictUnits(Unit unit){

        if (displayRect.left > unit.getBody().left || displayRect.right < unit.getBody().right) {
            unit.changeDirDx();
        }
        if (displayRect.top > unit.getBody().top || displayRect.bottom < unit.getBody().bottom) {
            unit.changeDirDy();
        }
    }

    void  detectedUnits(Unit unit){

        for (int i = 1; i <= MAX_UNITS ; i++) {
            Unit targetUnit = units[i];
            if(targetUnit == null) continue;
            if(unit==targetUnit) continue;
            if(unit.getSensor().contains(targetUnit.getBody().centerX(),targetUnit.getBody().centerY())){
                targetUnit.backMpve();
            }
        }
    }

    void setUnits(int threadIdx,int cardID, int level, int x, int y){

        units[threadIdx] = new Unit(new CardInfo(getContext(),cardID,level),x,y);
        units[threadIdx].start();

    }

}
