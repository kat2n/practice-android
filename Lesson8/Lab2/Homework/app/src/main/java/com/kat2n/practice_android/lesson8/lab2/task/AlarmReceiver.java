package com.kat2n.practice_android.lesson8.lab2.task;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

  private static final int NOTIFICATION_ID = 0;
  private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

  private NotificationManager mNotificationManager;

  @Override
  public void onReceive(Context context, Intent intent) {
    mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    deliverNotification(context);
  }

  private void deliverNotification(Context context) {
    Intent contentIntent = new Intent(context, MainActivity.class);
    PendingIntent contentPendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
      .setSmallIcon(R.drawable.ic_android)
      .setContentTitle("Make a Wish!")
      .setContentText("It's 11:11!")
      .setContentIntent(contentPendingIntent)
      .setPriority(NotificationCompat.PRIORITY_HIGH)
      .setAutoCancel(true)
      .setDefaults(NotificationCompat.DEFAULT_ALL);
    mNotificationManager.notify(NOTIFICATION_ID, builder.build());
  }
}
