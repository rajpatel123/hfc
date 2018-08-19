package com.hfcapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hfcapp.R;
import com.hfcapp.helper.FunctionHelper;
import com.hfcapp.prefrences.MySharedPreference;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText edUserName;
    private EditText edPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName=findViewById(R.id.ed_user_id);
        edPassword=findViewById(R.id.ed_password);
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_login:
            {
                FunctionHelper.hideKeyBoard(this);
                validateUserData();
                break;
            }
            default:
                break;

        }
    }


    private  void validateUserData()
    {
        String userName=edUserName.getText().toString();
        String password=edPassword.getText().toString();
        if(TextUtils.isEmpty(userName))
        {
            Toast.makeText(LoginActivity.this,"Please enter user name.",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(LoginActivity.this,"Please enter password.",Toast.LENGTH_SHORT).show();

        }else if(!userName.equalsIgnoreCase("admin"))
        {
            Toast.makeText(LoginActivity.this,"Invalid UserName.",Toast.LENGTH_SHORT).show();
        }else if(!password.equalsIgnoreCase("admin")){
            Toast.makeText(LoginActivity.this,"Invalid Password.",Toast.LENGTH_SHORT).show();

        }else
        {
            MySharedPreference.getInstance(this).setUserId("12");
            startActivity(new Intent(this,MainActivity.class));
            activityIn();
            finish();
        }

    }

}
