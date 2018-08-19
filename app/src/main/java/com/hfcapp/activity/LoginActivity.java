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
import com.hfcapp.helper.Constants;
import com.hfcapp.helper.FunctionHelper;
import com.hfcapp.model.LoginRequestModel;
import com.hfcapp.model.LoginResponse;
import com.hfcapp.prefrences.HFCPrefs;
import com.hfcapp.prefrences.MySharedPreference;
import com.hfcapp.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText edUserName;
    private EditText edPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.ed_user_id);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login: {
                FunctionHelper.hideKeyBoard(this);
                validateUserData();
                break;
            }
            default:
                break;

        }
    }


    private void validateUserData() {
        String userName = edUserName.getText().toString();
        String password = edPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(LoginActivity.this, R.string.valid_please_enter_user_name, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, R.string.valid_please_enter_password, Toast.LENGTH_SHORT).show();

        } else {
            LoginRequestModel loginRequestModel = new LoginRequestModel();
            loginRequestModel.setEmailAddress(userName);
            loginRequestModel.setPassword(password);
            RestClient.login(loginRequestModel, new Callback<LoginResponse>() {

                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();

                    HFCPrefs.putBoolean(LoginActivity.this, Constants.USER_LOGGED_IN, true);
                    HFCPrefs.putString(LoginActivity.this, Constants.ACCESS_TOKEN, loginResponse.getAccessToken());
                    HFCPrefs.putString(LoginActivity.this, Constants.USER_NAME, loginResponse.getUser().getFirstName());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });

        }

    }
}
