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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signupbutton;
    private TextView signintextview;
    private EditText signupemailedittext, signuppassedittext;
    public static String newuser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setTitle("Sign Up");
        mAuth = FirebaseAuth.getInstance();

        signupemailedittext = findViewById(R.id.emailid);
        signuppassedittext = findViewById(R.id.signuppasswordid);
        signintextview = findViewById(R.id.signintextviewid);
        signupbutton = findViewById(R.id.finalsignupbuttonid);

        signupbutton.setOnClickListener(this);
        signintextview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finalsignupbuttonid:
                userRegister();
                break;

            case R.id.signintextviewid:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userRegister() {
        String email= signupemailedittext.getText().toString().trim();
        String password= signuppassedittext.getText().toString().trim();

        //checking validity
        if (email.isEmpty())
        {
            signupemailedittext.setError("Enter an email address");
            signupemailedittext.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signupemailedittext.setError("Enter a valid email address");
            signupemailedittext.requestFocus();
            return;
        }

        if (password.isEmpty())
        {
            signuppassedittext.setError("Enter a password");
            signuppassedittext.requestFocus();
            return;
        }

        if (password.length()<6)
        {
            signuppassedittext.setError("Your password must carry atleast 6 characters");
            signuppassedittext.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Welcome to Patho Info",Toast.LENGTH_SHORT).show();
                            finish();
                            newuser=email;
                            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                        else {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(getApplicationContext(),"User is already registered",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                }

                        }

                    }
                });



    }
}