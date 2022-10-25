package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//La clase Carrito es para el fucionamiento de la pantalla del carrito de compra
public class Carrito extends AppCompatActivity {

    private Button pago;

    public Producto creaProductos(String nombre, int cant){
        //crea y regresa un producto p, para el nombre indicado
        Producto p;
        if(nombre.equals("Suéter")){
            p = new Producto("Suéter", 55.00, "Tintorería", cant);
        } else if(nombre.equals("Vestido")){
            p = new Producto("Vestido", 40.00, "Tintorería", cant);
        } else if(nombre.equals("Traje")){
            p = new Producto("Traje", 60.00, "Tintorería", cant);
        } else if(nombre.equals("Pantalón")){
            p = new Producto("Pantalón", 35.00, "Tintorería", cant);
        } else if(nombre.equals("Bolsa grande")){
            p = new Producto("Bolsa grande", 150.00, "Lavado", cant);
        } else if(nombre.equals("Bolsa chica")){
            p = new Producto("Bolsa chica", 90.00, "Lavado", cant);
        } else {
            p = new Producto();
            Log.println(Log.ERROR, "error", "El producto " + nombre + " no está disponible");
        }
        return p;
    }

    public int encuentraIdLavanderia(){
        //regresa el id de la lavandería seleccionada
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("idLav");
        return id;
    }

    public Pedido armaPedido(){
        //Crea y regresa un pedido, tomando las cantidades indicadas en la pantalla de orden
        Pedido pe = new Pedido();
        Bundle extras = getIntent().getExtras();
        int[] cantidades = extras.getIntArray("valores");
        String[] nombres = extras.getStringArray("nombres");
        for(int i = 0; i<cantidades.length; i++){
            pe.agregarProducto(creaProductos(nombres[i], cantidades[i]));
        }
        pe.setUserId(MainActivity.getCliente().getId());
        pe.setLavId(encuentraIdLavanderia());
        MainActivity.setPe(pe);
        return pe;
    }

    public void cargaPedido(){
        //Carga los datos del pedido en la pantalla, incluyendo aquellos relacionados con el precio
        Pedido pe = armaPedido();
        ArrayList<String> productos = pe.hazDescripciones();

        //Usando un ArrayAdapter se agregan los elementos del pedido a un ListView
        ListView lv = (ListView) findViewById(R.id.lista_compra);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos);
        lv.setAdapter(arrayAdapter);

        TextView subtotal = (TextView) findViewById(R.id.subtotal);
        TextView iva = (TextView) findViewById(R.id.iva);
        TextView total = (TextView) findViewById(R.id.total);
        pe.calcularSubtotal();

        subtotal.setText("Subtotal: " + String.format("%.2f", pe.getSubtotal()));
        iva.setText("IVA: " + String.format("%.2f", pe.calcularIva()));
        total.setText("Total: " + String.format("%.2f", pe.calcularTotal()));
    }

    public void cargaLavanderia(){
        // Se carga en pantalla los datos de la lavandería seleccionada
        int id = encuentraIdLavanderia();
        Lavanderia seleccion = new Lavanderia();
        for(Lavanderia lav: MainActivity.getLavanderias()){
            if(id == lav.getId()){
                seleccion = lav;
                break;
            }
        }
        TextView nombre = (TextView) findViewById(R.id.dato_nombre_lav);
        TextView direccion = (TextView) findViewById(R.id.dato_direccion_lav);
        TextView horario = (TextView) findViewById(R.id.dato_horario_lav);
        nombre.setText("Nombre:" + seleccion.getNombre());
        direccion.setText("Dirección:" + seleccion.getDireccion());
        horario.setText("Horario:" + seleccion.getHorario());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compra);
        //se cargan los datos en pantalla
        cargaPedido();
        cargaLavanderia();

        pago = (Button) findViewById(R.id.pagar);

        //Se agrega un evento al botón de pago para pasar al pago, añadiendo el monto en el Intent
        pago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.happywash", "com.example.happywash.PagoServicio");
                TextView total = (TextView) findViewById(R.id.total);
                String t = total.getText().toString();
                t = t.substring(7);
                intent.putExtra("monto",  Double.parseDouble(t));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        cargaPedido();
        cargaLavanderia();
    }

}
