package com.tcc.glice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {
    private static final int VersaoDoBanco = 1;
    private static final String BancodeDados = "bd_glic";

    private static final String TabelaAlimentos = "tb_alimentos";
    private static final String Coluna_id = "id";
    private static final String Coluna_nome = "nome";
    private static final String Coluna_Porcao = "porcao";
    private static final String Coluna_Carbo = "carboidratos";
    private static final String Coluna_Acucar = "acucar";
    private static final String Coluna_Categ = "categoria";


    public BancoDados(Context context) {
        super(context, BancodeDados, null, VersaoDoBanco);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_COLUNA = "CREATE TABLE " + TabelaAlimentos + "("
                + Coluna_id + " INTEGER PRIMARY KEY, " + Coluna_nome + " TEXT, " +
                Coluna_Porcao + " INTEGER, " + Coluna_Carbo + " INTEGER, " + Coluna_Acucar + " INTEGER, " + Coluna_Categ + " INTEGER);";

        db.execSQL(QUERY_COLUNA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    void AddAlimento(AlimentosConstrutor alimentos){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Coluna_nome, alimentos.getNome());
        values.put(Coluna_Porcao, alimentos.getPorcao());
        values.put(Coluna_Carbo, alimentos.getCarbo());
        values.put(Coluna_Acucar, alimentos.getAcucar());
        values.put(Coluna_Categ, alimentos.getCateg());


        db.insert(TabelaAlimentos, null, values);
        db.close();

    }

    AlimentosConstrutor SelecionaAlimentos(String nome){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TabelaAlimentos, new String[] {Coluna_id, Coluna_nome, Coluna_Porcao, Coluna_Carbo, Coluna_Acucar, Coluna_Categ}, Coluna_nome + " = ?",
                new String [] {String.valueOf(nome)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        AlimentosConstrutor selecionaAlimentos1 = new AlimentosConstrutor(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Double.parseDouble(cursor.getString(2)), Double.parseDouble(cursor.getString(3)),
                Double.parseDouble(cursor.getString(4)), Integer.parseInt(cursor.getString(5)));

        return selecionaAlimentos1;
    }



    public List<AlimentosConstrutor> ListaAlimentos(int categ){
        List<AlimentosConstrutor> listaalimentos = new ArrayList<AlimentosConstrutor>();

        String Query = "Select * from " + TabelaAlimentos;
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor c = bd.query(TabelaAlimentos, new String[] {Coluna_id, Coluna_nome, Coluna_Porcao, Coluna_Carbo, Coluna_Acucar, Coluna_Categ}, Coluna_Categ + " = ?",
                new String [] {String.valueOf(categ)}, null, null, null, null);

        if(c.moveToFirst()){
            do {
                AlimentosConstrutor selecionaCliente = new AlimentosConstrutor(Integer.parseInt(c.getString(0)),
                        c.getString(1), Double.parseDouble(c.getString(2)), Double.parseDouble(c.getString(3)),
                        Double.parseDouble(c.getString(4)),  Integer.parseInt(c.getString(5)));
                listaalimentos.add(selecionaCliente);
            } while (c.moveToNext());

        }
        return listaalimentos;
    }


    void AtualizaAlimentos(AlimentosConstrutor atualizaCliente){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Coluna_nome, atualizaCliente.getNome());
        values.put(Coluna_Porcao, atualizaCliente.getPorcao());
        values.put(Coluna_Carbo, atualizaCliente.getCarbo());
        values.put(Coluna_Acucar, atualizaCliente.getAcucar());

        db.update(TabelaAlimentos, values, Coluna_id + " = ?",
                new String[] { String.valueOf(atualizaCliente.getId())});
    }

}
