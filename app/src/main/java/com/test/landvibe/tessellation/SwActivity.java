package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class SwActivity extends Activity {


    Display display ;
    DisplayMetrics metrics ;

    GridView.LayoutParams params;

    static final String SESSION = "SESSION3";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sw);

        int img[] = new int [96];

        display = getWindowManager().getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics( metrics );



        // 커스텀 아답타 생성
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(adapter);
        gv.setColumnWidth(30);
//        gv.setMinimumHeight(30);

        if(SESSION.equals("SESSION1"))
            gv.setNumColumns(12);
        else if(SESSION.equals("SESSION2"))
            gv.setNumColumns(12);
        else if(SESSION.equals("SESSION3"))
            gv.setNumColumns(12);
        else
            ;

        gv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {


                int action = me.getActionMasked();
                float currentXPosition = me.getX();
                float currentYPosition = me.getY();
                int position = gv.pointToPosition((int) currentXPosition, (int) currentYPosition);

                if ((action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE) && gv.getChildAt(position) != null) {


                    Animation animation = new AlphaAnimation(0.0f,1.0f);
                    animation.setDuration(1000);
                    gv.getChildAt(position).setAnimation(animation);

                    int draw_temp = 0;

                    if(SESSION.equals("SESSION1")) {
                        draw_temp = (position % 2 == 0 ? R.drawable.scene_1_1_1 : R.drawable.scene_1_1_2);
                    }
                    else if(SESSION.equals("SESSION2")) {

                       if(position % 24 < 12) {
                           draw_temp = (position % 2 == 0 ? R.drawable.scene_1_2_03 : R.drawable.scene_1_2_02);
                       }else {
                           draw_temp = (position % 2 == 0 ? R.drawable.scene_1_2_13 : R.drawable.scene_1_2_14);
                       }


                    }else if (SESSION.equals("SESSION3")){


                        if(position % 24 < 12) {
                            switch(position % 6){
                                case 0 :
                                    draw_temp = R.drawable.scene_1_3_07;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene_1_3_02;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene_1_3_03;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene_1_3_04;
                                    break;
                                case 4 :
                                    draw_temp = R.drawable.scene_1_3_05;
                                    break;
                                case 5 :
                                    draw_temp = R.drawable.scene_1_3_06;
                                    break;
                                default:
                                    ;
                            }

                        }else {
                            switch(position % 5) {
                                case 0:
                                    draw_temp = R.drawable.scene_1_3_13;
                                    break;
                                case 1:
                                    draw_temp = R.drawable.scene_1_3_14;
                                    break;
                                case 2:
                                    draw_temp = R.drawable.scene_1_3_15;
                                    break;
                                case 3:
                                    draw_temp = R.drawable.scene_1_3_16;
                                    break;
                                case 4:
                                    draw_temp = R.drawable.scene_1_3_17;
                                    break;
                                default:
                                    ;
                            }
                        }

                    }else{
                        ;
                    }

                    gv.getChildAt(position).setBackgroundResource(draw_temp);
                }

                return true;
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        int img[];
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, int[] img) {
            this.context = context;
            this.layout = layout;
            this.img = img;
            inf = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = inf.inflate(layout, null);

            if(SESSION.equals("SESSION1"))
                params = new GridView.LayoutParams(metrics.widthPixels / 12 , metrics.heightPixels / 8);
            else if(SESSION.equals("SESSION2") )
                params = new GridView.LayoutParams(metrics.widthPixels / 12 , metrics.heightPixels / 8);
            else if( SESSION.equals("SESSION3"))
                params = new GridView.LayoutParams(metrics.widthPixels / 12 , metrics.heightPixels / 8);
            else
                ;
                convertView.setLayoutParams(params);



            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            iv.setImageResource(img[position]);
            return convertView;
        }
    }



}
