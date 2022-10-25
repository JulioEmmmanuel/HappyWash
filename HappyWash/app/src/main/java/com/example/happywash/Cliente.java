package com.example.happywash;

//C
import java.util.Scanner;

//La clase Cliente es usada para modelar a los usuarios
public class Cliente{

    private String nombres;
    private String apellidos;
    private int id;
    private String email;
    private String celular;
    private String genero;
    private static int currId = 0;
    private String direccion;

    public Cliente(String nombres, String apellidos, String email, String celular, String genero, String direccion){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
        this.genero = genero;
        this.id = currId;
        currId += 1;
    }

    public Cliente(){
        this.nombres = "";
        this.apellidos = "";
        this.email = "";
        this.celular = "";
        this.direccion = "";
        this.genero = "";
        this.id = currId;
        currId += 1;
    }

    public String getNombres(){
        return nombres;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCelular(){
        return celular;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}
