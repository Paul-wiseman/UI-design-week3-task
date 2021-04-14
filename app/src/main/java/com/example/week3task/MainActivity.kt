package com.example.week3task

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Toast.makeText(applicationContext, "COMMONSHOW", Toast.LENGTH_LONG).show()

        // create button to implement dark theme
        val Switch:ImageButton = findViewById<ImageButton>(R.id.btnMode)
        val appSettings: SharedPreferences = getSharedPreferences("AppSettings", 0)
        val sharedEdit: SharedPreferences.Editor = appSettings.edit()
        val nightModeOn: Boolean = appSettings.getBoolean("NightMode", false)

        if (nightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            //on the dark theme or night mode a sunny image is displayed as the switch button
            Switch.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_wb_sunny_24))
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            //on the light theme or day mode a moon is displayed as the switch button
            Switch.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_baseline_bedtime_24))
        }
//onclick listener to switch between the theme or mode
        Switch.setOnClickListener {
            if (nightModeOn){
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





//btn_Theme.addOnButtonCheckedListener(object :MaterialButtonToggleGroup.OnButtonCheckedListener{
//    override fun onButtonChecked(
//        group: MaterialButtonToggleGroup?,
//        selectedBtnId: Int,
//        isChecked: Boolean
//    ) { if (isChecked){
//        val theme = when(selectedBtnId){
//            R.id.btnLight -> AppCompatDelegate.MODE_NIGHT_NO
//            R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES
//            else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//        }
//        Log.d("checking", "ischecked:$isChecked theme:$theme")
//        AppCompatDelegate.setDefaultNightMode(theme)
//    }
//
//    }
//})
//
//<com.google.android.material.button.MaterialButtonToggleGroup
//android:id="@+id/btn_Theme"
//android:layout_width="0dp"
//android:layout_height="91dp"
//app:singleSelection="true"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintHorizontal_bias="1.0"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent">
//
//<Button
//android:id="@+id/btnLight"
//style="@style/Widget.MaterialComponents.Button.OutlinedButton"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="@string/lightMode"
//android:textColor="@color/textColor"
//android:backgroundTint="@color/rect_tint"
//app:cornerRadius="5dp"
//
///>
//
//<Button
//android:id="@+id/btnDark"
//style="@style/Widget.MaterialComponents.Button.OutlinedButton"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="@string/darkMode"
//android:textColor="@color/textColor"
//android:backgroundTint="@color/rect_tint"
//app:cornerRadius="5dp"
///>
//
//</com.google.android.material.button.MaterialButtonToggleGroup>
