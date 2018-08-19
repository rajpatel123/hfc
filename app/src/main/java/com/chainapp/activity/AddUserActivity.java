package com.hfcapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hfcapp.R;

public class AddUserActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private Button btnNext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_add_user);
        ivBack=findViewById(R.id.iv_back);
        btnNext=findViewById(R.id.btn_next);

        ivBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        finish();
        backIn();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.iv_back:
                finish();
                backIn();
                break;
            case R.id.btn_next:
                startActivity(new Intent(this,AccountDetailsActivity.class));
                activityIn();
                break;
                default:
                    break;


        }

    }
}
