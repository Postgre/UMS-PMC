package com.urovo.ums_pmc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.urovo.ums_pmc.util.AppManager;

/**
 * Created by Administrator on 2017/8/16.
 */

public abstract class BaseActivity extends AppCompatActivity {
    AppManager appManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appManager = AppManager.getAppManager();
        appManager.addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayout());
        initView(savedInstanceState);
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getLayout();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != outState) {
            setMap(outState);
        }
    }

    protected abstract void setMap(Bundle outState);


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (null != savedInstanceState) {
            getMap(savedInstanceState);
        }
    }

    protected abstract void getMap(Bundle savedInstanceState);

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
