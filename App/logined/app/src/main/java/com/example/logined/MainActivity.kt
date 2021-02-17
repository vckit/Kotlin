package com.example.logined

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemembered){
            var intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }
        val btnLogin = findViewById<Button>(R.id.login)
        val textEt = findViewById<TextView>(R.id.nameEt)
        val textAge = findViewById<TextView>(R.id.ageEt)
        val check = findViewById<CheckBox>(R.id.checkRemember)

        btnLogin.setOnClickListener{
            val name: String = textEt.text.toString()
            val age: Int = textAge.text.toString().toInt()
            val checked : Boolean = check.isChecked

            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("Name", name)
            editor.putInt("Age", age)
            editor.putBoolean("Checkbox", checked)
            editor.apply()

            Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}