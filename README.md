# SamsungServiceModeOTP
Generate OTP tokens for Samsung Service Mode to activate hidden debug/dumping features

1. Access SysDump service mode menu using secret code: `*#9900#`
2. Select any option that requires OTP authentication (i.e. `TCP DUMP START`)
3. Use this program to generate an activation key using the nonce provided by the app (`./SamsungServiceModeOTP <nonce>`)
4. Insert the generated key into the app and activate the locked features
