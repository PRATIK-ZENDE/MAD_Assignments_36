package com.example.mad1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    String filename = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        et = findViewById(R.id.et_storage_text);
        tv = findViewById(R.id.tv_storage_display);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnRead = findViewById(R.id.btn_read);

        btnSave.setOnClickListener(v -> {
            try {
                FileOutputStream fOut = openFileOutput(filename, MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fOut);
                osw.write(et.getText().toString());
                osw.close();
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                et.setText("");
            } catch (Exception e) { e.printStackTrace(); }
        });

        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fIn = openFileInput(filename);
                InputStreamReader isr = new InputStreamReader(fIn);
                char[] inputBuffer = new char[100];
                int charRead;
                String s = "";
                while ((charRead = isr.read(inputBuffer)) > 0) {
                    s += String.copyValueOf(inputBuffer, 0, charRead);
                }
                tv.setText(s);
            } catch (Exception e) { e.printStackTrace(); }
        });
    }
}