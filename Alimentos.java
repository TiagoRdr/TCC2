package com.tcc.glice;

import android.app.AlertDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Alimentos extends AppCompatActivity {
    private TextView tituloTela;
    private EditText descricaoAli;
    private EditText porcaoAli;
    private EditText carboAli;
    private EditText acuAli;

    private ImageButton btnVoltar;
    private AlertDialog viewDetalhesAlimento;

    com.tcc.glice.BancoDados bd = new com.tcc.glice.BancoDados(this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    ListView listaalimentos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);
        Bundle texto = getIntent().getExtras();
        tituloTela = findViewById(R.id.title_tela_alimentos);
        btnVoltar = findViewById(R.id.btn_Voltar_inicio_alimentos);
        listaalimentos = findViewById(R.id.listviewalimentos);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AbrirViewDetalhes("Alimento Teste", "15.000", "32,541", "4");
//            }
//        },3000);

        if ( texto != null ){
            //Utilizamos aqui o método getString que recebera o texto passado, através do identificado nome
            //que foi criando na primeira activity
            String categoriaRec = texto.getString("categoria");
            if (categoriaRec.equals("1")){
                tituloTela.setText("Doces");
            }else if(categoriaRec.equals("2")){
                tituloTela.setText("Cereais");
            }else if(categoriaRec.equals("3")){
                tituloTela.setText("Bebidas");
            }else if(categoriaRec.equals("4")){
                tituloTela.setText("Legumes");
            }else if(categoriaRec.equals("5")){
                tituloTela.setText("Verduras");
            }else if(categoriaRec.equals("6")){
                tituloTela.setText("Frutas");
            }else if(categoriaRec.equals("7")){
                tituloTela.setText("Laticínios");
            }

        }


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

//        bd.AddAlimento(new AlimentosConstrutor(1, "Bolo", 2, 3,1, 1));
//        bd.AddAlimento(new AlimentosConstrutor(2, "Farinha", 2, 3,1, 2));
//        bd.AddAlimento(new AlimentosConstrutor(3, "Pinga", 2, 3,1, 3));
//        bd.AddAlimento(new AlimentosConstrutor(4, "Cenoura", 2, 3,1, 4));
//        bd.AddAlimento(new AlimentosConstrutor(5, "Alface", 2, 3,1, 5));


        ListarAlimentos();


        listaalimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String conteudo = (String) listaalimentos.getItemAtPosition(position);

                //  Toast.makeText(Alimentos.this, "Select: " + conteudo, Toast.LENGTH_LONG).show();

                AlimentosConstrutor selecionaCliente = bd.SelecionaAlimentos(conteudo);

                AbrirViewDetalhes(selecionaCliente.getId(), selecionaCliente.getNome(), String.valueOf(selecionaCliente.getPorcao()), String.valueOf(selecionaCliente.getCarbo()),String.valueOf(selecionaCliente.getAcucar()), selecionaCliente.getCateg());
            }
        });
    }

    public void didTapButton(View view, View button) {

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        AnimacaoBounceInterpolator interpolator = new AnimacaoBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }

    public void ListarAlimentos() {
        String categ = getIntent().getStringExtra("categoria");
        int categint = Integer.parseInt((categ));

        //Toast.makeText(Alimentos.this, "" + categint, Toast.LENGTH_LONG).show();

        List<AlimentosConstrutor> lista = bd.ListaAlimentos(categint);

        //for(AlimentosConstrutor c : lista){
        //   Log.d("Lista" ,"Lista" + c.getNome());
        //}

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(Alimentos.this, android.R.layout.simple_list_item_1, arrayList);

        listaalimentos.setAdapter(adapter);

        for (AlimentosConstrutor sc : lista) {
            arrayList.add(sc.getNome());
            adapter.notifyDataSetChanged();
        }
    }

    private void AbrirViewDetalhes(final int id, String descricaoAlimento, final String porcaoAlimento, final String carboidatroAlimento, final String acucaresAlimento, int categ) {
        final Button fechar;
        final Button atualizar;
        final int id2 = id;
        final int categ2 = categ;
        LayoutInflater li = getLayoutInflater();
        View viewAliDesc = li.inflate(R.layout.view_detalhes_alimentos, null);
        fechar = viewAliDesc.findViewById(R.id.btnFecharViewDetlhes);
        atualizar = viewAliDesc.findViewById(R.id.btnatualizar);

        descricaoAli = viewAliDesc.findViewById(R.id.txtDescAlimento);
        porcaoAli = viewAliDesc.findViewById(R.id.txtPorcAlimento);
        carboAli = viewAliDesc.findViewById(R.id.txtCarboAlimento);
        acuAli = viewAliDesc.findViewById(R.id.txtAcucarAlimento);


        descricaoAli.setText(descricaoAlimento);
        porcaoAli.setText(porcaoAlimento);
        carboAli.setText(carboidatroAlimento);
        acuAli.setText(acucaresAlimento);


        fechar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                didTapButton(arg0, fechar);
                viewDetalhesAlimento.dismiss();
            }
        });


        atualizar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                if (descricaoAli.getText().toString().equals("") || porcaoAli.getText().toString().equals("") || carboAli.getText().toString().equals("") || acuAli.getText().toString().equals("")) {
                    Toast.makeText(Alimentos.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
                } else {
                    AlimentosConstrutor atualizaalimentos = new AlimentosConstrutor(id2);
                    atualizaalimentos.setNome(descricaoAli.getText().toString());
                    atualizaalimentos.setPorcao(Double.parseDouble(porcaoAli.getText().toString()));
                    atualizaalimentos.setCarbo(Double.parseDouble(carboAli.getText().toString()));
                    atualizaalimentos.setAcucar(Double.parseDouble(acuAli.getText().toString()));
                    bd.AtualizaAlimentos(atualizaalimentos);
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(viewAliDesc);
        viewDetalhesAlimento = builder.create();
        viewDetalhesAlimento.show();
    }

}
