package com.example.hector.prueba2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadPref extends AppCompatActivity {


    private TextView dia;
    private TextView hora;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_pref);

        //Identificamos los componentes
        dia = (EditText) findViewById(R.id.dia);
        hora = (EditText) findViewById(R.id.hora);
        volver = (Button) findViewById(R.id.btnVolver);

        //Funcionalidad del boton
        volver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Guardamos las preferencias
                guardarPref();

                //Cambiar activity
                cambioActivity();
            }

        });
    }

    private void guardarPref() {

        SharedPreferences sharedPref = getSharedPreferences("asd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("dia", dia.getText().toString());
        editor.putString("hora", hora.getText().toString());
        editor.commit();
        System.out.print("He guardado als preferencias");

    }

    private void cambioActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
