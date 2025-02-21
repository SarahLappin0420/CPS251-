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

                binding.textView.text = getString(R.string.YOU_MUST_ENTER_A_BILL_AMOUNT)
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

        /*   val resultText =
            "Total with 10% tip: $%.2f\nTotal with 15% tip: $%.2f\nTotal with 20% tip: $%.2f" */
        binding.textView.text =
            "Total with 10% tip:$${"%.2f".format(tip10)}\n" + "Total with 15% tip: $${
                "%.2f".format(tip15)
            }\n" + "Total with 20% tip: $${
                "%.2f".format(tip20)
            }"}}






