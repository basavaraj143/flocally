package com.example.appsriv_02.tabview;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class NewMainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "BREAKFAST", "LUNCH", "SNACKS","DINNER" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newactivity);
		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		//actionBar.setDisplayShowTitleEnabled(false);
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.tabBackground)));

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
//
		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft)
	{

		viewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft)
	{

	}

}
