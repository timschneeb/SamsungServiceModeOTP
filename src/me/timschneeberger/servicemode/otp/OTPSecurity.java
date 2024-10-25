package me.timschneeberger.servicemode.otp;

import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;


public class OTPSecurity {
    public static boolean checkOTP(String str, String str2) {
        int i = 5;
        while (true) {
            if (i <= -1)
                return false;

            i -= 1;
            if (str.equalsIgnoreCase(Integer.toString(makeHashCode(str2 + getDateString(i)))))
                return true;
        }
    }

    public static String getOTP(String basekey)
    {
        return Integer.toString(makeHashCode(basekey + getDateString(4)));
    }

    public static String getExpireDate() {
        LocalDateTime start = LocalDateTime.now(ZoneOffset.UTC).minusMinutes(4);
        LocalDateTime end = start.plusHours(1).truncatedTo(ChronoUnit.HOURS);
        return Duration.between(start, end).toMinutes() + " minutes";
    }

    private static String getDateString(int i) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(Calendar.MINUTE, i * -1);
        return new DecimalFormat("00").format(instance.get(Calendar.YEAR) - 2000) +
                new DecimalFormat("00").format(instance.get(Calendar.MONTH) + 1) +
                new DecimalFormat("00").format(instance.get(Calendar.MINUTE)) +
                new DecimalFormat("00").format(instance.get(Calendar.DATE)) +
                new DecimalFormat("00").format(instance.get(Calendar.HOUR_OF_DAY));
    }

    private static int makeHashCode(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = str.charAt(i2) + (i << 5) + i;
        }
        return i < 0 ? i * -1 : i;
    }
}
