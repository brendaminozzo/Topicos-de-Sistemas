package com.example.brend.agendatelefonica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brenda on 18/02/2016.
 */
public class Lista extends ArrayAdapter<Contato>  {
    private Context context;
    private List<Contato> contatos = null;

    public Lista(Context context, List<Contato> contatos) {
        super(context,0, contatos);
        this.contatos = contatos;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Contato contato = contatos.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.activity_lista, null);

        ImageView imagemContato = (ImageView) view.findViewById(R.id.imagem_contato);
        imagemContato.setImageResource(contato.getImagem());

        TextView tv_nomeContato = (TextView) view.findViewById(R.id.text_view_nome_contato);
        tv_nomeContato.setText(contato.getNome());

        TextView tv_telefone = (TextView)view.findViewById(R.id.text_view_telefone);
        String fone = String.valueOf(contato.getTelefone()+"");
        tv_telefone.setText("Tel: "+fone);

        return view;
    }
}
