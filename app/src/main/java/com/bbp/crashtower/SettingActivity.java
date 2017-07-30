package com.bbp.crashtower;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

/**
 * Created by HanGyuLee on 2017-07-30.
 */

public class SettingActivity extends BaseActivity{
    EditText idInput, passwordInput;
    String sId, sPw;
    CheckBox autoLogin;
    ToggleButton stb;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags=WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount=0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_setting);

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
