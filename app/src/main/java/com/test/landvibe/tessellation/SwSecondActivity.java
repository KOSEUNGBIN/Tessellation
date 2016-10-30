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

/**
 * Created by 고승빈 on 2016-10-08.
 */
public class SwSecondActivity  extends Activity {



    Display display ;
    DisplayMetrics metrics ;

    GridView.LayoutParams params;

    static final String SESSION = "SESSION1";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sw_sc);

        int img[] = new int [150];
        final boolean animationFlag[] = new boolean[150];

        display = getWindowManager().getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics( metrics );



        // 커스텀 아답타 생성
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        final GridView gv = (GridView) findViewById(R.id.gridView2);
        gv.setAdapter(adapter);
        gv.setColumnWidth(10);
//        gv.setMinimumHeight(30);

        if(SESSION.equals("SESSION1"))
            gv.setNumColumns(14);
        else if(SESSION.equals("SESSION2"))
            gv.setNumColumns(12);
        else if(SESSION.equals("SESSION3"))
            gv.setNumColumns(12);
        else if(SESSION.equals("SESSION4"))
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
                    if( !animationFlag[position]){
                        gv.getChildAt(position).setAnimation(animation);
                        animationFlag[position] = true;
                    }


                    int draw_temp = 0;

                    if(SESSION.equals("SESSION1")) {
                        draw_temp =  R.drawable.scene_2_1_1;
                    }else if(SESSION.equals("SESSION2")) {
                        draw_temp = (position % 2 == 0 ? R.drawable.scene_2_2_1 : R.drawable.scene_2_2_2);
                    }else if (SESSION.equals("SESSION3")){
                        draw_temp = (position % 2 == 0 ? R.drawable.scene_2_3_1 : R.drawable.scene_2_3_2);
                    }else if (SESSION.equals("SESSION4")){

                            switch(position % 12){
                                case 0 :
                                    draw_temp = R.drawable.scene_2_4_1;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene_2_4_2;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene_2_4_3;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene_2_4_4;
                                    break;
                                case 4 :
                                    draw_temp = R.drawable.scene_2_4_5;
                                    break;
                                case 5 :
                                    draw_temp = R.drawable.scene_2_4_6;
                                    break;
                                case 6 :
                                    draw_temp = R.drawable.scene_2_4_7;
                                    break;
                                case 7 :
                                    draw_temp = R.drawable.scene_2_4_8;
                                    break;
                                case 8 :
                                    draw_temp = R.drawable.scene_2_4_9;
                                    break;
                                case 9 :
                                    draw_temp = R.drawable.scene_2_4_10;
                                    break;
                                case 10 :
                                    draw_temp = R.drawable.scene_2_4_11;
                                    break;
                                case 11 :
                                    draw_temp = R.drawable.scene_2_4_12;
                                    break;
                                default:
                                    ;
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
                params = new GridView.LayoutParams( 65 ,65);
            else if(SESSION.equals("SESSION2") )
                params = new GridView.LayoutParams(metrics.widthPixels / 48 , metrics.heightPixels / 22);
            else if( SESSION.equals("SESSION3"))
                params = new GridView.LayoutParams(metrics.widthPixels / 48 , metrics.heightPixels / 22);
            else if( SESSION.equals("SESSION4"))
                params = new GridView.LayoutParams(metrics.widthPixels / 48 , metrics.heightPixels / 22);
            else
                ;
            convertView.setLayoutParams(params);



            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            iv.setImageResource(img[position]);
            return convertView;
        }
    }


}
