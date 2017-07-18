package com.bbp.crashtower;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BattleActivity extends BaseActivity {

    FrameLayout frameGround;

    ImageButton iBtn_card_1;

    int displayWidth, displayHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //상태 표시줄(Statusbar 안테나, 베터리 상태 등이 표시되는 부분)을 없앤다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_battle);

        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();

        frameGround =(FrameLayout)findViewById(R.id.frame_grooud);
        frameGround.addView(new appView.BattleGroundView(this));



        // 여기부터 드래그엔 드랍

        iBtn_card_1 = (ImageButton) findViewById(R.id.btn_battle_card_1);

        iBtn_card_1.setOnLongClickListener(new LongClickListener());

        findViewById(R.id.frame_grooud).setOnDragListener(new DragListener(this));
        findViewById(R.id.linear_deck).setOnDragListener(new DragListener(this));



    }

    private final class LongClickListener implements View.OnLongClickListener {

        public boolean onLongClick(View view) {

            // 태그 생성
            ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

            view.startDrag(data, // data to be dragged
                    shadowBuilder, // drag shadow
                    view, // 드래그 드랍할  Vew
                    0 // 필요없은 플래그
            );

            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }



    class DragListener implements View.OnDragListener {

        Drawable normalShape, targetShape;
        Context mContext;

        DragListener(Context context){
            mContext = context;

            normalShape = mContext.getResources().getDrawable(R.drawable.normal_space);
            targetShape = mContext.getResources().getDrawable(R.drawable.target_space);
        }

        public boolean onDrag(View v, DragEvent event) {

            // 이벤트 시작
            switch (event.getAction()) {

                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    Toast.makeText(mContext, "ACTION_DRAG_STARTED", Toast.LENGTH_SHORT).show();
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
                case DragEvent.ACTION_DRAG_ENTERED:
                    Toast.makeText(mContext, "ACTION_DRAG_ENTERED", Toast.LENGTH_SHORT).show();
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                    v.setBackground(targetShape);
                    break;

                // 드래그한 이미지가 영역을 빠져 나갈때
                case DragEvent.ACTION_DRAG_EXITED:
                    Toast.makeText(mContext, "ACTION_DRAG_EXITED", Toast.LENGTH_SHORT).show();
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                    v.setBackground(normalShape);
                    break;

                // 이미지를 드래그해서 드랍시켰을때
                case DragEvent.ACTION_DROP:
                    Toast.makeText(mContext, "ACTION_DROP", Toast.LENGTH_SHORT).show();
                    Log.d("DragClickListener", "ACTION_DROP");

                    if(v == ((Activity)mContext).findViewById(R.id.frame_grooud)){

                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }else if (v == ((Activity)mContext).findViewById(R.id.linear_deck)) {
                        View view = (View) event.getLocalState();
                        ViewGroup viewgroup = (ViewGroup) view.getParent();
                        viewgroup.removeView(view);

                        LinearLayout containView = (LinearLayout) v;
                        containView.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }else {
                        View view = (View) event.getLocalState();
                        view.setVisibility(View.VISIBLE);
                        Toast.makeText(mContext, "이미지를 다른 지역에 드랍할수 없습니다.", Toast.LENGTH_LONG).show();
                        break;
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Toast.makeText(mContext, "ACTION_DRAG_ENDED", Toast.LENGTH_SHORT).show();
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    v.setBackground(normalShape); // go back to normal shape

                default:
                    break;
            }
            return true;
        }
    }
}
