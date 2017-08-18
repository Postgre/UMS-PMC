package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PayMethodActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout ll_wx_pay;
    private LinearLayout ll_ali_pay;
    private LinearLayout ll_bankcard_pay;
    private LinearLayout ll_propertycard_pay;

    @Override
    protected void initListener() {
        ll_wx_pay.setOnClickListener(this);
        ll_ali_pay.setOnClickListener(this);
        ll_bankcard_pay.setOnClickListener(this);
        ll_propertycard_pay.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ll_wx_pay = (LinearLayout) findViewById(R.id.wx_pay);
        ll_ali_pay = (LinearLayout) findViewById(R.id.ali_pay);
        ll_bankcard_pay = (LinearLayout) findViewById(R.id.bankcard_pay);
        ll_propertycard_pay = (LinearLayout) findViewById(R.id.propertycard_pay);
    }

    @Override
    protected int getLayout() {
        return R.layout.paymethod_activity;
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
            case R.id.wx_pay:
//                break;
            case R.id.ali_pay:
//                break;
            case R.id.bankcard_pay:
//                break;
            case R.id.propertycard_pay:
                startActivity(new Intent(this,PayAmtAcivity.class));
                break;
            default:
                break;
        }
    }
}
