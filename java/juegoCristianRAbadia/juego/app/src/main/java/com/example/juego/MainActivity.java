package com.example.juego;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.juego.R;

import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearLayout;
    int numColumnas;
    int numFilas;
    int numClicks =0;
    int imagenes[] = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4,
            R.drawable.f5, R.drawable.f6, R.drawable.f7, R.drawable.f8};
    HashSet <Integer> posiciones = new HashSet<>();
    ImageButton imageButton1 = null;
    ImageButton imageButton2 = null;

    HashMap  <Integer,Integer> posicionesImagenes = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.generarPosiones();
        this.colocarImagenes();
    }
    public void clickStart(View v) {
        añadeBotones();
    }
    public void generarPosiones(){
        while (this.posiciones.size()<15){
            this.posiciones.add((int)(Math.random()*15));
        }
    }
    public void colocarImagenes(){
        posicionesImagenes.put(0,R.drawable.f1);
        posicionesImagenes.put(1,R.drawable.f2);
        posicionesImagenes.put(2,R.drawable.f3);
        posicionesImagenes.put(3,R.drawable.f4);
        posicionesImagenes.put(4,R.drawable.f5);
        posicionesImagenes.put(5,R.drawable.f6);
        posicionesImagenes.put(6,R.drawable.f7);
    }
    public void añadeBotones() {
        final GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        int numColumnas = gridLayout.getColumnCount();
        int numFilas = gridLayout.getRowCount();
        ImageButton imageButton;
        for (int i = 0; i <8 ; i++) {
            imageButton = new ImageButton(this);
            imageButton.setLayoutParams(new ViewGroup.LayoutParams(linearLayout.getWidth() / numColumnas,
                    linearLayout.getHeight() / numFilas));

            imageButton.setImageResource(imagenes[i]);
            imageButton.setId(i);
            imageButton.setAdjustViewBounds(Boolean.parseBoolean("true"));
            imageButton.setOnClickListener(this);
            gridLayout.addView(imageButton);
        }
        for (int i = 0; i <8 ; i++) {
            imageButton = new ImageButton(this);
            imageButton.setLayoutParams(new ViewGroup.LayoutParams(linearLayout.getWidth() / numColumnas,
                    linearLayout.getHeight() / numFilas));

            imageButton.setImageResource(imagenes[i]);
            imageButton.setId(i);
            imageButton.setAdjustViewBounds(Boolean.parseBoolean("true"));
            imageButton.setOnClickListener(this);
            gridLayout.addView(imageButton);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <gridLayout.getChildCount() ; i++) {
                    View aux = gridLayout.getChildAt(i);
                    if (aux instanceof ImageButton){
                        ImageButton aux2 = (ImageButton) aux;
                        aux2.setImageResource(R.drawable.f0);
                    }
                }
            }
        }, 500);

    }

    public void onClick (View v) {

        numClicks++;
        if (numClicks%2 == 0){
            imageButton1 = (ImageButton) v;
            imageButton1.setImageResource(imagenes[imageButton1.getId()]);
        }
        else {
            imageButton2 = (ImageButton) v;
            imageButton2.setImageResource(imagenes[imageButton2.getId()]);
        }

        if (imageButton1 != null && imageButton2 != null ){
            if(imageButton1.getId() == imageButton2.getId()){
                System.out.println("Imagen1 " + imageButton1.getId() + " imagen2 " + imageButton2.getId());
                imageButton1=null;
                imageButton2=null;
            }
            else{
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (imageButton1 != null && imageButton2 != null){
                            imageButton2.setImageResource(R.drawable.f0);
                            imageButton1.setImageResource(R.drawable.f0);
                        }
                    }
                }, 1000);
            }

        }
    }
}
