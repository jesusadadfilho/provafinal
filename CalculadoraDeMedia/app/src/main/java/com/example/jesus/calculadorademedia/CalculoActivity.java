package com.example.jesus.calculadorademedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculoActivity extends AppCompatActivity {

    private EditText nota1, nota2;
    TextView situacao;
    int peso1, peso2;
    Float nota;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        setupViews();
        SharedPreferences preferences = getSharedPreferences("calculadora.file", MODE_PRIVATE);
        usuario = preferences.getString("userName","niguem");
        Intent intent = getIntent();
        peso1 = intent.getIntExtra("peso1",-1);
        peso2 = intent.getIntExtra("peso2",-1);
        if(peso1 != -1){
            nota = ((preferences.getFloat("nota1", 0) * peso1) + (preferences.getFloat("nota2", 0) * peso2))/ (peso1+peso2);
            if(nota >= 7){
                situacao.setText("Parabens " + usuario+  " aprovado com " + nota);
            }else if(nota >= 4){
                situacao.setText("Continue tentando " + usuario+  " em prova final com " + nota);
            }else {
                situacao.setText("Infelizmente " + usuario+ " reprovado com " + nota);
            }
        }
    }

    private void setupViews() {
       nota1 = findViewById(R.id.editNota);
       nota2 = findViewById(R.id.notaEdit);
       situacao = findViewById(R.id.situacao);
    }

    public void situacaoView(View view) {
        try{
            SharedPreferences preferences = getSharedPreferences("calculadora.file", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat("nota1", Float.valueOf(nota1.getText().toString()));
            editor.putFloat("nota2", Float.valueOf(nota2.getText().toString()));
            editor.apply();
            Intent intent = new Intent(this, ResultActivity.class);
            startActivity(intent);
            finish();
        }catch (IllegalArgumentException e){
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show();
        }
    }
}
