package com.example.myapplicationprova;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaCadastro extends AppCompatActivity {

    private Button buttonCancelar, buttonCadastrar;
    private ImageView imageSetaVoltar;
    private EditText editCadastroNome, editCadastroEmail, editCadastroSenha, editCadastroConfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        editCadastroNome = findViewById(R.id.editCadastroNome);
        editCadastroEmail = findViewById(R.id.editCadastroEmail);
        editCadastroSenha = findViewById(R.id.editCadastroSenha);
        editCadastroConfirma = findViewById(R.id.editCadastroConfirma);
        imageSetaVoltar = findViewById(R.id.imageSetaVoltar);

        imageSetaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                irTelaLogin();

            }
        });
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popConfirma();

            }
        });
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                veryCampos();

            }
        });

    }

    private void irTelaLogin() {

        Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(intent);
        finish();

    }
    private void popConfirma() {

        AlertDialog.Builder pop = new AlertDialog.Builder(TelaCadastro.this);
        pop.setTitle("Confirmação");
        pop.setMessage("Tem certeza que quer cancelar a operação?");
        pop.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                irTelaLogin();

            }
        });

        pop.setNegativeButton("NÂO", null);
        pop.create().show();

    }
    private void veryCampos() {

        String nome = editCadastroNome.getText().toString().trim();
        String[] divide = nome.split(" ");

        if (divide.length < 2) {

            Log.d("ERROR", "Error");

        } else {

            Log.d("SUCESSO", "Sucesso");
            String email = editCadastroEmail.getText().toString().trim();

            if (!email.isEmpty()) {

                if (email.contains("@")) {



                }

            }

        }


    }

}