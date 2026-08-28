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
import java.util.Random.*;

import kotlin.random.URandomKt;

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

        
        Button butao = findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView);
        butao.setOnClickListener(view -> {
            EditText txtMin = findViewById(R.id.edmin);
            EditText txtMax = findViewById(R.id.edmax);
            String smin = txtMin.getText().toString();
            if (smin.trim().equals("")){
                txtMin.setError("informe um valor bobão");
                txtMin.requestFocus();
            }


            Random random = new Random();
            int min;
            min = Integer.parseInt(txtMin.getText().toString());
            int max;
            max = Integer.parseInt(txtMax.getText().toString());
            int r = (random.nextInt( max - min)) + min;
            tv.setText(Integer.toString(r));
        });


    }
}