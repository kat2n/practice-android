package com.kat2n.practice_android.lesson7.lab3.task;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

  private CustomReceiver mReceiver = new CustomReceiver();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    receivePowerBroadcast();
    receiveCustomeBroadcast();
    receiveHeadsetPlugBroadcast();
  }

  @Override
  protected void onDestroy() {
    this.unregisterReceiver(mReceiver);
    LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    super.onDestroy();
  }

  public void sendCustomBroadcast(View view) {
    Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
    LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
  }

  private void receivePowerBroadcast() {
    IntentFilter filter = new IntentFilter();
    filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
    filter.addAction(Intent.ACTION_POWER_CONNECTED);
    this.registerReceiver(mReceiver, filter);
  }

  private void receiveCustomeBroadcast() {
    LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
  }

  private void receiveHeadsetPlugBroadcast() {
    this.registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
  }
}
