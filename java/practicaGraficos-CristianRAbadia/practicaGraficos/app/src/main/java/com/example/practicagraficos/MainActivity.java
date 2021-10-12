package com.example.practicagraficos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    DibujosView canvas1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvas1 = new DibujosView(this);
        setContentView(canvas1);
        Hilo1 h = new Hilo1(canvas1,true,10);
        Hilo1 h2 = new Hilo1(canvas1,false,10);
        h.start();
        h2.start();


    }
}