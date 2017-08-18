package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PayResultActivity extends BaseActivity {

    private String mSolved;
    private SPUtils mInstance;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mInstance = SPUtils.getInstance();
        mSolved = mInstance.getString("solved");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayout() {
        return R.layout.payresult_activity;
    }

    @Override
    protected void setMap(Bundle outState) {

    }

    @Override
    protected void getMap(Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        if (!TextUtils.isEmpty(mSolved)) {
            if ("solved".equals(mSolved)) {
                startActivity(new Intent(this, RepairServiceEvaluationActivity.class));
                mInstance.clear();
            }
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
