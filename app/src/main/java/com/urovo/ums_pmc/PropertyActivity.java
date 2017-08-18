package com.urovo.ums_pmc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PropertyActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_property_confirm;
    private Button bt_property_cancel;

    @Override
    protected void initListener() {
        bt_property_confirm.setOnClickListener(this);
        bt_property_cancel.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_property_confirm = (Button) findViewById(R.id.bt_confirm);
        bt_property_cancel = (Button) findViewById(R.id.bt_cancel);
    }

    @Override
    protected int getLayout() {
        return R.layout.property_activity;
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
            case R.id.bt_confirm:

                //                break;
            case R.id.bt_cancel:
                this.finish();
                break;
            default:
                break;
        }
    }
}
