package com.dhanmitra.models

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val name: String?,   // optional: in case you show "Welcome [Name]"
    val token: String?   // optional: for future secure access
)
