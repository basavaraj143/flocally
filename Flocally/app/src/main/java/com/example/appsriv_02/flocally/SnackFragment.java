package com.example.appsriv_02.flocally;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SnackFragment extends Fragment {
	ArrayList<HashMap<String, String>> lunchList;
	private static final String DISH_NAME = "dishname";
	private static final String DISTANCE = "distance";
	private static final String PRICE = "price";
	private static final String TAG_SUBJECT = "subject";
	private static final String TAG_DATE = "date";
	LunchListCustomAdapter ExpAdapter;
	Context context;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.lunch_list, container, false);

		lunchList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();


		for (int i = 0 ; i < 3; i++)
		{
			String dishname = "biriyani";
			String distnce = "2km";
			String price = "120rs";
			map.put(DISH_NAME,dishname );
			map.put(DISTANCE, distnce);
			map.put(PRICE, price);
			lunchList.add(map);
		}

		ListView listView = (ListView) view.findViewById(R.id.lunchList);
		ImageView tippin=(ImageView)view.findViewById(R.id.tippin);
		ImageView preorder=(ImageView)view.findViewById(R.id.preorder);
		ImageView catering=(ImageView)view.findViewById(R.id.catering);
		tippin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "tiffin clicked ", Toast.LENGTH_SHORT).show();
			}
		});

		preorder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "preorder clicked ", Toast.LENGTH_SHORT).show();
			}
		});

		catering.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "catering clicked ", Toast.LENGTH_SHORT).show();
			}
		});
		ExpAdapter = new LunchListCustomAdapter(getActivity(), lunchList);
		listView.setAdapter(ExpAdapter);
		if(ExpAdapter != null) {
			ExpAdapter.notifyDataSetChanged();
		}


		return view;
	}


}
