package com.baidu.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baidu.activity.R;
import com.baidu.activity.VedioPlayActivity;
import com.baidu.adapter.VedioCursorAdapter;
import com.baidu.base.BaseFragment;
import com.baidu.bean.VedioItem;
import com.baidu.utils.CursorUtil;

/**
 * Created by guotaige on 17/4/6.
 */
public class VedioFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    private ListView list_view;
    private VedioCursorAdapter adapter;
    @Override
    public int getLayoutID() {
        return R.layout.fragment_vedio;
    }

    @Override
    public void initView() {
        list_view = (ListView) findViewById(R.id.list_view);

    }

    @Override
    public void initListener() {
        list_view.setOnItemClickListener(this);
        adapter = new VedioCursorAdapter(getActivity(),null);
        list_view.setAdapter(adapter);
    }

    @Override
    public void initData() {
        //查询sd卡下的视频文件
        ContentResolver contentResolver = getActivity().getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Video.Media._ID, MediaStore.Video.Media.DATA, MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DURATION, MediaStore.Video.Media.TITLE},null,null,null);
        CursorUtil.printCursor(cursor);
        //如果游标被放置在一个CursorAdapter中，你应使用swapCursor()方法，以使旧的游标不被关闭
        adapter.swapCursor(cursor);


    }

    @Override
    public void preClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);
        VedioItem vedioItem = VedioItem.instanceFromCursor(cursor);
        Intent intent = new Intent(getActivity(), VedioPlayActivity.class);
        intent.putExtra("item",vedioItem);
        startActivity(intent);

    }
}
