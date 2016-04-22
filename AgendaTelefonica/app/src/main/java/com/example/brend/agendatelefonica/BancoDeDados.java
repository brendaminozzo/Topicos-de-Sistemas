package com.example.brend.agendatelefonica;

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
        String sql = "CREATE TABLE agenda(_id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT, telefone TEXT, imagem INT)";
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
        String sql = "SELECT * FROM agenda where _id = ?";

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        if (cursor != null){
            cursor.moveToFirst();
            Contato contato = new Contato();
            contato.set_id(cursor.getInt(0));
            contato.setNome(cursor.getString(1));
            contato.setTelefone(cursor.getInt(2));
            contato.setImagem(cursor.getInt(3));

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
                contato.set_id(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setTelefone(cursor.getInt(2));
                contato.setImagem(cursor.getInt(3));
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

        return db.update(TABLE_NAME, values,  "_id = ?",
                new String[] { String.valueOf(contato.get_id())});
    }

    //excluindo contato
    public void deleteContato(Contato contato){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "_id = ?", new String[]{String.valueOf(contato.get_id())});
        db.close();
    }

    //obter quantidade de contatos na agenda
    public int getQtdContatos(){
        String qtdQuery = "SELECT * FROM" + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(qtdQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
