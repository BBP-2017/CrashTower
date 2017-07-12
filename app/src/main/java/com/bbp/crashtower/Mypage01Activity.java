package com.bbp.crashtower;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bbp.crashtower.adapter.MypageAdapter;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;

public class Mypage01Activity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage01);
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("검사"));
        characters.add(new Character("궁수"));
        characters.add(new Character("기마병"));
        characters.add(new Character("거인"));

        recyclerView=  (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.setAdapter(new MypageAdapter(characters));
    }
}
