package me.timschneeberger.servicemode.otp;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class OTPSecurity {
    public static boolean CheckOTP(String str, String str2) {
        int i = 5;
        while (true) {
            int i2 = i - 1;
            if (i <= -1) {
                return false;
            }
            if (str.equalsIgnoreCase(Integer.toString(MakeHashCode(String.valueOf(str2) + GetDateString(i2))))) {
                return true;
            }
            i = i2;
        }
    }

    public static String GetOTP(String basekey)
    {
        return Integer.toString(MakeHashCode(String.valueOf(basekey) + GetDateString(4)));
    }

    private static String GetDateString(int i) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(12, i * -1);
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(new DecimalFormat("00").format((long) (instance.get(1) - 2000))) + new DecimalFormat("00").format((long) (instance.get(2) + 1))));
        sb.append(new DecimalFormat("00").format((long) instance.get(12)));
        return String.valueOf(String.valueOf(sb.toString()) + new DecimalFormat("00").format((long) instance.get(5))) + new DecimalFormat("00").format((long) instance.get(11));
    }

    private static int MakeHashCode(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = str.charAt(i2) + (i << 5) + i;
        }
        return i < 0 ? i * -1 : i;
    }
}
