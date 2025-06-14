package com.dhanmitra.models

data class   OtpVerifyRequest(
    val email: String,
    val otp: String
)
