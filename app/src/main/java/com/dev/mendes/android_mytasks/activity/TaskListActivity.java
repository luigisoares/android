package com.dev.mendes.android_mytasks.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.fragment.TaskListFragment;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        // Esconde a action bar
        getSupportActionBar().hide();

        // Inclui o fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new TaskListFragment())
                .commit();


    }
}
