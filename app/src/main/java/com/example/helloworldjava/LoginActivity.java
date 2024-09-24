package com.example.helloworldjava;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class LoginActivity extends AppCompatActivity {
    public boolean isShown = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.signInBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText passwordInput = findViewById(R.id.password);
                EditText usernameInput = findViewById(R.id.username);

                if(/*usernameInput.getText().toString().equals("Yassine") && passwordInput.getText().toString().equals("1234567890")*/ true){

                    usernameInput.setText("");
                    passwordInput.setText("");
                    Intent intent = new Intent(LoginActivity.this, BlogPostActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "The Username or/and password are incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.showHideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText passwordInput =findViewById(R.id.password);
                if(!isShown){
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_NORMAL);
                }else{
                    passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                isShown=!isShown;
            }
        });
    }
}