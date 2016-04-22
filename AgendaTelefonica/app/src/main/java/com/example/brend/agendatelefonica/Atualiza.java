package com.example.brend.agendatelefonica;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Brenda on 25/02/2016.
 */
public class Atualiza extends AppCompatActivity {

    @Bind(R.id.imagem)ImageView imagem;
    @Bind(R.id.edtNome)EditText nome;
    @Bind(R.id.edtValor)EditText telefone;
    @Bind(R.id.bt_cancelAtualiza)Button cancelar;
    @Bind(R.id.bt_excluirContato)Button delete;

    BancoDeDados bd;
    int id = -1;
    Contato c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bd = new BancoDeDados(getBaseContext());

        Bundle b = getIntent().getExtras();
        if(b!=null){
            c = (Contato) b.get("contato");
            id = c.get_id();
            updateUI(c);
        }

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Contato c = new Contato();
                c.set_id(id);
                c.setNome(nome.getText().toString());
                c.setTelefone(Integer.parseInt(telefone.getText().toString()));
                c.setImagem(R.drawable.jack);
                bd.atualizarContatos(c);

                Intent i = new Intent(Atualiza.this, ListaMainActivity.class);
                Atualiza.this.startActivity(i);
                Atualiza.this.finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Atualiza.this, ListaMainActivity.class);
                Atualiza.this.startActivity(i);
                Atualiza.this.finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bd.deleteContato(c);
                Intent i = new Intent(Atualiza.this, ListaMainActivity.class);
                Atualiza.this.startActivity(i);
                Atualiza.this.finish();
            }
        });

    }

    public void updateUI(Contato c){
        if(c==null){
            nome.setText(null);
            telefone.setText(null);
            imagem.setImageResource(R.drawable.jack);
        }else{
            nome.setText(c.getNome());
            telefone.setText(String.valueOf(c.getTelefone()));
            imagem.setImageResource(c.getImagem());
        }
    }
}
