/**
 * 
 */
package com.example.actionbarfragment;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * @author Administrator
 *
 */
public class SecondActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		ActionBar mActionBar = getActionBar();
//		mActionBar.hide();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
