package me.timschneeberger.servicemode.otp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
        return Long.toString(Duration.between(start, end).toMinutes()) + " minutes";
    }

    private static String getDateString(int i) {
        Calendar calender = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calender.add(Calendar.MINUTE, -i);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHH");
        dateFormat.setTimeZone(calender.getTimeZone());
        return dateFormat.format(calender.getTime());
    }

    private static int makeHashCode(String str) {
        int hashCode = 0;
        for (char c : str.toCharArray()) {
            hashCode = 31 * hashCode + c;
        }
        return Math.abs(hashCode);
    }
}
