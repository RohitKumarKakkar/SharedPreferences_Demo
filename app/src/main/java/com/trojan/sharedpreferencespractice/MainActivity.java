package com.trojan.sharedpreferencespractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText msgBox;
    Button btnSave, btnRead;
    TextView tvMsg;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgBox = findViewById(R.id.msgBox);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        tvMsg=findViewById(R.id.tvMsg);

        sharedPreferences = getSharedPreferences(getPackageName() + "." + TAG, MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = msgBox.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("KEY",msg);
                editor.commit();

            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvMsg.setText(sharedPreferences.getString("KEY","String"));

            }
        });

    }
}
