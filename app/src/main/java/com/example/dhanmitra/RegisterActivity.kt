package com.dhanmitra

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.dhanmitra.models.RegisterRequest
import com.dhanmitra.models.RegisterResponse
import com.dhanmitra.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var aadhaarEditText: EditText
    private lateinit var panEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var loginRedirect: Button
    private lateinit var progressBar: ProgressBar

    private val apiService = ApiClient.apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nameEditText = findViewById(R.id.nameInput)
        emailEditText = findViewById(R.id.emailInput)
        passwordEditText = findViewById(R.id.passwordInput)
        phoneEditText = findViewById(R.id.phoneInput)
        genderEditText = findViewById(R.id.genderInput)
        dobEditText = findViewById(R.id.dobInput)
        addressEditText = findViewById(R.id.addressInput)
        aadhaarEditText = findViewById(R.id.aadhaarInput)
        panEditText = findViewById(R.id.panInput)
        registerButton = findViewById(R.id.registerBtn)
        loginRedirect = findViewById(R.id.loginRedirect)
        progressBar = findViewById(R.id.progressBar)

        registerButton.setOnClickListener {
            val request = RegisterRequest(
                nameEditText.text.toString().trim(),
                emailEditText.text.toString().trim(),
                passwordEditText.text.toString().trim(),
                phoneEditText.text.toString().trim(),
                genderEditText.text.toString().trim(),
                dobEditText.text.toString().trim(),
                addressEditText.text.toString().trim(),
                aadhaarEditText.text.toString().trim(),
                panEditText.text.toString().trim()
            )

            if (request.name.isEmpty() || request.email.isEmpty() || request.password.isEmpty() ||
                request.phone.isEmpty() || request.gender.isEmpty() || request.dob.isEmpty() ||
                request.address.isEmpty() || request.aadhaar_number.isEmpty() || request.pan_number.isEmpty()
            ) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(request)
            }
        }

        loginRedirect.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun registerUser(request: RegisterRequest) {
        progressBar.visibility = View.VISIBLE
        apiService.registerUser(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                progressBar.visibility = View.GONE
                val resBody = response.body()
                if (response.isSuccessful && resBody?.success == true) {
                    val intent = Intent(this@RegisterActivity, DashboardActivity::class.java)
                    intent.putExtra("user_name", request.name)
                    intent.putExtra("is_new_user", true)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@RegisterActivity, resBody?.message ?: "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(this@RegisterActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
