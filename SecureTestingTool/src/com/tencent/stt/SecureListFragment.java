package com.tencent.stt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

	
public class SecureListFragment extends ListFragment {

		private List<HashMap<String, Object>> mData;
    	
    	private SecureAdapter mAdapter;
    	
    	public static SecureListFragment newInstance(){
    		
    		return new SecureListFragment();
    	}
    	
    	
    	 @Override
    	public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           
        }
    	
    	 
    	
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_pager_list, container, false);
            List<HashMap<String, Object>> data = getData();
            mAdapter = new SecureAdapter(getActivity() ,data);
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
            onListItemClick(position);
        }
        
        
        private  void onListItemClick(int position){
        	Intent intent = new Intent(getActivity(), DatCheckActivity.class);
            startActivity(intent);
        }
        
        
        private List<HashMap<String, Object>> getData(){
        	
        	List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        	
        	CharSequence[] titles = SApplication.getContext().getResources().getStringArray(R.array.secure_item_title);
        	CharSequence[] comments = SApplication.getContext().getResources().getStringArray(R.array.secure_item_comment);
        	
        	HashMap<String, Object>  map;
        	for(int i = 0; i < titles.length; i++){
        		map = new HashMap<String, Object>();
        		map.put(Const.KEY_TITLE, titles[i]);
        		map.put(Const.KEY_COMMENT, comments[i]);
        		data.add(map);
        	}
        	
        	
        	return data;
        }
        
        
        class SecureAdapter extends BaseAdapter{

        	
        	private LayoutInflater mInflater;
        	List<HashMap<String, Object>> mData; 
        	
        	public SecureAdapter(Context ctx , List<HashMap<String, Object>> data){
        		mInflater = LayoutInflater.from(ctx);
        		mData = data;
        	}
        	
        	
			@Override
			public int getCount() {
				return mData.size();
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
				
				holder.mTitleTV.setText(mData.get(position).get(Const.KEY_TITLE).toString());
				holder.mCommentTV.setText(mData.get(position).get(Const.KEY_COMMENT).toString());
				
				return convertView;
			}
			
			 class ViewHolder{
				TextView  mTitleTV;
				TextView  mCommentTV;
				
			}
        	
        }
            
    }
