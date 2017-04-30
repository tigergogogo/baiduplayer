package com.baidu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.baidu.activity.R;
import com.baidu.interfac.UiInterface;

/**
 * Created by guotaige on 17/4/5.
 */
public abstract class BaseActivity extends FragmentActivity implements UiInterface{

    public String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局
        setContentView(getLayoutID());
        //初始化页面
        initView();
        //初始化监听
        initListener();
        //初始化数据
        initData();
        //处理公共控件的初始化和点击监听
        commonBtn();



    }

    private void commonBtn() {
        View view = findViewById(R.id.back);
        if (view != null){
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                //处理子类自己的点击事件
                preClick(v);
                break;
        }
    }
}
