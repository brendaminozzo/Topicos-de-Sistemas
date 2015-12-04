package com.example.brendaminozzo.lanchonete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by Brenda Minozzo on 03/12/2015.
 */
public class ListaLanches_Adapter extends ArrayAdapter<Lanches> {

    private Context context;
    private List<Lanches> lanches = null;

    public ListaLanches_Adapter(Context context, List<Lanches> lanches) {
        super(context,0, lanches);
        this.lanches = lanches;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Lanches lanche = lanches.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_lista, null);

        ImageView imagemLanche = (ImageView) view.findViewById(R.id.imagem_lanche);
        imagemLanche.setImageResource(lanche.getImagem());

        TextView tv_nomeLanche = (TextView) view.findViewById(R.id.text_view_nome_lanche);
        tv_nomeLanche.setText(lanche.getNome());

        TextView tv_preco = (TextView)view.findViewById(R.id.text_view_precoLanche);
        BigDecimal preco = new BigDecimal(lanche.getValor());
        preco = preco.setScale(2, RoundingMode.HALF_UP);
        String textoPreco = String.valueOf(preco+"");
        tv_preco.setText("R$ "+textoPreco);

        return view;
    }

}
