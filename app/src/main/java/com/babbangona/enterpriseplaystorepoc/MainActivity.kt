package com.babbangona.enterpriseplaystorepoc

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    private lateinit var tV2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tvH2)
        tV2 = findViewById(R.id.textView)
        tv.text = "This is the closed-testing branch versionName: ${BuildConfig.VERSION_NAME}"
    }
}