package com.ruth.jahan.pathoinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginbutton,signupbutton;
    private EditText signinemailedittext,signinpassedittext;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Log In");
        mAuth = FirebaseAuth.getInstance();

        signinemailedittext= findViewById(R.id.loginemailid);
        signinpassedittext= findViewById(R.id.loginpasswordid);
        loginbutton= findViewById(R.id.loginbuttonid);
        signupbutton= findViewById(R.id.signupbuttonid);

        loginbutton.setOnClickListener(this);
        signupbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.loginbuttonid:
                userlogin();
                break;

            case R.id.signupbuttonid:
                Intent intent= new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userlogin() {
        String email= signinemailedittext.getText().toString().trim();
        String password= signinpassedittext.getText().toString().trim();

        if(email.equals("Admin") && password.equals("admin")){
            Intent intent= new Intent(LoginActivity.this,AddTestActivity.class);
            startActivity(intent);

            signinemailedittext.setText("");
            signinpassedittext.setText("");
        }
        else {
            //checking validity
            if (email.isEmpty()) {
                signinemailedittext.setError("Enter an email address");
                signinemailedittext.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                signinemailedittext.setError("Enter a valid email address");
                signinemailedittext.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                signinpassedittext.setError("Enter a password");
                signinpassedittext.requestFocus();
                return;
            }

            if (password.length() < 6) {
                signinpassedittext.setError("Your password must carry atleast 6 characters");
                signinpassedittext.requestFocus();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        finish();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Log in unsuccessful", Toast.LENGTH_SHORT).show();
                    }


                }

            });
        }

    }
}