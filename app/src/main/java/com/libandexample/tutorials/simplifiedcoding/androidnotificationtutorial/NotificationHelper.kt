package com.libandexample.tutorials.simplifiedcoding.androidnotificationtutorial

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.libandexample.R

internal object NotificationHelper {

    fun displayNotification(context: Context, title: String, body: String) {

        val mBuilder = NotificationCompat.Builder(context, AndroidNotificationMainActivity.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

        val mNotificationMgr = NotificationManagerCompat.from(context)
        mNotificationMgr.notify(1, mBuilder.build())

    }

}
