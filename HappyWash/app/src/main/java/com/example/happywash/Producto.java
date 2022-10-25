package com.example.happywash;

//Clase para modelar  los productos
public class Producto {
    private String nombre;
    private double costoUnitario;
    private String servicio;
    private int cantidad;

    Producto(String nombre, double costoUnitario, String servicio, int cantidad){
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    Producto(){
        this.nombre = "";
        this.costoUnitario = 0;
        this.servicio = "";
        this.cantidad = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio(){
        return servicio;
    }

    public void setServicio(String servicio){
        this.servicio = servicio;
    }

    public double getCostoUnitario(){
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario){
        this.costoUnitario = costoUnitario;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void agregarUno(){
        // Se agrega un producto a la cantidad
        this.cantidad += 1;
    }

    public void quitarUno(){
        //Se quita un producto de la cantidad
        this.cantidad -= 1;
    }

    public void quitarTodos(){
        //Se quitan todos los productos de la cantidad
        this.cantidad = 0;
    }

}
