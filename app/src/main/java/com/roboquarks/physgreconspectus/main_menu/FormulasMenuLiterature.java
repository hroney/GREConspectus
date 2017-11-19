package com.roboquarks.physgreconspectus.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_activity.Formulas;

/**
 * Created by hroney on 11.05.16.
 */
public class FormulasMenuLiterature extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_menu_literature);
        setTitle("Literature");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.formulas_menu_literature, menu);
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
            case R.id.formulas_menu_tips:
                intent = new Intent(this, FormulasMenuTips.class);
                break;
            case R.id.formulas_menu_studyplan:
                intent = new Intent(this, FormulasMenuStudyPlan.class);
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
}
