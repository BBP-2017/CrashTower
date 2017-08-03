package com.bbp.crashtower.result;

/**
 * Created by roto1 on 2017-07-31.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.bbp.crashtower.R;


public class MultiResult extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//TITLE바 NONONO.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();

//팝업 외부 뿌연 효과

        layoutParams.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND;

//뿌연 효과 정도

        layoutParams.dimAmount= 0.3f;

//적용

        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.activity_multiresult);

    }

}

