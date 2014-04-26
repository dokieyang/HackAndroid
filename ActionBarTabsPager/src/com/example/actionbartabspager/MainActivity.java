package com.example.actionbartabspager;

import java.util.ArrayList;

import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
   
	ViewPager mVeiwPager;
//	TabsAdapter mTabsAdapter;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mVeiwPager = new ViewPager(this);
        mVeiwPager.setId(R.id.pager);
        setContentView(mVeiwPager);
        
        final ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
        
        
        //定义Adapter实例
        
        if(savedInstanceState != null){
        	bar.setSelectedNavigationItem(savedInstanceState.getInt("tab", 0));
        }
    }
    
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	outState.putInt("tab", getActionBar().getSelectedNavigationIndex());  
    }
    
    
    public static class TabsAdapter extends FragmentPagerAdapter
    		implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    	private final Context mContext;
    	private final ActionBar mActionBar;
    	private final ViewPager mViewPager;
    	private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
    	
    	
    	static final class TabInfo{
    		private final Class<?> clss;
    		private final Bundle args;
    		
    		TabInfo(Class<?> _clss,  Bundle _args){
    			clss = _clss;
    			args = _args;
    		}
    	}
		public TabsAdapter(Activity activity, ViewPager pager) {
			FragmentManager fm = activity.getFragmentManager();
			super(fm);
			mContext = activity;
			mActionBar = activity.getActionBar();
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}
    	
    }
    
    
    
    

}