package com.example.benjamin

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.benjamin.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        var mainVirtueId = sharedPreferences.getInt("mainVirtueId", 12)
        val lastRenewalDate = sharedPreferences.getString("lastRenewalDate", "")
        val currentDate = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val date = dateFormat.format(currentDate)
        if (!lastRenewalDate.equals(date)) {
            if (mainVirtueId != 12) {
                mainVirtueId++
                editor.putInt("mainVirtueId", mainVirtueId)
            }else {
                editor.putInt("mainVirtueId", 0)
            }
            editor.putString("lastRenewalDate", date)
            editor.commit()
        }
        Constants.mainVirtueIndex = mainVirtueId

            CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}