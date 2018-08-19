package com.hfcapp.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

@SerializedName("access_token")
@Expose
private String accessToken;
@SerializedName("expires_in")
@Expose
private Integer expiresIn;
@SerializedName("Result")
@Expose
private String result;
@SerializedName("StatusCode")
@Expose
private Integer statusCode;
@SerializedName("User")
@Expose
private User user;

public String getAccessToken() {
return accessToken;
}

public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

public Integer getExpiresIn() {
return expiresIn;
}

public void setExpiresIn(Integer expiresIn) {
this.expiresIn = expiresIn;
}

public String getResult() {
return result;
}

public void setResult(String result) {
this.result = result;
}

public Integer getStatusCode() {
return statusCode;
}

public void setStatusCode(Integer statusCode) {
this.statusCode = statusCode;
}

public User getUser() {
return user;
}

public void setUser(User user) {
this.user = user;
}

}

