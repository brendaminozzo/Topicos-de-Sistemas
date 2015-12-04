package com.example.brendaminozzo.lanchonete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Brenda Minozzo on 03/12/2015.
 */
public class Listagem_detalhesLanche extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);

        Intent i = getIntent();
        Lanches l = (Lanches) i.getSerializableExtra("lanchinho");


        TextView listaIngred = (TextView) findViewById(R.id.tv_listaIngredientes);

        TextView precoLanche = (TextView) findViewById(R.id.tv_listaPreco);

        BigDecimal preco = new BigDecimal(l.getValor());
        preco = preco.setScale(2, RoundingMode.HALF_UP);
        String textoPreco = String.valueOf(preco+"");
        listaIngred.setText(l.getIngredientes());
        precoLanche.setText("R$ "+textoPreco);
    }
}
