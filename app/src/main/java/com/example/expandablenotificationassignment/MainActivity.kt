package com.example.expandablenotificationassignment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.glance.Button
import androidx.glance.layout.Box
import java.lang.reflect.Modifier

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = CounterNotificationService(applicationContext)

        findViewById<Button>(R.id.btnSendNotification).setOnClickListener {
            service.showNotification(Counter.value)
        }

    }


}