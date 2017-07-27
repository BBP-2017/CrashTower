package com.bbp.crashtower.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;
import com.bbp.crashtower.mypage.MypagePopup;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by roto1 on 2017-07-12.
 */

public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.ViewHolder> implements ItemTouchHelperListener {
    ArrayList<Character> characters;


    public MypageAdapter(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //필수 메소드 1 :새로운 뷰 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_character_item, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {  //필수 메소드 2: ListView에서 getView 부분을 담당하는 메소드
        holder.tvName.setText(characters.get(position).name);
        holder.ivImage.setImageResource(characters.get(position).image);
        holder.ivImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)  {
                Character char01= characters.get(position);
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(), MypagePopup.class);
                intent.putExtra("CHAR",char01 );
                context.startActivity(intent);
            }
        });
    }

    @Override                                           //필수 메소드3
    public int getItemCount() {
        return characters.size();
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
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(characters, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(characters, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }
    @Override
    public void onItemRemove(int position) {
        characters.remove(position);
        notifyItemRemoved(position);
    }

 }
