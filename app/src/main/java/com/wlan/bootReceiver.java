package com.wlan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class bootReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(Context arg0, Intent arg1) {

		Intent newIntent = new Intent("com.wlan.autoBoot");
		arg0.startService(newIntent);//启动服务
		
	}

}
