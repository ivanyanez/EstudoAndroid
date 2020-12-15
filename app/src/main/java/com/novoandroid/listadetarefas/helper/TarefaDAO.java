package com.novoandroid.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.novoandroid.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements iTarefaDAO{

    private SQLiteDatabase escrever;
    private SQLiteDatabase ler;


    public TarefaDAO(Context applicationContext) {

        DbHelper dbHelper = new DbHelper(applicationContext);
        escrever = dbHelper.getWritableDatabase();
        ler = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            escrever.insert(DbHelper.TABELA_TAREFA,null,cv);
            Log.i("Show","Tabela Salva com sucesso");

        }catch (Exception e){
            Log.i("Erro","Erro ao salvar"+ e.getMessage());
            return  false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
            List<Tarefa> tarefas = new ArrayList<>();
        String sql = " SELECT * FROM " + DbHelper.TABELA_TAREFA + ";";
         Cursor c = ler.rawQuery(sql,null);
            while (c.moveToNext()){

               Long id = c.getLong(c.getColumnIndex("id"));
               String nomeTarefa = c.getString(c.getColumnIndex("nome"));

                Tarefa tarefa = new Tarefa();
                tarefa.setId(id);
                tarefa.setNomeTarefa(nomeTarefa);

                tarefas.add(tarefa);
            }

        return tarefas;
    }


}
