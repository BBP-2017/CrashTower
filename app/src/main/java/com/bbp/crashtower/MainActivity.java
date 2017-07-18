package com.bbp.crashtower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_strory).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent_battle = new Intent(getApplicationContext(),BattleActivity.class);
                        startActivity(intent_battle);
                    }
                }
        );
    }
}
