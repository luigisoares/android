package com.dev.mendes.android_mytasks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.dataBase.Task;


public class TaskDetailFragment extends Fragment {

    private Task mTask;
    private static final String ARG_TASK = "task";
    private TextView tvNameTask, tvPlaceTask, tvNoteTask, tvDateTask;

    public TaskDetailFragment() {
        // Required empty public constructor
    }

    public static TaskDetailFragment newInstance(Task task) {
        TaskDetailFragment fragment = new TaskDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_TASK, task);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mTask = getArguments().getParcelable(ARG_TASK);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_detail, container, false);

        tvNameTask = (TextView) view.findViewById(R.id.tv_name);
        tvDateTask = (TextView) view.findViewById(R.id.tv_date);
        tvPlaceTask = (TextView) view.findViewById(R.id.tv_place);
        tvNoteTask = (TextView) view.findViewById(R.id.tv_note);

        tvNameTask.setText(mTask.getTaskName());
        tvDateTask.setText(mTask.getTaskDate());
        tvPlaceTask.setText(mTask.getTaskPlace());
        tvNoteTask.setText(mTask.getTaskNote());


        return view;
    }


}
