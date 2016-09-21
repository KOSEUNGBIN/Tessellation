package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

/**
 * Created by 송원근 on 2016-09-13.
 */

public class FreeModeActivity extends Activity {
    private SimpleFingerGestures mySfg = new SimpleFingerGestures();
    private LinearLayout linearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);

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
                    Intent intent = new Intent(FreeModeActivity.this, MainActivity.class);
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

        linearLayout.setOnTouchListener(mySfg);
    }
}
