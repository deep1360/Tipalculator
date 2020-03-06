package com.example.tipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText username1;
    EditText password1;
    EditText confirmpassword;
    Button signup ;
    TextView login1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.registeration);
        username1=findViewById(R.id.username1);
        password1=findViewById(R.id.password1);
        confirmpassword=findViewById(R.id.confirmpassword);
        signup=findViewById(R.id.button1);
        login1=findViewById(R.id.login1);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
               startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();

                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
    public void  createUser()
    {
        String username=username1.getText().toString().trim();
        String password=password1.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "Success .",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
                            String user=username1.getText().toString().trim();
                            String pass= password1.getText().toString().trim();
                            String confirm = confirmpassword.getText() .toString().trim();

                            Map<String, Object> myuser = new HashMap<>();
                            myuser.put("username", user);
                            myuser.put("password", pass);
                            myuser.put("confirmpassword", confirm);
                            db.collection("users").add(myuser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getApplicationContext(),"added",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }

                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
               Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
               e.printStackTrace();
            }
        });
    }
}
