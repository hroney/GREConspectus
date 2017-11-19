package com.roboquarks.physgreconspectus;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.roboquarks.physgreconspectus.formulas_menu.About;
import com.roboquarks.physgreconspectus.formulas_menu.Literature;
import com.roboquarks.physgreconspectus.formulas_menu.Tips;
import com.roboquarks.physgreconspectus.fragments.ChaptersList;

/**
 * Created by hroney on 18.04.16.
 */
public class FormulasMenu extends AppCompatActivity
{
    int menuPositionId;
    /** for working with fragments */
    Fragment fragment;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.formulas_menu_container);

        Intent intent = getIntent();
        /** Obtaining the position in the menu */
        menuPositionId = intent.getIntExtra("position", menuPositionId);

        Init(menuPositionId);
    }

    /** method for switching between menu fragments */
    private void Init(int position)
    {
        fragmentManager = getSupportFragmentManager();
        /** updating the main content by replacing the fragments */
        switch(position)
        {
            case 0:
                fragment = new About();
                break;
            case 1:
                fragment = new Literature();
                break;
            case 2:
                fragment = new Tips();
                break;
            default:
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.formulas_menu_container, fragment).commit();
    }
}
