package com.tencent.stt;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

	
public class ToolboxListFragment extends ListFragment {

    	
    	
    	private SecureAdapter mAdapter;
    	
    	public static ToolboxListFragment newInstance(){
    		
    		return new ToolboxListFragment();
    	}
    	
    	
    	 @Override
    	public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           
        }
    	
    	 
    	
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_pager_list, container, false);
            mAdapter = new SecureAdapter(getActivity());
            //ListFragment绑定ListView的数据，必须通过ListFragment.setListAdapter()接口来绑定数据，
            //而不是使用ListView.setAdapter() 或其它方法！
            this.setListAdapter(mAdapter);
            
            return rootView;
        }
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            
        }
        
        
        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
        
        
        class SecureAdapter extends BaseAdapter{

        	
        	private LayoutInflater mInflater;
        	 
        	
        	public SecureAdapter(Context ctx){
        		mInflater = LayoutInflater.from(ctx);
        	}
        	
        	
			@Override
			public int getCount() {
				return 10;
			}

			@Override
			public Object getItem(int position) {
				return position;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder;
				
				if(convertView == null){
					convertView = mInflater.inflate(R.layout.listview_item, null);
					
					holder = new ViewHolder();
					holder.mTitleTV = (TextView) convertView.findViewById(R.id.title);
					holder.mCommentTV = (TextView) convertView.findViewById(R.id.comments);
				}else{
					holder = (ViewHolder) convertView.getTag();
				}
				
				holder.mTitleTV.setText("toolbox title " + position);
				holder.mCommentTV.setText("toolbox comment" + position);
				
				return convertView;
			}
			
			 class ViewHolder{
				TextView  mTitleTV;
				TextView  mCommentTV;
				
			}
        	
        }
            
    }
