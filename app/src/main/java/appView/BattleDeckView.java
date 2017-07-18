package appView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleDeckView extends View {

    int diplayWidth, displayHeight;

    //초기화 영역
    public BattleDeckView(Context context, int width, int height){
        super(context);

        diplayWidth = width;
        displayHeight = height;
    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
