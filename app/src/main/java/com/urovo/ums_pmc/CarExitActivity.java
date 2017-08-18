package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/16.
 */

public class CarExitActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_exit_confirm;
    private Button bt_exit_cancel;

    @Override
    protected void initListener() {
        bt_exit_confirm.setOnClickListener(this);
        bt_exit_cancel.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_exit_confirm = (Button) findViewById(R.id.bt_exit_confirm);
        bt_exit_cancel = (Button) findViewById(R.id.bt_exit_cancel);
    }

    @Override
    protected int getLayout() {
        return R.layout.carexit_activity;
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
            case R.id.bt_exit_confirm:
                startActivity(new Intent(this, PayMethodActivity.class));
                break;
            case R.id.bt_exit_cancel:
                this.finish();
                break;
        }

    }
}
