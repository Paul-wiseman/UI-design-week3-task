package com.example.week3task

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  Toast.makeText(applicationContext, "COMMONSHOW", Toast.LENGTH_LONG).show()

        // create button to implement dark theme
        val switch: ImageButton = findViewById(R.id.btnMode)
        val appSettings: SharedPreferences = getSharedPreferences("AppSettings", 0)
        val sharedEdit: SharedPreferences.Editor = appSettings.edit()
        val nightModeOn: Boolean = appSettings.getBoolean("NightMode", false)

        if (nightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            //on the dark theme or night mode a sunny image is displayed as the switch button
//            switch.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_wb_sunny_24))
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            //on the light theme or day mode a moon is displayed as the switch button
//            switch.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_bedtime_24))
        }

        //onclick listener to switch between the theme or mode
        switch.setOnClickListener {
            if (nightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedEdit.putBoolean("NightMode", false)
                sharedEdit.apply()


            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedEdit.putBoolean("NightMode", true)
                sharedEdit.apply()

            }
        }

    }
}

