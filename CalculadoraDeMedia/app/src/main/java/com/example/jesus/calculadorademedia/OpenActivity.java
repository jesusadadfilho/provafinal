package com.example.jesus.calculadorademedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OpenActivity extends AppCompatActivity {

    private EditText nomeEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        setupViews();
    }

    private void setupViews() {
        nomeEdit = findViewById(R.id.editNome);
    }

    public void novaTela(View view) {
        SharedPreferences preferences = getSharedPreferences("calculadora.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userName", nomeEdit.getText().toString());
        editor.commit();
        Intent intent = new Intent(this, CalculoActivity.class);
        startActivity(intent);
        finish();
    }
}
