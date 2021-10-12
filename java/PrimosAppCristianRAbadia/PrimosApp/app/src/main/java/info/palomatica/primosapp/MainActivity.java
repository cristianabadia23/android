package info.palomatica.primosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button boton;
    TextView texto1;
    EditText texto2;
    EditText campo2;
    TextInputLayout pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.boton = (Button) findViewById(R.id.boton);
        this.texto1 = (TextView) findViewById(R.id.texto1);
        this.pantalla = (TextInputLayout) findViewById(R.id.texto2);
        this.pantalla.setErrorEnabled(true);
        this.texto2 = (EditText) findViewById(R.id.editText3);

    }


    public void errorPantalla(View v){
        int num = Integer.parseInt( String.valueOf(this.texto2.getText()));
        System.out.println(num);
        if (num < 0){
            this.texto2.setText("Numero muy pequeño");
        }
        else if(num > 999999){
            this.texto2.setText("Numero demasiado grande");
        }
        else{
            generarNumero(v,num);
        }
    }
    public void generarNumero(View v,int num){
        NPrimo n = new NPrimo(num);
        this.texto1.setText(String.valueOf(n.generarPrimo()));

    }


}