package hfc.com.hfc.retrofit;




import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import hfc.com.hfc.model.LoginRequestModel;
import hfc.com.hfc.model.LoginResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("api/account/Authenticate")
    Call<LoginResponse> login(@Body LoginRequestModel dataObject);

//
//    @POST("/api/devices")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<AddDeviceModelResponse> addDevice(@Body DeviceInformation deviceInformation, @Header("X-Authorization-Firebase") String access_token);

  }