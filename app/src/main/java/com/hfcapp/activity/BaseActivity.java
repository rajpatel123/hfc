package com.hfcapp.activity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.hfcapp.R;

public class BaseActivity extends A{
    /*open new activity*/
    public void activityIn() {
        //calling to predefine method
        super.overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
    /*come to back activity*/
    public void backIn()
    {
        Log.e("backIn","isCalling");
        super.overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
    }

    /*
     * This methos is displaying long message
     *
     * */
    public void showLongMessage(Context context, String message)
    {
        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
    }

    /*
     * This method is displaying short message
     *
     * */
    public void showShortMessage(Context context, String message)
    {
        Toast.makeText(context,""+message,Toast.LENGTH_LONG).show();
    }

}
