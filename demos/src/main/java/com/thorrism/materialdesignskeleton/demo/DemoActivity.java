package com.thorrism.materialdesignskeleton.demo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thorrism.designtools.views.MaterialDialog;
import com.thorrism.designtools.views.ShakeEditText;
import com.thorrism.materialdesignskeleton.R;

import interfaces.FromXml;

public class DemoActivity extends AppCompatActivity {
    private ShakeEditText mShakeEdit;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable home button =
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);

        //get drawer layout and navigation view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        setupDrawerContent();

        //Add shake edit and listener
        mShakeEdit = (ShakeEditText) findViewById(R.id.name_edit);
        mShakeEdit.setValidationListener(new EmailValidator(mShakeEdit));
    }

    private void setupDrawerContent() {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @FromXml
    public void checkEdit(View v) {
        if (mShakeEdit.checkValidInput()) {
            //valid input!
        }
    }

    @FromXml
    public void showDialog(View v) {
        MaterialDialog.with(getApplicationContext())
                .setTitle(R.string.dialog_title)
                .setBody("This is a material alert dialog. Dismiss with flat buttons below." +
                        "")
                .setSubmitListener(new MaterialDialog.SubmitListener() {
                    @Override
                    public void onSubmit() {

                    }
                }).show(getSupportFragmentManager(), "material_dialog");
    }
}
