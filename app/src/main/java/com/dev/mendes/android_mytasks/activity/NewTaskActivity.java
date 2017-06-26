package com.dev.mendes.android_mytasks.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.fragment.NewTaskFragment;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        getSupportActionBar().hide();

        // Troca para o fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new NewTaskFragment())
                .commit();
    }

}
