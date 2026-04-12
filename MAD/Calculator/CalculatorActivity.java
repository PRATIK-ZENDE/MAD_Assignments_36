package com.example.mad1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        et1 = findViewById(R.id.et_num1);
        et2 = findViewById(R.id.et_num2);
        tvResult = findViewById(R.id.tv_result);

        findViewById(R.id.btn_add).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.btn_sub).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.btn_mul).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.btn_div).setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char op) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Enter numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res = 0;
        switch (op) {
            case '+': res = n1 + n2; break;
            case '-': res = n1 - n2; break;
            case '*': res = n1 * n2; break;
            case '/': res = n1 / n2; break;
        }
        tvResult.setText("Result: " + res);
    }
}