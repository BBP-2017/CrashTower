package appView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-18.
 */

public class BattleDeckView extends View{
    LinearLayout linearDeck;
    ImageButton btn_card1,btn_card2,btn_card3,btn_card4,btn_card5;

//            <android.support.v7.widget.LinearLayoutCompat
//    android:layout_width="fill_parent"
//    android:layout_height="0dp"
//    android:id="@+id/linear_deck"
//    android:layout_weight="1"
//    android:weightSum="5"
//            >
//            <android.support.v7.widget.AppCompatImageButton
//    android:layout_width="0dp"
//    android:layout_height="match_parent"
//    android:layout_weight="1"
//    android:background="@drawable/card_background"
//    android:id="@+id/btn_battle_card_1"
//            />

    //초기화 영역
    public BattleDeckView(Context context){
        super(context);



    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }



    // 그림그리는 영역
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putInt(getString(R.string.saved_high_score), newHighScore);
//        editor.commit();
    }
}
