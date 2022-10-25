package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Clase para la pantalla de pago por servicio
public class PagoServicio extends AppCompatActivity {

    private Button tarjeta;
    private Button efectivo;
    private Button paypal;

    public double obtenMonto(){
        //Se regresa el monto a pagar
        Bundle extras = getIntent().getExtras();
        double monto = extras.getDouble("monto");
        return monto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_servicio);

        //Se registran los botones para las distintas opciones de pago
        tarjeta = (Button) findViewById(R.id.pago_tarjeta);
        efectivo = (Button) findViewById(R.id.pago_efectivo);
        paypal = (Button) findViewById(R.id.pago_paypal);

        final double monto = obtenMonto();

        //Se agregan los eventos para las distintas opciones de pago, pasando el monto en el Intent
        tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.PagoTarjeta");
                intent.putExtra("monto", monto);
                startActivity(intent);
            }
        });
        efectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.PagoEnEfectivo");
                intent.putExtra("monto", monto);
                startActivity(intent);
            }
        });
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.PagoPaypal");
                intent.putExtra("monto", monto);
                startActivity(intent);
            }
        });
    }
}
