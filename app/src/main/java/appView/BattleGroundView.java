package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
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

    RectF displayRect;

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

        displayRect = new RectF(left,top,right,bottom);

        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);

        mob1_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);
        mob2_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.pekka);
        mob3_Bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.bone);

        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, (int)displayRect.width(), (int)displayRect.height(), true);
        mob1_Bitmap = Bitmap.createScaledBitmap(mob1_Bitmap, mob1_Bitmap.getWidth()/2 , mob1_Bitmap.getHeight()/2, true);
        mob3_Bitmap = Bitmap.createScaledBitmap(mob3_Bitmap, mob3_Bitmap.getWidth()/3, mob3_Bitmap.getHeight()/3, true);

        mob1_1 = new Mob(1,new RectF(500,500,mob1_Bitmap.getWidth(),mob1_Bitmap.getHeight()),null);
        mob2_1 = new Mob(2,new RectF(500,1000,mob2_Bitmap.getWidth(),mob2_Bitmap.getHeight()),null);
        mob3_1 = new Mob(3,new RectF(1000,500,mob3_Bitmap.getWidth(),mob3_Bitmap.getHeight()),null);

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
            int restrict = (int)mob3_1.width()*2;

            if((x > displayRect.left+restrict && x < displayRect.right-restrict) && (y > displayRect.top+restrict && y < displayRect.bottom-restrict) )
                mob3_1.setTarget(new RectF(x,y,1,1));
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

        canvas.drawBitmap(mob1_Bitmap, mob1_1.left- mob1_1.width(), mob1_1.top - mob1_1.height(),null);
        canvas.drawBitmap(mob2_Bitmap, mob2_1.left- mob2_1.width(), mob2_1.top - mob2_1.height(),null);
        canvas.drawBitmap(mob3_Bitmap, mob3_1.left- mob3_1.width(), mob3_1.top - mob3_1.height(),null);

    }

    // mob들 제한 구역 설정
    public void restrictMob(Mob mob){
        if(mob.left <  displayRect.left + mob.width()){
            mob.left= displayRect.left + mob.width();
            mob.changeDirDx();
        }
        if(mob.left > displayRect.right - mob.width()){
            mob.left=displayRect.right - mob.width();
            mob.changeDirDx();
        }
        if(mob.top <  displayRect.top + mob.height()){
            mob.right = displayRect.top + mob.height();
            mob.changeDirDy();
        }
        if(mob.top > displayRect.bottom - mob.height()){
            mob.right = displayRect.bottom - mob.height();
            mob.changeDirDy();
        }
    }
}
