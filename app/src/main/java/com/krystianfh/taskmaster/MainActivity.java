package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    // lines 11 through 14 are auto-generated and shouldn't be touched.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.task1Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task2Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task3Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
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
           Intent goToAllTasksIntent = new Intent(MainActivity.this, AllTasks.class);
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
    public void openSettingsPage(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}