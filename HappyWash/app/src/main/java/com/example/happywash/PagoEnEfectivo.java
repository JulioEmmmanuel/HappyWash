package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//Clase para la pantalla del pago en egectivo
public class PagoEnEfectivo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_en_efectivo);

        FloatingActionButton next = (FloatingActionButton) findViewById(R.id.continua_efectivo);
        TextView cant = (TextView) findViewById(R.id.monto);

        //Se obtiene el monto a pagar y se despliega en pantalla
        Bundle extras = getIntent().getExtras();
        final double monto = extras.getDouble("monto");

        cant.setText("Monto: " + String.format("%.2f", monto));

        //Al hacer click en el botón de continuar se enviará a la pantalla de pedido realizado
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.PedidoRealizado");
                MainActivity.setPa(new Pago(monto, MainActivity.getCliente().getId()));
                startActivity(intent);
            }
        });
    }
}
