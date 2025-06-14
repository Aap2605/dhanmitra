package com.dhanmitra

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoanDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_details)

        val loanCategory = intent.getStringExtra("loanCategory")
        val loanDetailsText = findViewById<TextView>(R.id.loanDetailsText)

        loanDetailsText.text = when (loanCategory) {
            "Business Loan" -> "Details about Business Loan:\n• Bank Statement\n• GST\n• Up to ₹10 Lakhs"
            "Personal Loan" -> "Details about Personal Loan:\n• Aadhaar + PAN\n• Salary > ₹15,000\n• Up to ₹5 Lakhs"
            "Home Loan" -> "Details about Home Loan:\n• CIBIL > 700\n• Property Papers\n• Up to ₹50 Lakhs"
            "Education Loan" -> "Details about Education Loan:\n• Admission Letter\n• Co-applicant\n• Up to ₹25 Lakhs"
            else -> "No details available."
        }
    }
}
