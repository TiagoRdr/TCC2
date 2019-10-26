package com.tcc.glice;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {
    private static int SPLAS_TIME = 4200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final LottieAnimationView animacao  = findViewById(R.id.anim_view_loading);
        final ImageView logotipo = findViewById(R.id.img_Logo);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.color1));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color1));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                 logotipo.setVisibility(View.VISIBLE);
                 didTapButton(this, logotipo);

                final Intent telaInicial = new Intent(Splash.this , MainActivity.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(telaInicial);
                        finish();
                    }
                },1000);

                //ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(), R.transition.enter_from_right, R.transition.exit_to_right);
                //ActivityCompat.startActivityForResult(Splash.this, telaInicial, activityOptionsCompat.toBundle());

            }
        },SPLAS_TIME);

    }

    //ANIMACAO DOS BUTTONS FUNCAO GLOBAL
    public void didTapButton(Runnable view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
