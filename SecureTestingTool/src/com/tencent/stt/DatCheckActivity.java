/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tencent.stt;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DatCheckActivity extends Activity{

    ActionBar mActionBar;
    
    
    private final static String CURR_POSTION = "curr_postion";
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar = getActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        
        TextView tv = new TextView(this);
        tv.setText("hello");
        setContentView(tv);
        
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int itemId = item.getItemId();
		switch (itemId) {
		case R.id.about:
			Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.settings:
			Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
			break;
			
		 case android.R.id.home:
             // This is called when the Home (Up) button is pressed in the action bar.
             // Create a simple intent that starts the hierarchical parent activity and
             // use NavUtils in the Support Package to ensure proper handling of Up.
             Intent upIntent = new Intent(this, MainActivity.class);
             if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                 // This activity is not part of the application's task, so create a new task
                 // with a synthesized back stack.
                 TaskStackBuilder.from(this)
                         // If there are ancestor activities, they should be added here.
                         .addNextIntent(upIntent)
                         .startActivities();
                 finish();
             } else {
                 // This activity is part of the application's task, so simply
                 // navigate up to the hierarchical parent activity.
                 NavUtils.navigateUpTo(this, upIntent);
             }
             return true;			
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
		return true;
	}
	

    

}
