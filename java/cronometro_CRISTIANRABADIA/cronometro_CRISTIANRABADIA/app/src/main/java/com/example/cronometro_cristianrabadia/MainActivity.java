package com.example.cronometro_cristianrabadia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    TextView cronometro;
    Button boton1,boton2,boton3;
    String patronCronometro;
    Thread t;
    Boolean isContado;
    long milisegundos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.cronometro =(TextView) findViewById(R.id.cronometro);
        this.boton1= (Button) findViewById(R.id.start);
        this.boton2 = (Button) findViewById(R.id.stop);
        this.boton3 = (Button) findViewById(R.id.reboot);
        this.patronCronometro = "%02d:%02d:%02d";
    }

    public void iniciar(View v){
        if (this.t == null){
            this.t = new Thread(this);
            this.t.start();
        }
        this.boton1.setVisibility(View.INVISIBLE);
        this.boton2.setVisibility(View.VISIBLE);
        this.isContado=true;
        this.milisegundos1=System.currentTimeMillis();
    }

    public void parar(View v){
        this.boton2.setVisibility(View.INVISIBLE);
        this.boton1.setVisibility(View.VISIBLE);
        this.isContado=false;
        this.t=null;
    }


    @Override
    public void run() {
        while (this.isContado) {
            long segundos = ((System.currentTimeMillis() - this.milisegundos1) / 1000)%60;
            long minutos = ((System.currentTimeMillis() - this.milisegundos1) / (1000 * 60))%60;
            long horas = (System.currentTimeMillis() - this.milisegundos1) / (1000 * 60 * 60);
            System.out.println(horas +" " + minutos + " " + segundos);
            this.cronometro.setText(String.format(this.patronCronometro, horas, minutos, segundos));

        }
    }
}