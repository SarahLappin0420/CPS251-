package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity

import com.example.tipcalculator.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val billAmountStr = binding.billAmount.text.toString()
            if (billAmountStr.isEmpty()) {

                binding.textView.text = getString(R.string.please_enter_a_bill_amount)
            } else {
                val billAmount = billAmountStr.toDouble()
                displayTipAmounts(billAmount)
                }


            }
        }


    private fun displayTipAmounts(billAmount: Double) {
        val tip10 = billAmount * 1.10
        val tip15 = billAmount * 1.15
        val tip20 = billAmount * 1.20

        val resultText =
            "Total with 10% tip: $%.2f\nTotal with 15% tip: $%.2f\nTotal with 20% tip: $%.2f"
        binding.textView.text = resultText.format(tip10, tip15, tip20)
    }}






