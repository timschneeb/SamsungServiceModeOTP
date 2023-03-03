package me.timschneeberger.servicemode.otp;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1)
        {
            System.out.println("Usage: SamsungServiceModeOTP <input key>");
            return;
        }

        String otp = OTPSecurity.getOTP(args[0]);
        System.out.println("Decrypted one-time password: " + otp);

        if(OTPSecurity.checkOTP(otp, args[0]))
        {
            System.out.println("=> Key verified. OTP expires in " + OTPSecurity.getExpireDate() + ".");
        }
        else
        {
            System.out.println("=> Key not verified. Something is wrong");
        }
    }
}
