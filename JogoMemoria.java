package com.tcc.glice;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.Collections;

public class JogoMemoria extends AppCompatActivity implements View.OnClickListener {

    private int cartasViradas = 0; //VERIFICA QUANTAS CARTAS ESTÃO VIRADAS AO MESMO TEMPO
    private int pontos = 0;
    private int erros = 0;
    private int acertos = 0;

    private LottieAnimationView countDown;
    private LottieAnimationView animacaoControle;
    private TextView tituloJogo;
    private ImageButton restartGame;
    private ImageButton btnVoltar;
    private ImageButton startGame;
    private LinearLayout layoutStartGame;
    private TableLayout painelgame;
    private ImageButton primeiraCartaVirada;
    private ImageButton segundaCartaVirada;
    private ImageButton btn0;
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;
    private ImageButton btn7;
    private ImageButton btn8;
    private ImageButton btn9;
    private ImageButton btn10;
    private ImageButton btn11;
    private ImageButton btn12;
    private ImageButton btn13;
    private ImageButton btn14;
    private ImageButton btn15;
    private ImageButton btn16;
    private ImageButton btn17;
    private ImageButton btn18;
    private ImageButton btn19;
    private ImageButton btn20;
    private ImageButton btn21;
    private ImageButton btn22;
    private ImageButton btn23;

    private int batman =  R.drawable.icon_melancia;
    private int huck = R.drawable.icon_morango;
    private int rangerAzul = R.drawable.icon_laranja;
    private int goku = R.drawable.icon_mel;
    private int incrivel =  R.drawable.icon_sushi;
    private int sonic =  R.drawable.icon_peru;
    private int mario =  R.drawable.icon_bolo;
    private int volverine =  R.drawable.icon_alface;
    private int mulhergata = R.drawable.icon_beterraba;
    private int aranha = R.drawable.icon_abobora;
    private int freeza = R.drawable.icon_pipoca;
    private int luigi = R.drawable.icon_repolho;

    private  ImageButton botoes[];
    private int imagens[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_memoria);

        animacaoControle = findViewById(R.id.animacao_jogomemoria_controle);
        painelgame = findViewById(R.id.lay_game);
        layoutStartGame = findViewById(R.id.layout_start_game);
        restartGame = findViewById(R.id.btn_RestartJogoMemoria);
        startGame = findViewById(R.id.btnStartGame);
        btnVoltar = findViewById(R.id.btn_Voltar_inicio_memoria);
        countDown = findViewById(R.id.animacao_jogomemoria_countdown);
        tituloJogo = findViewById(R.id.lbl_titulo_jogo_memoria);


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, startGame);
                startGame.setClickable(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layoutStartGame.setVisibility(View.INVISIBLE);
                        animarInicio();
                        startGame.setClickable(true);
                    }
                },500);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(v, btnVoltar);
                btnVoltar.setClickable(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                },500);
            }
        });

        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                painelgame.setVisibility(View.INVISIBLE);
                countDown.setVisibility(View.VISIBLE);

                didTapButton(v, restartGame);
                restartGame.setClickable(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animarInicio();
                    }
                },500);

            }
        });

    }

    public void animarInicio(){
        // NESSA FUNÇÃO ANIMAMOS O GAME MOSTRANDO UM 3, 2, 1 ANTES DO INICIO DO JOGO
        countDown.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countDown.setVisibility(View.INVISIBLE);
                novoJogo();
                painelgame.setVisibility(View.VISIBLE);
                restartGame.setVisibility(View.VISIBLE);
                restartGame.setClickable(true);
            }
        },3500);

    }

    public void novoJogo(){
        pontos = 0;
        erros = 0;
        acertos = 0;
        inicializarComponents();
        inicializarArrays();
        adicionarOuvintes();
        mostrarCartas();
        mostrarTodos();
        //HANDLER ESTA SENDO USADO COMO UM TIMER OU DELAY PARA ECONDER AS CARTAS
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //ANTES DE ESCONDER, É NECESSARIO DAR UMA PAUSA PARA O USUÁRIO "DECORAR" AS CARTAS :/
                esconderTodos();
            }
        },3000);
//        txtPontos.setText("Pontos: 0");
    }

    public void inicializarComponents(){
        btn0 =  (ImageButton) findViewById(R.id.btn0);
        btn1 =  (ImageButton) findViewById(R.id.btn1);
        btn2 =  (ImageButton) findViewById(R.id.btn2);
        btn3 =  (ImageButton) findViewById(R.id.btn3);
        btn4 =  (ImageButton) findViewById(R.id.btn4);
        btn5 =  (ImageButton) findViewById(R.id.btn5);
        btn6 =  (ImageButton) findViewById(R.id.btn6);
        btn7 =  (ImageButton) findViewById(R.id.btn7);
        btn8 =  (ImageButton) findViewById(R.id.btn8);
        btn9 =  (ImageButton) findViewById(R.id.btn9);
        btn10 = (ImageButton) findViewById(R.id.btn10);
        btn11 = (ImageButton) findViewById(R.id.btn11);
        btn12 = (ImageButton) findViewById(R.id.btn12);
        btn13 = (ImageButton) findViewById(R.id.btn13);
        btn14 = (ImageButton) findViewById(R.id.btn14);
        btn15 = (ImageButton) findViewById(R.id.btn15);
        btn16 = (ImageButton) findViewById(R.id.btn16);
        btn17 = (ImageButton) findViewById(R.id.btn17);
        btn18 = (ImageButton) findViewById(R.id.btn18);
        btn19 = (ImageButton) findViewById(R.id.btn19);
        btn20 = (ImageButton) findViewById(R.id.btn20);
        btn21 = (ImageButton) findViewById(R.id.btn21);
        btn22 = (ImageButton) findViewById(R.id.btn22);
        btn23 = (ImageButton) findViewById(R.id.btn23);
    }

    public  void  inicializarArrays() {
        botoes = new ImageButton[] {
                btn0, btn1,  btn2,  btn3, btn4, btn5,  btn6,  btn7,
                btn8, btn9,  btn10,  btn11, btn12, btn13,  btn14,  btn15,
                btn16, btn17,  btn18,  btn19, btn20, btn21,  btn22, btn23
        };

        imagens = new int[]{
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
                batman, huck, rangerAzul, goku, incrivel, sonic, mario, volverine,
                mulhergata, aranha, freeza, luigi, mulhergata, aranha, freeza, luigi
        };
    }

    //FAZ COM QUE TODOS OS BUTTONS IMPLEMENTEM O ONCLICK NA MESMA CLASSE
    public void adicionarOuvintes(){
        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setOnClickListener(this);
    }

    //EMBARALHA O ARRAY DE BUTTONS E DE IMAGENS, EM SEGUIDA, ATRIBUI CADA IMAGEM COMO
    //BACKGROUND PARA O RESPECTIVO BUTTON
    public void mostrarCartas() {
        Collections.shuffle(Arrays.asList(imagens));
        Collections.shuffle(Arrays.asList(botoes));

        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setBackgroundResource(imagens[i]);
    }
    //ATRIBUI UMA IMAGEM SUPERIOR AO BACKGROUND USANDO A IMAGEM 'capa.png'

    public void esconderTodos() {
        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setImageResource(R.drawable.capa);
    }

    public void mostrarTodos() {
        for(int i = 0 ; i < botoes.length; i++)
            botoes[i].setImageResource(0);
    }

    //PARA "VIRAR" A CARTA, BASTA ATRIBUIR O VALOR '0' A FUNÇAO  TORNANDO A IMAGEM
    //SUPERIOR TRANSPARENTE FICANDO VISIVEL SOMENTE O BACKGROUND
    private void viraCarta(ImageButton cartaTocada)    {
        cartaTocada.setImageResource(0);
    }

    public void  verificarPlacar()
    {
        pontos = acertos - erros;
        if (acertos == 12){
            Snackbar.make(painelgame, "Voce ganhou! Reinicie o jogo!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animacaoControle.setAnimation(R.raw.cora);
                    animacaoControle.playAnimation();
                    tituloJogo.setText("Parabéns você venceu!!");
                    startGame.setImageResource(R.drawable.ic_restart);
                    layoutStartGame.setVisibility(View.VISIBLE);
                    painelgame.setVisibility(View.INVISIBLE);
                    restartGame.setVisibility(View.INVISIBLE);
                    countDown.setVisibility(View.VISIBLE);
                }
            },2000);
        }
    }

    //VERIFICA SE AS IMAGENS DAS CARTAS SÃO IGUAIS
    private boolean verificaCartas(ImageButton carta1, ImageButton carta2) {
        if(carta1.getBackground().getConstantState().equals(carta2.getBackground().getConstantState()))
            return true;
        else
            return false;
    }


    //ATRIBUI A IMAGEM SUPERIOR PARA A IMAGEM DE CAPA NOVAMENTE
    public void desvirarCartas(final ImageButton carta1, final ImageButton carta2) {

        //Handler novamente para esconder as cartas erradas com um certo delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                carta1.setImageResource(R.drawable.capa);
                carta2.setImageResource(R.drawable.capa);
            }
        },1000);

    }

    @Override
    public void onClick(View v) {
        ImageButton cartaTocada = (ImageButton) v;
        didTapButton(cartaTocada, v);
        if(cartasViradas == 0) {   //SE NÃO HOUVER NENHUMA CARTA VIRADA NA MESA, VIRA, E ATUALIZA PARA UMA CARTA VIRADA
            primeiraCartaVirada = cartaTocada;
            viraCarta(cartaTocada);
            cartasViradas = 1;
            primeiraCartaVirada.setClickable(false);

        }else { //SE JÁ HOUVER UMA CARTA VIRADA, EXECUTA A COMPARAÇÃO ENTRE AS DUAS, VERIFICA SE SÃO IGUAIS E ATUALIZA PARA NENHUMA CARTA VIRADA
            segundaCartaVirada = cartaTocada;
            cartasViradas = 0;
            viraCarta(segundaCartaVirada);
            segundaCartaVirada.setClickable(false);



            if(verificaCartas(primeiraCartaVirada, segundaCartaVirada)) {
                acertos++;
                verificarPlacar();
            }
            else {

                // ANTES DE VIRAR AS CARTAS ERRADAS NOVAMENTE É PRECISO
                // DAR UM DELAY PARA QUE O USUÁRIO VEJA AS DUAS CARTAS
                // NÃO CORRESPONDENTES...

                erros++;
                verificarPlacar();
                desvirarCartas(primeiraCartaVirada, segundaCartaVirada);
                primeiraCartaVirada.setClickable(true);
                segundaCartaVirada.setClickable(true);
            }
        }
    }

    //ANIMACAO DOS BUTTONS FUNCAO GLOBAL
    public void didTapButton(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
