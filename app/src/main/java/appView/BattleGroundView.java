package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.bbp.crashtower.R;

import model.Mob;

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleGroundView extends View{

    int displayLeft, displayTop, displayRight, displayBottom;

    Paint paint;

    Bitmap backgroundBitmap, mob1_Bitmap, mob2_Bitmap;

    Mob mob1_1, mob1_2, mob2_1;

    //초기화 영역
    public BattleGroundView(Context context){
        super(context);

        paint = new Paint();

        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);


        // Mob 초기화

        mob1_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);
        mob2_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pekka);

        mob1_1 = new Mob(1,mob1_Bitmap.getWidth() / 2,mob1_Bitmap.getHeight() / 2,100,100,30,30);
        mob1_2 = new Mob(1,mob1_Bitmap.getWidth() / 2,mob1_Bitmap.getHeight() / 2,500,700,-30,-30);
        mob2_1 = new Mob(2,mob2_Bitmap.getWidth() / 2,mob2_Bitmap.getHeight() / 2,1000,1000,-10,10);



        ////

        mHandler.sendEmptyMessageDelayed(0,100);     // Handler 호출
    }

    // view가 layout에 적용됬을때 호출됨
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        displayLeft = left;
        displayRight = right;
        displayTop = top;
        displayBottom = bottom;

        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, displayRight, displayBottom, true);


        new Thread(mob1_1).start();
        new Thread(mob1_2).start();
        new Thread(mob2_1).start();
    }

    // Timer Handler
    Handler mHandler = new Handler(){
        public void handleMessage(Message msg){

            invalidate();   // View를 다시 그림
            mHandler.sendEmptyMessageDelayed(0,100);
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            mob1_2.setX((int) event.getX());
            mob1_2.setY((int) event.getY());
        }

        return super.onTouchEvent(event);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawBitmap(backgroundBitmap, 0, 0,paint);


        //
        restrictMob(mob1_1);
        restrictMob(mob1_2);
        restrictMob(mob2_1);

        canvas.drawBitmap(mob1_Bitmap, mob1_1.getX()- mob1_1.getRw(), mob1_1.gety() - mob1_1.getRh(),null);
        canvas.drawBitmap(mob1_Bitmap, mob1_2.getX()- mob1_2.getRw(), mob1_2.gety() - mob1_2.getRh(),null);
        canvas.drawBitmap(mob2_Bitmap, mob2_1.getX()- mob2_1.getRw(), mob2_1.gety() - mob2_1.getRh(),null);

        ////
    }

    public void restrictMob(Mob mob){
        if(mob.getX() <  displayLeft + mob.getRw()){
            mob.setX(displayLeft + mob.getRw());
            mob.setDirSx();
        }
        if(mob.getX() > displayRight - mob.getRw()){
            mob.setX(displayRight - mob.getRw());
            mob.setDirSx();
        }
        if(mob.gety() <  displayTop + mob.getRh()){
            mob.setY(displayTop + mob.getRh());
            mob.setDirSy();
        }
        if(mob.gety() > displayBottom - mob.getRh()){
            mob.setY(displayBottom - mob.getRh());
            mob.setDirSy();
        }
    }
}
