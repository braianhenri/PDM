package com.example.aula;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
        });

        EditText addNome = findViewById(R.id.nomeAdd);
        Button nomeaddbutao = findViewById(R.id.buttonNomeAdd);
        nomes = new ArrayList<>();

        ListView listanomes = findViewById(R.id.listinha);
        ArrayAdapter<String> adapto = new ArrayAdapter<>(this, R.layout.item_lista, R.id.textView, nomes);
        listanomes.setAdapter(adapto);

        nomeaddbutao.setOnClickListener(view -> {
            String texto = addNome.getText().toString().trim();
            if (!texto.isEmpty()) {
                nomes.add(texto);
                adapto.notifyDataSetChanged();
                addNome.setText("");
            }
        });

        listanomes.setOnItemClickListener((adapterView, view, i, l) ->
                Toast.makeText(getApplicationContext(), nomes.get(i), Toast.LENGTH_LONG).show()
        );
    }
}