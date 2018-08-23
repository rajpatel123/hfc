package hfc.com.hfc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import hfc.com.hfc.R;

public class PaymentRequestActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivBack;
    private Button btnPayNow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_request);
        initView();
    }



    public  void initView()
    {
        ivBack=findViewById(R.id.iv_back);
        btnPayNow=findViewById(R.id.btn_pay_now);
        btnPayNow.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }



    /*
    *
    * callback for onClick
    *
    * */


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_back:
                finish();
                backIn();
                break;
            case R.id.btn_pay_now:
                Toast.makeText(this, R.string.text_under_development,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
