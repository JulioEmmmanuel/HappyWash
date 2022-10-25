package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

//Clase para la pantalla de selección de lavanderías
public class SeleccionLavanderias extends AppCompatActivity {

    private ListView lv;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_lavanderia);

        context=this;

        //Se obtienen los datos de las lavanderías y sus imágenes
        int [] imagenes={R.drawable.lav1, R.drawable.lav2, R.drawable.lav3};
        ArrayList <Lavanderia> lavanderias = MainActivity.getLavanderias();
        Lavanderia [] lavs={lavanderias.get(0),lavanderias.get(1), lavanderias.get(2)};

        //Se agregan las tarjetas para cada lavandería
        lv=(ListView) findViewById(R.id.lista_lavanderias);
        lv.setAdapter(new CustomAdapter(this, lavs, imagenes));

    }
}
