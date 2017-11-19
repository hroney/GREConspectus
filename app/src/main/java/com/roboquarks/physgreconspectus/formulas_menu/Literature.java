package com.roboquarks.physgreconspectus.formulas_menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 18.04.16.
 */
public class Literature extends Fragment
{
    public Literature()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulas_menu_literature, container, false);
        return view;
    }
}
