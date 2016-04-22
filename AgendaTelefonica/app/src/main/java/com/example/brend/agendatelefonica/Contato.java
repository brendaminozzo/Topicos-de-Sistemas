package com.example.brend.agendatelefonica;

import java.io.Serializable;

/**
 * Created by Brenda on 18/02/2016.
 */
public class Contato implements Serializable {
    private String nome;
    private int telefone;
    private int imagem;
    private int _id;

    public Contato(){

    }

    public Contato(String nome, int tel, int imagem){
        this.nome = nome;
        this.telefone = tel;
        switch (this.imagem = imagem){
        }
    }

    public Contato(int _id, String nome, int tel, int imagem){
        //super();
        this._id = _id;
        this.nome = nome;
        this.telefone = tel;
        switch (this.imagem = imagem){

        }
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
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
