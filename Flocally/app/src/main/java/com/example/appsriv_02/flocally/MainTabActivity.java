package com.example.appsriv_02.flocally;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainTabActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_main);

        /**
         *Setup the DrawerLayout and NavigationView
         */

             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
      //  Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);


        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
             {
                 @Override
                 public boolean onNavigationItemSelected(MenuItem menuItem)
                 {
                     mDrawerLayout.closeDrawers();


                     if (menuItem.getItemId() == R.id.nav_item_breakfast)
                     {
                         FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                         fragmentTransaction.replace(R.id.containerView, new TabFragment().newInstance(3)).commit();

                        // fragmentTransaction.replace(R.id.containerView, getActionBar().addTab()).commit();

                     }

                     if (menuItem.getItemId() == R.id.nav_item_lunch)
                     {
                         FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                         xfragmentTransaction.replace(R.id.containerView, new BreakFastFragment()).commit();
                     }
                     if (menuItem.getItemId() == R.id.nav_item_snacks)
                     {
                         FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                         xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

                     }

                     return false;
                 }

             });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
       // ImageView imageView =(ImageView)toolbar.findViewById(R.id.dummy);
        /*imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"taq for clicking me " ,Toast.LENGTH_SHORT).show();
            }
        });
*/
                mDrawerLayout.setDrawerListener(mDrawerToggle);
                mDrawerToggle.syncState();

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }*/



}