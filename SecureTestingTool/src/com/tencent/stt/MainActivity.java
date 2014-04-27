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
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppPagerAdapter mAppPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;
    ActionBar mActionBar;
    
    
    private final static String CURR_POSTION = "curr_postion";
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppPagerAdapter = new AppPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        mActionBar = getActionBar();
        
        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        mActionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        
        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                mActionBar.setSelectedNavigationItem(position);
            }
        });
        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            mActionBar.addTab(mActionBar.newTab()
                            .setText(mAppPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
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
			

		default:
			return super.onOptionsItemSelected(item);
		}
		
		return true;
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		if(savedInstanceState != null){
			int index = savedInstanceState.getInt(CURR_POSTION);
			mViewPager.setCurrentItem(index);
		}
	}
	
	
	@Override
	public void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putInt(CURR_POSTION, mActionBar.getSelectedNavigationIndex());
	}
	

    /**
     * 
     * @author Administrator
     *
     */
    public static class AppPagerAdapter extends FragmentStatePagerAdapter {

    	public final static String[] PAGE_TITLE = new String[]{
    		SApplication.getContext().getString(R.string.qqpimsecure),
    		SApplication.getContext().getString(R.string.kingx),
    		SApplication.getContext().getString(R.string.toolbox)
    	};
    	
    	FragmentManager fm;
    	int index;
    	
        public AppPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

		@Override
		public Fragment getItem(int i) {
			Fragment f = null;
			switch (i) {
			case 0:{
				f = SecureListFragment.newInstance();
				break;
			}
			case 1:{
				f = KingxListFragment.newInstance();
				break;
			}
			case 2:{
				f = ToolboxListFragment.newInstance();
				break;
			}
				
			default:
				break;
			}
			
			return f;
		}

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLE[position];
        }
    }

    

}
