package com.tcc.glice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlimentosConstrutor {

    int Id;
    String Nome;
    Double Porcao;
    Double Carbo;
    Double Acucar;
    int Categ;

    public AlimentosConstrutor(){

    }

    public AlimentosConstrutor(int id, String nome, Double porcao, Double carbo, Double acucar, int categ) {
        this.Id = id;
        this.Nome = nome;
        this.Porcao = porcao;
        this.Carbo = carbo;
        this.Acucar = acucar;
        this.Categ = categ;

    }

    public AlimentosConstrutor(int id) {
        this.Id = id;

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getPorcao() {
        return Porcao;
    }

    public void setPorcao(Double porcao) {
        Porcao = porcao;
    }

    public Double getCarbo() {
        return Carbo;
    }

    public void setCarbo(Double carbo) {
        Carbo = carbo;
    }

    public Double getAcucar() {
        return Acucar;
    }

    public void setAcucar(Double acucar) {
        Acucar = acucar;
    }

    public int getCateg() {
        return Categ;
    }

    public void setCateg(int categ) {
        Categ = categ;
    }
}
