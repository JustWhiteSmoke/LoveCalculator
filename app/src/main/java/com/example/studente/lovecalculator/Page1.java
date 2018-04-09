package com.example.studente.lovecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Filippo on 04/03/2018.
 */

public class Page1 extends Activity {
    CheckBox[] cb;
    boolean checked;
    Integer x;
    String s = "";

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        cb[0] = (CheckBox) findViewById(R.id.CB1);
        cb[1] = (CheckBox) findViewById(R.id.CB2);
        cb[2] = (CheckBox) findViewById(R.id.CB3);
        cb[3] = (CheckBox) findViewById(R.id.CB4);
        cb[4] = (CheckBox) findViewById(R.id.CB5);
        cb[5] = (CheckBox) findViewById(R.id.CB6);

        do
        {
            if(cb[x].isChecked())
               s = s + cb[x].getText().toString()+ " ,";
            x++;
        }while(x<6);
    }

    public void stampa()
    {
        Toast t;
        t = Toast.makeText(Page1.this, "Hai fatto " + getIntent().getExtras().getString("percentuale") + "e lo/a vuoi " + s + "\nC R E D I C I", Toast.LENGTH_LONG);
    }
}
