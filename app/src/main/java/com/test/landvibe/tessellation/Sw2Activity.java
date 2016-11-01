package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

public class Sw2Activity extends Activity {


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
        setContentView(R.layout.activity_sw2);




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
*/
        degreeQuaterIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSeleted[4] == false){
                    degreeQuaterIv.setAlpha(1f);
                    isSeleted[4] = true;
                    setSession();
                } else {
                    degreeQuaterIv.setAlpha(0.5f);
                    isSeleted[4] = false;
                    setSession();
                }
            }
        });
        adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(adapter);
        gv.setColumnWidth(10);
        gv.setNumColumns(20);


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
                        draw_temp = R.drawable.scene1_01_01;
                    }
                    else if(SESSION.equals("SESSION2")) {

                        if(position % 4 == 0) {
                            draw_temp = R.drawable.scene1_02_01;
                        }else if(position % 4 == 1){
                            draw_temp = R.drawable.scene1_02_02;
                        }else if(position % 4 == 2){
                            draw_temp = R.drawable.scene1_02_03;
                        }else if(position % 4 == 3){
                            draw_temp = R.drawable.scene1_02_04;
                        }


                    }else if (SESSION.equals("SESSION3")){


                        if(position % 40 > 20) {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_03_01_01;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_03_01_02;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_03_01_03;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_03_01_04;
                                    break;
                                default:
                                    ;
                            }

                        }else {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_03_02_05;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_03_02_06;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_03_02_07;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_03_02_08;
                                    break;
                                default:
                                    ;
                            }
                        }

                    } else if (SESSION.equals("SESSION4")){


                        if(position % 40 > 20) {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_04_01_01;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_04_01_02;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_04_01_03;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_04_01_04;
                                    break;
                                default:
                                    ;
                            }

                        }else {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_04_02_05;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_04_02_06;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_04_02_07;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_04_02_08;
                                    break;
                                default:
                                    ;
                            }
                        }

                    }

                    else{
                        ;
                    }

                    gv.getChildAt(position).setBackgroundResource(draw_temp);
                }

                return true;
            }
        });




    }

    public void setSession(){

        if(!isSeleted[0] && !isSeleted[1] && !isSeleted[4]){
            SESSION = "SESSION1";
            Toast.makeText(Sw2Activity.this,"효과없음",Toast.LENGTH_SHORT).show();
        } else if (!isSeleted[0] && !isSeleted[1] && isSeleted[4]){
            Toast.makeText(Sw2Activity.this,"각도변형",Toast.LENGTH_SHORT).show();
            SESSION = "SESSION2";
        } else if (isSeleted[0] && !isSeleted[1] && isSeleted[4]){
            Toast.makeText(Sw2Activity.this,"각도변형 + 지그재그",Toast.LENGTH_SHORT).show();
            SESSION = "SESSION3";
        } else if (isSeleted[0] && isSeleted[1] && isSeleted[4]){
            Toast.makeText(Sw2Activity.this,"각도변형 + 지그재그 + 크기변형",Toast.LENGTH_SHORT).show();
            SESSION = "SESSION4";
        } else {
            Toast.makeText(Sw2Activity.this,"현재 지원되지 않는 시뮬레이션 입니다.",Toast.LENGTH_SHORT).show();
            Log.d("setSession" , "No Sessioin");
            SESSION = "SESSION1";
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

            gv.setNumColumns(20);

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
                        draw_temp = R.drawable.scene1_01_01;
                    }
                    else if(SESSION.equals("SESSION2")) {

                        if(position % 4 == 0) {
                            draw_temp = R.drawable.scene1_02_01;
                        }else if(position % 4 == 1){
                            draw_temp = R.drawable.scene1_02_02;
                        }else if(position % 4 == 2){
                            draw_temp = R.drawable.scene1_02_03;
                        }else if(position % 4 == 3){
                            draw_temp = R.drawable.scene1_02_04;
                        }


                    }else if (SESSION.equals("SESSION3")){


                        if(position % 40 > 20) {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_03_01_01;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_03_01_02;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_03_01_03;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_03_01_04;
                                    break;
                                default:
                                    ;
                            }

                        }else {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_03_02_05;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_03_02_06;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_03_02_07;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_03_02_08;
                                    break;
                                default:
                                    ;
                            }
                        }

                    } else if (SESSION.equals("SESSION4")){


                        if(position % 40 > 20) {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_04_01_01;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_04_01_02;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_04_01_03;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_04_01_04;
                                    break;
                                default:
                                    ;
                            }

                        }else {
                            switch(position % 4){
                                case 0 :
                                    draw_temp = R.drawable.scene1_04_02_05;
                                    break;
                                case 1 :
                                    draw_temp = R.drawable.scene1_04_02_06;
                                    break;
                                case 2 :
                                    draw_temp = R.drawable.scene1_04_02_07;
                                    break;
                                case 3 :
                                    draw_temp = R.drawable.scene1_04_02_08;
                                    break;
                                default:
                                    ;
                            }
                        }

                    }

                    else{
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

                params = new GridView.LayoutParams( 80 ,80);

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



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Sw2Activity.this, FreeModeActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }


}
