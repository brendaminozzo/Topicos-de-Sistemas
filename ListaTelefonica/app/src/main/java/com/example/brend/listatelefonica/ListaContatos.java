package com.example.brend.listatelefonica;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 26/01/2016.
 */
public class ListaContatos extends Activity{

    BancoDeDados b;
    List<Contato> contatos = new ArrayList<Contato>();
    ListView listinha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        listinha = (ListView) findViewById(R.id.minha_lista);

        b = new BancoDeDados(getBaseContext());

        contatos = b.getTodosContatos();

        final lista listaAdapter = new lista(this,contatos);
        listinha.setAdapter(listaAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato c = new Contato();
                c.setNome("Jack Sparrow");
                c.setTelefone(1111111);
                c.setImagem(R.drawable.jack);
                b.addContato(c);

                //contatos.add(c);
                //contatos = b.getTodosContatos();


                //lista l = new lista(getApplicationContext(), contatos);
                //listinha.setAdapter(l);

                atualizaLista();
            }
        });

        listinha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contatos.get(position).setImagem(R.drawable.angelina);
                b.atualizarContatos(contatos.get(position));

                atualizaLista();
            }
        });

    }

    private void atualizaLista(){
        contatos = b.getTodosContatos();

        final lista l = new lista(this, contatos);
        listinha.setAdapter(l);
    }

}
