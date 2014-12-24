package com.example.eduardo.todolist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by eduardo on 23/12/14.
 */
public class NewItemFragment extends Fragment {
    private OnNewItemAddedListener onNewItemAddedListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            onNewItemAddedListener = (OnNewItemAddedListener)activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement OnNewItemEventListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState){
        final View view = inflater.inflate(R.layout.new_item_fragment, container, false);

        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);

        View.OnKeyListener onkl = new View.OnKeyListener(){
            public boolean onKey(View v, int keycode, KeyEvent keyEvent){
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    if(keycode == KeyEvent.KEYCODE_DPAD_CENTER || keycode == KeyEvent.KEYCODE_ENTER){
                        String newItem = myEditText.getText().toString();
                        onNewItemAddedListener.onNewItemAdded(newItem);
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        };

        myEditText.setOnKeyListener(onkl);

        return view;
    }
}
