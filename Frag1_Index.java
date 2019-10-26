package com.tcc.glice;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1_Index extends Fragment {
    // o contexto é obtido de forma diferente -> getActivity().getApplicationContext()

    private LottieAnimationView btn_carosel_bottom;
    private AlertDialog telaAlimentos;
    private LinearLayout btnBottomBar01;
    private LinearLayout btnBottomBar02;

    public Frag1_Index() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_index, container, false);
        btnBottomBar01 = view.findViewById(R.id.btnBottomBar01);
        btnBottomBar02 = view.findViewById(R.id.btnBottomBar02);
        btn_carosel_bottom = view.findViewById(R.id.animation_carousel);

        btnBottomBar01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, btnBottomBar01);
                btnBottomBar01.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent tela = new Intent(getContext(), Glicemia.class);
                        startActivity(tela);
                        btnBottomBar01.setClickable(true);
                    }
                },500);
            }
        });

        btnBottomBar02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, btnBottomBar02);
                btnBottomBar02.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent tela = new Intent(getContext(), Glicemia.class);
                        startActivity(tela);
                        btnBottomBar02.setClickable(true);
                    }
                },500);
            }
        });

        btn_carosel_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, btn_carosel_bottom);
                btn_carosel_bottom.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        abrirviewComer();
                        btn_carosel_bottom.setClickable(true);
                    }
                },500);
            }
        });

        return view;
    }

    private void abrirviewComer() {
        final Button fechar;
        LayoutInflater li = getLayoutInflater();
        View viewComer = li.inflate(R.layout.comer_view, null);
        fechar = viewComer.findViewById(R.id.btnCancelar);

        fechar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                didTapButton(arg0, fechar);
                telaAlimentos.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(viewComer);
        telaAlimentos = builder.create();
        telaAlimentos.show();
    }

    public void didTapButton(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
