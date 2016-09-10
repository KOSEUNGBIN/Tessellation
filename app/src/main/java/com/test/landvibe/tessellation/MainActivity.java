package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.test.landvibe.tessellation.R;

import static android.R.attr.width;
import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_HOVER_ENTER;
import static android.view.MotionEvent.ACTION_HOVER_EXIT;
import static android.view.MotionEvent.ACTION_HOVER_MOVE;
import static android.view.MotionEvent.ACTION_MASK;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_OUTSIDE;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends Activity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;

    int img_width = 100;
    int img_height = 100;

    //사용할 패턴 이미지
    Bitmap patternImg;
    Bitmap resize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bitmap으로 이미지 가져와서 사이즈 조절
        patternImg = BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.pattern_image);
        resize = Bitmap.createScaledBitmap(patternImg,img_width,img_height,true);

        //레이아웃 만들기
//        LinearLayout linearLayout = new LinearLayout(this);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
//                (ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT);
//        linearLayout.setLayoutParams(params);

        AbsoluteLayout absoluteLayout = new AbsoluteLayout(this);

        img1 = new ImageView(this);
        img2 = new ImageView(this);
        img3 = new ImageView(this);
        img4 = new ImageView(this);
        img5 = new ImageView(this);

        absoluteLayout.addView(img1,new AbsoluteLayout.LayoutParams(img_width,img_height,0,0));
        absoluteLayout.addView(img2,new AbsoluteLayout.LayoutParams(img_width,img_height,100,100));
        absoluteLayout.addView(img3,new AbsoluteLayout.LayoutParams(img_width,img_height,200,200));
        absoluteLayout.addView(img4,new AbsoluteLayout.LayoutParams(img_width,img_height,300,300));
        absoluteLayout.addView(img5,new AbsoluteLayout.LayoutParams(img_width,img_height,400,400));

//        //만들어 놓은 LinearLayout에 imageview들 추가
//        linearLayout.addView(img1);
//        linearLayout.addView(img2);
//        linearLayout.addView(img3);
//        linearLayout.addView(img4);
//        linearLayout.addView(img5);

        setContentView(absoluteLayout);

        //TouchListener 추가
        TouchListener touchListener1 = new TouchListener("linearLayout");
        absoluteLayout.setOnTouchListener(touchListener1);
    }

    class TouchListener implements View.OnTouchListener{
        private String imgv_name;//어떤 이미지뷰에서 발생하는지 알기위한 변수

        TouchListener(String imgv_name){
            this.imgv_name = imgv_name;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()){
                case ACTION_DOWN:
                    Log.e("MainActivity","ACTION_DOWN 발생");
                    break;
                case ACTION_HOVER_ENTER:
                    Log.e("MainActivity","ACTION_HOVER_ENTER 발생");
                    break;
                case ACTION_HOVER_MOVE:
                    Log.e("MainActivity","ACTION_HOVER_MOVE 발생");
                    break;
                case ACTION_HOVER_EXIT:
                    Log.e("MainActivity","ACTION_HOVER_EXIT 발생");
                    break;
                case ACTION_MOVE:
                    Log.e("MainActivity","ACTION_MOVE 발생");
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();

                    Log.v(imgv_name,"X = " + x + "     Y = " + y );

                    if(x < 100 && y < 100){
                        img1.setImageBitmap(resize);
                    }else if (100 < x && x < 200 && 100 < y && y < 200 ) {
                        img2.setImageBitmap(resize);
                    }else if (200 < x && x < 300 && 200 < y && y < 300) {
                        img3.setImageBitmap(resize);
                    }else if (300 < x && x < 400 && 300 < y && y < 400) {
                        img4.setImageBitmap(resize);
                    }else if (400 < x && x < 500 &&  400 < y && y < 500) {
                        img5.setImageBitmap(resize);
                    }

                    break;
                case ACTION_CANCEL:
                    Log.e("MainActivity","ACTION_CANCEL 발생");
                    break;
                case ACTION_UP:
                    Log.e("MainActivity","ACTION_UP 발생");
                    break;
                case ACTION_OUTSIDE:
                    Log.d("MainActivity","ACTION_OUTSIDE 발생");
                    break;

            }
            return true;
        }
    }
}