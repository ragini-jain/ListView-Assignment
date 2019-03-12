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

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mPasswordLabel;
    Button mChangePasswordButton;
    EditText mEditConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initView();
        registerListener();
    }

    /**
     * Onclick Listener
     */
    private void registerListener() {
        mChangePasswordButton.setOnClickListener(this);
    }

    /**
     * init View
     */
    private void initView() {
        mPasswordLabel = findViewById(R.id.editPassword);
        mChangePasswordButton = findViewById(R.id.changePasswordButton);
        mEditConfirmPassword = findViewById(R.id.editConfirmPassword);
    }

    @Override
    public void onClick(View v) {
        if (v == mChangePasswordButton) {
            String password = mPasswordLabel.getText().toString();
            String confirmPassword = mEditConfirmPassword.getText().toString();
            validatePassword(password,confirmPassword);
        }

    }

    /**
     *
     * @param password New Password
     * @param confirmPassword Confirm Password
     */
    private void validatePassword(String password, String confirmPassword) {
        if (validateView(password, confirmPassword)) {
            if (password.equals(confirmPassword) || mEditConfirmPassword.toString().equals(password)) {
                mChangePasswordButton.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), "Password Change Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, LoginActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("changePassword",confirmPassword);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Password And Confirm Password Should Be Same", Toast.LENGTH_LONG).show();
            }
        }
        }

    /**
     * Validate Password
     * @param password New Password
     * @param confirmPassword Confirm Password
     * @return boolean
     */
    private boolean validateView (String password, String confirmPassword){
        boolean status = true;
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
            status= false;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Please Enter Confirm Password", Toast.LENGTH_LONG).show();
            status= false;
        }

        return status;
    }

}
