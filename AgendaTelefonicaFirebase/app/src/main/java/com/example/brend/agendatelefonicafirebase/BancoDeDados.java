package com.example.brend.agendatelefonicafirebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brenda on 18/02/2016.
 */
public class BancoDeDados extends SQLiteOpenHelper {
    //versão do BD
    public static final int DATABASE_VERSION = 1;

    //nome do BD
    public static final String DATABASE_NAME = "Agenda";

    //nome da tabela
    public static final String TABLE_NAME = "agenda";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE agenda(id TEXT PRIMARY KEY,nome TEXT, telefone TEXT, imagem TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS agenda";
        db.execSQL(sql);
        onCreate(db);
    }
    //adicionando contato
    public void addContato(Contato contato){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", contato.getId());
        values.put("nome", contato.getNome());
        values.put("telefone", contato.getTelefone());
        values.put("imagem", contato.getImagem());

        //inserindo valor na tabela
        db.insert(TABLE_NAME, null, values);

        //fechando conexão
        db.close();
    }

    //retornando um unico contato
    public Contato getContato(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM agenda where id = ?";

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        if (cursor != null){
            cursor.moveToFirst();
            Contato contato = new Contato();
            contato.setId(cursor.getString(0));
            contato.setNome(cursor.getString(1));
            contato.setTelefone(cursor.getString(2));
            contato.setImagem(cursor.getString(3));

            return contato;
        }
        return null;
    }

    //listando todos os contatos
    public List<Contato> getTodosContatos(){
        List<Contato> contatos = new ArrayList<Contato>();
        String sql = "SELECT * FROM agenda";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do{
                Contato contato = new Contato();
                contato.setId(cursor.getString(0));
                contato.setNome(cursor.getString(1));
                contato.setTelefone(cursor.getString(2));
                contato.setImagem(cursor.getString(3));
                contatos.add(contato);
            }while (cursor.moveToNext());
        }
        return contatos;
    }

    //editando contatos
    public int atualizarContatos(Contato contato){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("telefone", contato.getTelefone());
        values.put("imagem", contato.getImagem());

        return db.update(TABLE_NAME, values,  "id = ?",
                new String[] { contato.getId()});
    }

    //excluindo contato
    public void deleteContato(Contato contato){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[]{contato.getId()});
        db.close();
    }

}
