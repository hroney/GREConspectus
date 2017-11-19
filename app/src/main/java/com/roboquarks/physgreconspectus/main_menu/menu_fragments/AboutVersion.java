package com.roboquarks.physgreconspectus.main_menu.menu_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 08.05.16.
 */
public class AboutVersion extends Fragment
{
    /** Constructor of class */
    public AboutVersion()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.formulas_menu_about_version, container, false);

        return view;
    }
}
