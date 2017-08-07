package com.bbp.crashtower.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.bbp.crashtower.R;

/**
 * Created by HanGyuLee on 2017-07-12.
 */

public class OptionActivity extends AppCompatActivity {

    EditText idInput, passwordInput;
    CheckBox autoLogin;
    Boolean loginChecked;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ToggleButton stb;

    protected void onCreate(Bundle savedInstanceState){
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

        idInput = (EditText)findViewById(R.id.emailInput);
        passwordInput = (EditText)findViewById(R.id.pwInput);
        autoLogin = (CheckBox)findViewById(R.id.checkBox);
        stb = (ToggleButton)findViewById(R.id.soundBtn);

        setContentView(R.layout.activity_option);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnClose:
                this.finish();
                break;
            case R.id.soundBtn:
                if(stb.isChecked()){
                    stb.setTextColor(Color.GREEN);
                }else{
                    stb.setTextColor(Color.RED);
                }
                break;
            case R.id.loginBtn:
                break;
            case R.id.signupBtn:
                break;
        }
    }
}
