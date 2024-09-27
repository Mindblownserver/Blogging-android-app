package com.example.helloworldjava;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    public interface OnRecyclerClickListener{
        void onItemCLick(View view, int position);
        void onItemLongCLick(View view, int position);
    }
    private final OnRecyclerClickListener listener;
    private final GestureDetector gestureDetector;
    public RecyclerItemClickListener(Context context, RecyclerView recyclerView, OnRecyclerClickListener listener){
        this.listener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
                Log.d("Confirmed click", "You Clicked one time!");
                View blogCard = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(blogCard!=null && listener!=null){
                    listener.onItemCLick(blogCard, recyclerView.getChildAdapterPosition(blogCard));
                }
                return super.onSingleTapConfirmed(e);
            }

            @Override
            public void onLongPress(@NonNull MotionEvent e) {
                Log.d("Long Click", "You took your sweet sweet time");
                View blogCard = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(blogCard!=null && listener!=null){
                    listener.onItemLongCLick(blogCard, recyclerView.getChildAdapterPosition(blogCard));
                }
                else{
                    Log.d("LongPress", "childView = null");
                }
                super.onLongPress(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        if(gestureDetector!=null){
            boolean result = gestureDetector.onTouchEvent(e);
            Log.d("Gesture Detector", ""+result);
            return result;
        }else{
            Log.d("Gesture Detector Null", "false");
            return false;
        }
    }
}
