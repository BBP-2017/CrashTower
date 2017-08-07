package com.bbp.crashtower.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.bbp.crashtower.R;

public class LoadingActivity extends AppCompatActivity {
    Handler handler = new Handler();    //스레드 이용 프로그레스바 움직이기위한것
  //  public static Activity AActivity;
    private ProgressBar prog;
    private int i=0;
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // AActivity = LoadingActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        layout = (ConstraintLayout) findViewById(R.id.Loadinglayout);
        layout.setBackgroundResource(R.drawable.loading);

        final ProgressBar prog = (ProgressBar) findViewById(R.id.Loadiongbar);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() { // Thread 로 작업할 내용을 구현
               for( i=0;i<=100;i++) {
                   if(i>80){
                       i+=2;
                   }
                   else if(i>30){
                       i+=5;
                   }
                   else if(i>90) ;
                   prog.setProgress(i);
                   if(i==99){
                       Intent i=new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(i);
                       finish();
                   }
                    try {
                        Thread.sleep(100); // 시간지연
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t.start(); // 쓰레드 시작

    }
}
