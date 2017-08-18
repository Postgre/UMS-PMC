package com.urovo.ums_pmc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.urovo.ums_pmc.util.AppManager;
import com.urovo.ums_pmc.view.RatingBarView;

/**
 * Created by Administrator on 2017/8/16.
 */

public class RepairServiceEvaluationActivity extends BaseActivity implements View.OnClickListener, RatingBarView.OnRatingListener {
    private Button bt_evaluation_confirm;
    private Button bt_evaluation_cancel;
    private RatingBarView mRatingBarView;
    private RatingBarView mRatingBarView1;
    private RatingBarView mRatingBarView2;
    private TextView tv_result;
    private TextView tv_result1;
    private TextView tv_result2;
    private String[] evaluations;

    @Override
    protected void initListener() {
        bt_evaluation_confirm.setOnClickListener(this);
        bt_evaluation_cancel.setOnClickListener(this);
        mRatingBarView.setOnRatingListener(this);
        mRatingBarView1.setOnRatingListener(this);
        mRatingBarView2.setOnRatingListener(this);
    }

    @Override
    protected void initData() {
        evaluations = getResources().getStringArray(R.array.service_evaluation);
        mRatingBarView.setmClickable(true);
        mRatingBarView1.setmClickable(true);
        mRatingBarView2.setmClickable(true);
        mRatingBarView.setBindObject(1);
        mRatingBarView1.setBindObject(2);
        mRatingBarView2.setBindObject(3);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bt_evaluation_confirm = (Button) findViewById(R.id.bt_evaluation_confirm);
        bt_evaluation_cancel = (Button) findViewById(R.id.bt_evaluation_cancel);
        mRatingBarView = (RatingBarView) findViewById(R.id.ratingbarview);
        mRatingBarView1 = (RatingBarView) findViewById(R.id.ratingbarview1);
        mRatingBarView2 = (RatingBarView) findViewById(R.id.ratingbarview2);
        tv_result = (TextView) findViewById(R.id.tv_ratingbar_result);
        tv_result1 = (TextView) findViewById(R.id.tv_ratingbar_result1);
        tv_result2 = (TextView) findViewById(R.id.tv_ratingbar_result2);
    }

    @Override
    protected int getLayout() {
        return R.layout.service_evaluation_activity;
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
            case R.id.bt_evaluation_confirm:

                //                break;
            case R.id.bt_evaluation_cancel:
                this.finish();
                AppManager appManager = AppManager.getAppManager();
                appManager.finishAllActivity();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    @Override
    public void onRating(Object bindObject, int RatingScore) {
        switch ((Integer) bindObject) {
            case 1:
                if (!StringUtils.isEmpty(tv_result.getText())) {
                    tv_result.clearComposingText();
                }
                tv_result.setVisibility(View.VISIBLE);
                tv_result.setText(evaluations[RatingScore-1]);
                //                ToastUtils.showShort("1 = " + RatingScore);
                break;
            case 2:
                if (!StringUtils.isEmpty(tv_result1.getText())) {
                    tv_result.clearComposingText();
                }
                tv_result1.setVisibility(View.VISIBLE);
                tv_result1.setText(evaluations[RatingScore-1]);
                //                ToastUtils.showShort("2 = " + RatingScore);
                break;
            case 3:
                if (!StringUtils.isEmpty(tv_result2.getText())) {
                    tv_result.clearComposingText();
                }
                tv_result2.setVisibility(View.VISIBLE);
                tv_result2.setText(evaluations[RatingScore-1]);
                //                ToastUtils.showShort("3 = " + RatingScore);
                break;
            default:
                break;
        }

    }
}
