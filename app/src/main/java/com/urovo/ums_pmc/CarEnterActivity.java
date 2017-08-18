package com.urovo.ums_pmc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/16.
 */

public class CarEnterActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_enter_confirm;
    private Button bt_enter_cancel;

    @Override
    protected void initListener() {
        bt_enter_confirm.setOnClickListener(this);
        bt_enter_cancel.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_enter_confirm = (Button) findViewById(R.id.bt_enter_confirm);
        bt_enter_cancel = (Button) findViewById(R.id.bt_enter_cancel);
    }

    @Override
    protected int getLayout() {
        return R.layout.carenter_activty;
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
            case R.id.bt_enter_confirm:

                //                break;
            case R.id.bt_enter_cancel:
                this.finish();
                break;
        }
    }
}
