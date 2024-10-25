# SamsungServiceModeOTP
Generate OTP tokens for Samsung Service Mode to activate hidden debug/dumping features

1. Download .jar file: https://github.com/ThePBone/SamsungServiceModeOTP/releases/
2. Access SysDump service mode menu using secret code: `*#9900#`
3. Select any option that requires OTP authentication (i.e. `TCP DUMP START`)
4. Use this program to generate an activation key using the nonce provided by the app (`java -jar SamsungServiceModeOTP.jar <nonce>`)
5. Insert the generated key into the app and activate the locked features

Note: The generated OTPs expire after a while and are calculated using time and date. Make sure the clock on your computer and phone are accurate and in the same timezone.

Example:
```bash
java -jar SamsungServiceModeOTP.jar yuh0h
```
```
Decrypted one-time password: 2142664100
=> Key verified. OTP expires in 13 minutes.
```
