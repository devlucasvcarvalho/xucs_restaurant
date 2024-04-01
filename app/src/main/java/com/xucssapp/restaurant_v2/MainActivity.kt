package com.xucssapp.restaurant_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var total = 0.0
    private lateinit var textViewResult: TextView
    private val decimalFormat = DecimalFormat("#0.00")
    data class FoodOption(val id: Int, val price: Double)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodOptions = arrayOf(FoodOption(R.id.Frits_check, 10.0),
            FoodOption(R.id.Barbecue_check, 8.50),
            FoodOption(R.id.Sausage_check, 5.0),
            FoodOption(R.id.Farofa_check, 11.70),
            FoodOption(R.id.Beef_check, 45.0),
            FoodOption(R.id.Cooked_check, 25.50),
            FoodOption(R.id.Chicken_check, 18.90),
            FoodOption(R.id.Yaksoba_check, 18.50),
            FoodOption(R.id.Suco_check, 5.0),
            FoodOption(R.id.Caipirinha_check, 10.0),
            FoodOption(R.id.Cupckake_check, 5.0),
            FoodOption(R.id.Croassant_check, 8.0),
            FoodOption(R.id.Popsicle_check, 8.0),
            FoodOption(R.id.Icecream_check, 8.0),)


        for (food in foodOptions){
            val checkBox = findViewById<CheckBox>(food.id)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                this.handleCheckBox(food.price, isChecked)
            }
        }

        val buttonCalculate = findViewById<Button>(R.id.Button_calculate)
        textViewResult = findViewById(R.id.Total_Payment_res)

        buttonCalculate.setOnClickListener {
            if (total == 0.0) {
                Toast.makeText(this, R.string.Toast_safe_Res, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.Toast_completed_res, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun handleCheckBox(value: Double, isChecked: Boolean) {
        if (isChecked) {
            total += value
        } else {
            total -= value
        }

        updateResult()
    }

    private fun updateResult() {
        val formattedTotal = decimalFormat.format(total)
        textViewResult.text = "R$ $formattedTotal"
    }
}

