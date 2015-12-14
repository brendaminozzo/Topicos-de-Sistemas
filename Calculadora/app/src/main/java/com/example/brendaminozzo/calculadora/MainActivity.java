package com.example.brendaminozzo.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
    TextView visor;
    Button zero, um, dois, tres, quatro, cinco, seis, sete, oito, nove, ponto, subtracao, soma, divisao, multiplicacao, igual, limpar;
    boolean primeiro = true;
    double anterior, proximo;
    String operador = null;
    Calculos c = new Calculos();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (TextView) findViewById(R.id.tv_visor);
        zero = (Button) findViewById(R.id.bt_0);
        um = (Button) findViewById(R.id.bt_1);
        dois = (Button) findViewById(R.id.bt_2);
        tres = (Button) findViewById(R.id.bt_3);
        quatro = (Button) findViewById(R.id.bt_4);
        cinco = (Button) findViewById(R.id.bt_5);
        seis = (Button) findViewById(R.id.bt_6);
        sete = (Button) findViewById(R.id.bt_7);
        oito = (Button) findViewById(R.id.bt_8);
        nove = (Button) findViewById(R.id.bt_9);
        ponto = (Button) findViewById(R.id.bt_ponto);
        subtracao = (Button) findViewById(R.id.bt_subtracao);
        soma = (Button) findViewById(R.id.bt_adicao);
        divisao = (Button) findViewById(R.id.bt_divisao);
        multiplicacao = (Button) findViewById(R.id.bt_multiplicacao);
        igual = (Button) findViewById(R.id.bt_igual);
        limpar = (Button) findViewById(R.id.bt_c);



        igual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operador != null){
                    proximo = Double.parseDouble(visor.getText().toString());
                    visor.setText(c.calculo(anterior, operador, proximo));
                }
            }
        });

        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"0");
            }
        });

        um.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"1");
            }
        });

        dois.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"2");
            }
        });

        tres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"3");
            }
        });

        quatro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"4");
            }
        });

        cinco.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"5");
            }
        });

        seis.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"6");
            }
        });

        sete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"7");
            }
        });

        oito.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"8");
            }
        });

        nove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primeiro){
                    visor.setText("");
                    primeiro = false;
                }
                visor.setText(visor.getText()+"9");
            }
        });

        ponto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(visor.getText().toString().contains("."))){
                    if (primeiro){
                        primeiro = false;
                    }
                    visor.setText(visor.getText()+".");
                }
            }
        });

        limpar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiro = true;
                visor.setText("0");
                operador = null;
                anterior = 0.0;
                proximo = 0.0;
            }
        });

        soma.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiro = true;
                anterior = Double.parseDouble(visor.getText().toString());
                operador = "+";
            }
        });

        subtracao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiro = true;
                anterior = Double.parseDouble(visor.getText().toString());
                operador = "-";
            }
        });

        divisao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiro = true;
                anterior = Double.parseDouble(visor.getText().toString());
                operador = "/";
            }
        });

        multiplicacao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiro = true;
                anterior = Double.parseDouble(visor.getText().toString());
                operador = "*";
            }
        });
    }
}

