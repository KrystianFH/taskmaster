package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myTasks = MainActivity.this.findViewById(R.id.mytasks);
        myTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button addTasks = MainActivity.this.findViewById(R.id.add_tasks);
        addTasks.setOnClickListener((view) -> {
            System.out.println("go to add tasks");
        });
    }
}