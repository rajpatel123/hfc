package com.chainapp.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.chainapp.R;
import com.chainapp.adapter.HomeAdapter;
import com.chainapp.fragment.DashboardFragment;
import com.chainapp.prefrences.MySharedPreference;


public class MainActivity extends BaseActivity {

    //private PrefencesClass prefencesClass;
    //  ApplicationConstant _app;
    private final static String TAG_FRAGMENT = "TAG_FRAGMENT";
    String TITLES[] = {"DashBoard","My Profile","Bank Details","My Chain List","Logout"};

    int ICONS[] = {R.drawable.ic_dashboard,R.drawable.ic_user,R.drawable.ic_banck_details,R.drawable.ic_chain,R.drawable.ic_logout};

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    String NAME = "kundan";
    String EMAIL = "kindjcet@gmail.com";
    int PROFILE = R.drawable.ic_back_white;

    Toolbar toolbar;                                      // Declaring the Toolbar Object
    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle
    //   AppLocationUtils mAppLocationUtils;
    private BroadcastReceiver broadcastReceiver;
    private TextView tvTitle;
    private  TextView tvMessage;
    private TextView tvAddUser;
    String username,url,password,user_id,userLoggedIn,userTypeString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mAppLocationUtils = AppLocationUtils.getInstance(this);
//        mAppLocationUtils.startFetchingLocation(this);

        setContentView(R.layout.activity_home);
        tvAddUser=findViewById(R.id.tv_add);

        tvAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddUserActivity.class));
                activityIn();
            }
        });


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }
        // do something for phones running an SDK before lollipop


        try {
           /* ApplicationConstant appl =(ApplicationConstant) MainActivity.this.getApplication();
            appl.ReadyApplicationDatabase(MainActivity.this);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            /*   _app = (ApplicationConstant) MainActivity.this.getApplication();*/
        } catch (Exception e) {
            // TODO: handle exception
        }



        toolbar=(Toolbar)findViewById(R.id.tool_bar);
        tvTitle=(TextView) findViewById(R.id.tv_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
        // mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST));

        mAdapter = new HomeAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE,this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        //and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView


        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    Drawer.closeDrawers();

                    Fragment fragment = null;
                    int position =recyclerView.getChildPosition(child);
                    Intent _intent =null;
                    switch (position) {
                        case 0:
                          /*  Intent intent=new Intent(HomeActivity.this, ProfileActivity.class);
                            startActivity(intent);
                            finish();
                            activityIn();*/
                            // startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                            break;
                        case 1:
                            //carrier moldule
                            fragment = new DashboardFragment();
                            break;
                        case 2:
                            //    fragment = new RentalFragment();
                            break;
                        case 3:
                            // fragment = new RecentActivityFragment();
                            break;
                        case 4:
                            //  fragment = new PlanAJournyFragment();
                            break;
                        case 5:
                            MySharedPreference.getInstance(MainActivity.this).resetAll();
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));
                            activityIn();
                            finish();
                            break;
                        default:
                            break;
                    }

                    if (fragment != null) {
                        clearBackStack();
                        String _titlevalue[] = {"DashBoard","DashBoard","Active Rental","Activity"};

                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_container, fragment,TAG_FRAGMENT).commit();
                        tvTitle.setText(_titlevalue[position]);
                        //setTitle(_titlevalue[position]);

                        // update selected item and title, then close the drawer
                       /* mRecyclerView.setItemChecked(position, true);
                        mRecyclerView.setSelection(position);
                        setTitle(navMenuTitles[position]);*/
                        Drawer.closeDrawer(mRecyclerView);
                    } else {
                        // error in creating fragment
                        Log.e("MainActivity", "Error in creating fragment");
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        if (savedInstanceState == null) {
            // on first time display view for first nav item

          /*  Fragment dialogFragment = new DashBoardFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, dialogFragment, TAG_FRAGMENT).addToBackStack(null).commit();
            tvTitle.setText("DashBoard");*/
            //toolbar.setTitle("DashBoard");
            //setTitle("DashBoard");


        }


        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State




    }

    private void clearBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }



    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
      /*  if(mAppLocationUtils!=null) {
            mAppLocationUtils.stopLocationUpdates();
        }*/
        /*unregister the receiver*/
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }


    @Override
    protected void onStart() {
        super.onStart();
        // mAppLocationUtils.connectClient(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
           /* case R.id.action_overflow_profile:
            {
               *//* Fragment fragment1 = new Profile();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment1, TAG_FRAGMENT).addToBackStack(null).commit();
                setTitle("Profile");*//*
                // setTitleColor(getColor(R.color.textColor));

            }*/
        }



        return super.onOptionsItemSelected(item);

    }





    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }






}
