package hfc.com.hfc.helper;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FunctionHelper {
    private static ProgressDialog sProgressDialog;

    public static void disable_user_Intration(Context context, String text) {
        enableUserIntraction();
        if (sProgressDialog == null || sProgressDialog.getContext() != context) {
            sProgressDialog = new ProgressDialog(context);
            sProgressDialog.setCancelable(true);
            sProgressDialog.setCanceledOnTouchOutside(true);
            sProgressDialog.setMessage(text);
            try {
                sProgressDialog.show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
    }

    public static void enableUserIntraction() {
        try {
            if (sProgressDialog != null && sProgressDialog.isShowing()) {
                sProgressDialog.dismiss();
            }
            sProgressDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void callNumber(Context context, String number) {
        if (context == null)
            return;
        if (number != null && number.length() > 0) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            context.startActivity(intent);
        }
    }

    public static boolean hideKeyBoard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE));
            return inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void hideKeyBoard(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }



    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Activity.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName()))
                return true;
        }
        return false;
    }
/*
    public static void appShare(Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.app_name));
        sendIntent.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=" + context.getPackageName());
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }*/


    /*password length should be 8 to 15*/
    public static boolean isValidPassword(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            if (target.length() < 8 || target.length() > 15) {
                return false;
            } else {
                return true;
            }
        }
    }



    /*
    *
    * validate formate
    * */
    public static  boolean isValidPasswordFormate(final String password) {

        Pattern pattern;
        Matcher matcher;
        String regex = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[~'!@#$%?\\\\/&*\\]|\\[=()}\"{+_:;,.><'-])).{8,}";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

    /*Validate contact number*/
    public static boolean isValidContactNumber(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            if (target.length() < 8 || target.length() > 15) {
                return false;
            } else {
                return android.util.Patterns.PHONE.matcher(target).matches();
            }
        }

    }

    //String contains one character and number
    public static boolean isValidateContactCharacter(String target) {
        if (target == null) {
            return false;
        } else {
            //return target.matches("^(?=.*[a-z])(?=.*[0-9])[a-z0-9]+$");
            return target.matches("^(?:[0-9]+[a-z]|[a-z]+[0-9])[a-z0-9]*$");
        }

    }


    public static String currentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-d");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String currentDate1() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    /**/
    public static String currentDateWithTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }



    public static Date gmtToLocalDate(Date date) {

        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
        return local;
    }

// "Mar 10, 2016 6:30:00 PM"; in this formate
    public static String updatedNewFormate(String newDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updateDate= null;
        try {
            updateDate = df.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        df= new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        String  date = df.format(updateDate);
     return  date;
    }

   /* public static long currentTime()
    {
        Calendar c = Calendar.getInstance();

        return c.getTime();
    }*/

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
/*

    */
/*logout from app*//*

    public static void logout(Context context) {
        Toast.makeText(context, R.string.hint_you_are_logged_in_another_device, Toast.LENGTH_SHORT).show();
        MySharedPreference.getInstance(context).resetAll();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
*/

/*

    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400

    public static String getDifference(String sDate) {
        Logger.e("sDate----" + sDate);
        String returnDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        Date endDate = null;
        String eDate;
        try {
            startDate = simpleDateFormat.parse(sDate);
            Logger.e("startDate---" + startDate);
            Logger.e("currentDate---" + currentDate1());
            eDate = currentDate1();
            endDate = simpleDateFormat.parse(eDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long yearInMilli = daysInMilli * 365;

        long elapsedYear = different / yearInMilli;
        different = different % yearInMilli;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        Logger.e("year---" + elapsedYear);

        if (elapsedYear == 0) {
            returnDate = "";
        } else {
            returnDate = " " + elapsedYear + " year";
        }

     */
/*   if (elapsedDays == 0) {
        } else {
            returnDate = returnDate + " " + elapsedDays + " days";
        }

        if (elapsedHours == 0) {
        } else {
            returnDate = " " + returnDate + " " + elapsedHours + " " + " hrs";
        }*//*


        return returnDate;
    }
*/

/*

    */
/*get current latitude and longitude*//*

    public static void setCurrentLatLng(Context context) throws Exception {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        if(latitude!=0.0)
        {
            MySharedPreference.getInstance(context).setLatitude(""+latitude);
        }
        if(longitude!=0.0)
        {
            MySharedPreference.getInstance(context).setLongitude(""+longitude);
        }
    }
*/


    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

/*

            //2017-06-29 01:12:49

    */
/*get date in utc format *//*

    public static String convertUtc(){
        String date =currentDateWithTime();
        Logger.e("c_date"+date);
      */
/*  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date myDate = simpleDateFormat.parse(date);
            SimpleDateFormat outPutDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
            outPutDateFormat.setTimeZone(TimeZone.getDefault());
            String dateF=outPutDateFormat.format(myDate);
            return dateF;
        } catch (ParseException e) {
            e.printStackTrace();
        }*//*

        return date;
    }
*/


    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }








    /*get the profile path*/
    public static String  createPath(Uri selectedImageUri,Context context) {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            return cursor.getString(columnIndex);
        }
        return null;
    }


/*return price*/
    public static String withSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format(Locale.getDefault(),"%.1f %c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt(exp-1));
    }


    }

