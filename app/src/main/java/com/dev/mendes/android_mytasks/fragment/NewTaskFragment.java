package com.dev.mendes.android_mytasks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.dataBase.DataBaseControl;

public class NewTaskFragment extends Fragment {

    public static String taskName, taskDate, taskPlace, taskNote, task;
    public static EditText etTaskName, etTaskPlace, etTaskDate, etTaskNote;

    public NewTaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_task, container, false);

        // Encontra os elementos da tela
        etTaskName = (EditText) view.findViewById(R.id.et_name);
        etTaskPlace = (EditText) view.findViewById(R.id.et_place);
        etTaskDate = (EditText) view.findViewById(R.id.et_date);
        etTaskNote = (EditText) view.findViewById(R.id.et_note);

        // Quando clicar no botao salvar no banco de dados
        Button btnSave = (Button) view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Encontra o banco de dados
                DataBaseControl crud = new DataBaseControl(getContext());

                // Guarda na string o valor digitado no edit text
                taskName = etTaskName.getText().toString();
                taskDate = etTaskDate.getText().toString();
                taskPlace = etTaskPlace.getText().toString();
                taskNote = etTaskNote.getText().toString();

                task = crud.addTask(taskName, taskDate, taskPlace, taskNote);

                Toast.makeText(getContext(), task, Toast.LENGTH_SHORT).show();

                getActivity()
                        .finish();

            }
        });

        return view;
    }

}
