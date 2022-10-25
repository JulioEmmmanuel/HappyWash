package com.example.happywash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//La clase Orden es empleada para la pantalla en que se realiza la orden
public class Orden extends AppCompatActivity {

    private FloatingActionButton continuar1;
    private FloatingActionButton continuar2;
    // se guarda el número de productos seleccionadas para verificar que no sea 0 al querer cambiar de pantalla
    private int numProductos = 0;

    public int leeValor(TextView numValue){
        //Se regresa como entero el valor de un elemento de texto
        String text = numValue.getText().toString();
        int cant = Integer.parseInt(text);
        return cant;
    }

    public void modificarValor(TextView numValue, boolean crece){
        //Se modifica el valor de la cantidad de un producto
        //Se debe indicar si el valor debería crecer o no
        int cant = leeValor(numValue);
        if(crece){
            //Si la cantidad es menor a 99 se aumentará el valor
            if(cant < 99) {
                numProductos += 1;
                cant += 1;
                numValue.setText(Integer.toString(cant));
            }
        } else {
            //Si la cantidad es mayor que 0 se disminuirá el valor
            if(cant > 0) {
                numProductos -= 1;
                cant -= 1;
                numValue.setText(Integer.toString(cant));
            }
        }
    }


    public int[] armaOrden(){
        //Se arma la orden como un arreglo de enteros con las cantidades de cada producto
        int[] cantidades = new int[6];
        TextView cantSueter = findViewById(R.id.cant_sueter);
        cantidades[0] = leeValor(cantSueter);
        TextView cantVestido = findViewById(R.id.cant_vestido);
        cantidades[1] = leeValor(cantVestido);
        TextView cantTraje = findViewById(R.id.cant_traje);
        cantidades[2] = leeValor(cantTraje);
        TextView cantPantalon = findViewById(R.id.cant_pantalon);
        cantidades[3] = leeValor(cantPantalon);
        TextView cantBolsaG = findViewById(R.id.cant_bolsagrande);
        cantidades[4] = leeValor(cantBolsaG);
        TextView cantBolsaS = findViewById(R.id.cant_bolsachica);
        cantidades[5] = leeValor(cantBolsaS);
        return cantidades;
    }

    public int encuentraIdLavanderia(){
        //Se regresa el id de la lavandería seleccionada
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id");
        return id;
    }

    public void activaContador(Button menos, Button mas, final TextView valor){
        //Se activa el contador para un elemento
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { modificarValor(valor, false);
            }
        });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarValor(valor, true);
            }
        });
    }

    public void activaTodosLosContadores(){
        //Se activan todos los contadores
        Button menosSueter = findViewById(R.id.menos_sueter);
        Button masSueter = findViewById(R.id.mas_sueter);
        final TextView cantSueter = findViewById(R.id.cant_sueter);
        activaContador(menosSueter, masSueter, cantSueter);

        Button menosPantalon = findViewById(R.id.menos_pantalon);
        Button masPantalon = findViewById(R.id.mas_pantalon);
        final TextView cantPantalon = findViewById(R.id.cant_pantalon);
        activaContador(menosPantalon, masPantalon, cantPantalon);


        Button menosVestido = findViewById(R.id.menos_vestido);
        Button masVestido = findViewById(R.id.mas_vestido);
        final TextView cantVestido = findViewById(R.id.cant_vestido);
        activaContador(menosVestido, masVestido, cantVestido);

        Button menosTraje = findViewById(R.id.menos_traje);
        Button masTraje = findViewById(R.id.mas_traje);
        final TextView cantTraje = findViewById(R.id.cant_traje);
        activaContador(menosTraje, masTraje, cantTraje);

        Button menosBolsaG = findViewById(R.id.menos_bolsagrande);
        Button masBolsaG = findViewById(R.id.mas_bolsagrande);
        final TextView cantBolsaG = findViewById(R.id.cant_bolsagrande);
        activaContador(menosBolsaG, masBolsaG, cantBolsaG);

        Button menosBolsaS = findViewById(R.id.menos_bolsachica);
        Button masBolsaS = findViewById(R.id.mas_bolsachica);
        final TextView cantBolsaS = findViewById(R.id.cant_bolsachica);
        activaContador(menosBolsaS, masBolsaS, cantBolsaS);
    }

    public void muestraAlerta(){
        //Se muestra una alerta indicando que hay que selccionar un servicio para continuar
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Debes seleccionar al menos un servicio para poder continuar");
        dialog.setTitle("¡Atención!");
        dialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

       activaTodosLosContadores();

        continuar1 = findViewById(R.id.continuar);
        continuar2 = findViewById(R.id.continuar2);

        final String articulos[] = {"Suéter", "Vestido", "Traje", "Pantalón", "Bolsa grande", "Bolsa chica"};

        // al hacer click en los botones, si no se han seleccionado productos se muestra una alerta
        // si hay productos seleccionados se pasa al carrito de compra, enviando la información de los productos
        //seleccionados con sus cantidades y la lavandería seleccionada
        continuar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numProductos > 0) {
                    int cantidades[] = armaOrden();
                    Intent intent = new Intent();
                    intent.setClassName("com.example.happywash", "com.example.happywash.Carrito");
                    intent.putExtra("nombres", articulos);
                    intent.putExtra("valores", cantidades);
                    intent.putExtra("idLav", encuentraIdLavanderia());
                    startActivity(intent);
                } else {
                    muestraAlerta();
                }
            }
        });
        continuar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numProductos > 0) {
                    int cantidades[] = armaOrden();
                    Intent intent = new Intent();
                    intent.setClassName("com.example.happywash", "com.example.happywash.Carrito");
                    intent.putExtra("nombres", articulos);
                    intent.putExtra("valores", cantidades);
                    intent.putExtra("idLav", encuentraIdLavanderia());
                    startActivity(intent);
                } else {
                    muestraAlerta();
                }
            }
        });



    }
}
