package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-18.
 */



public class BattleGroundView extends View{

    int diplayWidth, displayHeight;
    int pxWith, pxHeight;

    Bitmap backgroundBitmap, babaBitmap;

    Paint paint;

    //초기화 영역
    public BattleGroundView(Context context, int width, int height){
        super(context);

        paint = new Paint();

        diplayWidth = width;
        displayHeight = height;

        DisplayMetrics metrics = new DisplayMetrics();


        backgroundBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.battle_ground);
        backgroundBitmap = Bitmap.createScaledBitmap(backgroundBitmap, diplayWidth, displayHeight, true);

        babaBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.baba);
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backgroundBitmap, 0, 0,paint);
        canvas.drawBitmap(babaBitmap,diplayWidth/2,displayHeight/2,paint);
    }
}
