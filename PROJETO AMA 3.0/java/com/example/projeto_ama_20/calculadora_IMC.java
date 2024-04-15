package com.example.projeto_ama_20;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculadora_IMC extends AppCompatActivity {

    private TextView textView_resultadoIMC;

    private EditText editText_peso, editText_altura;

    private Button bt_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        textView_resultadoIMC = findViewById(R.id.textView_resultadoIMC);
        bt_ok = findViewById(R.id.button);
        editText_peso = findViewById(R.id.editText_peso);
        editText_altura = findViewById(R.id.editText_altura);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double peso = Double.parseDouble(editText_peso.getText().toString());
                double altura = Double.parseDouble(editText_altura.getText().toString());
                ;
                double IMC = peso / (altura * altura);

                if (IMC < 18.5) {
                    textView_resultadoIMC.setText(IMC + "\n ATENÇÃO: Você está abaixo do peso!");
                } else if (IMC >= 18.5 && IMC < 25) {
                    textView_resultadoIMC.setText(IMC + "\n PARABÉNS: Você está no peso ideal!");
                } else if (IMC >= 25 && IMC < 30) {
                    textView_resultadoIMC.setText(IMC + "\n CUIDADO: Você está com sobrepeso!");
                } else if (IMC >= 30 && IMC < 35) {
                    textView_resultadoIMC.setText(IMC + "\n ATENÇÃO: Você está com obesidade gral 1");
                } else if (IMC >= 35 && IMC < 40) {
                    textView_resultadoIMC.setText(IMC + "\n ATENÇÃO: Você está com obesidade gral 2");
                } else if (IMC > 40) {
                    textView_resultadoIMC.setText(IMC + "\n ATENÇÃO: Você está com obesidade gral 3");
                }

            }
        });
    }
}