package com.novoandroid.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;
import com.novoandroid.listadetarefas.R;
import com.novoandroid.listadetarefas.helper.TarefaDAO;
import com.novoandroid.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){
            case R.id.itemSalvar :
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
               String nomedaTarefa = editTarefa.getText().toString();
                if(!nomedaTarefa.isEmpty()) {

                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomedaTarefa);
                    tarefaDAO.salvar(tarefa);
                    finish();
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
