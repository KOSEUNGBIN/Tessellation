package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends Activity {
    private float xCurrentPos, yCurrentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ImageButton button = (ImageButton) findViewById(R.id.map_korea);
        final ImageButton button2 = (ImageButton) findViewById(R.id.map_book);
        final ImageView cloud1 = (ImageView) findViewById(R.id.cloud01);
        final ImageView cloud2 = (ImageView) findViewById(R.id.cloud02);
        final ImageView cloud3 = (ImageView) findViewById(R.id.cloud03);
        final ImageView cloud4 = (ImageView) findViewById(R.id.cloud04);
        final ImageView cloud5 = (ImageView) findViewById(R.id.cloud05);
        final ImageView cloud6 = (ImageView) findViewById(R.id.cloud06);

        buttonEffect(button);
        buttonEffect(button2);

        final Animation anim= new TranslateAnimation(xCurrentPos, xCurrentPos+150, yCurrentPos, yCurrentPos);
        anim.setDuration(5000);
        anim.setFillAfter(true);
        anim.setRepeatCount(100);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });
        final Animation anim2= new TranslateAnimation(xCurrentPos, xCurrentPos-150, yCurrentPos, yCurrentPos);
        anim2.setDuration(4000);
        anim2.setFillAfter(true);
        anim2.setRepeatCount(100);
        anim2.setRepeatMode(Animation.REVERSE);
        anim2.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        final Animation anim3= new TranslateAnimation(xCurrentPos, xCurrentPos-150, yCurrentPos, yCurrentPos);
        anim3.setDuration(3000);
        anim3.setFillAfter(true);
        anim3.setRepeatCount(100);
        anim3.setRepeatMode(Animation.REVERSE);
        anim3.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        final Animation anim4= new TranslateAnimation(xCurrentPos, xCurrentPos+150, yCurrentPos, yCurrentPos);
        anim4.setDuration(2500);
        anim4.setFillAfter(true);
        anim4.setRepeatCount(100);
        anim4.setRepeatMode(Animation.REVERSE);
        anim4.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        final Animation anim5= new TranslateAnimation(xCurrentPos, xCurrentPos+150, yCurrentPos, yCurrentPos);
        anim5.setDuration(6000);
        anim5.setFillAfter(true);
        anim5.setRepeatCount(100);
        anim5.setRepeatMode(Animation.REVERSE);
        anim5.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        final Animation anim6= new TranslateAnimation(xCurrentPos, xCurrentPos+150, yCurrentPos, yCurrentPos);
        anim6.setDuration(4500);
        anim6.setFillAfter(true);
        anim6.setRepeatCount(100);
        anim6.setRepeatMode(Animation.REVERSE);
        anim6.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {

            }
        });

        float xPos[] = new float[6];
        float yPos[] = new float[6];

        xPos[0] =  cloud1.getLeft();
        yPos[0] = cloud1.getTop();
        xPos[1] =  cloud2.getLeft();
        yPos[1] = cloud2.getTop();
        xPos[2] =  cloud3.getLeft();
        yPos[2] = cloud3.getTop();
        xPos[3] =  cloud4.getLeft();
        yPos[3] = cloud4.getTop();
        xPos[4] =  cloud5.getLeft();
        yPos[4] = cloud5.getTop();
        xPos[5] =  cloud6.getLeft();
        yPos[5] = cloud6.getTop();

        xPos[0] = cloud1.getLeft();
        yPos[0] = cloud1.getTop();
        cloud1.startAnimation(anim3);
        xPos[1] = cloud2.getLeft();
        yPos[1] = cloud2.getTop();
        cloud2.startAnimation(anim);
        xPos[2] = cloud3.getLeft();
        yPos[2] = cloud3.getTop();
        cloud3.startAnimation(anim6);
        xPos[3] = cloud4.getLeft();
        yPos[3] = cloud4.getTop();
        cloud4.startAnimation(anim4);
        xPos[4] = cloud5.getLeft();
        yPos[4] = cloud5.getTop();
        cloud5.startAnimation(anim5);
        xPos[5] = cloud6.getLeft();
        yPos[5] = cloud6.getTop();
        cloud6.startAnimation(anim2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SwActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, FreeModeActivity.class);
                startActivity(intent);
            }
        });

    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0x60000000, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }


}