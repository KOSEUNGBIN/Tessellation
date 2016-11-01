package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

import static com.test.landvibe.tessellation.MenuActivity.buttonEffect;

/**
 * Created by 송원근 on 2016-09-13.
 */

public class FreeModeActivity extends Activity implements View.OnClickListener {
    private SimpleFingerGestures mySfg = new SimpleFingerGestures();
    private GridView gridView;

    private ImageView freeTopFigureImgbtn;
    private ImageView freeTopPaintsImgbtn;
    private ImageView freeTopSizeImgbtn;
    private ImageView freeTopMovingImgbtn;

    private View freeMenuIncludeTop;
    private View freeMenuIncludeFigure;
    private View freeMenuIncludePaints;
    private View freeMenuIncludeSize;
    private View freeMenuIncludeMoving;

    private ImageView freeFigureUpwardImgbtn;
    private ImageView freePaintsUpwardImgbtn;
    private ImageView freeSizeUpwardImgbtn;
    private ImageView freeMovingUpwardImgbtn;

    private ImageView freeExit;
    private ImageView freeClear;
    private ImageView freeDone;

    int border[] = {0,0,0,0};
    ArrayList<LinearLayout> list = new ArrayList<LinearLayout>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        ImageView default_triangle = (ImageView) findViewById(R.id.free_figure_menu_triangle_usual_imgbtn);


        default_triangle.setOnTouchListener(new MyTouchListener());


        gridView = (GridView) findViewById(R.id.gridView);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.free_center);
        LinearLayout linearLayoutRight1 = (LinearLayout) findViewById(R.id.free_right1);
        LinearLayout linearLayoutRight2 = (LinearLayout) findViewById(R.id.free_right2);
        LinearLayout linearLayoutRight3 = (LinearLayout) findViewById(R.id.free_right3);
        linearLayout.setOnDragListener(new MyDragListener0());
        linearLayoutRight1.setOnDragListener(new MyDragListener1());
        linearLayoutRight2.setOnDragListener(new MyDragListener2());
        linearLayoutRight3.setOnDragListener(new MyDragListener3());
        list.add(linearLayout);
        list.add(linearLayoutRight1);
        list.add(linearLayoutRight2);
        list.add(linearLayoutRight3);



        ImageView purple = (ImageView) findViewById(R.id.purple);
        purple.setOnClickListener(this);
        ImageView green = (ImageView) findViewById(R.id.green);
        green.setOnClickListener(this);
        ImageView red = (ImageView) findViewById(R.id.red);
        red.setOnClickListener(this);
        ImageView blue = (ImageView) findViewById(R.id.blue);
        blue.setOnClickListener(this);




        freeTopFigureImgbtn = (ImageView) findViewById(R.id.free_top_figure_imgbtn);
        freeTopPaintsImgbtn =  (ImageView) findViewById(R.id.free_top_paints_imgbtn);
        freeTopSizeImgbtn =  (ImageView) findViewById(R.id.free_top_size_imgbtn);
        freeTopMovingImgbtn =  (ImageView) findViewById(R.id.free_top_moving_imgbtn);
        freeTopFigureImgbtn.setOnClickListener(this);
        freeTopPaintsImgbtn.setOnClickListener(this);
        freeTopSizeImgbtn.setOnClickListener(this);
        freeTopMovingImgbtn.setOnClickListener(this);

        freeFigureUpwardImgbtn = (ImageView) findViewById(R.id.free_figure_upward_imgbtn);
        freePaintsUpwardImgbtn = (ImageView) findViewById(R.id.free_paints_upward_imgbtn);
        freeSizeUpwardImgbtn = (ImageView) findViewById(R.id.free_size_upward_imgbtn);
        freeMovingUpwardImgbtn = (ImageView) findViewById(R.id.free_moving_upward_imgbtn);
        freeFigureUpwardImgbtn.setOnClickListener(this);
        freePaintsUpwardImgbtn.setOnClickListener(this);
        freeSizeUpwardImgbtn.setOnClickListener(this);
        freeMovingUpwardImgbtn.setOnClickListener(this);

        freeExit = (ImageView) findViewById(R.id.free_exit);
        freeClear = (ImageView) findViewById(R.id.free_clear);
        freeDone = (ImageView) findViewById(R.id.free_done);
        freeExit.setOnClickListener(this);
        freeClear.setOnClickListener(this);
        freeDone.setOnClickListener(this);

        buttonEffect(purple);
        buttonEffect(green);
        buttonEffect(blue);
        buttonEffect(red);
        buttonEffect(freeTopFigureImgbtn);
        buttonEffect(freeTopPaintsImgbtn);
        buttonEffect(freeTopSizeImgbtn);
        buttonEffect(freeTopMovingImgbtn);
        buttonEffect(freeFigureUpwardImgbtn);
        buttonEffect(freePaintsUpwardImgbtn);
        buttonEffect(freeSizeUpwardImgbtn);
        buttonEffect(freeMovingUpwardImgbtn);

        //SimpleFingerGestures 라이브러리 사용
        mySfg.setDebug(true);
        mySfg.setConsumeTouchEvents(true);
        mySfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onSwipeDown(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onSwipeLeft(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onSwipeRight(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onPinch(int i, long l, double v) {
                //3손가락의 핀치로 액티비티 전환
                Log.e("Free", i + " fingers  " + l + " millsec  " + v + "fixels far");
                if (i == 3 && l >= 10 && v >= 10) {
                    int count =0;
                    for(int bor =0;  bor< 4; bor++ ){
                        if(border[bor] != 0){
                            count++;
                        }
                    }
                    Intent intent;
                    if(count <= 1){
                        intent = new Intent(FreeModeActivity.this, Sw2Activity.class);
                    } else {
                        intent = new Intent(FreeModeActivity.this, Sw3Activity.class);
                    }

                    startActivity(intent);
                    finish();
                }
                return false;
            }

            @Override
            public boolean onUnpinch(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onDoubleTap(int i) {
                return false;
            }
        });

        gridView.setOnTouchListener(mySfg);
    }

    @Override
    protected void onResume() {
        super.onResume();

        freeMenuIncludeTop = findViewById(R.id.free_menu_include_top);
        freeMenuIncludeTop.setVisibility(View.VISIBLE);

        freeMenuIncludeFigure = findViewById(R.id.free_menu_include_figure);
        freeMenuIncludeFigure.setVisibility(View.GONE);
        freeMenuIncludePaints = findViewById(R.id.free_menu_include_paints);
        freeMenuIncludePaints.setVisibility(View.GONE);
        freeMenuIncludeSize = findViewById(R.id.free_menu_include_size);
        freeMenuIncludeSize.setVisibility(View.GONE);
        freeMenuIncludeMoving = findViewById(R.id.free_menu_include_moving);
        freeMenuIncludeMoving.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.free_top_figure_imgbtn :
            {
                freeMenuIncludeTop.setVisibility(View.GONE);
                freeMenuIncludeFigure.setVisibility(View.VISIBLE);
                freeMenuIncludePaints.setVisibility(View.GONE);
                freeMenuIncludeSize.setVisibility(View.GONE);
                freeMenuIncludeMoving.setVisibility(View.GONE);
                break;
            }
            case R.id.free_top_paints_imgbtn :
            {
                freeMenuIncludeTop.setVisibility(View.GONE);
                freeMenuIncludeFigure.setVisibility(View.GONE);
                freeMenuIncludePaints.setVisibility(View.VISIBLE);
                freeMenuIncludeSize.setVisibility(View.GONE);
                freeMenuIncludeMoving.setVisibility(View.GONE);
                break;
            }
            case R.id.free_top_size_imgbtn :
            {
                freeMenuIncludeTop.setVisibility(View.GONE);
                freeMenuIncludeFigure.setVisibility(View.GONE);
                freeMenuIncludePaints.setVisibility(View.GONE);
                freeMenuIncludeSize.setVisibility(View.VISIBLE);
                freeMenuIncludeMoving.setVisibility(View.GONE);
                break;
            }
            case R.id.free_top_moving_imgbtn :
            {
                freeMenuIncludeTop.setVisibility(View.GONE);
                freeMenuIncludeFigure.setVisibility(View.GONE);
                freeMenuIncludePaints.setVisibility(View.GONE);
                freeMenuIncludeSize.setVisibility(View.GONE);
                freeMenuIncludeMoving.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.free_exit :
            {
                // 나가기 버튼의 액션
                break;
            }
            case R.id.free_clear :
            {
                // 초기화 버튼의 액션
                recreate();
                break;
            }
            case R.id.free_done :
            {
                // 완성 버튼의 액션
                break;
            }
            case R.id.free_figure_upward_imgbtn :
            case R.id.free_paints_upward_imgbtn :
            case R.id.free_size_upward_imgbtn :
            case R.id.free_moving_upward_imgbtn :
            {
                onResume();
                break;
            }
            case  R.id.purple:
            {
                for(int i =0;  i< 4; i++ ){
                    if(border[i] == 1){
                        final LinearLayout temp =  list.get(i);
                        final int foo = i;
                        temp.setBackground(getResources().getDrawable(R.drawable.triangle_purple_));
                        temp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(border[foo] == 1){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_purple));
                                    border[foo] = 2;
                                } else if(border[foo] ==0 || border[foo] == 2){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_purple_));
                                    border[foo] = 1;
                                } else {
                                    Log.d("???", ""+border[0]);
                                }

                            }
                        });
                    }
                }
                break;
            }

            case  R.id.green:
            {
                for(int i =0;  i< 4; i++ ){
                    if(border[i] == 1){
                        final LinearLayout temp =  list.get(i);
                        temp.setBackground(getResources().getDrawable(R.drawable.triangle_green_));
                        final int foo = i;
                        temp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(border[foo] == 1){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_green));
                                    border[foo] = 2;
                                } else if(border[foo] ==0 || border[foo] == 2){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_green_));
                                    border[foo] = 1;
                                } else {
                                    Log.d("???", ""+border[0]);
                                }

                            }
                        });
                    }
                }
                break;
            }
            case  R.id.red:
            {
                for(int i =0;  i< 4; i++ ){
                    if(border[i] == 1){
                        final LinearLayout temp =  list.get(i);
                        temp.setBackground(getResources().getDrawable(R.drawable.triangle_red_));
                        final int foo = i;
                        temp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(border[foo] == 1){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_red));
                                    border[foo] = 2;
                                } else if(border[foo] ==0 || border[foo] == 2){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_red_));
                                    border[foo] = 1;
                                } else {
                                    Log.d("???", ""+border[0]);
                                }

                            }
                        });
                    }
                }
                break;
            }
            case  R.id.blue:
            {
                for(int i =0;  i< 4; i++ ){
                    if(border[i] == 1){
                        final LinearLayout temp =  list.get(i);
                        temp.setBackground(getResources().getDrawable(R.drawable.triangle_blue_));
                        final int foo = i;
                        temp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(border[foo] == 1){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_blue));
                                    border[foo] = 2;
                                } else if(border[foo] ==0 || border[foo] == 2){
                                    temp.setBackgroundDrawable(getResources().getDrawable(R.drawable.triangle_blue_));
                                    border[foo] = 1;
                                } else {
                                    Log.d("???", ""+border[0]);
                                }

                            }
                        });
                    }
                }
                break;
            }
            default :
                break;
        }
    }

    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                view.setBackgroundResource(R.drawable.triangle_default_);
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener0 implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.triangle_default_);
        Drawable normalShape = getResources().getDrawable(R.drawable.triangle_default);

        @Override
        public boolean onDrag(final View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    v.setBackgroundDrawable(enterShape);
                    if(border[0] == 0){
                        border[0] = 1;
                    }
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(border[0] == 1){
                                v.setBackgroundDrawable(normalShape);
                                border[0] = 2;
                            } else if(border[0] ==0 || border[0] == 2){
                                v.setBackgroundDrawable(enterShape);
                                border[0] = 1;
                            } else {
                                Log.d("???", ""+border[0]);
                            }

                        }
                    });
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    class MyDragListener1 implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.triangle_default_);
        Drawable normalShape = getResources().getDrawable(R.drawable.triangle_default);

        @Override
        public boolean onDrag(final View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    v.setBackgroundDrawable(enterShape);
                    if(border[1] == 0){
                        border[1] = 1;
                    }
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(border[1] == 1){
                                v.setBackgroundDrawable(normalShape);
                                border[1] = 2;
                            } else if(border[1] ==0 || border[1] == 2){
                                v.setBackgroundDrawable(enterShape);
                                border[1] = 1;
                            }

                        }
                    });
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    class MyDragListener2 implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.triangle_default_);
        Drawable normalShape = getResources().getDrawable(R.drawable.triangle_default);

        @Override
        public boolean onDrag(final View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    v.setBackgroundDrawable(enterShape);
                    if(border[2] == 0){
                        border[2] = 1;
                    }
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(border[2] == 1){
                                v.setBackgroundDrawable(normalShape);
                                border[2] = 2;
                            } else if(border[2] ==0 || border[2] == 2){
                                v.setBackgroundDrawable(enterShape);
                                border[2] = 1;
                            }

                        }
                    });
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }

    class MyDragListener3 implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.triangle_default_);
        Drawable normalShape = getResources().getDrawable(R.drawable.triangle_default);

        @Override
        public boolean onDrag(final View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    v.setBackgroundDrawable(enterShape);
                    if(border[3] == 0){
                        border[3] = 1;
                    }
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(border[3] == 1){
                                v.setBackgroundDrawable(normalShape);
                                border[3] = 2;
                            } else if(border[3] ==0 || border[3] == 2){
                                v.setBackgroundDrawable(enterShape);
                                border[3] = 1;
                            }

                        }
                    });
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FreeModeActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }




}
