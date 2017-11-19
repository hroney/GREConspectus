package com.roboquarks.physgreconspectus.main_menu.menu_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 09.05.16.
 */
public class StudyPlanDescriptionScreen extends Fragment
{
    public StudyPlanDescriptionScreen()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.formulas_menu_studyplan_description, container, false);

        Init(view);
        return view;
    }

    /** Main Custom method */
    private void Init(View view)
    {

    }
}
