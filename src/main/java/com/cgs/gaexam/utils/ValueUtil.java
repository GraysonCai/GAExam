package com.cgs.gaexam.utils;

import java.text.DecimalFormat;

public class ValueUtil {

    private static DecimalFormat df = new DecimalFormat();

    /**
     * 格式化小数点
     *
     * @param digits
     * @param pattern
     * @return
     */
    public static float roundDecimals(float digits, String pattern) {
        df.applyPattern(pattern);
        return Float.valueOf(df.format(digits));
    }

    /**
     * 格式化两位小数点
     *
     * @param digits
     * @return
     */
    public static float round2Decimals(float digits) {
        df.applyPattern("0.00");
        return Float.valueOf(df.format(digits));
    }

    /**
     * 格式化两位小数点
     *
     * @param digits
     * @return
     */
    public static float round2Decimals(int digits) {
        df.applyPattern("0.00");
        return Float.valueOf(df.format(digits));
    }

    public static void main(String[] args) {
        float f = 0.123456F;
        System.out.println(roundDecimals(f, "0.00"));
        System.out.println(roundDecimals(f, "#.000"));
    }
}
