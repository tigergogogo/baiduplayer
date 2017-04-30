package com.baidu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.baidu.base.BaseActivity;

/**
 * Created by guotaige on 17/4/5.
 */
public class SplashActivity extends BaseActivity {

    private Intent intent;


    @Override
    public int getLayoutID() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        //全屏
        intent = new Intent();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    public void preClick(View view) {

    }

    @Override
    protected void onResume() {
        super.onResume();




    }
}
