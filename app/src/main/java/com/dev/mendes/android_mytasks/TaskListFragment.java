package com.dev.mendes.android_mytasks;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dev.mendes.android_mytasks.adapter.TaskListAdapter;
import com.dev.mendes.android_mytasks.dataBase.DataBaseControl;
import com.dev.mendes.android_mytasks.dataBase.DataBaseTask;
import com.dev.mendes.android_mytasks.dataBase.Task;

import java.util.ArrayList;


public class TaskListFragment extends Fragment {


    private ArrayList<Task> tasks = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Infla o layout correto
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        DataBaseControl crud = new DataBaseControl(getContext());
        Cursor cursor = crud.loadTasks();




        // Busca a RV da tela e define seu layout
        RecyclerView listaTarefas = (RecyclerView) view.findViewById(R.id.rv);
        listaTarefas.setLayoutManager(new LinearLayoutManager(getContext()));

        // Define o adapter da RV
        adapter = new TaskListAdapter(getContext(), tasks);
        listaTarefas.setAdapter(adapter);

        // Seta o layout da lista se vazia
        LinearLayout layoutEmpty = (LinearLayout) view.findViewById(R.id.layout_empty);
        if(tasks.size() == 0){
            layoutEmpty.setVisibility(View.VISIBLE);
        } else {
            layoutEmpty.setVisibility(View.GONE);
        }


        return view;
    }



}
