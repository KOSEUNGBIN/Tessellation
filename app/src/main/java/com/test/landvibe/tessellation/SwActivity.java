package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
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

    final boolean isSeleted[] = new boolean[5];

    String SESSION = "SESSION1";
    GridView gv = null;
    int img[] = new int [9000];
    final boolean animationFlag[] = new boolean[9000];

    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sw);




        display = getWindowManager().getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics( metrics );

        final ImageView zigzagIv = (ImageView) findViewById(R.id.zigzag);
        final ImageView sizeIv = (ImageView) findViewById(R.id.size_change);
        final ImageView degreeHalfIv = (ImageView) findViewById(R.id.degree1);
        final ImageView crossIv = (ImageView)findViewById(R.id.cross);
        final ImageView degreeQuaterIv =(ImageView) findViewById(R.id.degree2);

        final ImageView clearIv =(ImageView) findViewById(R.id.clear);



        clearIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });


        zigzagIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[0] == false){
                    zigzagIv.setAlpha(1f);
                    isSeleted[0] = true;
                    setSession();

                } else {
                    zigzagIv.setAlpha(0.5f);
                    isSeleted[0] = false;
                    setSession();
                }

            }
        });


        sizeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[1] == false){
                    sizeIv.setAlpha(1f);
                    isSeleted[1] = true;
                    setSession();
                } else {
                    sizeIv.setAlpha(0.5f);
                    isSeleted[1] = false;
                    setSession();
                }
            }
        });

       /* degreeHalfIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[2] == false){
                    degreeHalfIv.setAlpha(1f);
                    isSeleted[2] = true;
                } else {
                    degreeHalfIv.setAlpha(0.5f);
                    isSeleted[2] = false;
                }
            }
        });

        crossIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[3] == false){
                    crossIv.setAlpha(1f);
                    isSeleted[3] = true;
                } else {
                    crossIv.setAlpha(0.5f);
                    isSeleted[3] = false;
                }
            }
        });

        degreeQuaterIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[4] == false){
                    degreeQuaterIv.setAlpha(1f);
                    isSeleted[4] = true;
                } else {
                    degreeQuaterIv.setAlpha(0.5f);
                    isSeleted[4] = false;
                }
            }
        });*/
        adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(adapter);
        gv.setColumnWidth(10);
//        gv.setMinimumHeight(30);

        if(SESSION.equals("SESSION1"))
            gv.setNumColumns(9);
        else if(SESSION.equals("SESSION2"))
            gv.setNumColumns(9);
        else if(SESSION.equals("SESSION3"))
            gv.setNumColumns(9);
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
                    animation.setDuration(250);
                    if( !animationFlag[position]){
                        gv.getChildAt(position).setAnimation(animation);
                        animationFlag[position] = true;
                    }


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

    public void setSession(){

        if(!isSeleted[0] && !isSeleted[1]){
            SESSION = "SESSION1";
        } else if (isSeleted[0] && !isSeleted[1]){
            SESSION = "SESSION2";
        } else if (isSeleted[0] && isSeleted[1]){
            SESSION = "SESSION3";
        }
        Log.d("setSession" , SESSION);
        setGridView();
    }

    public void setGridView(){

        adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(adapter);
        gv.setColumnWidth(10);
//        gv.setMinimumHeight(30);

        if(SESSION.equals("SESSION1"))
            gv.setNumColumns(9);
        else if(SESSION.equals("SESSION2"))
            gv.setNumColumns(9);
        else if(SESSION.equals("SESSION3"))
            gv.setNumColumns(9);
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
                    animation.setDuration(250);
                    if( !animationFlag[position]){
                        gv.getChildAt(position).setAnimation(animation);
                        animationFlag[position] = true;
                    }


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
                params = new GridView.LayoutParams( 140 ,140);
            else if(SESSION.equals("SESSION2") )
                params = new GridView.LayoutParams(140 ,140);
            else if( SESSION.equals("SESSION3"))
                params = new GridView.LayoutParams(140 ,140);
            else
                ;
                convertView.setLayoutParams(params);



            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            iv.setImageResource(img[position]);
            return convertView;
        }
    }
    private View.OnTouchListener mTouchEvent = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            ImageView image = (ImageView) v;
            switch (v.getId()) {
                case R.id.zigzag:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        image.setColorFilter(0xaa111111, PorterDuff.Mode.SRC_OVER);
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        image.setColorFilter(0x00000000, PorterDuff.Mode.SRC_OVER);
                    }
                    break;
            }
            return true;
        }
    };





}
