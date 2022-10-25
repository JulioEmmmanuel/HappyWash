package com.example.happywash;

//La clase Lavanderia es utilizada para modelar los establecimientos
public class Lavanderia {
    private String nombre;
    private String direccion;
    private String horario;
    private int id;

    public Lavanderia(){
        this.nombre = "";
        this.direccion = "";
        this.horario = "";
        this.id= 0;
    }

    public Lavanderia(String nombre, String direccion, String horario, int id){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.id= id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getHorario(){
        return horario;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
