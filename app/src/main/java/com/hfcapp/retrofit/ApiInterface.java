package com.hfcapp.retrofit;


import com.hfcapp.model.LoginRequestModel;
import com.hfcapp.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("/api/account/Authenticate")
    Call<LoginRequestModel> login(@Body LoginResponse dataObject);



//    @GET("/api/devices/details/{deviceId}")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
////    Call<DeviceInfo> getDeviceInformation(@Path("deviceId") String deviceId, @Header("X-Authorization-Firebase") String access_token);

//
//    @POST("api/users/order")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<Order> createOrder(@Header("X-Authorization-Firebase") String access_token, @Body PlaceOrder order);
//
//    @PUT("api/users/initiate-payment/{id}")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<InitiatePaymentResponse> initiate_payment(@Header("X-Authorization-Firebase") String access_token, @Path("id") String orderNumber);
//
//    @POST("api/users/update-user")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<ResponseBody> updateUser(@Body UpdateUser updateUser);
//
//    @DELETE("/api/userimage")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<JSONObject> deleteImage(@Header("X-Authorization-Firebase") String access_token);
//
//
//
//    @POST("/api/userinfo")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Observable<Response<ResponseBody>> sendFCMTokenToServer(@Body HashMap<String, String> body, @Header("X-Authorization-Firebase") String access_toke);

}