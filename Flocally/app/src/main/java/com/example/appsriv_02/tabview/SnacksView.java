package com.example.appsriv_02.tabview;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class SnacksView extends Activity {

    ArrayList<HashMap<String, String>> lunchList;
    private static final String DISH_NAME = "dishname";
    private static final String DISTANCE = "distance";
    private static final String PRICE = "price";
    LunchListCustomAdapter ExpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunch_list);


        lunchList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();


        for (int i = 0 ; i < 10; i++)
        {
            String dishname = "biriyani";
            String distnce = "2km";
            String price = "1000rs";
            map.put(DISH_NAME,dishname );
            map.put(DISTANCE, distnce);
            map.put(PRICE, price);
            lunchList.add(map);
        }

/*
        final ListView listView = (ListView)findViewById(R.id.list);
        ListAdapter adapter = new SimpleAdapter(Lunch_View.this,lunchList, R.layout.lunch_items, new String[] { DISH_NAME, DISTANCE, PRICE },
                new int[] { R.id.dishname, R.id.distance, R.id.price });
        // updating listview
        setListAdapter(adapter);*/
        ListView listView = (ListView)findViewById(R.id.lunchList);
        ExpAdapter = new LunchListCustomAdapter(getApplicationContext(), lunchList);
        listView.setAdapter(ExpAdapter);
        if(ExpAdapter != null) {
            ExpAdapter.notifyDataSetChanged();
        }
    }
}
