package View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-18.
 */



public class BattleView extends View{

    int width, height;
    Resources res;

    //초기화 영역
    public BattleView(Context context){
        super(context);
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();


        res = context.getResources();



    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        canvas.drawText("해상도 = " + width + " x " + height, 100, 200, paint);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baba);

        canvas.drawBitmap(bitmap, width/2, height/2, paint);
    }
}
