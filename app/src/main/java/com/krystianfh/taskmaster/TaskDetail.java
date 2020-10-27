package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

//        TextView taskDetailPageHeader = TaskDetail.this.findViewById(R.id.taskDetailPageHeader);
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
//        String displayTaskTitle = preferences.getString("taskName", "taskDetails");
//        taskDetailPageHeader.setText(displayTaskTitle);

        Intent intent = getIntent();
        System.out.println(intent.getExtras().getString("taskTitle"));
        System.out.println(intent.getExtras().getString("taskDetails"));
        System.out.println(intent.getExtras().getString("taskState"));

        TextView taskTitleTextView = TaskDetail.this.findViewById(R.id.taskDetailPageHeader);
        TextView taskDetailsTextView = TaskDetail.this.findViewById(R.id.taskDescriptionTextView);
        TextView taskStateTextView = TaskDetail.this.findViewById(R.id.taskStatusTextView);

        taskTitleTextView.setText(intent.getExtras().getString("taskTitle"));
        taskDetailsTextView.setText(intent.getExtras().getString("taskDetails"));
        taskStateTextView.setText(intent.getExtras().getString("taskState"));
    }

}