package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/16.
 */

public class ParkingPayActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_enter_register;
    private Button bt_exit_pay;

    @Override
    protected void initListener() {
        bt_enter_register.setOnClickListener(this);
        bt_exit_pay.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_enter_register = (Button) findViewById(R.id.bt_enter_register);
        bt_exit_pay = (Button) findViewById(R.id.bt_exit_pay);
    }

    @Override
    protected int getLayout() {
        return R.layout.parkingpay_activity;
    }

    @Override
    protected void setMap(Bundle outState) {

    }

    @Override
    protected void getMap(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_enter_register:
                startActivity(new Intent(this, CarEnterActivity.class));
                break;
            case R.id.bt_exit_pay:
                startActivity(new Intent(this, CarExitActivity.class));
                break;
        }
    }
}
