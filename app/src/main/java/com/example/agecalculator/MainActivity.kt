package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var selectDate : TextView
    private lateinit var calcBtn : Button
    private lateinit var showAge : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectDate = findViewById(R.id.selectDate)
        calcBtn  = findViewById(R.id.calcBtn)
        showAge = findViewById(R.id.showAge)
    }

    fun selectDate(view : View) {
        var c = Calendar.getInstance();
        var cDay = c.get(Calendar.DAY_OF_MONTH);
        var cMonth = c.get(Calendar.MONTH);
        var cYear = c.get(Calendar.YEAR);

        var calendarDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                cDay = dayOfMonth
                cMonth = month
                cYear = year
                calcBtn.visibility = View.VISIBLE
                textMessage("You select date : $cDay/${cMonth+1}/$cYear")
                calcBtn.setOnClickListener {
                    val currentYear = Calendar.getInstance()
                        .get(Calendar.YEAR)
                    val age = currentYear - cYear
                    showAge.visibility = View.VISIBLE
                    showAge.text = "Your age is $age"
                    textMessage("Your age is $age")
                }
                selectDate.text = "You select date : $cDay/${cMonth+1}/$cYear"
            }, cYear, cMonth, cDay)
        calendarDialog.show()
    }

    private fun textMessage(s : String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}