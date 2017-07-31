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
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;


public class MypagePopup extends Activity {
    Character char01;
    ArrayList<Character> select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        char01 = (Character) intent.getSerializableExtra("CHAR");
        select=(ArrayList<Character>) intent.getSerializableExtra("Choicech");
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
        setContentView(R.layout.character_explain);
        TextView tvname=(TextView) findViewById(R.id.chex01);
        tvname.setText(char01.name);

    }
    public void ChExEquipbt(View v){
        Intent intent = new Intent(getApplicationContext(), MypageEquip.class);
        intent.putExtra("EQUIP",char01 );
        intent.putExtra("Equipch",select);
        startActivityForResult(intent,0);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                Intent intent = new Intent();
                ArrayList<Character> Reselect=(ArrayList<Character>) data.getSerializableExtra("Rechar");
                intent.putExtra("Rechar", Reselect);
                setResult(1, intent);
                finish();
//B의 신호를 받아 실행할 작업
                break;
            default:
                break;
        }
    }
}
