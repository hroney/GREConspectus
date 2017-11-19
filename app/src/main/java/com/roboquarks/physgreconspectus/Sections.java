package com.roboquarks.physgreconspectus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.roboquarks.physgreconspectus.fragments.Chapter;
import com.roboquarks.physgreconspectus.fragments.ChaptersList;

/**
 * Created by Hroney on 10.04.2016.
 */
public class Sections extends AppCompatActivity implements ChaptersList.ChapterId
{
    /**
     * Creating and initialising an arrays for chapters and url pages
     */
    String[] chapters, uri;
    /**
     * Creating global variables for:
     * fragment, fragment list and fragment manager
     */
    Chapter chapter;
    ChaptersList chaptersList;
    FragmentManager fragmentManager;
    Button btnNextPage, btnPreviousPage;
    /**
     * For identifying the position
     */
    int position_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Setting the theme of the activity according to the section chosen */
        Formulas.onActivityCreateSetTheme(this);
        /** Setting the content View of the Activity */
        setContentView(R.layout.sections_fragment);



        /** getting the information from Formulas activity */
        Intent intent = getIntent();
        chapters = intent.getStringArrayExtra("chapters");
        uri = intent.getStringArrayExtra("uri");

        btnNextPage = (Button)findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button)findViewById(R.id.btnPreviousPage);

        Init(chapters, uri);
    }

    /** getting the position from the FragmentList */
    @Override
    public void chapterId(int position)
    {
        /** passing the position */
        position_id = position;
    }

    private void Init(String[] chapters, String[] uri) {
        fragmentManager = getSupportFragmentManager();

        /** initialising listfragment and transfer chapters into it  */
        if (fragmentManager.findFragmentById(R.id.list_fragment) == null) {
            chaptersList = new ChaptersList(chapters, uri);
            fragmentManager.beginTransaction().add(R.id.main_container_fragment, chaptersList).commit();
        }
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }

    /** methods for Buttons, which enables us to change fragments */
    public void toPreviousPage(View view)
    {

        /** condition for setting up the list */
        if (position_id == 0)
        {
            fragmentManager.beginTransaction().replace(R.id.main_container_fragment, chaptersList).commit();
        }
        else
        {
            /** adopting the position */
            position_id = position_id - 1;
            /** Initialising new fragment */
            chapter = new Chapter(uri[position_id]);
            /** replacing the existing fragment */
            fragmentManager.beginTransaction().replace(R.id.main_container_fragment, chapter).commit();
        }
    }

    public void toNextPage(View view)
    {
        /** condition for going to the list */
        if (position_id == (chapters.length - 1))
        {
            fragmentManager.beginTransaction().replace(R.id.main_container_fragment, chaptersList).commit();
        }
        else if (position_id != chapters.length)
        {
            /** adopting the position */
            position_id = position_id + 1;
            /** Initialising new fragment */
            chapter = new Chapter(uri[position_id]);
            /** replacing the existing fragment */
            fragmentManager.beginTransaction().replace(R.id.main_container_fragment, chapter).commit();
        }
    }
    /** The end of methods for buttons */
}
