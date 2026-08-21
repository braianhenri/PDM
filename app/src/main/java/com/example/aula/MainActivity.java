package com.example.aula;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText edmin = findViewById(R.id.edmin);
        EditText edmax = findViewById(R.id.edmax);
        Button butao= findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView);


        butao.setOnClickListener(view -> {
            int min = Integer.parseInt(edmin.getText().toString());
            Random random = new Random();
            int valor= random.nextInt(min,max);
            tv.setText(Integer.toString(valor));
        });

    }
}