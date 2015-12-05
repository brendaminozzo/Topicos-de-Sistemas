package com.example.brend.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button entrar, cadastro;
    EditText usuario, senha;

    BancoDeDados bd = BancoDeDados.getInstance();
    Pessoa p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.text_usuario);
        senha = (EditText) findViewById(R.id.text_senha);
        entrar = (Button) findViewById(R.id.bt_entrar);
        cadastro = (Button) findViewById(R.id.bt_cadastro);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = new Pessoa();
                p.setUsuarioPessoa(usuario.getText().toString());
                p.setSenhaPessoa(senha.getText().toString());
                if (bd.validacao(p)) {
                    Toast.makeText(getApplicationContext(), "Redirecionando...", Toast.LENGTH_SHORT).show();
                    Intent entraAplicacao = new Intent(Login.this, Aplicacao.class);

                    String nome = usuario.getText().toString();
                    String password = senha.getText().toString();
                    Bundle b = new Bundle(); //encapsula o valor pra passar pra próxima tela
                    b.putString("user", nome);
                    entraAplicacao.putExtras(b);

                    Login.this.startActivity(entraAplicacao);
                    Login.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Dados incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrarCadastro = new Intent(Login.this, Cadastro.class);
                Login.this.startActivity(entrarCadastro);
                Login.this.finish();
            }
        });



    }



}
