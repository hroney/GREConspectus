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
public class FormulasMenuAdditional extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_menu_additional);
        setTitle("Additional");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.formulas_menu_additional, menu);
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
            case R.id.formulas_menu_studyplan:
                intent = new Intent(this, FormulasMenuStudyPlan.class);
                break;
        }
        /** Initialising the transition between activities */
        startActivity(intent);
        finish();
        return true;
    }
}

/** - Links

 PhysicsGRE.com is a great independent site with lots of tips and advice on how to prepare for the exam.
 The Ohio State University has a great physics GRE study site. Their site has all of the released tests.
 GREPhysics.net has detailed solutions to all of the physics GRE questions.*/

/**
 * http://www.alexhunterlang.com/physics-gre
 * https://sites.google.com/a/uw.edu/physicsgre/home/step-4-test-taking-methods
 * https://physicsworks.wordpress.com/2011/07/16/gr0877-solutions/
 * http://physgre.s3-website-us-east-1.amazonaws.com/
 * http://www.physicsgre.com/
 * http://web.mit.edu/uwip/www/advice/gre/
 * https://jaan.io/how-to-ace-the-gre-and-physics-gre/
 * http://www.phys.cwru.edu/flashCards/
 * http://www.amazon.com/gp/product/1479274631/
 * http://sjbyrnes.com/studysheet.pdf
 * http://www.hcs.harvard.edu/~physics/wp-content/uploads/2013/02/GRE-notes.pdf
 * */
