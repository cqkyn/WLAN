package com.wlan;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class autoBoot extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher, "服务已经自启动", System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(autoBoot.this ,0,new Intent(autoBoot.this, MainActivity.class) , 0);
		notification.setLatestEventInfo(autoBoot.this, "自启动", "服务已经自启动", pendingIntent);
		notification.flags= Notification.FLAG_AUTO_CANCEL;
		notification.defaults=Notification.DEFAULT_SOUND;
		notificationManager.notify(0, notification);


		super.onCreate();
	}

	@Override
	public void onDestroy() {
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification1 = new Notification(R.drawable.ic_launcher, "服务已停止启动", System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(autoBoot.this ,0,new Intent(autoBoot.this, MainActivity.class) , 0);
		notification1.flags= Notification.FLAG_AUTO_CANCEL;
		notification1.defaults=Notification.DEFAULT_SOUND;
		notificationManager.notify(0, notification1);
		super.onDestroy();
	}

}
