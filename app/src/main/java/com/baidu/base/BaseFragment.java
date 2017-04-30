package com.baidu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.activity.R;
import com.baidu.interfac.UiInterface;

/**
 * Created by guotaige on 17/4/6.
 */
public abstract class BaseFragment extends Fragment implements UiInterface {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(getLayoutID(),null);
        /*初始化view*/
        initView();
        /*初始化監聽*/
        initListener();
        /*初始化數據*/
        initData();
        /*處理公共控件的初始化和點擊監聽*/
        commonBtn();
        return view;

    }

    public View findViewById(int resID) {
        return view.findViewById(resID);
    }

    /*處理公共控件的初始化和點擊監聽*/
    private void commonBtn() {
        View v = findViewById(R.id.back);
        if (v != null) {
            v.setOnClickListener(this);
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                getFragmentManager().popBackStack();  //相当于activity的finish方法 退栈。 但是在该项目中，该方法时没有被用到的
                break;
            default:
                /*處理子類自己的點擊事件*/
                preClick(v);
                break;
        }
    }
}
