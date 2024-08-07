package com.example.myapplicationprova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaLogin extends AppCompatActivity {

    private EditText editUsuario, editSenha;
    private Button buttonAcessar, buttonCadastro;
    private int very = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editUsuario = findViewById(R.id.editUsuario);
        editSenha = findViewById(R.id.editSenha);
        buttonAcessar = findViewById(R.id.buttonAcessar);
        buttonCadastro = findViewById(R.id.buttonCadastro);

        buttonAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veryEdits();
            }
        });

        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                irTelaCadastro();

            }
        });

    }

    @SuppressLint("ResourceAsColor")
    private void veryEdits() {

        String usuario = editUsuario.getText().toString().trim();
        String senha = editSenha.getText().toString().trim();

        if (usuario.equals("admin") && senha.equals("admin")) {

            irTelaPrincipal();
            very = 0;

        } else {

            very++;
            Log.d("INFO", "very: " + very);

            if (very >= 3) {

                bloqueia();

            } else {

               Toast.makeText(TelaLogin.this, "Usuário/Senha inválidos!", Toast.LENGTH_SHORT).show();
               mudaStroke();

            }


        }

    }

    private void irTelaCadastro() {

        Intent intent = new Intent(TelaLogin.this, TelaCadastro.class);
        startActivity(intent);
        finish();

    }
    private void irTelaPrincipal() {

        Intent intent = new Intent(TelaLogin.this, TelaPrincipal.class);
        startActivity(intent);
        finish();

    }
    private void bloqueia() {

        very = 0;

        Toast.makeText(TelaLogin.this, "Login bloqueado: aguarde 30s!", Toast.LENGTH_SHORT).show();

        editUsuario.setEnabled(false);
        editSenha.setEnabled(false);
        buttonAcessar.setEnabled(false);
        buttonCadastro.setEnabled(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                desbloqueia();

            }
        }, 30000);

    }

    private void desbloqueia() {

        editUsuario.setEnabled(true);
        editSenha.setEnabled(true);
        buttonAcessar.setEnabled(true);
        buttonCadastro.setEnabled(true);

        mudaStroke2();

    }

    private void mudaStroke() {

        GradientDrawable drawable = (GradientDrawable) getDrawable(R.drawable.shape_edittext);
        drawable.setStroke(2, Color.RED);
        editUsuario.setBackground(drawable);
        editSenha.setBackground(drawable);

    }

    private void mudaStroke2() {

        GradientDrawable drawable = (GradientDrawable) getDrawable(R.drawable.shape_edittext);
        drawable.setStroke(2, Color.BLACK);
        editUsuario.setBackground(drawable);
        editSenha.setBackground(drawable);

    }

}