package com.bbp.crashtower;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class BattleActivity extends BaseActivity {

    FrameLayout frameGround;

    ImageButton iBtn_card_1;

    int displayWidth, displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상태 표시줄(Statusbar 안테나, 베터리 상태 등이 표시되는 부분)을 없앤다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_battle);

        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();

        frameGround =(FrameLayout)findViewById(R.id.frame_grooud);
        frameGround.addView(new appView.BattleGroundView(this));


    }

}
