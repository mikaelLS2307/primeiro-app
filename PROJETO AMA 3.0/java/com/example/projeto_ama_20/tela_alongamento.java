package com.example.projeto_ama_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_alongamento extends AppCompatActivity implements View.OnClickListener {

    Button btvoltainicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alongamento);

        btvoltainicial= (Button) findViewById(R.id.btvoltainicial);
        btvoltainicial.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btvoltainicial) {
            Intent intencao = new Intent(this, tela_principal.class);
            startActivity(intencao);
        }
    }
}