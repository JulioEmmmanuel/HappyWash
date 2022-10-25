package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//Clase para la pantalla del menú
public class Menu extends AppCompatActivity {
    private ImageButton home;
    private ImageButton user;
    private Button ordenar;

    //Se asignan los botones de la pantalla a variables mediante sus ids
    public void asignaBotones(){
        home = findViewById(R.id.home);
        user = findViewById(R.id.user);
        ordenar = findViewById(R.id.button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        asignaBotones();

        //Se  agregan los eventos para ir a la pantalla de perfil y de selección de lavandería de acuerdo al botón pulsado
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.Perfil");
                startActivity(intent);
            }
        });
        ordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.SeleccionLavanderias");
                startActivity(intent);
            }
        });

    }
}
