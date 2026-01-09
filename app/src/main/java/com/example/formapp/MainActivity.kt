package com.example.formapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAge: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnReset: Button
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etAge = findViewById(R.id.etAge)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnReset = findViewById(R.id.btnReset)

        preferences = getSharedPreferences("UserData", MODE_PRIVATE)

        btnSubmit.setOnClickListener {

            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()
            val age = etAge.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || age.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save data locally
            preferences.edit()
                .putString("name", name)
                .putString("email", email)
                .putString("phone", phone)
                .putString("age", age)
                .apply()

            Toast.makeText(this, "Your response is recorded", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            intent.putExtra("age", age)
            startActivity(intent)
        }

        btnReset.setOnClickListener {
            preferences.edit().clear().apply()
            etName.setText("")
            etEmail.setText("")
            etPhone.setText("")
            etAge.setText("")
            Toast.makeText(this, "Data reset successfully", Toast.LENGTH_SHORT).show()
        }
    }
}
