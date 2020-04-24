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

    Button b1,b2,sub,add,log;
    EditText bill1;
    TextView ttip,tbill,totalbill;

  double et,tv;
  int tippercent=0;
  double per=100;
  double tipout;
  double totalout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcuatetip);

     b1=findViewById(R.id.calculate11)  ;
     log=findViewById(R.id.button2);

        b2=findViewById(R.id.button11)  ;
        sub=findViewById(R.id.buttonsub);
        add=findViewById(R.id.buttonadd);
        bill1=findViewById(R.id.bill);

        ttip=findViewById(R.id.textview3);
        tbill=findViewById(R.id.textView5);
        totalbill=findViewById(R.id.textView7);


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


log.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(calcuatetip.this,MainActivity.class);
        startActivity(i);
    }
});





     b1.setOnClickListener(new View.OnClickListener()
    {
    @Override
    public void onClick(View v)
    {

        et=Double.parseDouble(bill1.getText().toString());
        tv=Double.parseDouble(ttip.getText().toString());

        tipout=(et*tv)/per;
        totalout=tipout+et;

        totalbill.setText(String.valueOf(totalout));

        tbill.setText(String.valueOf(tipout));

    }

});



     b2.setOnClickListener(new View.OnClickListener()
     {
         @Override
         public void onClick(View v) {
           String p=  totalbill.getText().toString();
           String t= tbill.getText().toString();


             Intent i=new Intent(calcuatetip.this,Main3Activity.class);
             i.putExtra("name",p);
             i.putExtra("tbill",t);
             startActivity(i);
         }
     });


    }



}
