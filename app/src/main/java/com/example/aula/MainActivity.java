package com.example.aula;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ArrayList<String> nomes;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });inte
        TextView addNome = findViewById(R.id.layout.item_lista.nomeAdd);
        Button nomeaddbutao = findViewById(R.id.buttonNomeAdd);
        nomes = new ArrayList<String>();
        nomeaddbutao.setOnClickListener(view ->{
            nomes.add(addNome.getText().toString());
        });
        ListView listanomes = findViewById(R.id.listinha);
        ArrayAdapter<String> adapto = new ArrayAdapter<>(getApplicationContext(), R.layout.item_lista, R.id.textView, nomes);
        listanomes.setAdapter(adapto);
        listanomes.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(),nomes.get(i), Toast.LENGTH_LONG).show();
        });


    }
}