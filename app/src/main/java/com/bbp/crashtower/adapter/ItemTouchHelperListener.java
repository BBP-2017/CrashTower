package com.bbp.crashtower.adapter;

public interface ItemTouchHelperListener {
    boolean onItemMove(int fromPosition, int toPosition);
   void onItemRemove(int position);
}