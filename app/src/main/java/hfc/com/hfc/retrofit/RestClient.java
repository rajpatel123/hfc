package hfc.com.hfc.retrofit;



import hfc.com.hfc.model.LoginRequestModel;
import hfc.com.hfc.model.LoginResponse;
import retrofit2.Callback;

public class RestClient {


    public static void login(LoginRequestModel loginRequestModel, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().login(loginRequestModel).enqueue(callback);
    }


}



