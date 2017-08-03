package com.bbp.crashtower.activity;

/**
 * Created by roto1 on 2017-07-28.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;


public class MypageEquip extends Activity {
    Character char02;
    ArrayList<Character> select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        char02 = (Character) intent.getSerializableExtra("EQUIP");
        select=(ArrayList<Character>) intent.getSerializableExtra("Equipch");
        super.onCreate(savedInstanceState);
//TITLE바 NONONO.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
//팝업 외부 뿌연 효과
        layoutParams.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//뿌연 효과 정도
        layoutParams.dimAmount= 0.7f;
//적용
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.character_equipbt);
        ImageButton ib1= (ImageButton) findViewById(R.id.ChSelect01);
        ib1.setImageResource(select.get(0).image);
        ImageButton ib2= (ImageButton) findViewById(R.id.ChSelect02);
        ib2.setImageResource(select.get(1).image);
        ImageButton ib3= (ImageButton) findViewById(R.id.ChSelect03);
        ib3.setImageResource(select.get(2).image);
        ImageButton ib4= (ImageButton) findViewById(R.id.ChSelect04);
        ib4.setImageResource(select.get(3).image);
        ImageButton ib5= (ImageButton) findViewById(R.id.ChSelect05);
        ib5.setImageResource(select.get(4).image);
        ImageButton ib6= (ImageButton) findViewById(R.id.ChSelect06);
        ib6.setImageResource(select.get(5).image);
    }

    public void Chsel01(View v){
        select.set(0,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
    public void Chsel02(View v){
        select.set(1,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
    public void Chsel03(View v){
        select.set(2,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
    public void Chsel04(View v){
        select.set(3,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
    public void Chsel05(View v){
        select.set(4,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
    public void Chsel06(View v){
        select.set(5,char02);
        Intent intent = new Intent();
        intent.putExtra("Rechar", select);
        setResult(1, intent);
        finish();
    }
}