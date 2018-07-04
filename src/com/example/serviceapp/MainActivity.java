package com.example.serviceapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity {
	private RadioButton r1,r2;
	EditText t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		r1=(RadioButton)findViewById(R.id.radioButton1);
	    r2=(RadioButton)findViewById(R.id.radioButton2);
	    t1=(EditText)findViewById(R.id.editText1);
	    registerForContextMenu(t1);
	} int t;
	  public void settime(View v)
	    
	  {
	      	if(r1.isChecked())
	      
	  	{
	      	   t=60;//1 minute	
	      	}
	      
	  	if(r2.isChecked())
	      
	  	{
	      		t=300;//5minute
	      	}
	  	Intent i=new Intent(MainActivity.this,servicedemo.class);
	    
	 	Bundle b=new Bundle();
	    
		b.putInt("time",t);
	    
		i.putExtras(b);
	    
		startService(i);
	    	
	finish();
	  	
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		/*menu.add("Blue");
		menu.add("Red");
		menu.add("Green");*/
		getMenuInflater().inflate(R.menu.my_new_menu, menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
