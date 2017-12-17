package id.iwanbazz.dev.sigkopek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;

public class ScreenSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_splash);

        //Animation anim = new Animation();
        //anim.setAnimationListener();

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(ScreenSplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
