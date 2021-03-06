package com.example.appsriv_02.flocally;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ratan on 7/27/2015.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 4 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        /**
         *Inflate tab_layout and setup Views.
         */

            View x =  inflater.inflate(R.layout.tab_layout, null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);


        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run()
            {
                //tabLayout.setupWithViewPager(viewPager);
                selectPage(1);
            }
        });

        return x;

    }
    public static void selectPage(int pageIndex)
    {
        viewPager.setCurrentItem(pageIndex);
        tabLayout.setupWithViewPager(viewPager);
    }



    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
          switch (position)
          {
              case 0 : return new BreakFastFragment();
              case 1 : return new LunchFragment();
              case 2 : return new SnackFragment();
              case 3: return new DinnerFragment();
          }
        return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position)
            {

                case 0 :
                    return "BREAKFAST";
                case 1 :
                    return "LUNCH";
                case 2 :
                    return "SNACKS";
                case 3 :
                    return "DINNER";
            }
                return null;
        }
    }


   /* static TabFragment newInstance(final int position)
    {
        TabFragment swipeFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        swipeFragment.setArguments(bundle);
        viewPager.setCurrentItem(position);
        tabLayout.setupWithViewPager(viewPager);

        //tabLayout.notify();
       *//* tabLayout.post(new Runnable() {
            @Override
            public void run() {
                //tabLayout.setupWithViewPager(viewPager);
                selectPage(position);
            }
        });*//*

        return swipeFragment;
    }
*/

}
