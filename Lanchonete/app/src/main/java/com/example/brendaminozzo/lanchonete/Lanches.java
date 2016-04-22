package com.example.brendaminozzo.lanchonete;

import java.io.Serializable;

/**
 * Created by Brenda Minozzo on 03/12/2015.
 */
public class Lanches implements Serializable{
    private String nome;
    private String ingredientes;
    private double valor;
    private int imagem;

    public Lanches(String nome, String ingredientes, double valor, int imagem){
        super();
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.valor = valor;
        switch (this.imagem = imagem) {
        }
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
    @Override
     public String toString() {
        return nome;
    }
}
