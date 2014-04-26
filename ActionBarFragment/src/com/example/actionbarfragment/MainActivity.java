package com.example.actionbarfragment;



import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	ActionBar mActionBar;
	Button mGoToButton ; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mActionBar = getActionBar();
//		mActionBar.hide();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		
//		mGoToButton = (Button)findViewById(R.id.button1);
//		mGoToButton.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent i = new Intent(MainActivity.this, SecondActivity.class);
//				startActivity(i);
//			}
//		});
//		
		
		Tab tab = mActionBar.newTab()
				.setText("tab1")
				.setTabListener(new TabListener(new TabContentFragment("test")));
		mActionBar.addTab(tab);
		
		Tab tab2 = mActionBar.newTab()
				.setText("tab2")
				.setTabListener(new TabListener(new TabContentFragment("test2")));
		mActionBar.addTab(tab2);
		
		Tab tab3 = mActionBar.newTab()
				.setText("tab3")
				.setTabListener(new TabListener(new TabContentFragment("test3")));
		mActionBar.addTab(tab3);
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
		case R.id.action_compose:
			Toast.makeText(this, "action_compose", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.action_search:
			Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.action_settings:
			Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		
		return true;
	}
	
	
	private class TabListener implements ActionBar.TabListener {
        private TabContentFragment mFragment;

        public TabListener(TabContentFragment fragment) {
            mFragment = fragment;
        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            ft.add(R.id.fragment_content, mFragment, mFragment.getText());
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            ft.remove(mFragment);
        }

        public void onTabReselected(Tab tab, FragmentTransaction ft) {
            Toast.makeText(MainActivity.this, "Reselected!", Toast.LENGTH_SHORT).show();
        }

    }
	
    private class TabContentFragment extends Fragment {
        private String mText;

        public TabContentFragment(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragView = inflater.inflate(R.layout.action_bar_tab_content, container, false);

            TextView text = (TextView) fragView.findViewById(R.id.text);
            text.setText(mText);

            return fragView;
        }

    }	

}
