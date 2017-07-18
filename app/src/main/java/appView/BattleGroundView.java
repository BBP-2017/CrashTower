package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-18.
 */



public class BattleGroundView extends View{

    int displayLeft, displayTop, displayRight, displayBottom;
    int pxWidth, pxHeight;

    Bitmap backgroundBitmap, babaBitmap;

    Paint paint;

    //초기화 영역
    public BattleGroundView(Context context){
        super(context);

        paint = new Paint();

        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);
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

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundBitmap, 0, 0,paint);
    }
}
