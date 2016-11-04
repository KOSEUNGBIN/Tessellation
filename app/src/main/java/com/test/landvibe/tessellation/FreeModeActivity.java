package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

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
//
    private ImageView freeFigureUpwardImgbtn;
    private ImageView freePaintsUpwardImgbtn;
    private ImageView freeSizeUpwardImgbtn;
    private ImageView freeMovingUpwardImgbtn;

    private ImageView freeExit;
    private ImageView freeClear;
    private ImageView freeDone;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        gridView = (GridView) findViewById(R.id.gridView);

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
                    Intent intent = new Intent(FreeModeActivity.this, Sw2Activity.class);
                    startActivity(intent);
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
                finish();
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
            default :
                break;
        }
    }

}
