package com.dhanmitra

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dhanmitra.network.ApiClient
import com.dhanmitra.network.ApiService
import com.dhanmitra.models.OtpVerifyRequest
import com.dhanmitra.models.OtpVerifyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterOtpActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_otp)

        apiService = ApiClient.apiService

        val otpEditText = findViewById<EditText>(R.id.otpInput)
        val verifyOtpButton = findViewById<Button>(R.id.verifyBtn)

        verifyOtpButton.setOnClickListener {
            val otp = otpEditText.text.toString()
            val email = intent.getStringExtra("email") ?: ""

            val request = OtpVerifyRequest(email, otp)
            verifyOtp(request)
        }
    }

    private fun verifyOtp(request: OtpVerifyRequest) {
        apiService.verifyOtp(request).enqueue(object : Callback<OtpVerifyResponse> {
            override fun onResponse(call: Call<OtpVerifyResponse>, response: Response<OtpVerifyResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterOtpActivity, "OTP Verified!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@RegisterOtpActivity, "Invalid OTP", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<OtpVerifyResponse>, t: Throwable) {
                Toast.makeText(this@RegisterOtpActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
