package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/16.
 */

public class LoginActivity extends BaseActivity {
    private EditText workNum;
    private EditText password;
    private String mWorkNum;
    private String mPassWord;
    private Button but_login;

    @Override
    protected void initListener() {
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        workNum = (EditText) findViewById(R.id.work_num);
        password = (EditText) findViewById(R.id.password);
        but_login = (Button) findViewById(R.id.but_login);
    }

    @Override
    protected int getLayout() {
        return R.layout.login_activity;
    }


    public void login() {
        mWorkNum = workNum.getText().toString();
        mPassWord = password.getText().toString();
        if (TextUtils.isEmpty(mWorkNum)) {
            Toast.makeText(this, "工号不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(mPassWord)) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (checkLoginInfo(mWorkNum, mPassWord)) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private boolean checkLoginInfo(String params1, String params2) {
        if ("admin".equals(params1) && "123456".equals(params2)) {
            return true;
        }
        return false;
    }


    @Override
    protected void setMap(Bundle outState) {
        outState.putString("workNum", mWorkNum);
        outState.putString("password", mPassWord);
    }


    @Override
    protected void getMap(Bundle savedInstanceState) {
        mWorkNum = savedInstanceState.getString("workNum");
        mPassWord = savedInstanceState.getString("password");
    }
}
