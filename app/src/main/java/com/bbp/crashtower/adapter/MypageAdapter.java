package com.bbp.crashtower.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bbp.crashtower.R;
import com.bbp.crashtower.model.Character;

import java.util.ArrayList;

/**
 * Created by roto1 on 2017-07-12.
 */

public class MypageAdapter extends RecyclerView.Adapter<MypageAdapter.ViewHolder>{
    ArrayList<Character> characters;
    public MypageAdapter(ArrayList<Character> characters) {
        this.characters = characters;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_character_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(characters.get(position).name);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
