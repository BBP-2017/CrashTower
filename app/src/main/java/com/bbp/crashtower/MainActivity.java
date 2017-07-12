package com.bbp.crashtower;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_strory).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent_battle = new Intent(getApplicationContext(),BattleActivity.class);
                        startActivity(intent_battle);
                    }
                }
        );

        findViewById(R.id.btnOption).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOption:
                new AlertDialog.Builder(this)
                        .setTitle("옵션설정")
                        .setMessage("팝업창 내용")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dlg, int sumthin){

                            }
                        })
                        .show();
                break;
        }

    }
}
