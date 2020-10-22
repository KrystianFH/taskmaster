package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView taskDetailPageHeader = TaskDetail.this.findViewById(R.id.taskDetailPageHeader);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String displayTaskTitle = preferences.getString("taskName", "taskDetails");
        taskDetailPageHeader.setText(displayTaskTitle);
    }

}