package com.baidu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangpengfei on 2016/6/20.
 */
public class StringUtil {
    private static final int YOUR = 60 * 60 * 1000;
    private static final int MIN =  60 * 1000;
    private static final int SEC =  1000;


    public static String fromatDuration(int duration) {
        int hour = duration/YOUR;
        int min = duration%YOUR/MIN;
        int sec = duration%MIN/SEC;
        if (hour > 0) {
            /*00:00:00*/
            return String.format("%02d:%02d:%02d",hour,min,sec);
        }else {
            /*00:00*/
            return String.format("%02d:%02d",min,sec);
        }
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
