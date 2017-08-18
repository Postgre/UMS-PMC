package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.SPUtils;

/**
 * Created by Administrator on 2017/8/16.
 */

public class OwerRepairActivity extends BaseActivity implements View.OnClickListener {
    private Button bt_solved;
    private Button bt_unsolved;

    @Override
    protected void initListener() {
        bt_solved.setOnClickListener(this);
        bt_unsolved.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_solved = (Button) findViewById(R.id.bt_solved);
        bt_unsolved = (Button) findViewById(R.id.bt_unsolved);
    }

    @Override
    protected int getLayout() {
        return R.layout.owner_repaire_activity;
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
            case R.id.bt_solved:
                Intent intent = new Intent(this, PayMethodActivity.class);
                SPUtils instance = SPUtils.getInstance();
                instance.put("solved","solved");
                startActivity(intent);
                break;

            case R.id.bt_unsolved:
                startActivity(new Intent(this,ReasonActivity.class));
                break;
            default:
                break;
        }
    }
}
