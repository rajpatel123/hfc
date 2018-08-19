package com.hfcapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.hfcapp.R;

public class AccountDetailsActivity extends BaseActivity {

    private ImageView ivBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        ivBack=findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                backIn();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        backIn();
    }

}
