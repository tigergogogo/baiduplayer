package com.baidu.utils;

import android.database.Cursor;
import android.util.Log;

/**
 * Created by zhangpengfei on 2016/6/20.
 */
public class CursorUtil {
    private static final String TAG = "CursorUtil";
    public static void printCursor(Cursor cursor) {

        Log.e(TAG,"查询数据库获取到的数据总数为==="+cursor.getCount());
        while (cursor.moveToNext()){
            Log.e(TAG,"========================");
            for (int i = 0; i <cursor.getColumnCount(); i++) {
                Log.e(TAG,"name=="+cursor.getColumnName(i)+";value=="+cursor.getString(i));
            }
        }
    }
}
