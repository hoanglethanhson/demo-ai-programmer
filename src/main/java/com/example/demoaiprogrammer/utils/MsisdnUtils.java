package com.example.demoaiprogrammer.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MsisdnUtils {
    public static String formatMsisdn(String msisdn) {
        if (msisdn.startsWith("0")) {
            return msisdn.replaceFirst("0", "84");
        }
        return msisdn;
    }

    public static String formatMsisdnWithZero(String msisdn) {
        if (msisdn.startsWith("84")) {
            return msisdn.replaceFirst("84", "0");
        }
        return msisdn;
    }

    public static boolean isMsisdnValid(String msisdn) {
        return msisdn.matches("^(84|0)(3[2-9]|5[2689]|7[06789]|8[1-689]|9[0-9])[0-9]{7}$");
    }
}
