package com.example.practicagraficos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

class DibujosView extends View {
    Paint _brocha1;
    Paint _brocha2;
    Paint _brocha3;
    int verde = 0;
    int y = 0;
    int azul;
    int radio=40;
    boolean inicio=true;

    public DibujosView(Context context) {
        super(context);
        _brocha1 = new Paint();
        _brocha1.setColor(Color.GRAY);
        _brocha1.setStyle(Paint.Style.FILL);
        _brocha2 = new Paint();
        _brocha2.setColor(Color.GREEN);
        _brocha2.setStyle(Paint.Style.FILL);
        _brocha3 = new Paint();
        _brocha3.setColor(Color.BLUE);
        _brocha3.setStyle(Paint.Style.FILL);
    }



    public void onDraw(Canvas c) {
        Paint brocha=_brocha2;
        Paint brocha2 = _brocha3;
        ponerFondo(c);

        if (inicio){
            y=c.getHeight()/2;
            azul=c.getWidth() -radio;
            inicio=false;
        }
        if (verde -radio>c.getWidth()){
            verde =-radio;
        }
        if(azul+radio < 0){
            azul=c.getWidth() -radio;
        }
        c.drawCircle(verde, y, radio,brocha);
        c.drawCircle(azul,y,radio,brocha2);

    }

    public synchronized void moverDerecha(){
        while ((azul > 255 && azul < 775) && (verde < 780 && verde > 255) ){
            try {
                System.out.println("Parando verde " + verde);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        verde++;
        invalidate();
        System.out.println("Verde = " + verde);
        notifyAll();
    }
    public synchronized void moverIzquierda(){
     while ((verde > 255 && verde < 780) && (azul >780 && azul < 790) ){
            try {
                System.out.println("Parando azul  " + azul);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        azul--;
        System.out.println("azul = " + azul);
        invalidate();
        notifyAll();
    }

    void ponerFondo(Canvas c){
        Bitmap bmpOriginal, bmpOriginalEscalado;
        bmpOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        bmpOriginalEscalado = Bitmap.createScaledBitmap(bmpOriginal, c.getWidth(), c.getHeight(), false);
        c.drawBitmap(bmpOriginalEscalado, 0, 0, null);
    }

}
