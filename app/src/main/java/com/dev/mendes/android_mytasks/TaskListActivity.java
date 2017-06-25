package com.dev.mendes.android_mytasks;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.mendes.android_mytasks.adapter.TaskListAdapter;
import com.dev.mendes.android_mytasks.dataBase.DataBaseControl;
import com.dev.mendes.android_mytasks.dataBase.DataBaseTask;
import com.dev.mendes.android_mytasks.dataBase.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        // Esconde a action bar
        getSupportActionBar().hide();

        FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskListActivity.this, NewTaskActivity.class);
                startActivity(intent);

            }
        });



    }
}
