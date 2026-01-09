package com.example.formapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResultData = findViewById<TextView>(R.id.tvResultData)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val age = intent.getStringExtra("age")

        tvResultData.text =
            "Name: $name\nEmail: $email\nPhone: $phone\nAge: $age"
    }
}
