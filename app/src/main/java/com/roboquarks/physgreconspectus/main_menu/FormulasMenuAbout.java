package com.roboquarks.physgreconspectus.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_activity.Formulas;
import com.roboquarks.physgreconspectus.main_menu.adapter.ViewPagerAdapter;
import com.roboquarks.physgreconspectus.main_menu.menu_fragments.AboutProgram;
import com.roboquarks.physgreconspectus.main_menu.menu_fragments.AboutVersion;

/**
 * Created by hroney on 08.05.16.
 */

/** This option enable user to know more about the app:
 * This activity is a container for a two fragments */

public class FormulasMenuAbout extends AppCompatActivity
{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /** Fragments */
    /** Adapter */
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_menu_about_coordinator);
        Init();

    }

    /** Methods for menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        /** Inflating the menu: this adds item
         * to the app bar if it is present */
        getMenuInflater().inflate(R.menu.formulas_menu_about, menu);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    /** Method for switching between menu parts */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(this, Formulas.class);
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            /** Finding the menu item from formulas_menu by id */
            case R.id.formulas_menu_literature:
                intent = new Intent(FormulasMenuAbout.this, FormulasMenuLiterature.class);
                break;
            case R.id.formulas_menu_tips:
                intent = new Intent(FormulasMenuAbout.this, FormulasMenuTips.class);
                break;
            case R.id.formulas_menu_studyplan:
                intent = new Intent(FormulasMenuAbout.this, FormulasMenuStudyPlan.class);
                break;
            case R.id.formulas_menu_additional:
                intent = new Intent(FormulasMenuAbout.this, FormulasMenuAdditional.class);
                break;
        }
        /** Initialising the transition between activities */
        startActivity(intent);
        finish();
        return true;
    }

    /** Main custom method of a class */
    private void Init()
    {
        toolbar = (Toolbar) findViewById(R.id.formulas_about_toolbar);
        /** Configuring the toolbar: setting title, navigation icon etc. */
        toolbar.setTitle("About the Program");
        //toolbar.setNavigationIcon(R.mipmap.ic_back);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.formulas_about_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.formulas_about_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    /** Method for adding fragments to viewPager */
    private void setupViewPager(ViewPager viewPager)
    {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AboutProgram(), "Description");
        viewPagerAdapter.addFragment(new AboutVersion(), "Version");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
