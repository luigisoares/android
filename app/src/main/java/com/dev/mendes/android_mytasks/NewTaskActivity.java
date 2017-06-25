package com.dev.mendes.android_mytasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.mendes.android_mytasks.dataBase.DataBaseControl;

public class NewTaskActivity extends AppCompatActivity {

        public static String taskName, taskDate, taskPlace, taskNote, task;
        public static EditText etTaskName, etTaskPlace, etTaskDate, etTaskNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        getSupportActionBar().hide();

        // Encontra os elementos da tela
         etTaskName = (EditText) findViewById(R.id.et_name);
         etTaskPlace = (EditText) findViewById(R.id.et_place);
         etTaskDate = (EditText) findViewById(R.id.et_date);
         etTaskNote = (EditText) findViewById(R.id.et_note);

        // Quando clicar no botao salvar no banco de dados
        Button btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Encontra o banco de dados
                DataBaseControl crud = new DataBaseControl(getBaseContext());

                // Guarda na string o valor digitado no edit text
                taskName = etTaskName.getText().toString();
                taskDate = etTaskDate.getText().toString();
                taskPlace = etTaskPlace.getText().toString();
                taskNote = etTaskNote.getText().toString();

                task = crud.addTask(taskName,taskDate,taskPlace,taskNote);

                Toast.makeText(getApplicationContext(), task, Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
