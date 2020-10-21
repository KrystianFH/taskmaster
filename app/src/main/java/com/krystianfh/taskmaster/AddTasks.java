package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks2);



        Button addATaskButton = AddTasks.this.findViewById(R.id.addATaskButton);
        addATaskButton.setOnClickListener((view) -> {
            EditText title = findViewById(R.id.editTitle);
            System.out.println(title.getText().toString());
            EditText body = findViewById(R.id.editBody);
            System.out.println(body.getText().toString());

            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Submitted";

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();

        });

    }


}