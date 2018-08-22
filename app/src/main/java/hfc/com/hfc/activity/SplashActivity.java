package hfc.com.hfc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import hfc.com.hfc.R;
import hfc.com.hfc.prefrences.MySharedPreference;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_STATUS=3000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        transitActivity();
    }

    /*
     * This method is calling to transit activity
     *
     * */
    private  void transitActivity()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String userId= MySharedPreference.getInstance(SplashActivity.this).getUserId();
                if(TextUtils.isEmpty(userId)) {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    activityIn();
                    finish();
                }else
                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    activityIn();
                    finish();
                }
            }
        },SPLASH_STATUS);
    }
}
