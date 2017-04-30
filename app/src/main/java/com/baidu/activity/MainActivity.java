package com.baidu.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.adapter.MyFragmentAdapter;
import com.baidu.base.BaseActivity;
import com.baidu.fragment.AudioFragment;
import com.baidu.fragment.VedioFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private TextView main_tv_vedio,main_tv_audio;
    private ImageView main_indicate;
    private ViewPager main_viewpager;
    private ArrayList<Fragment> fragments;
    private MyFragmentAdapter adapter;
    private MyOnPageChangeListener myOnPageChangeListener;
    private int screenW;
    private int screenH;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        main_tv_vedio = (TextView) findViewById(R.id.main_tv_vedio);
        main_tv_audio = (TextView) findViewById(R.id.main_tv_audio);
        main_indicate = (ImageView) findViewById(R.id.main_indicate);
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
        getScreenWH();
    }

    private void getScreenWH() {
        screenW = getWindowManager().getDefaultDisplay().getWidth();
        screenH = getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override
    public void initListener() {
        main_tv_vedio.setOnClickListener(this);
        main_tv_audio.setOnClickListener(this);

        myOnPageChangeListener = new MyOnPageChangeListener();
        main_viewpager.setOnPageChangeListener(myOnPageChangeListener);

    }

    @Override
    public void initData() {
        fragments = new ArrayList<>();
        adapter = new MyFragmentAdapter(getSupportFragmentManager(),fragments);
        main_viewpager.setAdapter(adapter);
        fragments.add(new VedioFragment());
        fragments.add(new AudioFragment());

        adapter.notifyDataSetChanged();
        updataTabs(0);
        main_indicate.getLayoutParams().width = screenW / fragments.size();
    }

    @Override
    public void preClick(View view) {
        switch (view.getId()){
            case R.id.main_tv_vedio:
                main_viewpager.setCurrentItem(0);
                break;
            case R.id.main_tv_audio:
                main_viewpager.setCurrentItem(1);
                break;

        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        /*当页面滑动时回调*/
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.e(TAG,"position=="+position+";positionOffset=="+positionOffset+";positionOffsetPixels="+positionOffsetPixels);

//            移动的位置 = 起始位置 + 偏移位置
//                起始位置 = position * 指示器宽度
//                        偏移位置 = 手指划过屏幕的百分比 * 指示器跨度
//            main_indicate.getWidth() * (position +positionOffset );
//              ViewCompat.animate(main_indicate).translationX(main_indicate.getWidth() * (position +positionOffset ));
            ViewCompat.setTranslationX(main_indicate,main_indicate.getWidth() * (position +positionOffset ));
        }

        @Override
        /*当页面滑动结束选中后回调*/
        public void onPageSelected(int position) {
            updataTabs(position);
        }

        @Override
        /*当页面滑动状态发生变化时回调*/
        public void onPageScrollStateChanged(int state) {

        }
    }

    private void updataTabs(int position) {
        updataTab(0,position,main_tv_vedio);
        updataTab(1,position,main_tv_audio);
    }

    private void updataTab(int i, int position, TextView tab) {
        int green = getResources().getColor(R.color.green);
        int halfwhite = getResources().getColor(R.color.halfwhite);
        if (i == position) {
            /*选中状态*/
            tab.setTextColor(green);
            ViewCompat.animate(tab).scaleX(1.2f).scaleY(1.2f);
        }else{
            /*非选中状态*/
            tab.setTextColor(halfwhite);
            ViewCompat.animate(tab).scaleX(1.0f).scaleY(1.0f);
        }
    }
}
