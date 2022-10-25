package com.example.happywash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

//Clase para la pantalla del perfil de usuario
public class Perfil extends AppCompatActivity {
    private ImageButton home;

    public void muestraDatos(Cliente c1){
        //Se muestran en pantalla los datos del usuario
        TextView nombres = findViewById(R.id.nombre);
        nombres.setText("Nombres: " + c1.getNombres() + " " + c1.getApellidos());

        TextView email = findViewById(R.id.email);
        email.setText("Email: " + c1.getEmail());

        TextView celular = findViewById(R.id.celular);
        celular.setText("Celular: " + c1.getCelular());

        TextView genero = findViewById(R.id.genero);
        genero.setText("Genero: " + c1.getGenero());

        TextView direccion = findViewById(R.id.direccion);
        direccion.setText("Direccion: " + c1.getDireccion());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        muestraDatos(MainActivity.getCliente());

        home = findViewById(R.id.home);

        //Se agrega el evento para llevar a la pantalla del menú
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
