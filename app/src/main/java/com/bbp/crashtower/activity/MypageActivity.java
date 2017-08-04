package com.bbp.crashtower.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bbp.crashtower.R;
import com.bbp.crashtower.adapter.MypageAdapter;
import com.bbp.crashtower.model.Card;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity implements View.OnClickListener {


    static final int MAX_DECK = 4;
    static final int MAX_DECK_CARD = 6;

    private int choice = 1; //어떤 파티를 선택하였는가 정하는것


    private int Level;
    private String ID;

    int ivID[] = new int[MAX_DECK_CARD];
    int btnDeckID[] = new int[MAX_DECK];

    private RecyclerView recyclerView;
    private MypageAdapter adapter;

    Button btnDeck[] = new Button[MAX_DECK];

    ArrayList<Card> cards = new ArrayList<Card>(MAX_DECK_CARD);
    ArrayList<Card>[] deck = new ArrayList[MAX_DECK];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Level = intent.getIntExtra("LEVEL",1);
        ID = intent.getStringExtra("ID");

        setContentView(R.layout.activity_mypage);

        cards.add(new Card(getApplicationContext(),1,1));
        cards.add(new Card(getApplicationContext(),2,1));
        cards.add(new Card(getApplicationContext(),3,1));
        cards.add(new Card(getApplicationContext(),4,1));
        cards.add(new Card(getApplicationContext(),5,1));
        cards.add(new Card(getApplicationContext(),6,1));


        ivID[0] = R.id.mpch01;
        ivID[1] = R.id.mpch02;
        ivID[2] = R.id.mpch03;
        ivID[3] = R.id.mpch04;
        ivID[4] = R.id.mpch05;
        ivID[5] = R.id.mpch06;

        btnDeckID[0] = R.id.btn_mypage_deck1;
        btnDeckID[1] = R.id.btn_mypage_deck2;
        btnDeckID[2] = R.id.btn_mypage_deck3;
        btnDeckID[3] = R.id.btn_mypage_deck4;


        for (int i = 0; i < MAX_DECK ; i++) {
            deck[i] = new ArrayList<Card>(MAX_DECK_CARD);
            for (int j = 0; j < MAX_DECK_CARD ; j++) {
                deck[i].add(new Card(getApplicationContext(),0,0));
            }
        }


        for (int i = 0; i < MAX_DECK; i++) {
            btnDeck[i] = (Button)findViewById(btnDeckID[i]);
            btnDeck[i].setOnClickListener(this);
        }

        adapter = new MypageAdapter(cards, choice, deck[0]);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), MAX_DECK));
        recyclerView.setAdapter(adapter);


        // recyclerView.setLayoutManager(new ItemLayoutManger(this));
        LinearLayout layout = (LinearLayout) findViewById(R.id.charlayout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2);
        ImageView iv = new ImageView(this);
        iv.setLayoutParams(layoutParams);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
           super.onActivityResult(requestCode, resultCode, data);
            switch (resultCode){
                case 1:
                    deck[choice] = (ArrayList<Card>)data.getSerializableExtra("Rechar");

                    ImageView[] iv = new ImageView[MAX_DECK_CARD];
                    for (int i = 0; i < MAX_DECK_CARD ; i++) {
                        iv[i] = (ImageView) findViewById(ivID[i]);
                        iv[i].setImageResource(deck[choice].get(i).image);
                    }
                    adapter = new MypageAdapter(cards, choice, deck[choice]);
                    recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), MAX_DECK));
                    recyclerView.setAdapter(adapter);

                    //B의 신호를 받아 실행할 작업
                    break;
                default:
                    break;
            }
        }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_mypage_deck1:
                choice = 0;
                break;
            case R.id.btn_mypage_deck2:
                choice = 1;
                break;
            case R.id.btn_mypage_deck3:
                choice = 2;
                break;
            case R.id.btn_mypage_deck4:
                choice = 3;
                break;
            default:
                return;

        }

            adapter = new MypageAdapter(cards, choice, deck[choice]);
            recyclerView = (RecyclerView) findViewById(R.id.recycleview);
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), MAX_DECK));
            recyclerView.setAdapter(adapter);

            ImageView[] iv = new ImageView[MAX_DECK_CARD];
            for (int i = 0; i < MAX_DECK_CARD ; i++) {
                iv[i] = (ImageView) findViewById(ivID[i]);
                iv[i].setImageResource(deck[choice].get(i).image);
            }
            Log.d("abc","################################################choiced");

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



