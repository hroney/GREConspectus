package com.roboquarks.physgreconspectus.formulas_menu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 18.04.16.
 */
public class About extends Fragment
{
    public About()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulas_menu_about, container, false);
        return view;
    }
}
