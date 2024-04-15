package com.example.projeto_ama_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_treino extends AppCompatActivity implements View.OnClickListener {

    Button btvoltainicial,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_treino);

        btvoltainicial= (Button) findViewById(R.id.btvoltainicial);
        button= (Button) findViewById(R.id.button);

        btvoltainicial.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btvoltainicial){
            Intent intencao = new Intent(this, tela_principal.class);
            startActivity(intencao);
        }else {
            if (view.getId()==R.id.button){
                Intent intencao2 = new Intent(this, iniciar_treino.class);
                startActivity(intencao2);
            }
        }
    }

}