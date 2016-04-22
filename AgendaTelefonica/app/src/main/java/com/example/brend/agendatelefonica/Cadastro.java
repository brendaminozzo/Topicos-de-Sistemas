package com.example.brend.agendatelefonica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brenda on 19/02/2016.
 */
public class Cadastro extends AppCompatActivity {

    //colocar a imagem
    @Bind(R.id.editText)EditText editText;
    @Bind(R.id.editText2)EditText editText2;
    Button salva, cancela;
    BancoDeDados bd;
    List<Contato> contatos = new ArrayList<Contato>();
    ListView listinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_contato);

        ButterKnife.bind(this);
        salva = (Button) findViewById(R.id.bt_salvar);
        cancela = (Button) findViewById(R.id.bt_cancelar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bd = new BancoDeDados(getBaseContext());

        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editText.getText().toString();
                int tel = Integer.parseInt(editText2.getText().toString());
                Contato c = new Contato();
                c.setNome(nome);
                c.setTelefone(tel);
                c.setImagem(R.drawable.jack);
                bd.addContato(c);

                Intent i = new Intent(Cadastro.this, ListaMainActivity.class);
                Cadastro.this.startActivity(i);
                Cadastro.this.finish();

                //Toast.makeText(getApplicationContext(), "Contato salvo!!", Toast.LENGTH_SHORT).show();
            }
        });

        cancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(Cadastro.this, ListaMainActivity.class);
                Cadastro.this.startActivity(inicio);
                Cadastro.this.finish();
            }
        });


    }

}
