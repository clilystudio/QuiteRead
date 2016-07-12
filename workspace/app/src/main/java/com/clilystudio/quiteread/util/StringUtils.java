package com.clilystudio.quiteread.util;

import java.util.Locale;

public class StringUtils {

    public static String formatFileSize(long fileSize) {
        if (fileSize < 1000) {
            return "" + fileSize + " B";
        }
        int index = (int) (Math.log(fileSize) / Math.log(1000.0));
        String unit = "" + "kMGTPE".charAt(index - 1);
        return String.format(Locale.CHINA,"%.1f %sB", (float) fileSize / Math.pow(1000.0, index), unit);
    }
}
