package hfc.com.hfc.prefrences;

import android.content.Context;
import android.content.SharedPreferences;


public class MySharedPreference {
    private static SharedPreferences.Editor editor;
    private static Context _context;
    private static SharedPreferences mPreferences;
    private static final String PREF_NAME = "HFCApp";
    private static MySharedPreference uniqInstance;
    private static final int PRIVATE_MODE = 0;

    /**
     * Private Constructor for not allowing other classes to instantiate this
     * class
     */
    private MySharedPreference() {

    }

    /**
     * @param context of the class calling this method
     * @return instance of this class This method is the global point of access
     * for getting the only one instance of this class
     */
    public static synchronized MySharedPreference getInstance(Context context) {
        if (uniqInstance == null) {
            _context = context;
            mPreferences = _context.getSharedPreferences(PREF_NAME,
                    PRIVATE_MODE);
            editor = mPreferences.edit();
            uniqInstance = new MySharedPreference();
        }
        return uniqInstance;
    }

    /**
     * Method is used for reset all the key & values of the shared preference.
     */
    public void resetAll() {
        boolean isRememberMe=isRememberMe();
        String userEmail=getEmail();
        String password=getPassword();
        editor.clear();
        editor.commit();
        if(isRememberMe){
            setRememberMe(isRememberMe);
            setEmail(userEmail);
            setPassword(password);
        }

    }


    public void setUserLoginType(String navigationStatus) {
        editor.putString("loginType", navigationStatus);
        editor.commit();
    }

    public String getUserLoginType() {
        return mPreferences.getString("loginType",null);
    }


    /*Login Status*/



    public void setUserLoginStatus(Boolean lStatus) {
        editor.putBoolean("loginStatus", lStatus);
        editor.commit();
    }

    public Boolean getUserLoginStatus() {
        return mPreferences.getBoolean("loginStatus",false);
    }





    /*NotificationCount*/
    public void setBooKMyRideTransition(String navigationStatus) {
        editor.putString("book_my_ride_transition", navigationStatus);
        editor.commit();
    }
    public String getBooKMyRideTransition() {
        return mPreferences.getString("book_my_ride_transition","0");
    }


    /*set pager position*/
    public void setCurrentPagerPosition(String pagerPosition) {
        editor.putString("pager_position", pagerPosition);
        editor.commit();
    }
    /*get pager position*/
    public String getCurrentPagerPosition() {
        return mPreferences.getString("pager_position","0");
    }



    /*Firebase Token*/
    public void setFirebaseToken(String navigationStatus) {
        editor.putString("firebase_token", navigationStatus);
        editor.commit();
    }
    public String getFirebaseToken() {
        return mPreferences.getString("firebase_token","0");
    }



    public void setCurrentDriverId(String driverId) {
        editor.putString("driver_id", driverId);
        editor.commit();
    }

    public String getCurrentDriverId() {
        return mPreferences.getString("driver_id", "0");
    }



    public void setDeviceToken(String deviceToken) {
        editor.putString("device_token", deviceToken);
        editor.commit();
    }

    public String getDeviceToken() {
        return mPreferences.getString("device_token", "device_token");
    }


    public boolean getLogin() {
        return mPreferences.getBoolean("is_login", false);
    }

    public void setCategoryList(boolean value) {
        editor.putBoolean("category_list", value);
        editor.commit();
    }

    public boolean getCategoryList() {
        return mPreferences.getBoolean("category_list", false);
    }

    public void setLogin(boolean is_login) {
        editor.putBoolean("is_login", is_login);
        editor.commit();
    }


    public void setUserId(String value) {
        editor.putString("user_id", value);
        editor.commit();
    }

    public String getUserId() {
        return mPreferences.getString("user_id", "");
    }


    public void setUserCountry(String value) {
        editor.putString("user_country", value);
        editor.commit();
    }

    public String getUserCountry() {
        return mPreferences.getString("user_country", "");
    }


    public String getUserProfileImageF() {
        return mPreferences.getString("image", "");
    }

    public void setUserProfileImageF(String value) {
        editor.putString("image", value);
        editor.commit();
    }


    public void setUserProfileImage(String value) {
        editor.putString("user_image", value);
        editor.commit();
    }

    public String getUserProfileImage() {
        return mPreferences.getString("user_image", "");
    }

    public String getFirstName() {
        return mPreferences.getString("firstName",null);
    }

    public void setFirstName(String value) {
        editor.putString("firstName", value);
        editor.commit();
    }

    public String getLastName() {
        return mPreferences.getString("lastName",null);
    }

    public void setLastName(String value) {
        editor.putString("lastName", value);
        editor.commit();
    }

    /*user Name*/


    public String getUserName() {
        return mPreferences.getString("userName",null);
    }

    public void setUserName(String value) {
        editor.putString("userName", value);
        editor.commit();
    }
    /*session Id*/


    public String getSessionId() {
        return mPreferences.getString("sessionId",null);
    }

    public void setSessionId(String value) {
        editor.putString("sessionId", value);
        editor.commit();
    }

    public String getDOB() {
        return mPreferences.getString("dob", "");
    }

    public void setDOB(String value) {
        editor.putString("dob", value);
        editor.commit();
    }


    public String getStatus() {
        return mPreferences.getString("status", "");
    }

    public void setStatus(String value) {
        editor.putString("status", value);
        editor.commit();
    }


    public String getGender() {
        return mPreferences.getString("gender", "");
    }

    public void setGender(String value) {
        editor.putString("gender", value);
        editor.commit();
    }

    public String getEmail() {
        return mPreferences.getString("user_email", "");
    }

    public void setEmail(String value) {
        editor.putString("user_email", value);
        editor.commit();
    }

    public String getPushNotification() {
        return mPreferences.getString("push_notification", "0");
    }

    public void setPushNotification(String value) {
        editor.putString("push_notification", value);
        editor.commit();
    }


    public void setServiceKey(String serviceKey) {
        editor.putString("serviceKey", serviceKey);
        editor.commit();
    }
    public String getServiceKey() {
        return mPreferences.getString("serviceKey", "");
    }

    public void setMobileNo(String mobileNo) {
        editor.putString("mobileNo", mobileNo);
        editor.commit();
    }

    public String getMobileNo() {
        return mPreferences.getString("mobileNo", "");
    }


    public void setRememberMe(boolean isRemember){
        editor.putBoolean("remember_me",isRemember);
        editor.commit();
    }
    public boolean isRememberMe(){
        return mPreferences.getBoolean("remember_me",false);
    }

    public void setPassword(String password){
        editor.putString("pass_key",password);
        editor.commit();
    }
    public String getPassword(){
        return mPreferences.getString("pass_key","");
    }

    public String getAddress(){
        return mPreferences.getString("address","");
    }
    public void setAddress(String pickupAddress) {
        editor.putString("address",pickupAddress);
        editor.commit();
    }


    void setLatitude(String latitude) {
        editor.putString("latitude",latitude);
        editor.commit();
    }

    public void setLongitude(String longitude) {
        editor.putString("longitude",longitude);
        editor.commit();
    }

    public String getLatitude() {
        return mPreferences.getString("latitude","28.369");
    }

    public String getLongitude() {
        return mPreferences.getString("longitude","28.369");
    }



    /*
    *
    * Store notification count
    * */
    public void setNotificationCount(String notificationCount){
        editor.putString("notification-count",notificationCount);
        editor.commit();
    }
    public String getNotificationCount(){
        return mPreferences.getString("notification-count","0");
    }



    /*
   *
   * Store notification count
   * */
    public void setNotificationStatus(String notificationStatus){
        editor.putString("notification-status",notificationStatus);
        editor.commit();
    }
    public String getNotificationStatus(){
        return mPreferences.getString("notification-status","");
    }





}
