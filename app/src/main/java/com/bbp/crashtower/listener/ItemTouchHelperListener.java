package com.bbp.crashtower.listener;

public interface ItemTouchHelperListener {
    boolean onItemMove(int fromPosition, int toPosition);
   void onItemRemove(int position);
}