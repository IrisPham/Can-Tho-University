package com.example.visualstudio.canthouniversity.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.visualstudio.canthouniversity.R;
import com.example.visualstudio.canthouniversity.Activitys.LoginActivity;

public class Splash_Screen_LoginActivity extends AppCompatActivity {
    private ImageView imWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen__login);
        imWelcome = (ImageView) findViewById(R.id.image_ic_logo_Welcome);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_welcome);
        imWelcome.setAnimation(animation);
        final Intent intent = new Intent(this, LoginActivity.class);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }

}
