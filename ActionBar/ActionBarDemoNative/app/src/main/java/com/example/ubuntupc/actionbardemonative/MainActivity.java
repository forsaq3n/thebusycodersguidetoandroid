package com.example.ubuntupc.actionbardemonative;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity{

    private static final String[] items = { "lorem", "ipsum", "dolor",
            "sit", "amet", "consectuer", "adipiscing", "elit", "morbi",
            "vel", "ligua", "vitae", "arcu", "aliquet", "mollis", "etiam",
            "erat", "placerat", "ante", "porttitor", "sodales",
            "pellentesque", "augue", "purus"};

    private ArrayList<String> words = null;
    private ArrayAdapter<String> adapter= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initAdapter();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actions,menu);
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add:
                addWord();

                return (true);

            case R.id.reset:
                initAdapter();

                return (true);

            case R.id.about:
                Toast.makeText(this,R.string.about_toast, Toast.LENGTH_LONG).show();

                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void initAdapter(){
        words = new ArrayList<String>();

        for ( int i = 0; i < 5; i++){
            words.add(items[i]);
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,words);
        setListAdapter(adapter);
    }

    private void addWord(){
        if ( adapter.getCount() < items.length){
            adapter.add(items[adapter.getCount()]);
        }
    }
}
