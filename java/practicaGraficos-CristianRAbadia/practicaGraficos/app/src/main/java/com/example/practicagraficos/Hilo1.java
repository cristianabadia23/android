package com.example.practicagraficos;

public class Hilo1 extends Thread {
    DibujosView canvas;
    boolean direccion;
    int tiempo;
    public Hilo1(DibujosView canvas,boolean direccion,int tiempo) {
        this.canvas = canvas;
        this.direccion=direccion;
        this.tiempo = tiempo;
    }
    public void run() {
        while (true){
            if (this.direccion){
                canvas.moverDerecha();
            }
            else{
                canvas.moverIzquierda();
            }
            try {

                sleep(this.tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}