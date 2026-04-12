package com.example.mad1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        final EditText et = findViewById(R.id.et_message);
        Button btn = findViewById(R.id.btn_send);

        btn.setOnClickListener(v -> {
            String msg = et.getText().toString();
            Intent intent = new Intent(ExplicitIntentActivity.this, SecondActivity.class);
            intent.putExtra("MSG", msg);
            startActivity(intent);
        });
    }
}