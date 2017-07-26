package com.bbp.crashtower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.bbp.crashtower.view.MultiView;

public class MultiActivity extends AppCompatActivity {

    FrameLayout frameMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상태 표시줄(Statusbar 안테나, 베터리 상태 등이 표시되는 부분)을 없앤다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_multi);

        frameMulti = (FrameLayout) findViewById(R.id.frame_multi);
        frameMulti.addView(new MultiView(this));
    }
}
