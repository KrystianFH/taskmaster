package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton saveUsernameButton = Settings.this.findViewById(R.id.saveSettingsButton);
        saveUsernameButton.setOnClickListener((view) -> {
            EditText username = findViewById(R.id.editUsername);
            System.out.println(username.getText().toString());

            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Username Saved";

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();

        });
    }
}