package com.dev.mendes.android_mytasks.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.dataBase.Task;
import com.dev.mendes.android_mytasks.fragment.TaskDetailFragment;

public class TaskDetailActivity extends AppCompatActivity {

    public static String EXTRA_TASK = "task";
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        task = getIntent().getExtras().getParcelable(EXTRA_TASK);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Troca para o fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, TaskDetailFragment.newInstance(task))
                .commit();
    }

    // Retorna para tela principal
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
