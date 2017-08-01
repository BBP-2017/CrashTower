package com.bbp.crashtower;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BattleActivity extends BaseActivity implements View.OnClickListener{

    public static final String PREFS_NAME = "MyPrefsFile";

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    FrameLayout frameGround;
    LinearLayout linearDeck;

    ImageButton iBtnCard1,iBtnCard2,iBtnCard3,iBtnCard4,iBtnCard5;

    int displayWidth, displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상태 표시줄(Statusbar 안테나, 베터리 상태 등이 표시되는 부분)을 없앤다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_battle);

        pref = getSharedPreferences(PREFS_NAME, 0);
        editor = pref.edit();

        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();

        frameGround = (FrameLayout) findViewById(R.id.frame_grooud);
        frameGround.addView(new appView.BattleGroundView(this,pref));

        iBtnCard1 = (ImageButton)findViewById(R.id.btn_battle_card_1);
        iBtnCard2 = (ImageButton)findViewById(R.id.btn_battle_card_2);
        iBtnCard3 = (ImageButton)findViewById(R.id.btn_battle_card_3);
        iBtnCard4 = (ImageButton)findViewById(R.id.btn_battle_card_4);
        iBtnCard5 = (ImageButton)findViewById(R.id.btn_battle_card_5);

        iBtnCard1.setOnClickListener(this);
        iBtnCard2.setOnClickListener(this);
        iBtnCard3.setOnClickListener(this);
        iBtnCard4.setOnClickListener(this);
        iBtnCard5.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_battle_card_1:
                editor.putInt("cardID",1);
                break;
            case R.id.btn_battle_card_2:
                editor.putInt("cardID",2);
                break;
            case R.id.btn_battle_card_3:
                editor.putInt("cardID",3);
                break;
            case R.id.btn_battle_card_4:
                editor.putInt("cardID",4);
                break;
            case R.id.btn_battle_card_5:
                editor.putInt("cardID",5);
                break;
        }
        editor.commit();
    }
}

