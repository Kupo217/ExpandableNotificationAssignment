package com.example.expandablenotificationassignment

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.NotificationCompat

class CounterNotificationService(
    private val context: Context
) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
            )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_numbers_24)
            .setContentTitle("Increment counter $counter")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("This is detailed description of counter notification, that demonstrates that it is expandable." +
                        "You can click increment to increase number in the counter and it will change the value accordingly." +
                        "Thank you for seeing this notification <3"))
            .setContentIntent(pendingIntent)
            .addAction(
                R.drawable.ic_baseline_numbers_24,
                "Increment",
                incrementIntent
            )
            .build()


        notificationManager.notify(
            1,
            notification
        )
    }

    companion object {
        const val CHANNEL_ID = "counter_channel"
    }
}