package com.example.brend.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Brenda on 12/11/2015.
 */
public class Aplicacao extends AppCompatActivity {
    TextView boasVindas;
    Button sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicacao);
        Intent i = getIntent();
        String nome = i.getStringExtra("user");
        boasVindas = (TextView) findViewById(R.id.tvBoasVindas);
        boasVindas.setText(boasVindas.getText()+" "+nome);

        sair = (Button) findViewById(R.id.bt_sair);

        sair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sairAplicacao = new Intent(Aplicacao.this, Login.class);
                Aplicacao.this.startActivity(sairAplicacao);
                Aplicacao.this.finish();
            }
        });
    }


}
