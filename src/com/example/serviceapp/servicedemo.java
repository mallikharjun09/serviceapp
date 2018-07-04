package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;

public class servicedemo extends Service implements Runnable {
	int[] images={R.drawable.desert,R.drawable.kola};
	private Bitmap b1,b2;
	int time=0;
	public Thread th;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Bundle b=intent.getExtras();
		time=b.getInt("time");
		b1=BitmapFactory.decodeResource(getResources(),images[0]);
		b2=BitmapFactory.decodeResource(getResources(),images[1]);
		th=new Thread(servicedemo.this);
		th.start();
		
		
		return super.onStartCommand(intent, flags, startId);

	}
	int dummy=0;
	@Override
	
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true)
			{
				if(dummy==0)
				{
					this.setWallpaper(b1);
					dummy++;
				}
				else
				{
					this.setWallpaper(b2);
					dummy--;
				}
			Thread.sleep(time*1000);//either 60*1000 or 300*1000
			}
		}
		catch(Exception obj){}
	}
	
	}	
	

