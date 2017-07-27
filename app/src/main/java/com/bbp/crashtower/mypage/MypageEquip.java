package com.bbp.crashtower.mypage;

/**
 * Created by roto1 on 2017-07-28.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;


public class MypageEquip extends Activity {
    Character char02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        char02 = (Character) intent.getSerializableExtra("EQUIP");
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


    }
    public void cheq01(View v){

    }
}