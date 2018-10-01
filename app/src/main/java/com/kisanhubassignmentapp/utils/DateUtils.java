package com.kisanhubassignmentapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Prajakta on 29-09-2018.
 */

public class DateUtils {

    public static final String TAG = DateUtils.class.getSimpleName();

    public DateUtils() {
    }


    public static String getCurrentDateInFormat(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(new Date());
    }

    public static String getDateInFormat(String dateFormat, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
}
