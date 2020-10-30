package com.krystianfh.taskmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskViewAdapter extends RecyclerView.Adapter<TaskViewAdapter.TasksRemainingViewHolder> {

    public ArrayList<Task> tasksRemaining;
    Context context;
    public OnInteractWithTasksRemainingListener listener;

    public TaskViewAdapter(ArrayList<Task> tasksRemaining, Context context){
        this.tasksRemaining = tasksRemaining;
//        this.listener = listener;
        this.context = context;
    }

    // view holder deals with passing the data from java to the fragment
    public static class TasksRemainingViewHolder extends RecyclerView.ViewHolder {

        public Task tasks;
        public View itemView;
        TextView textViewName,textViewDescription, textViewState;



        public TasksRemainingViewHolder(@NonNull View itemView){
            super(itemView);
            this.itemView = itemView;
            this.textViewName = itemView.findViewById(R.id.textViewTaskName);
            this.textViewDescription = itemView.findViewById(R.id.textViewTaskDescription);
            this.textViewState = itemView.findViewById(R.id.textViewTaskState);
        }

    }

    @NonNull
    @Override // gets called when a fragment pops into existence
    public TasksRemainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_row, parent, false);

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

    @Override // gets called when a fragment has a java class attached to it
    public void onBindViewHolder(@NonNull TasksRemainingViewHolder holder, int position){
        holder.tasks = tasksRemaining.get(position);
        holder.textViewName.setText(tasksRemaining.get(position).taskTitle);
        holder.textViewDescription.setText(tasksRemaining.get(position).taskDetails);
        holder.textViewState.setText(tasksRemaining.get(position).taskState);

//        taskNameTextView.setText(holder.tasks.taskTitle);
//        taskDetailsTextView.setText(holder.tasks.taskDetails);
//        taskState.setText(holder.tasks.taskState);

    }

    @Override // gets called so it knows how many fragments to put on the screen at once
    public int getItemCount(){
        return tasksRemaining.size();
    }

}
