package com.tcc.glice;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Games extends Fragment {
    private CardView jogoMemoria;


    public Frag_Games() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag = inflater.inflate(R.layout.fragment_games, container, false);
        jogoMemoria = frag.findViewById(R.id.card_jogo_memoria);
        jogoMemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(v, jogoMemoria);
                jogoMemoria.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent tela = new Intent(getContext(), JogoMemoria.class);
                        startActivity(tela);
                        jogoMemoria.setClickable(true);
                    }
                },500);
            }
        });

        return frag;
    }

    public void animar(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }

}
