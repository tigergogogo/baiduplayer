package com.baidu.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.baidu.base.BaseActivity;
import com.baidu.bean.VedioItem;
import com.baidu.utils.StringUtil;
import com.baidu.view.VideoView;

import java.util.Date;

public class VedioPlayActivity extends BaseActivity {


    private VideoView vedioplay_videoview;
    private VedioItem vedioItem;

    private TextView videoplayer_tv_title;
    private TextView videoplayer_tv_system_time;
    private ImageView videoplayer_iv_battery;
    private ImageView videoplayer_iv_mute;
    private SeekBar videoplayer_sk_volume;

    @Override
    public int getLayoutID() {
        return R.layout.activity_vedio_play;

    }

    @Override
    public void initView() {
        vedioplay_videoview = (VideoView) findViewById(R.id.videoplayer_videoview);
        videoplayer_tv_title = (TextView) findViewById(R.id.videoplayer_tv_title);
        videoplayer_tv_system_time = (TextView) findViewById(R.id.videoplayer_tv_system_time);
        videoplayer_iv_battery = (ImageView) findViewById(R.id.videoplayer_iv_battery);
        videoplayer_iv_mute = (ImageView) findViewById(R.id.videoplayer_iv_mute);
        videoplayer_sk_volume = (SeekBar) findViewById(R.id.videoplayer_sk_volume);
    }

    @Override
    public void initListener() {
        vedioplay_videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            //预加载结束后回掉
            @Override
            public void onPrepared(MediaPlayer mp) {
                vedioplay_videoview.start();
                videoplayer_tv_title.setText(vedioItem.getTitle());
                videoplayer_tv_system_time.setText(StringUtil.getDate());
            }
        });
    }

    @Override
    public void initData() {
        vedioItem = (VedioItem) getIntent().getSerializableExtra("item");
    }

    @Override
    public void preClick(View view) {

    }
}
