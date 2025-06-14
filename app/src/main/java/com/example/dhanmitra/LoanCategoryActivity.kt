package com.dhanmitra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoanCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_category)

        val businessLoanButton = findViewById<Button>(R.id.businessLoanButton)
        val personalLoanButton = findViewById<Button>(R.id.personalLoanButton)
        val homeLoanButton = findViewById<Button>(R.id.homeLoanButton)
        val educationLoanButton = findViewById<Button>(R.id.educationLoanButton)

        businessLoanButton.setOnClickListener { navigateToLoanDetails("Business Loan") }
        personalLoanButton.setOnClickListener { navigateToLoanDetails("Personal Loan") }
        homeLoanButton.setOnClickListener { navigateToLoanDetails("Home Loan") }
        educationLoanButton.setOnClickListener { navigateToLoanDetails("Education Loan") }
    }

    private fun navigateToLoanDetails(loanCategory: String) {
        val intent = Intent(this, LoanDetailsActivity::class.java)
        intent.putExtra("loanCategory", loanCategory)
        startActivity(intent)
    }
}
