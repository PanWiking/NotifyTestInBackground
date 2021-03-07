package com.example.notifytestinbackground

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        var pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        var builder: NotificationCompat.Builder = NotificationCompat.Builder(context, "notifiTest")
            .setContentTitle("titleLest")
            .setContentText("text")
            .setSmallIcon(R.drawable.ic_baseline_api_24)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        var notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(6666, builder.build())
    }
}