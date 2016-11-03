package com.test.landvibe.tessellation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 고승빈 on 2016-11-02.
 */
public class Scene1CompleteActivity extends Activity {

    private AnimationDrawable frameAnimation;
    private ImageView scene1_complete_image;
    private ImageView scene1_complete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene1complete);

        scene1_complete_image = (ImageView) findViewById(R.id.scene1_complete_image);
        scene1_complete_image.setImageResource(R.drawable.scene1_complete_animation_list);
        frameAnimation = (AnimationDrawable) scene1_complete_image.getDrawable();

        frameAnimation.start();

        scene1_complete_btn = (ImageView) findViewById(R.id.scene1_complete_btn);
        scene1_complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Scene1CompleteActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
