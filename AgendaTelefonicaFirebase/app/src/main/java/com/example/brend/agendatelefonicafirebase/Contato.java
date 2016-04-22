package com.example.brend.agendatelefonicafirebase;

import java.io.Serializable;

/**
 * Created by Brenda on 18/02/2016.
 */
public class Contato implements Serializable {
    private String nome;
    private String telefone;
    private String imagem;
    private String id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
