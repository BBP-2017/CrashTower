package com.bbp.crashtower.result;

/**
 * Created by roto1 on 2017-07-31.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.activity.MypageActivity;


public class SingleResult extends Activity  {
    private String UserID;
    private int UserLevel,getExp,getGold,presentExp,presentGold,totalGold;
    private Boolean isitWin;

    MypageActivity AActivity = (MypageActivity)MypageActivity.AActivity; //강제종료1

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

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        int width = (int) (display.getWidth() * 0.95); //Display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.95);  //Display 사이즈의 90%


       // layoutParams.height=layoutParams.MATCH_PARENT;
       // layoutParams.width=layoutParams.MATCH_PARENT;

//적용

        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_singelresult);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;
        Handler handler = new Handler();
        ProgressBar ExBar01 =(ProgressBar)findViewById(R.id.Exbar01);

        for(int i=0;i<getExp;i++) {
            ExBar01.incrementProgressBy(1);

        }

        if(isitWin){
            ImageView i=(ImageView)findViewById(R.id.resultCrown1);
            i.setImageResource(R.drawable.crown);

            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i1=(ImageView)findViewById(R.id.resultCrown2);
                    i1.setImageResource(R.drawable.crown);
                }
            }, 300);  // 2000은 2초를 의미합니다.
            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i2=(ImageView)findViewById(R.id.resultCrown3);
                    i2.setImageResource(R.drawable.crown);
                }
            }, 600);


        }
        else{
            ImageView i=(ImageView)findViewById(R.id.resultCrown1);
            i.setImageResource(R.drawable.crown1);
            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i1=(ImageView)findViewById(R.id.resultCrown2);
                    i1.setImageResource(R.drawable.crown1);
                }
            }, 300);  // 2000은 2초를 의미합니다.
            handler.postDelayed(new Runnable() {
                public void run() {
                    ImageView i2=(ImageView)findViewById(R.id.resultCrown3);
                    i2.setImageResource(R.drawable.crown1);
                }
            }, 600);
        }
        TextView tvResult=(TextView)findViewById(R.id.tvResult01);
        tvResult.setText(UserID+"\nLevel :"+UserLevel+"\nEXP : "+presentExp+" + "+getExp+"\nGOLD : "+presentGold+" + "+getGold);
        totalGold=presentGold+getGold;

    }
    public void ResultExBT01(View v){
        finish();
        AActivity.finish(); //강제종료2

    }
}