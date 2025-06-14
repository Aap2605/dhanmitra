package com.dhanmitra.models


data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String,
    val gender: String,
    val dob: String,
    val address: String,
    val aadhaar_number: String,
    val pan_number: String
)
