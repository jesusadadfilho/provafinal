package com.example.jesus.calculadorademedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    SharedPreferences preferences;
    EditText peso1, peso2;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        preferences = getSharedPreferences("reader.file", MODE_PRIVATE);
        setupViews();
    }

    private void setupViews() {
        peso1 = findViewById(R.id.pesoEdit1);
        peso2 = findViewById(R.id.pesoEdit2);
    }

    public void mostrarSituacao(View view) {
        try{
            int p1 = Integer.valueOf(peso1.getText().toString());
            int p2 = Integer.valueOf(peso2.getText().toString());
            Intent intent = new Intent(this, CalculoActivity.class);
            intent.putExtra("peso1", p1);
            intent.putExtra("peso2", p2);
            startActivity(intent);
            finish();
        }catch (IllegalArgumentException e){
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show();
        }
    }
}
