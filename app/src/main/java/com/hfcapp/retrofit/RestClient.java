package com.hfcapp.retrofit;


import com.hfcapp.model.LoginRequestModel;
import com.hfcapp.model.LoginResponse;

import retrofit2.Callback;

public class RestClient {


    public static void login(LoginRequestModel loginRequestModel, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().login(loginRequestModel).enqueue(callback);
    }


}



