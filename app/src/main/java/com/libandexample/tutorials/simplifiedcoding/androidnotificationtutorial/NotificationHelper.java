package com.libandexample.tutorials.simplifiedcoding.androidnotificationtutorial;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.libandexample.R;

public class NotificationHelper {

    public static void displayNotification(Context context, String title, String body) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, AndroidNotificationMainActivity.CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat mNotificationMgr = NotificationManagerCompat.from(context);
        mNotificationMgr.notify(1, mBuilder.build());

    }

}
