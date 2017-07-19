package com.bbp.crashtower;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bbp.crashtower.adapter.ItemTouchHelperCallback;
import com.bbp.crashtower.adapter.MypageAdapter;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;

public class Mypage01Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MypageAdapter adapter;
    ArrayList<Character> select1=new ArrayList<Character>(6);
    ArrayList<Character> select2=new ArrayList<Character>(6);
    ArrayList<Character> select3=new ArrayList<Character>(6);
    ArrayList<Character> select4=new ArrayList<Character>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage01);
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character(R.drawable.cr_swordman, "검사"));
        characters.add(new Character(R.drawable.cr_archer, "궁수"));
        characters.add(new Character(R.drawable.cr_cavalry, "기마병"));
        characters.add(new Character(R.drawable.ccr_giant, "거인"));

        adapter = new MypageAdapter(characters);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);


        // recyclerView.setLayoutManager(new ItemLayoutManger(this));
        LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.ccr_giant);
        iv.setLayoutParams(layoutParams);
        layout.addView(iv);
    }
    public void onClick01(View v) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.ccr_giant);
        iv.setLayoutParams(layoutParams);
        layout.addView(iv);
    }

    public void onClick02(View v) {
       LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.cr_archer);
        iv.setLayoutParams(layoutParams);
        layout.addView(iv);
    }
    public void onClick03(View v) {
      LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.cr_cavalry);
        iv.setLayoutParams(layoutParams);
        layout.addView(iv);
    }

    public void onClick04(View v) {
       LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.cr_swordman);
        iv.setLayoutParams(layoutParams);
        layout.addView(iv);
    }
}




    /*
    //Selected image id
int position = i.getExtras().getInt("id");
MyAdapter myAdapter = new MyAdapter(this);

//Set image id
ImageView imageView = (ImageView) findViewById(R.id.mp3Image);
imageView.setImageResource(myAdapter.items.get(position).drawableId);
*/



