package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class calcuatetip extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcuatetip);

     b1=findViewById(R.id.calculate11)  ;

        b2=findViewById(R.id.button11)  ;

     b1.setOnClickListener(new View.OnClickListener()
    {
    @Override
    public void onClick(View v)
    {
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
