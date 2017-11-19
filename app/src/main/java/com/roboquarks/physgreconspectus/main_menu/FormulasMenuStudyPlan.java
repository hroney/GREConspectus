package com.roboquarks.physgreconspectus.main_menu;

/**
 * Created by hroney on 09.05.16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_activity.Formulas;
import com.roboquarks.physgreconspectus.main_menu.menu_fragments.StudyPlanMainScreen;

/**
 * This option enables you to create your own study plan:
 * this activity is a container for a 3 fragments
 */
public class FormulasMenuStudyPlan extends AppCompatActivity
{
    Fragment fragment;
    FragmentManager fragmentManager;
    /**
     * List fragment:
     */
    StudyPlanMainScreen studyPlanMainScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_menu_studyplan_container);
        setTitle("Study Plan");
        Init();
    }

    /** Methods for menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        /** Inflating the menu: this adds item
         * to the app bar if it is present */
        getMenuInflater().inflate(R.menu.formulas_menu_studyplan, menu);
        return true;
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
            case R.id.formulas_menu_about:
                intent = new Intent(this, FormulasMenuAbout.class);
                break;
            case R.id.formulas_menu_literature:
                intent = new Intent(this, FormulasMenuLiterature.class);
                break;
            case R.id.formulas_menu_tips:
                intent = new Intent(this, FormulasMenuTips.class);
                break;
            case R.id.formulas_menu_additional:
                intent = new Intent(this, FormulasMenuAdditional.class);
                break;
        }
        /** Initialising the transition between activities */
        startActivity(intent);
        finish();
        return true;
    }

    /** Main custom method */
    private void Init()
    {
        fragmentManager = getSupportFragmentManager();
        studyPlanMainScreen = new StudyPlanMainScreen();
        fragmentManager.beginTransaction().add(R.id.formulas_studyplan_container, studyPlanMainScreen).commit();
    }
}
