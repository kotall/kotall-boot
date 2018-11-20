package com.kotall.rms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateTimeUtil {

    /**
     * 格式 yyyy年MM月dd日 HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static String getDateTimeDisplayString(Date dateTime) {

        SimpleDateFormat dtf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(dateTime);

        return strDate2;
    }
}
