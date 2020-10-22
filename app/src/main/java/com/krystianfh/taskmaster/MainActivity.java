package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        TextView myTasksHeader = findViewById(R.id.myTasksHeader);
        String savedUsernameGreeting = String.format("%s's tasks", preferences.getString("savedUsername", "My Tasks"));
        myTasksHeader.setText(savedUsernameGreeting);
        SharedPreferences.Editor preferenceEditor = preferences.edit();
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
            preferenceEditor.putString("taskName", task1Button.getText().toString());
            preferenceEditor.apply();
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task2Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            Button task2Button = findViewById(R.id.task2Button);
            preferenceEditor.putString("taskName", task2Button.getText().toString());
            preferenceEditor.apply();
            MainActivity.this.startActivity(gotoDetailsPageIntent);
        });

        findViewById(R.id.task3Button).setOnClickListener((view) -> {
            Intent gotoDetailsPageIntent = new Intent(MainActivity.this, TaskDetail.class);
            Button task3Button = findViewById(R.id.task3Button);
            preferenceEditor.putString("taskName", task3Button.getText().toString());
            preferenceEditor.apply();
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