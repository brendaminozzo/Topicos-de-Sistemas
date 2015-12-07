package com.example.brendaminozzo.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView visor;
    String currentString = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (TextView) findViewById(R.id.tv_visor);
        int[] vetorBotoes = {R.id.bt_0, R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4, R.id.bt_5, R.id.bt_6, R.id.bt_7, R.id.bt_8, R.id.bt_9};
        NumberButtonClickListener numeroClick = new NumberButtonClickListener();
        for (int id:vetorBotoes){
            View v = findViewById(id);
            v.setOnClickListener(numeroClick);
        }
        int[] botoesOperandos = {R.id.bt_adicao, R.id.bt_multiplicacao, R.id.bt_subtracao, R.id.bt_divisao, R.id.bt_igual, R.id.bt_ponto};
        OperandoButtonClickListener op = new OperandoButtonClickListener();
        for (int id:botoesOperandos){
            View v = findViewById(id);
            v.setOnClickListener(op);
        }
        setCurrentString("0");
    }
    class NumberButtonClickListener implements View.OnClickListener {
        @Override public void onClick(View v){
            String texto=(String)((Button)v).getText();
            if (currentString.equals("0")){
                setCurrentString(texto);
            }else{
                setCurrentString(currentString+texto);
            }
        }
    }

    void setCurrentString(String s){
        currentString=s;
        visor.setText(s);
    }

    class OperandoButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.bt_c){
                setCurrentString("0");
            }
        }
    }
}