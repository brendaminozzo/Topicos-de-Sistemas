package com.example.brend.agendatelefonicafirebase;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.Firebase;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Brenda on 25/02/2016.
 */
public class Atualiza extends AppCompatActivity {

    private Firebase firebase;
    BancoDeDados bd;

    @Bind(R.id.imagem)
    ImageView imvImagem;
    @Bind(R.id.edtValor)
    EditText edttel;
    @Bind(R.id.edtNome)
    EditText edtNome;
    @Bind(R.id.fabDel)
    FloatingActionButton fbDell;

    private boolean update = false;

    private Contato contato;

    private String localFoto;

    private static final int FOTO = 1;

    private boolean fotoResource = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza);
        ButterKnife.bind(this);

        bd = new BancoDeDados(getBaseContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebase = FirebaseAgenda.getFirebase();
        updateUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        contato = new Contato();
        Bundle b = getIntent().getExtras();

        if (b != null) {
            contato = (Contato) b.get("contato");
            update = true;
            fbDell.setVisibility(View.VISIBLE);
            updateUI();
            localFoto = contato.getImagem();
        }
    }

    @OnClick(R.id.fabDel)
    public void fabDel(View view) {
        firebase.child("contato").child(contato.getId()).removeValue();
        bd.deleteContato(contato);
        finish();
    }


    @OnClick(R.id.fabCad)
    public void fabcad(View v) {
        Firebase posRef = firebase.child("contato");

        Firebase newPost;
        contato.setNome(edtNome.getText().toString());
        contato.setTelefone(edttel.getText().toString());
        contato.setImagem((String) imvImagem.getTag());

        if (update) {
            newPost = posRef.child(contato.getId());
            bd.atualizarContatos(contato);
        } else {
            newPost = posRef.push();
            contato.setId(newPost.getKey());
            bd.addContato(contato);
        }
        newPost.setValue(contato);


        finish();
    }


    public void updateUI() {
        if (contato == null) {
            edtNome.setText(null);
            edttel.setText(null);
        } else {
            edtNome.setText(contato.getNome());
            setFoto(contato.getImagem());
            edttel.setText(contato.getTelefone());
        }
    }


    public void carregaFoto() {
        fotoResource = true;
        localFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(localFoto)));

        startActivityForResult(intentCamera, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FOTO) {
            if (resultCode == Activity.RESULT_OK) {
                setFoto(localFoto);
            } else {
                this.localFoto = null;
            }
        }
    }

    private void setFoto(String url) {
        if (url != null) {
            Bitmap imagemFoto = BitmapFactory.decodeFile(url);
            imvImagem.setImageBitmap(imagemFoto);
            imvImagem.setTag(url);
        }
    }

    @OnClick(R.id.fabFhoto)
    public void foto(View v) {
        carregaFoto();
    }
}
