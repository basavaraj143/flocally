package com.example.appsriv_02.tabview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by appsriv-02 on 11/12/15.
 */


public class LunchListCustomAdapter extends BaseAdapter implements View.OnClickListener {

    /*********** Declare Used Variables *********/
    private Context activity;
    private ArrayList data;
    int item_number = 0;
    private static LayoutInflater inflater=null;
    public Resources res;
    int i=0;
    ArrayList<HashMap<String, String>> lunchList;
    LinearLayout dishImages[] = new LinearLayout[1000];
    LinearLayout[] alert = new LinearLayout[1000];
    boolean visibility=true;

    /*************  CustomAdapter Constructor *****************/
    public LunchListCustomAdapter(Context a, ArrayList<HashMap<String, String>> lunchList)
    {
        activity = a;
        this.lunchList=lunchList;
        //inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public int getCount()
    {
        if(lunchList.size()<=0)
            return 1;
        return lunchList.size();
    }


    public Object getItem(int position)
    {
        return lunchList.get(position);
    }

    public long getItemId(int position)
    {

        return lunchList.size();
    }

    @Override
    public int getViewTypeCount() {
        return lunchList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    /********* Create a holder Class to contain inflated xml file elements *********/
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater infalInflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.lunch_items,null);
        }
           // convertView = inflater.inflate(R.layout.lunch_items, null);
            TextView dishname =(TextView)convertView.findViewById(R.id.dishname);
            TextView distance =(TextView)convertView.findViewById(R.id.distance);
            TextView price =(TextView)convertView.findViewById(R.id.price);
            ImageView location=(ImageView) convertView.findViewById(R.id.location);
            ImageView addToCart=(ImageView)convertView.findViewById(R.id.addToCart);
            ImageView removeFromCart=(ImageView)convertView.findViewById(R.id.removeFromCart);
            dishImages[position]=(LinearLayout)convertView.findViewById(R.id.dishimage);
            final TextView numberOfOrders =(TextView)convertView.findViewById(R.id.numberOfOrders);

        alert[position]=(LinearLayout)convertView.findViewById(R.id.alert);




        //reting bar
        RatingBar ratingBar = (RatingBar)convertView.findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

        //location onclick
            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "location clicked", Toast.LENGTH_SHORT).show();
                }
            });

        //add to cart
            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(activity,"added to cart",Toast.LENGTH_SHORT).show();
                    item_number++;
                    numberOfOrders.setText(""+item_number);

                }
            });
            removeFromCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(activity,"removed from cart",Toast.LENGTH_SHORT).show();
                    if (item_number>0) {
                        item_number--;
                        numberOfOrders.setText("" + item_number);
                    }

                }
            });

            dishImages[position].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(activity, "position number " +position, Toast.LENGTH_SHORT).show();
                    //messageDialog("hi","hello",activity);
                    alert[position].setVisibility(View.VISIBLE);
                    dishImages[position].setVisibility(View.GONE);
                }



            });

        alert[position].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(activity, "position number " +position, Toast.LENGTH_SHORT).show();
                alert[position].setVisibility(View.GONE);
                dishImages[position].setVisibility(View.VISIBLE);
            }
        });



            for (int i =0 ; i<lunchList.size();i++) {
                dishname.setText(lunchList.get(i).get("dishname"));
                distance.setText(lunchList.get(i).get("distance"));
                price.setText(lunchList.get(i).get("price"));

            }

        return convertView;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0)
        {

        }
    }
}