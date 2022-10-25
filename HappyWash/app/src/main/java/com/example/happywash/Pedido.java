package com.example.happywash;

import com.example.happywash.Lavanderia;
import com.example.happywash.Producto;

import java.util.ArrayList;
import java.util.Scanner;

//Clase para el registro de los pedidos
public class Pedido {
    private int id;
    private int userId;
    private ArrayList<Producto> productos;
    private double subtotal;
    private int lavId;
    private static int currId = 0;

    public Pedido(){
        subtotal = 0;
        productos = new ArrayList<Producto>();
        id = currId;
        userId = 0;
        currId += 1;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getSubtotal(){
        return subtotal;
    }

    public void setSubtotal(double subtotal){
        this.subtotal = Math.round(subtotal);
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getLavId(){
        return lavId;
    }

    public void setLavId(int lavId){
        this.lavId = lavId;
    }


    public void agregarProducto(Producto p){
        //Se agrega un producto a la lista de productos
        if(p.getCantidad() > 0) {
            productos.add(p);
        }
    }

    public void calcularSubtotal(){
        //Se calcula el subtotal para el pedido
        float suma = 0;
        for(Producto p: productos) {
            suma += p.getCostoUnitario()*p.getCantidad();
        }
        subtotal = suma;
    }

    public double calcularIva(){
        //Se regresa el iva del pedidp
        return subtotal * 0.16;
    }

    public double calcularTotal(){
        //Se regresa el precio total del pedido
        return subtotal + calcularIva();
    }

    public ArrayList<String> hazDescripciones(){
        //Se regresa una descripción de cada producto como un ArrayList de String
        ArrayList<String> descriptions = new ArrayList<String>();
        for(Producto p: productos){
            descriptions.add(p.getNombre() + "  " + p.getCantidad() + "  $" + String.format("%.2f", p.getCostoUnitario()*p.getCantidad()));
        }
        return descriptions;
    }


}
