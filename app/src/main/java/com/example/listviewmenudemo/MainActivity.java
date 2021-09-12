package com.example.listviewmenudemo;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.menu);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, getData());
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);//给listview注册上下文菜单
    }

    public List<String> getData() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            list.add("list " + i);
        }
        return list;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        // 加载xml中的上下文菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.three_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(MainActivity.this, "编辑操作", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(MainActivity.this, "分享操作", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "删除操作", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

//        String title=item.getTitle().toString();
//        int id=item.getItemId();
//        Log.d("title",title);
//        Toast.makeText(MainActivity.this, "title:"+title+"\nid:"+id, Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

}