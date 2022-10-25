package com.example.happywash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

// La clase MainActivity es utilizada para la pantalla de inicio
// En este caso se guarda en esta el cliente, lavanderías disponibles, pedido y pago de la sesión, para su acceso mediante otras pantallas
// En un caso real, estos datos se guardarían en cambio en una base de datos

public class MainActivity extends AppCompatActivity {
    private Button comenzar;

    private static Cliente c1 = new Cliente();
    private static ArrayList<Lavanderia> lavanderias = new ArrayList<Lavanderia>();
    private static Pedido pe = new Pedido();
    private static Pago pa = new Pago();

    public static void setCliente(){
        c1.setNombres("Julio Emmanuel");
        c1.setApellidos("Meza Rangel");
        c1.setEmail("juliomeza2510@outlook.com");
        c1.setCelular("+52 444-574-0360");
        c1.setGenero("Maculino");
        c1.setDireccion("2a Privada de San Martín");
    }

    public static Cliente getCliente(){
        return c1;
    }

    public static void setLavanderias(){
        Lavanderia lav1 = new Lavanderia("Princess", "Garza Sada #1552", "Lunes a viernes \n 12:00 a.m. a 7:00 p.m.", 1);
        Lavanderia lav2 = new Lavanderia("Washaholic", "Damián Carmona #113", "Lunes a jueves \n 11:00 a.m. a 8:00 p.m.", 2);
        Lavanderia lav3 = new Lavanderia("Skip the wash", "Av. Las Flores #212", "Lunes a domingo \n 12:00 a.m. a 5:00 p.m.", 3);
        lavanderias.add(lav1);
        lavanderias.add(lav2);
        lavanderias.add(lav3);
    }

    public static ArrayList<Lavanderia> getLavanderias(){
        return lavanderias;
    }

    public static void setPe(Pedido p1){
        pe = p1;
    }

    public static Pedido getP(Pedido pe){
        return MainActivity.pe;
    }

    public static void setPa(Pago pag){
        pa = pag;
    }

    public static Pago getPa(){
        return pa;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se inicializa el cliente y las lavanderías disponibles
        setCliente();
        setLavanderias();

        comenzar = findViewById(R.id.buttoncomenzar);
        // Se agrega  el evento para ir al menú al pulsar el botón comenzar
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.Menu");
                startActivity(intent);
            }
        });
    }
}
