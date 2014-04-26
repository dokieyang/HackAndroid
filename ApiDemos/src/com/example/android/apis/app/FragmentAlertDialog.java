/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.apis.app;

import com.example.android.apis.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Demonstrates how to show an AlertDialog that is managed by a Fragment.
 */
public class FragmentAlertDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dialog);

        View tv = findViewById(R.id.text);
        ((TextView)tv).setText("Example of displaying an alert dialog with a DialogFragment");

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.show);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });
    }


    void showDialog() {
        DialogFragment newFragment = MyAlertDialogFragment.newInstance(
                R.string.alert_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }
    
    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }

    

    public static class MyAlertDialogFragment extends DialogFragment {

        public static MyAlertDialogFragment newInstance(int title) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }
        
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");
            
            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.alert_dialog_icon)
                    .setTitle(title)
                    .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((FragmentAlertDialog)getActivity()).doPositiveClick();
                            }
                        }
                    )
                    .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ((FragmentAlertDialog)getActivity()).doNegativeClick();
                            }
                        }
                    )
                    .create();
        }
        
        
        @Override
        public void onAttach(Activity activity) {
        	super.onAttach(activity);
        	Log.i("FragmentAlertDialog", "onAttach");
        }
        
        public void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	Log.i("FragmentAlertDialog", "onCreate");
        }
        
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	super.onCreateView(inflater, container, savedInstanceState);
        	Log.i("FragmentAlertDialog", "onCreateView");
            return null;
        }
        
        public void onActivityCreated(Bundle savedInstanceState) {
        	super.onActivityCreated(savedInstanceState);
        	Log.i("FragmentAlertDialog", "onActivityCreated");
        }
        
        
        public void onStart(){
        	super.onStart();
        	Log.i("FragmentAlertDialog", "onStart");
        }
        
        public void onResume() {
        	super.onResume();
        	Log.i("FragmentAlertDialog", "onResume");
        }
        
        public void onPause() {
        	super.onPause();
        	Log.i("FragmentAlertDialog", "onPause");
        }
        
        public void onStop() {
        	super.onStop();
        	Log.i("FragmentAlertDialog", "onStop");
        }
        
        public void onDestroyView() {
        	super.onDestroyView();
        	Log.i("FragmentAlertDialog", "onDestroyView");
        }
        
        public void onDestroy() {
        	super.onDestroy();
        	Log.i("FragmentAlertDialog", "onDestroy");
        }
        
        public void onDetach() {
        	super.onDetach();
        	Log.i("FragmentAlertDialog", "onDetach");
        }
       
    }

}
