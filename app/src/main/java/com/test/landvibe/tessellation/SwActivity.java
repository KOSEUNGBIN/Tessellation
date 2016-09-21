package com.test.landvibe.tessellation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class SwActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sw);

        int img[] = {
                R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image,
                R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image,
                R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image,
                R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image,
                R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image, R.drawable.pattern_image
        };

        // 커스텀 아답타 생성
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, img);

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(adapter);
        gv.setColumnWidth(30);
        gv.setMinimumHeight(30);
        gv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {

                int action = me.getActionMasked();
                float currentXPosition = me.getX();
                float currentYPosition = me.getY();
                int positiona = gv.pointToPosition((int) currentXPosition, (int) currentYPosition);

                if (action == MotionEvent.ACTION_DOWN && gv.getChildAt(positiona) != null) {
                    gv.getChildAt(positiona).setVisibility(View.INVISIBLE);
                } else if (action == MotionEvent.ACTION_MOVE && gv.getChildAt(positiona) != null) {
                    gv.getChildAt(positiona).setVisibility(View.INVISIBLE);
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
            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            iv.setImageResource(img[position]);
            return convertView;
        }
    }


}
