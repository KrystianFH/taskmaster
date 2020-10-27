package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskViewAdapter.OnInteractWithTasksRemainingListener{
    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView myTasksHeader = findViewById(R.id.myTasksHeader);
        String savedUsernameGreeting = String.format("%s's tasks", preferences.getString("savedUsername", "My Tasks"));
        myTasksHeader.setText(savedUsernameGreeting);
        SharedPreferences.Editor preferenceEditor = preferences.edit();

        ArrayList<Task> exampleTasks = new ArrayList<Task>();

        Task first = new Task ("first task", "first task details", "new");
        Task second = new Task ("second task", "second task details", "assigned");
        Task third = new Task ("third task", "third task details", "completed");

        exampleTasks.add(first);
        exampleTasks.add(second);
        exampleTasks.add(third);

        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TaskViewAdapter(exampleTasks, this));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor preferenceEditor = preferences.edit();

        findViewById(R.id.task1Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            Button task1Button = findViewById(R.id.task1Button);
//            preferenceEditor.putString("taskName", task1Button.getText().toString());
//            preferenceEditor.apply();

            gotoDetailsPageIntent.putExtra("taskTitle", task1Button.getText().toString());
            gotoDetailsPageIntent.putExtra("body", task1Button.getText().toString());
            gotoDetailsPageIntent.putExtra("state", task1Button.getText().toString());
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task2Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            Button task2Button = findViewById(R.id.task2Button);
//            preferenceEditor.putString("taskName", task2Button.getText().toString());
//            preferenceEditor.apply();

            gotoDetailsPageIntent.putExtra("taskTitle", task2Button.getText().toString());
            gotoDetailsPageIntent.putExtra("body", task2Button.getText().toString());
            gotoDetailsPageIntent.putExtra("state", task2Button.getText().toString());
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task3Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            Button task3Button = findViewById(R.id.task3Button);
//            preferenceEditor.putString("taskName", task3Button.getText().toString());
//            preferenceEditor.apply();

            gotoDetailsPageIntent.putExtra("taskTitle", task3Button.getText().toString());
            gotoDetailsPageIntent.putExtra("body", task3Button.getText().toString());
            gotoDetailsPageIntent.putExtra("state", task3Button.getText().toString());
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        Button goToAddTasksPageButton = MainActivity.this.findViewById(R.id.addTasksButton);
        goToAddTasksPageButton.setOnClickListener((view) -> {
            System.out.println("going to add tasks page");

            Intent goToAddTasksIntent = new Intent(MainActivity.this, AddTasks.class);
            MainActivity.this.startActivity(goToAddTasksIntent);

        });

        Button goToAllTasksPageButton = MainActivity.this.findViewById(R.id.allTasksButton);
        goToAllTasksPageButton.setOnClickListener((view) -> {
           Intent goToAllTasksIntent = new Intent(MainActivity.this, recyclerViewGeneric.class);
           MainActivity.this.startActivity(goToAllTasksIntent);
        });

        ImageButton goToSettingsButton = findViewById(R.id.goToSettingsPageButton);
        goToSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });
    }

    public void tasksRemainingListener(Task task){
        Intent intent = new Intent(MainActivity.this, TaskDetail.class);
        intent.putExtra("taskTitle", task.taskTitle);
        intent.putExtra("taskDetails", task.taskDetails);
        intent.putExtra("taskState", task.taskState);
        this.startActivity(intent);
    }


    public void openSettingsPage(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}