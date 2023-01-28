package com.example.comunicacidadao;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity {
    Button bMenuCriarChamado, bMenuConsultarChamados, bMenuConsultarMeusChamados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bMenuCriarChamado = findViewById(R.id.bMenuCriarChamado);
        bMenuConsultarChamados = findViewById(R.id.bMenuConsultarChamados);
        bMenuConsultarMeusChamados = findViewById(R.id.bMenuConsultarMeusChamados);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bMenuCriarChamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent
                Intent it = new Intent(MenuActivity.this, CriarChamadoActivity.class);
                startActivity(it);
            }
        });

        bMenuConsultarChamados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent
            }
        });


        bMenuConsultarMeusChamados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent
            }
        });



    }

}
