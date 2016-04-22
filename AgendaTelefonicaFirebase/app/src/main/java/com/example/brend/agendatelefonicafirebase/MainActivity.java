package com.example.brend.agendatelefonicafirebase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.FirebaseListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private BancoDeDados bd;
    private Firebase firebase;

    @Bind(R.id.lista)
    ListView listView;

    private List<Contato> contatos = new ArrayList<Contato>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bd = new BancoDeDados(getBaseContext());
        ButterKnife.bind(this);
        firebase = FirebaseAgenda.getFirebase();
    }

    @OnClick(R.id.fab)
    public void onFabCad(View view) {
        Intent i = new Intent(getBaseContext(), Atualiza.class);
        startActivity(i);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Firebase mFirebase = firebase.child("contato");
        FirebaseListAdapter<Contato> adapter =
                new FirebaseListAdapter<Contato>(this, Contato.class, R.layout.activity_lista, mFirebase) {
                    @Override
                    protected void populateView(View view, Contato contato, int i) {
                        ViewHolder holder;
                        holder = new ViewHolder(view);
                        holder.nome.setText(contato.getNome());
                        holder.telefone.setText(contato.getTelefone());
                        String url = contato.getImagem();
                        if (url != null) {
                            Bitmap imagemFoto = BitmapFactory.decodeFile(url);
                            holder.imagem.setImageBitmap(imagemFoto);
                            holder.imagem.setTag(url);
                        }
                    }
                };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("men", "update" + contatos.get(position).getNome());
                Intent i = new Intent(getBaseContext(), Atualiza.class);
                i.putExtra("contato", contatos.get(position));
                startActivity(i);
            }
        });

        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    contatos.add(data.getValue(Contato.class));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    static class ViewHolder {
        @Bind(R.id.text_view_nome_contato)
        TextView nome;
        @Bind(R.id.text_view_telefone)
        TextView telefone;
        @Bind(R.id.imagem_contato)
        ImageView imagem;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
