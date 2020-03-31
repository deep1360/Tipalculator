package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
import java.util.Locale;

public class calcuatetip extends AppCompatActivity {

    Button b1,b2,sub,add;
    EditText bill1;
    TextView ttip,tbill;


  int tippercent=0;
  double billintial=100.00;
  double tipout=0;
  double totalout=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcuatetip);

     b1=findViewById(R.id.calculate11)  ;

        b2=findViewById(R.id.button11)  ;
        sub=findViewById(R.id.buttonsub);
        add=findViewById(R.id.buttonadd);
        bill1=findViewById(R.id.bill);

        ttip=findViewById(R.id.textview3);
        tbill=findViewById(R.id.textView5);


sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (tippercent>0)
        {
            tippercent--;
            ttip.setText(tippercent + "0");
        }

    }
});

add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

            tippercent++;
            ttip.setText(tippercent + "0");
    }
});







     b1.setOnClickListener(new View.OnClickListener()
    {
    @Override
    public void onClick(View v)
    {

        String  bills=bill1.getText().toString();
        if (!bills.equals(""))
        {
            billintial=Double.valueOf(bills);
            billintial=billintial*100;
            billintial=Math.round(billintial);
            billintial=billintial/100;
            bill1.setText(String.format(Locale.getDefault(),"0.2f",billintial));

            tipout= (billintial*tippercent)/100;
            tipout=tipout*100;
            tipout=Math.round(tipout);
            tipout=tipout/100;


            ttip.setText(String.format(Locale.getDefault(),"0.2f",tipout));


            totalout=billintial +  tipout ;

            tbill.setText(String.format(Locale.getDefault(),"0.2f",totalout));

        }
        Intent i=new Intent(calcuatetip.this,calcuatetip.class);
        startActivity(i);


    }
});


     b2.setOnClickListener(new View.OnClickListener()
     {
         @Override
         public void onClick(View v) {
             Intent i=new Intent(calcuatetip.this,Main3Activity.class);
             startActivity(i);
         }
     });

    }
}
