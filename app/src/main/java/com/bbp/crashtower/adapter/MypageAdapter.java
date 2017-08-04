package com.bbp.crashtower.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Card;
import com.bbp.crashtower.activity.MypagePopup;

import java.util.ArrayList;


/**
 * Created by roto1 on 2017-07-12.
 */

public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.ViewHolder>  {
    ArrayList<Card> cards,select;

    int choice;
    public MypageAdapter(ArrayList<Card> cards, int choice, ArrayList<Card> select) {
        this.cards = cards;
        this.choice=choice;
        this.select=select;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //필수 메소드 1 :새로운 뷰 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_character_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {  //필수 메소드 2: ListView에서 getView 부분을 담당하는 메소드

        holder.tvName.setText(cards.get(position).name);
        holder.ivImage.setImageResource(cards.get(position).image);

        holder.ivImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)  {
                Card char01= cards.get(position);
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), MypagePopup.class);
                intent.putExtra("CHAR",char01 );
                intent.putExtra("Choicech",select);
                ((Activity)context).startActivityForResult(intent,0);
            }
        });
    }
    /*
    public void onActivityResult(int requestCode, int resultCode, Intent com.bbp.crashtower.data) {
     //   super.onActivityResult(0, resultCode, com.bbp.crashtower.data);
        if(requestCode==0) {
            switch (resultCode) {
                case 1:

                    Intent intent = new Intent();
                    ArrayList<Card> char01 = (ArrayList<Card>) com.bbp.crashtower.data.getSerializableExtra("Rechar");
                    intent.putExtra("Rechar", char01);
                     setResult(1, intent);
                    finish();
                    //B의 신호를 받아 실행할 작업
                    break;
                default:
                    break;
            }
        }
    }
    */

    @Override                                           //필수 메소드3
    public int getItemCount() {
        return cards.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivImage = itemView.findViewById(R.id.iv_main);
        }
    }
 }
