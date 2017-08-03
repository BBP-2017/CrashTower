package com.bbp.crashtower.result;

/**
 * Created by roto1 on 2017-07-31.
 */

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bbp.crashtower.R;


public class SingleResult extends Activity {
    private String UserID;
    private int UserLevel,getExp,getGold,presentExp,presentGold,totalGold;
    private Boolean isitWin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserID="roto";
        UserLevel=1;
        getGold=500;
        presentGold=1000;
        presentExp=0;
        getExp=40;
        isitWin=true;
//TITLE바 NONONO.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
//팝업 외부 뿌연 효과
        layoutParams.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
//뿌연 효과 정도
        layoutParams.dimAmount= 0.3f;
        layoutParams.height=layoutParams.MATCH_PARENT;
        layoutParams.width=layoutParams.MATCH_PARENT;
//적용
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_singelresult);
        ProgressBar ExBar01 =(ProgressBar)findViewById(R.id.Exbar01);
        ExBar01.incrementProgressBy(getExp);
        if(isitWin){
            ImageView i=(ImageView)findViewById(R.id.resultCrown1);
            i.setImageResource(R.drawable.crown);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i1=(ImageView)findViewById(R.id.resultCrown2);
                    i1.setImageResource(R.drawable.crown);
                }
            }, 1000);  // 2000은 2초를 의미합니다.
            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i2=(ImageView)findViewById(R.id.resultCrown3);
                    i2.setImageResource(R.drawable.crown);
                }
            }, 1000);  // 2000은 2초를 의미합니다.


        }
        else{
            ImageView i=(ImageView)findViewById(R.id.resultCrown1);
            i.setImageResource(R.drawable.crown1);
            ImageView i1=(ImageView)findViewById(R.id.resultCrown2);
            i1.setImageResource(R.drawable.crown1);
            ImageView i2=(ImageView)findViewById(R.id.resultCrown3);
            i2.setImageResource(R.drawable.crown1);
        }
        TextView tvResult=(TextView)findViewById(R.id.tvResult01);
        tvResult.setText(UserID+"\nLevel :"+UserLevel+"\nEXP : "+presentExp+" + "+getExp+"\nGOLD : "+presentGold+" + "+getGold);
        totalGold=presentGold+getGold;



    }
}