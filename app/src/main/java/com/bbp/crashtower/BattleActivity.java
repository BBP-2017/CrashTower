package com.bbp.crashtower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import View.BattleView;

public class BattleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new BattleView(this));
    }
}
