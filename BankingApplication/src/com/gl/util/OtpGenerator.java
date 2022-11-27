package com.gl.util;

public class OtpGenerator {
	public int getOTP() {
		int otp =0;
		otp = (int)((Math.random() * 9000)+1000 );
		return otp;
	}
}