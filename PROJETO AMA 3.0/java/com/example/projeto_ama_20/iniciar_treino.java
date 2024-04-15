package com.example.projeto_ama_20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class iniciar_treino extends AppCompatActivity {
    private TextView tvCountdown;
    private Button startButton;
    private Button pauseButton; // Adicionado
    private Button resetButton;
    private CountDownTimer countDownTimer;
    private boolean isPaused = false; // Flag de pausa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_treino);

        tvCountdown = findViewById(R.id.tvTimer);
        startButton = findViewById(R.id.btnStart);
        pauseButton = findViewById(R.id.btnPause); // Inicializa o botão de pausa
        resetButton = findViewById(R.id.btnReset);

        // Inicialmente, o botão Reset e Pausa são invisíveis
        resetButton.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);

        countDownTimer = new CountDownTimer(600000, 1000) { // 30 segundos
            @Override
            public void onTick(long millisUntilFinished) {
                if (!isPaused) {
                    long seconds = millisUntilFinished / 1000;
                    tvCountdown.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
                }
            }

            @Override
            public void onFinish() {
                resetButton.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.INVISIBLE);
                pauseButton.setVisibility(View.INVISIBLE);
                showAlertDialog("Cronômetro Terminado", "O cronômetro chegou ao fim!");
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
                startButton.setVisibility(View.INVISIBLE);
                pauseButton.setVisibility(View.VISIBLE); // Mostra o botão de pausa
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPaused = !isPaused; // Alterna a flag de pausa
                if (isPaused) {
                    pauseButton.setText("Retomar"); // Muda o texto do botão para "Retomar"
                } else {
                    pauseButton.setText("Pausar"); // Muda o texto do botão de volta para "Pausar"
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                tvCountdown.setText("00:00");
                resetButton.setVisibility(View.INVISIBLE);
                startButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.INVISIBLE); // Oculta o botão de pausa
                isPaused = false; // Redefine a flag de pausa
            }
        });
    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}