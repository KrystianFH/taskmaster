package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // lines 11 through 14 are auto-generated and shouldn't be touched.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}