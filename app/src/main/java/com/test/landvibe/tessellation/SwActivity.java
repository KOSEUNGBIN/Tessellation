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

                    if(SESSION.equals("SESSION1")) {
                        gv.getChildAt(position).setBackgroundResource(position % 2 == 0 ? R.drawable.scene_1_1_1 : R.drawable.scene_1_1_2);
                    }
                    else if(SESSION.equals("SESSION2")) {

                        switch(position % 24){
                            case 0 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_01);
                                break;
                            case 1 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_02);
                                break;
                            case 2 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_03);
                                break;
                            case 3 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_04);
                                break;
                            case 4 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_05);
                                break;
                            case 5 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_06);
                                break;
                            case 6 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_07);
                                break;
                            case 7 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_08);
                                break;
                            case 8 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_09);
                                break;
                            case 9 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_10);
                                break;
                            case 10 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_11);
                                break;
                            case 11 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_12);
                                break;
                            case 12 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_13);
                                break;
                            case 13 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_14);
                                break;
                            case 14 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_15);
                                break;
                            case 15 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_16);
                                break;
                            case 16 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_17);
                                break;
                            case 17 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_18);
                                break;
                            case 18 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_19);
                                break;
                            case 19 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_20);
                                break;
                            case 20 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_21);
                                break;
                            case 21 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_22);
                                break;
                            case 22 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_23);
                                break;
                            case 23 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_2_24);
                                break;
                            default:
                                break;
                        }

                    }else if (SESSION.equals("SESSION3")){


                        switch(position % 24){
                            case 0 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_01);
                                break;
                            case 1 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_02);
                                break;
                            case 2 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_03);
                                break;
                            case 3 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_04);
                                break;
                            case 4 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_05);
                                break;
                            case 5 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_06);
                                break;
                            case 6 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_07);
                                break;
                            case 7 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_08);
                                break;
                            case 8 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_09);
                                break;
                            case 9 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_10);
                                break;
                            case 10 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_11);
                                break;
                            case 11 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_12);
                                break;
                            case 12 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_13);
                                break;
                            case 13 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_14);
                                break;
                            case 14 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_15);
                                break;
                            case 15 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_16);
                                break;
                            case 16 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_17);
                                break;
                            case 17 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_18);
                                break;
                            case 18 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_19);
                                break;
                            case 19 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_20);
                                break;
                            case 20 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_21);
                                break;
                            case 21 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_22);
                                break;
                            case 22 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_23);
                                break;
                            case 23 :
                                gv.getChildAt(position).setBackgroundResource(R.drawable.scene_1_3_24);
                                break;
                            default:
                                break;
                        }

                    }else{

                    }

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
