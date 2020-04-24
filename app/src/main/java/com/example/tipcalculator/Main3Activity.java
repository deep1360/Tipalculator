package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Button cal,bac,log1;
    TextView  tamount,tperpsn,tipperprsn,fals;
    EditText persn;
    String pos,tos;

    double sd,md,t,fal,fnl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perperson);
        bac=findViewById(R.id.button3);
        log1=findViewById(R.id.button4);
        cal=findViewById(R.id.calculate1);
        fals=findViewById(R.id.textView);
        persn=findViewById(R.id.editText);
        tamount=findViewById(R.id.tv2);
        tperpsn=findViewById(R.id.tv8);
        tipperprsn=findViewById(R.id.tv6);

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main3Activity.this,calcuatetip.class);
                startActivity(i);
            }
        });

        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,MainActivity.class);
                startActivity(i);
            }
        });




         pos=getIntent().getExtras().getString("name");
         tos=getIntent().getExtras().getString("tbill");
         tamount.setText(pos);
        fals.setText(tos);











        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sd=Double.parseDouble(tamount.getText().toString());
                md=Double.parseDouble(persn.getText().toString());
                fal=Double.parseDouble(fals.getText().toString());

                t=sd/md;
                fnl=fal/md;
                tperpsn.setText(String.valueOf(t));
                tipperprsn.setText(String.valueOf(fnl));


            }
        });



    }
}
