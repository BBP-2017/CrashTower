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

    Bitmap backgroundBitmap, mob1_Bitmap, mob2_Bitmap, mob3_Bitmap;

    Mob mob1_1, mob2_1, mob3_1;

    //초기화 영역
    public BattleGroundView(Context context){
        super(context);

        paint = new Paint();

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

        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);

        mob1_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);
        mob2_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pekka);
        mob3_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.bone);

        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, displayRight, displayBottom, true);
        mob1_Bitmap = Bitmap.createScaledBitmap(mob1_Bitmap, mob1_Bitmap.getWidth()/2 , mob1_Bitmap.getHeight()/2, true);
        mob3_Bitmap = Bitmap.createScaledBitmap(mob3_Bitmap, mob3_Bitmap.getWidth()/3, mob3_Bitmap.getHeight()/3, true);

        mob1_1 = new Mob(1,mob1_Bitmap.getWidth() / 2,mob1_Bitmap.getHeight() / 2,1500,1000,30,30);
        mob2_1 = new Mob(2,mob2_Bitmap.getWidth() / 2,mob2_Bitmap.getHeight() / 2,500,1000,-10,-10);
        mob3_1 = new Mob(3,mob3_Bitmap.getWidth() / 2,mob3_Bitmap.getHeight() / 2,1000,500,-200,200);

        ////

        new Thread(mob1_1).start();
        new Thread(mob2_1).start();
        new Thread(mob3_1).start();

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
            int x = (int)event.getX();
            int y = (int)event.getY();

            // 터치범위 제한
            int restrict = mob3_1.getRw()*2;

            if((x > displayLeft+restrict && x < displayRight-restrict) && (y > displayTop+restrict && y < displayBottom-restrict) )
                mob3_1.setTarget(x,y);
        }

        return super.onTouchEvent(event);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundBitmap, 0, 0,paint);

        restrictMob(mob1_1);
        restrictMob(mob2_1);
        restrictMob(mob3_1);

        canvas.drawBitmap(mob1_Bitmap, mob1_1.getX()- mob1_1.getRw(), mob1_1.gety() - mob1_1.getRh(),null);
        canvas.drawBitmap(mob2_Bitmap, mob2_1.getX()- mob2_1.getRw(), mob2_1.gety() - mob2_1.getRh(),null);
        canvas.drawBitmap(mob3_Bitmap, mob3_1.getX()- mob3_1.getRw(), mob3_1.gety() - mob3_1.getRh(),null);

    }

    // mob들 제한 구역 설정
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
