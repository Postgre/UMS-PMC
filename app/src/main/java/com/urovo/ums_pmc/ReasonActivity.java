package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/8/16.
 */

public class ReasonActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_upload;

    @Override
    protected void initListener() {
        bt_upload.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_upload = (Button) findViewById(R.id.bt_upload);
    }

    @Override
    protected int getLayout() {
        return R.layout.reason_activity;
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
            case R.id.bt_upload:
                startActivity(new Intent(this, RepairServiceEvaluationActivity.class));
                break;
        }
    }
}
