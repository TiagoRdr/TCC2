package com.tcc.glice;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AlertDialog alerta;
    private ImageButton abrirMenu;
    private TextView tituloTela;
    int telaAtual =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        tituloTela = findViewById(R.id.title_tela_principal);
        abrirMenu = findViewById(R.id.btnOpen);
        abrirMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, abrirMenu);
                abrirMenu.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onOpenPressed();
                        abrirMenu.setClickable(true);
                    }
                },400);
            }
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                    .addToBackStack(null)
                    .add(R.id.frame_container, new Frag1_Index()) .commit();
        }

    }//ONCREATE

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            sair();
        }
    }

    public void onOpenPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (!drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {

            if (telaAtual != 1){
                telaAtual = 1;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .addToBackStack(null)
                        .replace(R.id.frame_container, new Frag1_Index()).commit();
                tituloTela.setText(R.string.title_home);
            }
            else {
                return false;
            }

        } else if (id == R.id.nav_curiosidades) {

            if (telaAtual != 2){
                telaAtual = 2;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .addToBackStack(null)
                        .replace(R.id.frame_container, new Frag_Curiosidades()).commit();
                tituloTela.setText(R.string.title_curiosidades);
            }
            else {
                return false;
            }

        } else if (id == R.id.nav_alimentos) {

            if (telaAtual != 3){
                telaAtual = 3;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .addToBackStack(null)
                        .replace(R.id.frame_container, new Frag_CatAlimentos()).commit();
                tituloTela.setText(R.string.title_alimentos);
            }
            else {
                return false;
            }

        } else if (id == R.id.nav_games) {

            if (telaAtual != 4){
                telaAtual = 4;
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .addToBackStack(null)
                        .replace(R.id.frame_container, new Frag_Games()).commit();
                tituloTela.setText(R.string.title_jogos);
            }
            else {
                return false;
            }

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void sair() {
        //LayoutInflater é utilizado para inflar nosso layout em uma view.
        //-pegamos nossa instancia da classe
        LayoutInflater li = getLayoutInflater();

        //inflamos o layout alerta.xml na view
        View view = li.inflate(R.layout.dialog_sair, null);
        //definimos para o botão do layout um clickListener
        view.findViewById(R.id.btn_Nao).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });
        view.findViewById(R.id.btn_Sim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }


    public void didTapButton(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
