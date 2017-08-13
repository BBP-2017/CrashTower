package com.bbp.crashtower.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.SeekBar;
import android.media.AudioManager;
import android.os.Bundle;
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

public class OptionActivity extends Activity {

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
        //stb = (ToggleButton)findViewById(R.id.soundBtn);

        SeekBar seekVolumn = (SeekBar) findViewById(R.id.optionseekbar);
        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolumn = audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);

        seekVolumn.setMax(nMax);
        seekVolumn.setProgress(nCurrentVolumn);

        seekVolumn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }
        });
        setContentView(R.layout.activity_option);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnClose:
                this.finish();
                break;
           /* case R.id.soundBtn:
                if(stb.isChecked()){
                    stb.setTextColor(Color.GREEN);
                }else{
                    stb.setTextColor(Color.RED);
                }
                break;*/
            case R.id.loginBtn:
                break;
            case R.id.signupBtn:
                break;
        }
    }
}
