package com.example.notifytestinbackground

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        var button:Button = findViewById(R.id.buttonRemind)
        button.setOnClickListener {
            Toast.makeText(this, "REMMIDNER SET", Toast.LENGTH_SHORT).show()
            val intent:Intent = Intent(this, ReminderBroadcast::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0 ,intent, 0 )

            val alarmManager:AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val timeAtButtonClick = System.currentTimeMillis()
            alarmManager.set(AlarmManager.RTC_WAKEUP,
            timeAtButtonClick+10000,
            pendingIntent)
        }
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) run {
            val name: String = "Reminder"
            val description: String = "casdasdasdasd"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel: NotificationChannel = NotificationChannel("notifiTest", name, importance)
            channel.description = description

            val notificationManager: NotificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}