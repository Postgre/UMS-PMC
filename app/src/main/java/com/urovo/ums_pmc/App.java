package com.urovo.ums_pmc;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Administrator on 2017/8/17.
 */

public class App extends Application {
    public App context;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        context = this;
        Utils.init(context);
    }
}
