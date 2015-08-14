package com.thorrism.materialdesignskeleton.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thorrism.designtools.views.FormView;
import com.thorrism.designtools.views.ShakeEditText;
import com.thorrism.materialdesignskeleton.R;

import com.thorrism.materialdesignskeleton.demo.Fragments.TabFragment;

import interfaces.FromXml;

public class DemoActivity extends AppCompatActivity {
    private ShakeEditText mShakeEdit;
    private FormView mFormView;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //setup the sliding drawer and toolbar
        setupToolbar();
        setupViewPager();
    }

    private void setupViewPager() {
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mPager);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable home button =
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mNavView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    public void showSnackbar(String str) {
        final Snackbar bar = Snackbar.make(findViewById(R.id.view_pager),
                str,
                Snackbar.LENGTH_LONG);
        bar.setAction("CLEAR", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar.dismiss();
            }
        }).setActionTextColor(Color.RED)
                .show();
    }

    @FromXml
    public void showFragment(MenuItem i) {
        switch (i.getItemId()) {
            case R.id.navigation_item_1:
                mPager.setCurrentItem(0);
                break;
            case R.id.navigation_item_2:
                mPager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new TabFragment().newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return TabFragment.TYPE_EDIT;
                case 1:
                default:
                    return TabFragment.TYPE_DIALOG;
            }
        }


    }
}
