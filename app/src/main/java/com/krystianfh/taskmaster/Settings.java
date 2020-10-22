package com.krystianfh.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor preferenceEditor = preferences.edit();

        ImageButton saveUsernameButton = Settings.this.findViewById(R.id.saveSettingsButton);
        saveUsernameButton.setOnClickListener((view) -> {
            EditText username = findViewById(R.id.editUsername);
            preferenceEditor.putString("savedUsername", username.getText().toString());
            preferenceEditor.apply();
            System.out.println(username.getText().toString());

            int duration = Toast.LENGTH_SHORT;
            CharSequence text = "Username Saved";

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();

        });
    }
}