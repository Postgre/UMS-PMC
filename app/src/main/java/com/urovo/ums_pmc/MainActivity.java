package com.urovo.ums_pmc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.urovo.ums_pmc.lib.zxing.android.CaptureActivity;
import com.urovo.ums_pmc.view.Carousel;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout ll_parking_pay;
    private LinearLayout ll_owner_repair;
    private LinearLayout ll_owner_confirm;
    private LinearLayout ll_property_pay;
    private LinearLayout ll_safe_patrol;

    public final static int SCANNING_REQUEST_CODE = 200;
    private Carousel ad;


    @Override
    protected void initListener() {
        ll_parking_pay.setOnClickListener(this);
        ll_owner_repair.setOnClickListener(this);
        ll_owner_confirm.setOnClickListener(this);
        ll_property_pay.setOnClickListener(this);
        ll_safe_patrol.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        int[] imgs = {R.drawable.ad};
        ad.setImagesRes(imgs);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ll_parking_pay = (LinearLayout) findViewById(R.id.parking_pay);
        ll_owner_repair = (LinearLayout) findViewById(R.id.owner_repair);
        ll_owner_confirm = (LinearLayout) findViewById(R.id.owner_confirm);
        ll_property_pay = (LinearLayout) findViewById(R.id.property_pay);
        ll_safe_patrol = (LinearLayout) findViewById(R.id.safe_patrol);
//        ImageView ad = (ImageView) findViewById(R.id.iv_ad);
        ad = (Carousel)findViewById(R.id.iv_ad);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
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
            case R.id.parking_pay:
                startActivity(new Intent(this, ParkingPayActivity.class));
                break;
            case R.id.owner_repair:
                startActivity(new Intent(this, OwerRepairActivity.class));
                break;
            case R.id.owner_confirm:
                startScanningActivity();
                break;
            case R.id.property_pay:
                startActivity(new Intent(this, PayMethodActivity.class));
                break;
            case R.id.safe_patrol:
                startActivity(new Intent(this, SafePatrolActivity.class));
                break;
            default:
                break;
        }
    }

    private void startScanningActivity() {
        try {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityForResult(intent, SCANNING_REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNING_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    if (null != bundle) {//codedContent//result
                        Intent intent = new Intent(this, PropertyActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                }
                break;
            default:
                break;
        }
    }
}
