package com.example.studente.lovecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText male, female;
    TextView tv;
    String result;
    Intent openPage1;
    SharedPreferences prefs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("preferenze" , Context.MODE_PRIVATE);
    }
    public void showResult(View v)
    {
        SharedPreferences.Editor editor = prefs.edit();
        openPage1 = new Intent(MainActivity.this, Page1.class);      //definisco l'intenzione
        male = (EditText) findViewById(R.id.NomeMaschio);
        female = (EditText) findViewById(R.id.NomeFemmina);
        tv = (TextView) findViewById(R.id.Risultato);
        String f= female.getText().toString();
        String m=male.getText().toString();
        String sum=m+f;
        sum = sum.toLowerCase();
        int value = sum.hashCode();

        Random random = new Random(value);
        result=""+(random.nextInt(100)+1);
        Toast t;
        if(f.equals("") || m.equals(""))
        {
            t= Toast.makeText(MainActivity.this, "Inserisci i campi", Toast.LENGTH_SHORT);
            t.show();
        }
        else
            {
            tv.setText(result);
            if (Integer.parseInt(result) < 30) {
                t = Toast.makeText(MainActivity.this, "Meglio cercare altrove", Toast.LENGTH_SHORT);
                t.show();
            }
            if (Integer.parseInt(result) > 30 && Integer.parseInt(result) < 60) {
                t = Toast.makeText(MainActivity.this, "La speranza è l'ultima a morire...forse...", Toast.LENGTH_SHORT);
                t.show();
            }
            if (Integer.parseInt(result) > 60 && Integer.parseInt(result) < 80) {
                t = Toast.makeText(MainActivity.this, "Ci prova ma non si applica", Toast.LENGTH_SHORT);
                t.show();
            }
            if (Integer.parseInt(result) > 80 && Integer.parseInt(result) < 100) {
                t = Toast.makeText(MainActivity.this, "Un'allineamento di pianeti ti aiuta", Toast.LENGTH_SHORT);
                t.show();
            }
            if (Integer.parseInt(result) == 100) {
                t = Toast.makeText(MainActivity.this, "VOLIAMO A BERLINO BEPPE!!!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        result = result +"%";
        tv.setText(result);
        editor.putString("nome maschio", male.toString());
        editor.putString("nome femmina", female.toString());
        editor.putString("risultato", result);
        editor.commit();
    }

    public void changeGraphic(View vv)
    {
        //passo un parametro
        this.openPage1.putExtra("percentuale", result);
        //attivo l'activity PAge1.java
        startActivity(openPage1);
    }
}
