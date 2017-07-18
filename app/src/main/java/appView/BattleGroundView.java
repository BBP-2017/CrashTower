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

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleGroundView extends View{

    int displayLeft, displayTop, displayRight, displayBottom;

    int x, y;       // 캐릭터의 현재 좌표
    int sx, sy;     // 캐릭터가 이동할 방향과 거리
    int rw, rh;     // 캐릭터의 중심점

    Paint paint;

    Bitmap backgroundBitmap, babaBitmap;



    //초기화 영역
    public BattleGroundView(Context context){
        super(context);

        paint = new Paint();

        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);
        babaBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);

        rw = babaBitmap.getWidth() / 2;     // 캐릭터의 중심점
        rh = babaBitmap.getHeight() / 2;

        x = 100;    // 캐릭터 초기 좌표
        y = 100;
        sx = 30;     // 캐릭터 1회에 이동할 거리
        sy = 30;

        mHandler.sendEmptyMessageDelayed(0,10);     // Handler 호출
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
            x = (int) event.getX();
            y = (int) event.getY();
        }
        
        return super.onTouchEvent(event);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawBitmap(backgroundBitmap, 0, 0,paint);

        moveMob();

        canvas.drawBitmap(babaBitmap, x - rw, y - rh,null);
    }

    public void moveMob(){
        x += sx;    //수평으로 이동
        y += sy;    //수직으로 이동
        if(x <  displayLeft + rw){
            x = displayLeft + rw;
            sx = -sx;
        }
        if(x > displayRight - rw){
            x = displayRight - rw;
            sx = -sx;
        }
        if(y <  displayTop + rh){
            y = displayTop + rh;
            sy = -sy;
        }
        if(y > displayBottom - rh){
            y = displayBottom - rh;
            sy = -sy;
        }
    }

}
