package com.gl.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password extends AppCompatActivity implements View.OnClickListener {

    EditText mPasswordLabel;
    EditText mConfirmPasswordLabel;
    Button mChangePasswordButton;
    EditText mEditConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initView();
        registerListener();
    }

    private void registerListener() {
        mChangePasswordButton.setOnClickListener(this);
    }

    private void initView() {
        mPasswordLabel = findViewById(R.id.editPassword);
        mConfirmPasswordLabel = findViewById(R.id.editConfirmPassword);
        mChangePasswordButton = findViewById(R.id.changePasswordButton);
        mEditConfirmPassword = findViewById(R.id.editConfirmPassword);
    }

    @Override
    public void onClick(View v) {
        if (v == mChangePasswordButton) {
            String password = mPasswordLabel.getText().toString();
            String confirmPassword = mConfirmPasswordLabel.getText().toString();
            validatePassword(password,confirmPassword);
        }

    }

    private boolean validatePassword(String password, String confirmPassword) {
        if (validateView(password, confirmPassword)) {
            if (password.equals(confirmPassword) || password.equals(mEditConfirmPassword)) {
                mChangePasswordButton.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), "Password Change Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("changePassword",confirmPassword);
                intent.putExtras(bundle);
                startActivity(intent);
                return  true;
            } else {
                Toast.makeText(getApplicationContext(), "Password And Confirm Password Should Be Same", Toast.LENGTH_LONG).show();
                 return  false;
            }
        }else{
             return false;
            }
        }


    public boolean validateView (String password, String confirmPassword){
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Please Enter Confirm Password", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}
