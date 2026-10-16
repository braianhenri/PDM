package com.example.aula;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    int id;
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
        EditText AddTexto = findViewById(R.id.addlist);
        Button butao = findViewById(R.id.idADD);
        ListView listinha = findViewById(R.id.listinha);
        butao.setOnClickListener(view -> {
            String texto = AddTexto.getText().toString();
            ContentValues values = new ContentValues();
            values.put("titulo", texto);
            database.insert("notas", null, values);
            id++;
            AddTexto.setText("");
            if(id>0){
                Toast.makeText(this.getApplicationContext(), "Nota Salva com sucesso", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Erro ao salvar nota", Toast.LENGTH_SHORT).show();
            }
        });
        database = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR)");

    }
}