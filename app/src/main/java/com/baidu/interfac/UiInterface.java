package com.baidu.interfac;

import android.view.View;

/**
 * Created by guotaige on 17/4/5.
 */
public interface UiInterface extends View.OnClickListener {

    int getLayoutID();

    void initView();

    void initListener();

    void initData();

    void preClick(View view);
}
