package com.roboquarks.physgreconspectus.main_menu.menu_fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_menu.adapter.ListFragmentAdapter;

/**
 * Created by hroney on 09.05.16.
 */
public class StudyPlanMainScreen extends ListFragment
{
    String[] array = {"1", "2", "3"};
    ListFragmentAdapter listFragmentAdapter;

    Fragment fragment;
    FragmentManager fragmentManager;
    /** creting the list adapter */
    CheckBox checkBox;

    FloatingActionButton floatingActionButton;

    /** Constructor of a class */
    public StudyPlanMainScreen()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.formulas_menu_studyplan_list, container, false);

        Init(inflater, view);
        return view;
    }

    /** The ClickListener for the list */
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id)
//    {
        /** initialising the created fragment with webview */
//        fragment = new StudyPlanDescriptionScreen();
        /** getting the fragment manager */
//        fragmentManager = getFragmentManager();
        /** replacing fragment from list view with the help of fragment manager */
//        fragmentManager.beginTransaction().replace(R.id.main_container_fragment, fragment).commit();
//    }

    /** Main custom method */
    private void Init(LayoutInflater inflater, View view)
    {
        /** parforming actions with the list */
        //listView = (ListView)view.findViewById(R.id.formulas_studyplan_list);
        listFragmentAdapter = new ListFragmentAdapter(getActivity(), array);
        /*checkBox = (CheckBox)view.findViewById(R.id.formulas_studyplan_singleplan);
        checkBox.setFocusable(false);
        checkBox.setFocusableInTouchMode(false);*/
        setListAdapter(listFragmentAdapter);


        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.formulas_studyplan_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}

/** Recommended Study Plan

 If you want an extremely detailed study plan, definitely check out the great website from a study group at the Astronomy department
 of the University of Washington. If I had to take the exam again, I would follow this site closely!

 If you want a less detailed study plan, check out my advice below. This is an ideal plan, one that I did not follow but wish I had.
 This plan is for someone taking the exam in October, so adjust the dates accordingly for a different exam date.

 May (5 months to exam): Take a practice test. Force yourself to sit down and take it under test like conditions. I recommend using the 2001 exam. Grade the practice exam.
 If you felt good about the exam and liked your score, you can ignore the rest of my advice. You are a genius.
 Otherwise, don't reach for alcohol. The point of taking a practice test without any preparation was to provide motivation for you to study throughout the summer.
 Review the correct solutions to problems at GRE Physics. Make a note of the topics you missed.
 Open up your textbooks from undergrad (you did buy them all right? And didn't sell them back?) and review the topics that you are rusty on (as determined by the past exam results)
 June (4 months to exam): Take another practice test under test conditions. Grade it. I recommend the 1996 exam. Repeat steps 3 and 4 from above.
 July (3 months to exam): Time for another practice exam. I recommend the 1986 exam. Grade and review.
 August (2 months to exam): Time for another practice exam. I recommend the 1992 exam. Grade and review.
 Early September (5 weeks to exam): Take your last remaining practice exam. If you followed the above steps, it should be the 2008 exam. I told you to save this for last since it is the most similar to the current exam. Do a very detailed grading, keep careful note of topics you still need to review.
 September/October (last month to exam): At this point you've taken all the practice exams, so you hopefully only have a few topics that you still have issues with. Go to the Ohio State website where they have compiled the questions from past exams by topic.
 October (less than 2 weeks to exam): Memorize equations. You don't want to waste valuable test time deriving results.
 *
 * From: http://www.alexhunterlang.com/physics-gre */