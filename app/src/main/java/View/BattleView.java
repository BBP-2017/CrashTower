package View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by dongbin on 2017-07-18.
 */



public class BattleView extends View{

    Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    int width = display.getWidth();
    int height = display.getHeight();

    //초기화 영역
    public BattleView(Context context){
        super(context);


    }

    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
