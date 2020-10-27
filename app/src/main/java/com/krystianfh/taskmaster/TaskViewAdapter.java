package com.krystianfh.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskViewAdapter extends RecyclerView.Adapter<TaskViewAdapter.TasksRemainingViewHolder> {

    public ArrayList<Task> tasksRemaining;
    public OnInteractWithTasksRemainingListener listener;

    public TaskViewAdapter(ArrayList<Task> tasksRemaining, OnInteractWithTasksRemainingListener listener){
        this.tasksRemaining = tasksRemaining;
        this.listener = listener;
    }

    public static class TasksRemainingViewHolder extends RecyclerView.ViewHolder {

        public Task tasks;
        public View itemView;

        public TasksRemainingViewHolder(@NonNull View itemView){
            super(itemView);
            this.itemView = itemView;
        }

    }

    @NonNull
    @Override
    public TasksRemainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tasks, parent, false);

        TasksRemainingViewHolder viewHolder = new TasksRemainingViewHolder(view);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println(viewHolder.tasks.taskTitle);
                listener.tasksRemainingListener(viewHolder.tasks);
            }
        });
        return viewHolder;
    }

    public static interface OnInteractWithTasksRemainingListener {
        public void tasksRemainingListener(Task task);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksRemainingViewHolder holder, int position){
        holder.tasks = tasksRemaining.get(position);

        TextView taskNameTextView = holder.itemView.findViewById(R.id.taskNameTextView);
        TextView taskDetailsTextView = holder.itemView.findViewById(R.id.taskDetailTextView);
        TextView taskState = holder.itemView.findViewById(R.id.taskStateTextView);
        taskNameTextView.setText(holder.tasks.taskTitle);
        taskDetailsTextView.setText(holder.tasks.taskDetails);
        taskState.setText(holder.tasks.taskState);

    }

    @Override
    public int getItemCount(){
        return tasksRemaining.size();
    }

}
