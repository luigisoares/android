package com.dev.mendes.android_mytasks.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dev.mendes.android_mytasks.R;
import com.dev.mendes.android_mytasks.dataBase.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tainaviriato on 21/06/17.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {

    private ArrayList<Task> tasks;
    public Context context;

    public TaskListAdapter(Context context, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout correto
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Recupera os valores da lista na posicao atual
        String name = tasks.get(position).getTaskName();
      //  boolean check = tasks.get(position).getIsChecked();
       // String date = tasks.get(position).getTaskDate();

        //in some cases, it will prevent unwanted situations
        holder.checkBox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkBox.setChecked(tasks.get(position).getIsChecked());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tasks.get(holder.getAdapterPosition()).setChecked(isChecked);
            }
        });

        // Define os valores no item
        holder.nameTask.setText(name);
       // holder.checkBox.setChecked(check);
       // holder.dateTask.setText(date);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    /*
     * Objeto necessario para mapear os componentes do layout do item da lista
     * */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView nameTask, dateTask;
        private CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.nameTask = (TextView) view.findViewById(R.id.tv_task);
            this.dateTask = (TextView) view.findViewById(R.id.tv_date);
            this.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        }
    }

}
