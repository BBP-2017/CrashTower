package com.bbp.crashtower;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //프로그램 제목 표시줄 없앤다.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //상태 표시줄(Statusbar 안테나, 베터리 상태 등이 표시되는 부분)을 없앤다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_strory).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), BattleActivity.class));
                    }
                }
        );
    }
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_option:
                startActivity(new Intent(this, OptionActivity.class));
                break;
            case  R.id.btn_mypage:
                startActivity(new Intent(getApplicationContext(), Mypage01Activity.class));
                break;
            default:
                break;
        }
    }

}
