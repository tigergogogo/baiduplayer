package com.baidu.bean;

import android.database.Cursor;
import android.provider.MediaStore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by guotaige on 17/4/9.
 */
public class VedioItem implements Serializable{
    private String title,path;
    private int size,duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static ArrayList<VedioItem> instanceListFromCursor(Cursor cursor){
        ArrayList<VedioItem> items = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0){
            return items;
        }

        cursor.moveToPosition(-1);
        while (cursor.moveToNext()){
            items.add(instanceFromCursor(cursor));
        }

        return items;
    }

    public static VedioItem instanceFromCursor(Cursor cursor){
        VedioItem vedioItem = new VedioItem();
        if (cursor == null || cursor.getCount() == 0){
            return vedioItem;
        }

        vedioItem.title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
        vedioItem.path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
        vedioItem.size = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
        vedioItem.duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

        return vedioItem;
    }

    @Override
    public String toString() {
        return "VedioItem{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                '}';
    }
}
