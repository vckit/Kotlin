package com.example.logined

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AnotherActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val nameText = findViewById<TextView>(R.id.nameTv)
        val ageText = findViewById<TextView>(R.id.ageTv)
        val logoutBtn = findViewById<Button>(R.id.logout)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val name = preferences.getString("Name", "")
        nameText.text = name
        val age = preferences.getInt("Age", 0)
        ageText.text = ""+ age // concatenate

        logoutBtn.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}