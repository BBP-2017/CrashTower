package com.bbp.crashtower.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;

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
    public void onBindViewHolder(ViewHolder holder, int position) {  //필수 메소드 2: ListView에서 getView 부분을 담당하는 메소드
        holder.tvName.setText(characters.get(position).name);
        holder.ivImage.setImageResource(characters.get(position).image);
    }

    @Override                                           //필수 메소드3
    public int getItemCount() {
        return characters.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
         implements View.OnClickListener {
        public TextView tvName;
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tv_name);
            ivImage = itemView.findViewById(R.id.iv_main);
        }
            private String mItem="name";
        public void setItem(String item) {
            mItem = item;
            tvName.setText(item);
        }

        @Override
        public void onClick(View view) {
            /*if(view==itemView){ //view가 alert 이면 팝업실행 즉 버튼을 누르면 팝업창이 뜨는 조건

            Context mContext = getApplicationContext();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            //R.layout.character_explain는 xml 파일명이고  R.id.charexlayout은 보여줄 레이아웃 아이디
            View layout = inflater.inflate(R.layout.character_explain,(ViewGroup)findViewById(R.id.charexlayout));
            AlertDialog.Builder aDialog = new AlertDialog.Builder(CustomActivity.this);

            aDialog.setTitle("상세 설명"); //타이틀바 제목
            aDialog.setView(layout); //dialog.xml 파일을 뷰로 셋팅

            //그냥 닫기버튼을 위한 부분
            aDialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        //팝업창 생성
        AlertDialog ad = aDialog.create();
        ad.show();//보여줌!

            }*/
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
