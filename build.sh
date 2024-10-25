#!/bin/bash

javac src/me/timschneeberger/servicemode/otp/Main.java src/me/timschneeberger/servicemode/otp/OTPSecurity.java
jar cvfe SamsungServiceModeOTP.jar me.timschneeberger.servicemode.otp.Main -C src/ .
