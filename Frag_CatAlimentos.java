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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_CatAlimentos extends Fragment {

    private CardView card1;
    private CardView card2;
    private CardView card3;
    private CardView card4;
    private CardView card5;
    private CardView card6;
    private CardView card7;

    public Frag_CatAlimentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag = inflater.inflate(R.layout.fragment_cat_alimentos, container, false);
            card1 = frag.findViewById(R.id.card1);
            card2 = frag.findViewById(R.id.card2);
            card3 = frag.findViewById(R.id.card3);
            card4 = frag.findViewById(R.id.card4);
            card5 = frag.findViewById(R.id.card5);
            card6 = frag.findViewById(R.id.card6);
            card7 = frag.findViewById(R.id.card7);


            card1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card1);
                    card1.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","1");
                            startActivity(abrirTelaAlimentos);
                            card1.setClickable(true);
                        }
                    },500);
                }
            });

            card2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card2);
                    card2.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","2");
                            startActivity(abrirTelaAlimentos);
                            card2.setClickable(true);
                        }
                    },500);
                }
            });

            card3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card3);
                    card3.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","3");
                            startActivity(abrirTelaAlimentos);
                            card3.setClickable(true);
                        }
                    },500);
                }
            });

            card4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card4);
                    card4.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","4");
                            startActivity(abrirTelaAlimentos);
                            card4.setClickable(true);
                        }
                    },500);
                }
            });

            card5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card5);
                    card5.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","5");
                            startActivity(abrirTelaAlimentos);
                            card5.setClickable(true);
                        }
                    },500);
                }
            });

            card6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animar(v, card6);
                    card6.setClickable(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                            abrirTelaAlimentos.putExtra("categoria","6");
                            startActivity(abrirTelaAlimentos);
                            card6.setClickable(true);
                        }
                    },500);
                }
            });

        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animar(v, card7);
                card7.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent abrirTelaAlimentos = new Intent(getContext(), Alimentos.class);
                        abrirTelaAlimentos.putExtra("categoria","7");
                        startActivity(abrirTelaAlimentos);
                        card7.setClickable(true);
                    }
                },500);
            }
        });


        return frag;
    }


    public void animar(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce2);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
