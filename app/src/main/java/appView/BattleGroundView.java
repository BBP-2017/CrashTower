package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bbp.crashtower.R;

import model.Tower;
import model.Unit;

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleGroundView extends View {

    RectF displayRect;

    Paint paint;

    Bitmap backgroundBitmap, unit1Bitmap, unit2Bitmap, unit3Bitmap, tower1Bitmap;

    Unit unit1, unit2, unit3;
    Tower tower1;

    boolean gameOver;

    //초기화 영역
    public BattleGroundView(Context context) {
        super(context);

        paint = new Paint();

        mHandler.sendEmptyMessageDelayed(0, 100);     // Handler 호출
    }

    // view가 layout에 적용됬을때 호출됨
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        displayRect = new RectF(left, top, right, bottom);

        unit1 = new Unit(1,500, 500, 500+100, 500+100,displayRect);
        unit2 = new Unit(2,1000, 1000, 1000+200, 1000+200,displayRect);
        unit3 = new Unit(3,1000, 1000, 1000+50, 1000+50,displayRect);
        tower1 = new Tower(4,(int)displayRect.right/2-100,(int)displayRect.bottom/4-150,(int)displayRect.right/2+100,(int)displayRect.bottom/4+150);


        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);
        unit1Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);
        unit2Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pekka);
        unit3Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.bone);
        tower1Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.king_tower);

        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, (int) displayRect.width(), (int) displayRect.height(), true);
        unit1Bitmap = Bitmap.createScaledBitmap(unit1Bitmap, (int) unit1.width(), (int) unit1.height(), true);
        unit2Bitmap = Bitmap.createScaledBitmap(unit2Bitmap, (int) unit2.width(), (int) unit2.height(), true);
        unit3Bitmap = Bitmap.createScaledBitmap(unit3Bitmap, (int) unit3.width(), (int) unit3.height(), true);
        tower1Bitmap = Bitmap.createScaledBitmap(tower1Bitmap, (int) tower1.width(), (int) tower1.height(), true);


        new Thread(unit1).start();
        new Thread(unit2).start();
        new Thread(unit3).start();
        new Thread(tower1).start();


    }

    // Timer Handler
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {

            invalidate();   // View를 다시 그림

            detectedUnits(); // Unit 감지 처리
            

            mHandler.sendEmptyMessageDelayed(0, 100);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            // 터치범위 제한
            int restrict = (int) unit3.width() * 2;

            if ((x > displayRect.left + restrict && x < displayRect.right - restrict) && (y > displayRect.top + restrict && y < displayRect.bottom - restrict))
                unit3.setTarget(new RectF(x, y, x+1, y+1));
        }

        return super.onTouchEvent(event);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawBitmap(backgroundBitmap, 0, 0, paint);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawRect(new RectF(unit1.sensor), paint);
        canvas.drawRect(new RectF(unit2.sensor), paint);
        canvas.drawRect(new RectF(unit3.sensor), paint);
        canvas.drawRect(new RectF(tower1.sensor), paint);

        canvas.drawBitmap(unit1Bitmap, unit1.left, unit1.top, null);
        canvas.drawBitmap(unit2Bitmap, unit2.left, unit2.top, null);
        canvas.drawBitmap(unit3Bitmap, unit3.left, unit3.top, null);
        canvas.drawBitmap(tower1Bitmap, tower1.left, tower1.top, null);




    }

    void  detectedUnits(){
        if(unit1.sensor.contains(unit3)){
            unit1.setTarget(unit3);
        }
        if(unit2.sensor.contains(unit3)) {
            unit2.setTarget(unit3);
        }
        if(unit3.intersect(tower1)){
            tower1.damaged(unit3.attack());
            unit3.changeDir();
            Log.d("unit3 to Tower","attacked");
            if(tower1.getHp()<0){
                gameOver = true;
            }
        }
    }

}
