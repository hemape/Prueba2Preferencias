package com.example.hector.prueba2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String dia;
    private String hora;
    private Button guardar;
    private Button mostrar;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (TextView) findViewById(R.id.mensaje);
        guardar = (Button) findViewById(R.id.btnGuardar);
        mostrar = (Button) findViewById(R.id.btnMostrar);

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Cambiar activity
                cambioActivity();
            }

        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Recupera preferencias
                recuperaPref();

                //Compone mensaje
               String mensaje = componerMensaje();

                //Mostrar mensaje
                message.setText(mensaje);

            }

        });
    }

    private void recuperaPref() {
        SharedPreferences sharedPref = getSharedPreferences("asd", Context.MODE_PRIVATE);
        dia = sharedPref.getString("dia", "-------");
        hora = sharedPref.getString("hora", "-------");



    }
    private String componerMensaje() {
        String mensaje = "Hola, la ultima toma de medicacion fue el dia "+dia+" a la hora "+hora;

        return mensaje;

    }


    private void cambioActivity() {
        Intent intent = new Intent(this, ActividadPref.class);
        startActivity(intent);
    }
}
