package com.chainapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chainapp.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private TextView addUser;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addUser=findViewById(R.id.tv_add);
        ivBack=findViewById(R.id.iv_back);


        ivBack.setOnClickListener(this);
        addUser.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_add:
                startActivity(new Intent(HomeActivity.this, AddUserActivity.class));
                activityIn();
                break;
            case R.id.iv_back:
                finish();
                break;
                default:
                    break;


        }


    }
}
