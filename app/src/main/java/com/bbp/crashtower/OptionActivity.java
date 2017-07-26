package com.bbp.crashtower;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

/**
 * Created by HanGyuLee on 2017-07-12.
 */

public class OptionActivity extends AppCompatActivity {

    EditText idInput, passwordInput;
    String sId, sPw;
    CheckBox autoLogin;
    ToggleButton stb;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_option);
        idInput = (EditText)findViewById(R.id.emailInput);
        passwordInput = (EditText)findViewById(R.id.pwInput);
        autoLogin = (CheckBox)findViewById(R.id.checkBox);
        stb = (ToggleButton)this.findViewById(R.id.soundBtn);
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
                sId = idInput.getText().toString();
                sPw = passwordInput.getText().toString();
                break;
            case R.id.signupBtn:
                break;
        }
    }
}
