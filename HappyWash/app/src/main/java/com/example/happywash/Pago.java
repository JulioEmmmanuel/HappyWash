package com.example.happywash;

//Clase para modelar el Pago
public class Pago {
    private int id;
    private double monto;
    private int userId;
    private static int currId = 0;


    public Pago(){
        monto = 0;
        userId = 0;
        id = currId;
        currId += 1;
    }

    public Pago(double monto, int userId){
        this.monto = monto;
        this.userId = userId;
        id = currId;
        currId += 1;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public double getMonto(){
        return monto;
    }
    public void setMonto(double monto){
        this.monto = monto;
    }

    public int getUserId(){ return userId;}
    public void setUserId(int userId){
        this.userId = userId;
    }

}
