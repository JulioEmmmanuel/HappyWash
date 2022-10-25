package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//Clase para la pantalla de pedido realizado
public class PedidoRealizado extends AppCompatActivity {
    private ImageButton home;
    private ImageButton user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_realizado);
        //Se registran los botones
        home = findViewById(R.id.home);
        user = findViewById(R.id.user);
        //Se agregan los eventos para regresar al menú de inicio y al perfil del usuarip
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.Perfil");
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.Menu");
                startActivity(intent);
            }
        });
    }
}
