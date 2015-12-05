package com.example.brend.myapplication;

import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Brenda on 18/11/2015.
 */
public class BancoDeDados {

    static ArrayList<Pessoa> listaUsuarios;
    private static BancoDeDados bd;

    public static BancoDeDados getInstance(){
        if (bd == null){
            listaUsuarios =  new ArrayList<Pessoa>();
            bd = new BancoDeDados();
        }
        return bd;
    }

    public boolean inserirUsuario(Pessoa p){
        for(int i=0; i<listaUsuarios.size();i++){
            if(p.getUsuarioPessoa().equals(listaUsuarios.get(i).getUsuarioPessoa())){
                return true;
            }
        }
        listaUsuarios.add(p);
        return false;

    }
    public boolean validacao(Pessoa p){
        for(int i=0; i<listaUsuarios.size();i++){
            if (p.getUsuarioPessoa().equals(listaUsuarios.get(i).getUsuarioPessoa())&& p.getSenhaPessoa().equals(listaUsuarios.get(i).getSenhaPessoa())){
                return true;
            }
        }
        return false;
    }
}
