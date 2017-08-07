package com.bbp.crashtower.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import android.widget.LinearLayout;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Card;
import com.bbp.crashtower.view.BattleGroundView;

import com.bbp.crashtower.data.CardInfo;

import java.util.ArrayList;

public class BattleActivity extends BaseActivity implements View.OnClickListener{

    public static final String PREFS_NAME = "MyPrefsFile";

    int displayWidth, displayHeight;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    FrameLayout frameGround;
    LinearLayout linearDeck;

    ImageButton iBtnCard1,iBtnCard2,iBtnCard3,iBtnCard4,iBtnCard5;

    ArrayList<Card> deckInfo;

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
        frameGround.addView(new BattleGroundView(this,pref));

        iBtnCard1 = (ImageButton)findViewById(R.id.btn_battle_card_1);
        iBtnCard2 = (ImageButton)findViewById(R.id.btn_battle_card_2);
        iBtnCard3 = (ImageButton)findViewById(R.id.btn_battle_card_3);
        iBtnCard4 = (ImageButton)findViewById(R.id.btn_battle_card_4);
        iBtnCard5 = (ImageButton)findViewById(R.id.btn_battle_card_5);

        if(CardInfo.curDecks!=null) {
            deckInfo = CardInfo.curDecks[CardInfo.BattleDeckNum];
        }

        if(deckInfo!=null) {

            iBtnCard1.setBackgroundResource(deckInfo.get(0).image);
            iBtnCard2.setBackgroundResource(deckInfo.get(1).image);
            iBtnCard3.setBackgroundResource(deckInfo.get(2).image);
            iBtnCard4.setBackgroundResource(deckInfo.get(3).image);
            iBtnCard5.setBackgroundResource(deckInfo.get(4).image);
        }else{
            iBtnCard1.setBackgroundResource(new CardInfo(getApplicationContext(), 1, 1).resID);
            iBtnCard2.setBackgroundResource(new CardInfo(getApplicationContext(), 2, 1).resID);
            iBtnCard3.setBackgroundResource(new CardInfo(getApplicationContext(), 3, 1).resID);
            iBtnCard4.setBackgroundResource(new CardInfo(getApplicationContext(), 4, 1).resID);
            iBtnCard5.setBackgroundResource(new CardInfo(getApplicationContext(), 5, 1).resID);
        }

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
                if(deckInfo!=null) {
                    editor.putInt("cardID", deckInfo.get(0).cardID);
                }else {
                    editor.putInt("cardID", 1);
                }
                break;
            case R.id.btn_battle_card_2:
                if(deckInfo!=null) {
                    editor.putInt("cardID", deckInfo.get(1).cardID);
                }else {
                    editor.putInt("cardID", 2);
                }
                break;
            case R.id.btn_battle_card_3:
                if(deckInfo!=null) {
                    editor.putInt("cardID", deckInfo.get(2).cardID);
                }else {
                    editor.putInt("cardID", 3);
                }
                break;
            case R.id.btn_battle_card_4:
                if(deckInfo!=null) {
                    editor.putInt("cardID", deckInfo.get(3).cardID);
                }else {
                    editor.putInt("cardID", 4);
                }
                break;
            case R.id.btn_battle_card_5:
                if(deckInfo!=null) {
                    editor.putInt("cardID", deckInfo.get(4).cardID);
                }else {
                    editor.putInt("cardID", 5);
                }
                break;
        }
        editor.commit();
    }
}

