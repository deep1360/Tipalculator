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

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeration);
        username1=findViewById(R.id.username1);
        password1=findViewById(R.id.password1);
        confirmpassword=findViewById(R.id.confirmpassword);
        signup=findViewById(R.id.button1);
        login1=findViewById(R.id.login1);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();


            }
        });



    }
    public void  createUser()
    {
        String username=username1.getText().toString().trim();
        String password=password1.getText().toString().trim();
        registerMethod(username,password);

    }

    public void registerMethod(final String stEmail, final String stPassword) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://10.0.2.2:3012/register",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            // String status = response;

                            Toast.makeText(RegisterActivity.this,response,Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(i);

                        } catch (Exception e) {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        String error_msg = "something went wrong";
                        Toast.makeText(RegisterActivity.this,error_msg,Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("email", stEmail);
                map.put("password", stPassword);
                return map;
            }

        };
        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                60000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue1.add(stringRequest);
    }


}
