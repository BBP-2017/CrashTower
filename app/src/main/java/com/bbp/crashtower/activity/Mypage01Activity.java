package com.bbp.crashtower.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bbp.crashtower.R;
import com.bbp.crashtower.adapter.MypageAdapter;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;

public class Mypage01Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MypageAdapter adapter;
    private int choice = 1; //어떤 파티를 선택하였는가 정하는것
    private int Level;
    private String ID;
    ArrayList<Character> characters = new ArrayList<Character>();
    ArrayList<Character> select1 = new ArrayList<Character>(6);
    ArrayList<Character> select2 = new ArrayList<Character>(6);
    ArrayList<Character> select3 = new ArrayList<Character>(6);
    ArrayList<Character> select4 = new ArrayList<Character>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Level = intent.getIntExtra("LEVEL",1);
        ID= intent.getStringExtra("ID");
        setContentView(R.layout.activity_mypage01);
        characters.add(new Character(R.drawable.cr_swordman, "검사",1));
        characters.add(new Character(R.drawable.cr_archer, "궁수",1));
        characters.add(new Character(R.drawable.cr_cavalry, "기마병",1));
        characters.add(new Character(R.drawable.ccr_giant, "거인",1));
        characters.add(new Character(R.drawable.baba,"바바",2));
        characters.add(new Character(R.drawable.bone,"스켈",2));


        select1.add(new Character(R.drawable.card_background, "공백"));
        select1.add(new Character(R.drawable.card_background, "공백"));
        select1.add(new Character(R.drawable.card_background, "공백"));
        select1.add(new Character(R.drawable.card_background, "공백"));
        select1.add(new Character(R.drawable.card_background, "공백"));
        select1.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select2.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select3.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        select4.add(new Character(R.drawable.card_background, "공백"));
        adapter = new MypageAdapter(characters, choice, select1);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);


        // recyclerView.setLayoutManager(new ItemLayoutManger(this));
        LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setLayoutParams(layoutParams);

    }

    public void onClick01(View v) {
        choice = 1;
        adapter = new MypageAdapter(characters, choice, select1);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);
        //  startActivity(i);
        ImageView iv1 = (ImageView) findViewById(R.id.mpch01);
        iv1.setImageResource(select1.get(0).image);
        ImageView iv2 = (ImageView) findViewById(R.id.mpch02);
        iv2.setImageResource(select1.get(1).image);
        ImageView iv3 = (ImageView) findViewById(R.id.mpch03);
        iv3.setImageResource(select1.get(2).image);
        ImageView iv4 = (ImageView) findViewById(R.id.mpch04);
        iv4.setImageResource(select1.get(3).image);
        ImageView iv5 = (ImageView) findViewById(R.id.mpch05);
        iv5.setImageResource(select1.get(4).image);
        ImageView iv6 = (ImageView) findViewById(R.id.mpch06);
        iv6.setImageResource(select1.get(5).image);
    }

    public void onClick02(View v) {
        choice=2;
        adapter = new MypageAdapter(characters, choice, select2);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);
        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
        iv1.setImageResource(select2.get(0).image);
        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
        iv2.setImageResource(select2.get(1).image);
        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
        iv3.setImageResource(select2.get(2).image);
        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
        iv4.setImageResource(select2.get(3).image);
        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
        iv5.setImageResource(select2.get(4).image);
        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
        iv6.setImageResource(select2.get(5).image);
    }
    public void onClick03(View v) {
        choice=3;
        adapter = new MypageAdapter(characters, choice, select3);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);
       ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
        iv1.setImageResource(select3.get(0).image);
        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
        iv2.setImageResource(select3.get(1).image);
        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
        iv3.setImageResource(select3.get(2).image);
        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
        iv4.setImageResource(select3.get(3).image);
        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
        iv5.setImageResource(select3.get(4).image);
        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
        iv6.setImageResource(select3.get(5).image);
    }

    public void onClick04(View v) {
        choice=4;
        adapter = new MypageAdapter(characters, choice, select4);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        recyclerView.setAdapter(adapter);
        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
        iv1.setImageResource(select4.get(0).image);
        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
        iv2.setImageResource(select4.get(1).image);
        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
        iv3.setImageResource(select4.get(2).image);
        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
        iv4.setImageResource(select4.get(3).image);
        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
        iv5.setImageResource(select4.get(4).image);
        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
        iv6.setImageResource(select4.get(5).image);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
           super.onActivityResult(requestCode, resultCode, data);
            switch (resultCode) {
                case 1:
                    Intent intent = new Intent();
                    ArrayList<Character> char01 = (ArrayList<Character>) data.getSerializableExtra("Rechar");
                    if(choice==1){
                        select1=char01;
                        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
                        iv1.setImageResource(select1.get(0).image);
                        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
                        iv2.setImageResource(select1.get(1).image);
                        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
                        iv3.setImageResource(select1.get(2).image);
                        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
                        iv4.setImageResource(select1.get(3).image);
                        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
                        iv5.setImageResource(select1.get(4).image);
                        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
                        iv6.setImageResource(select1.get(5).image);
                        adapter = new MypageAdapter(characters, choice, select1);
                        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
                        recyclerView.setAdapter(adapter);
                    }
                    else if(choice==2){
                        select2=char01;
                        adapter = new MypageAdapter(characters, choice, select2);
                        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
                        recyclerView.setAdapter(adapter);
                        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
                        iv1.setImageResource(select2.get(0).image);
                        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
                        iv2.setImageResource(select2.get(1).image);
                        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
                        iv3.setImageResource(select2.get(2).image);
                        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
                        iv4.setImageResource(select2.get(3).image);
                        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
                        iv5.setImageResource(select2.get(4).image);
                        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
                        iv6.setImageResource(select2.get(5).image);
                    }
                    else if(choice==3){
                        select3=char01;
                        adapter = new MypageAdapter(characters, choice, select3);
                        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
                        recyclerView.setAdapter(adapter);
                        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
                        iv1.setImageResource(select3.get(0).image);
                        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
                        iv2.setImageResource(select3.get(1).image);
                        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
                        iv3.setImageResource(select3.get(2).image);
                        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
                        iv4.setImageResource(select3.get(3).image);
                        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
                        iv5.setImageResource(select3.get(4).image);
                        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
                        iv6.setImageResource(select3.get(5).image);
                    }
                    else{
                        select4=char01;
                        adapter = new MypageAdapter(characters, choice, select4);
                        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
                        recyclerView.setAdapter(adapter);
                        ImageView iv1 = (ImageView)findViewById(R.id.mpch01);
                        iv1.setImageResource(select4.get(0).image);
                        ImageView iv2 = (ImageView)findViewById(R.id.mpch02);
                        iv2.setImageResource(select4.get(1).image);
                        ImageView iv3 = (ImageView)findViewById(R.id.mpch03);
                        iv3.setImageResource(select4.get(2).image);
                        ImageView iv4 = (ImageView)findViewById(R.id.mpch04);
                        iv4.setImageResource(select4.get(3).image);
                        ImageView iv5 = (ImageView)findViewById(R.id.mpch05);
                        iv5.setImageResource(select4.get(4).image);
                        ImageView iv6 = (ImageView)findViewById(R.id.mpch06);
                        iv6.setImageResource(select4.get(5).image);
                    }
                    //B의 신호를 받아 실행할 작업
                    break;
                default:
                    break;
            }
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



