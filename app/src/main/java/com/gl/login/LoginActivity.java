package com.gl.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button mForgotPasswordButton;
    Button mButtonLogin;
    EditText mUserNameLabel;
    EditText mPasswordLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        registerListener();

    }

    private void initView() {
        mForgotPasswordButton= findViewById(R.id.forgotPasswordButton);
        mButtonLogin = findViewById(R.id.loginButton);
        mUserNameLabel = findViewById(R.id.usernameEditView);
        mPasswordLabel = findViewById(R.id.passwordEditView);
    }

    private void registerListener() {
        mForgotPasswordButton.setOnClickListener(this);
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if(v == mForgotPasswordButton){
           openForgotPasswordActivity();
       }if(v == mButtonLogin){
          loginUser();
       }
    }

    private void loginUser() {
        mButtonLogin.setTextColor(Color.BLUE);
        String username = mUserNameLabel.getText().toString();
        String password = mPasswordLabel.getText().toString();

        String changePasswordUser = null;
        try {
            Intent intent = getIntent();
            changePasswordUser = intent.getStringExtra("changePassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userPassword;
        if (changePasswordUser != null) {
            userPassword = changePasswordUser;
        } else {
            userPassword = "admin1234";
        }

        String userName = "admin";
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        if (validateView(username, password)) {
            if ((username.toLowerCase().trim().equals(userName)) && password.trim().toLowerCase().equals(userPassword)) {
                openEmployeeActivity();
            } else {
                mButtonLogin.setTextColor(Color.BLUE);
                alertDialog.setTitle("Sorry, Password is Wrong, Do You want to Change Password ?");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        openForgotPasswordActivity();
                    }
                });
                alertDialog.setNegativeButton("Cancel", null);
                AlertDialog alert = alertDialog.create();
                alert.show();
            }
        }
    }

    private boolean validateView(String username, String password){
        if(TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(),"Please Enter UserName",Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Please Enter Password",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void openForgotPasswordActivity(){
        Intent intent =  new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private void openEmployeeActivity(){
        //Explicit Intent
        //Implicit Intent
        Intent intent =  new Intent(this,EmployeeActivity.class);
        startActivity(intent);
    }
}
