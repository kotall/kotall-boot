package com.kotall.rms.common.utils;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class FileKit {

    public static String getFileSufix(String fileName) {
        int index = fileName.lastIndexOf('.');
        String suffix = fileName.substring(index);
        return suffix;
    }
}
