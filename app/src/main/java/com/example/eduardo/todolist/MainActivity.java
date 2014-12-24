package com.example.eduardo.todolist;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements OnNewItemAddedListener {

    private ArrayList<String> todoItens;
    private ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Inflate view
        setContentView(R.layout.activity_main);

        //Get references to the fragments
        FragmentManager fm = getFragmentManager();
        TodoListFragment todoListFragment =
                (TodoListFragment)fm.findFragmentById(R.id.TodoListFragment);

        //create ArrayList for TodoItens
        todoItens = new ArrayList<>();
        aa = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, todoItens);

        todoListFragment.setListAdapter(aa);

        //getReferences
        //ListView myListView = (ListView)findViewById(R.id.myListView);

        //bind array adapter to listview
        //myListView.setAdapter(aa);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        todoItens.add(newItem);
        aa.notifyDataSetChanged();
    }
}
