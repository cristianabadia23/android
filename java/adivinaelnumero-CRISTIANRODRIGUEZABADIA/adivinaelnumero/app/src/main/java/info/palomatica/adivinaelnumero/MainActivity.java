package info.palomatica.adivinaelnumero;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button boton1,boton2;
    TextView titulo,verificador,intentos;
    EditText cajaTexto;
    int aleatorio,cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.boton1 = (Button) findViewById(R.id.comprobar);
        this.boton2 = (Button) findViewById(R.id.generarNumero);
        this.titulo = (TextView) findViewById(R.id.titulo);
        this.verificador = (TextView) findViewById(R.id.verificador);
        this.intentos = (TextView) findViewById(R.id.intentos);
        this.cajaTexto = (EditText) findViewById(R.id.cajaTexto);
        this.generarNumero();

    }
    public void limpiarcontador(View v){
        this.cont=0;
        android.content.res.Resources res = getResources();
        String numPulsados;
        numPulsados = res.getQuantityString(R.plurals.numPulsaciones, cont,cont);
        this.intentos.setText(numPulsados);
    }
    public void generarNumero(){
        this.aleatorio = (int) (Math.random()*100)+1;
    }
    public void generarNumero(View v){
        this.aleatorio = (int) (Math.random()*100)+1;
        limpiarcontador(v);
    }

    public void intantarAdivinar(View v){
        this.cont++;
        if (Integer.parseInt(String.valueOf(cajaTexto.getText())) == aleatorio){
            verificador.setText("Has ganado\nPulsa en generar numero");
            generarNumero();
        }
        else if (Integer.parseInt(String.valueOf(cajaTexto.getText())) < aleatorio){
            verificador.setText("Muy pequeño");
        }
        else {
            verificador.setText("Demasiado grande");
        }
        System.out.println(aleatorio);
        android.content.res.Resources res = getResources();
        String numPulsados;
        numPulsados = res.getQuantityString(R.plurals.numPulsaciones, cont,cont);
        this.intentos.setText(numPulsados);
    }
}