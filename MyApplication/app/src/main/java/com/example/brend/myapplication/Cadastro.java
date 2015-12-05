package com.example.brend.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Brenda on 12/11/2015.
 */
public class Cadastro extends AppCompatActivity {
    TextView nomeUsuario, senhaUsuario;
    Button cadastrar, cancelar;

    BancoDeDados bd = BancoDeDados.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        Intent i = getIntent();
        nomeUsuario = (TextView) findViewById(R.id.textCad_usuario);
        senhaUsuario = (TextView) findViewById(R.id.textCad_senha);
        cadastrar = (Button) findViewById(R.id.btCad_cadastrar);
        cancelar = (Button) findViewById(R.id.btCad_cancelar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = nomeUsuario.getText().toString();
                String pass = senhaUsuario.getText().toString();
                Pessoa p = new Pessoa();
                p.setUsuarioPessoa(user);
                p.setSenhaPessoa(pass);
                if(bd.inserirUsuario(p)){
                    Toast.makeText(getApplicationContext(), "Usuário já está cadastrado!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent iCad = new Intent(Cadastro.this, Login.class);
                    startActivity(iCad);
                    Cadastro.this.finish();
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCad = new Intent(Cadastro.this, Login.class);
                startActivity(iCad);
                Cadastro.this.finish();
            }
        });
    }


}
