package com.novoandroid.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static String NOME_DB = "DB_TAREFAS";
    public static int VERSION = 1;
    public static String TABELA_TAREFA = "tarefas";



    public DbHelper(Context context) {
        super(context, NOME_DB, null , VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFA
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " nome TEXT NOT NULL);" ;

        try {
            db.execSQL(sql);
            Log.i("info DB","Sucesso ao criar tabela");


        }catch (Exception e){
            Log.i("info DB","Erro ao Criar Tabela"+ e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String  sql = "DROP TABLE IF EXISTS " + TABELA_TAREFA + ";";


        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("info DB","Sucesso ao atualizar app");


        }catch (Exception e){
            Log.i("info DB","Erro ao Atualizar app"+ e.getMessage());
        }

    }
}
