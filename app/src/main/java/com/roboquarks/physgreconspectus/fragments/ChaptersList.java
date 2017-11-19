package com.roboquarks.physgreconspectus.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by Hroney on 10.04.2016.
 */
public class ChaptersList extends ListFragment
{
    //Button btnNextPage, btnPreviousPage;

    //Intent intent = new Intent();
    /** Creating the fragment and fragment manager */
    Fragment fragment;
    FragmentManager fragmentManager;
    /** creting the list adapter */
    ArrayAdapter<String> adapter;
    /** Creating the array of names for each section of physics
     * and the array of urls for each chapter */
    String[] chapters, uri;
    /** the global variable for the position defined in terms of the interface
     * (interface enables as to pass data between fragment and activity) */
    ChapterId position_id;
    /** the constructor of the fragment */
    public ChaptersList(String[] chapters, String[] uri)
    {
        this.chapters = chapters;
        this.uri = uri;
    }

    /** To pass data between activities we need to implement an interface */
    /*public interface OnHeadlineSelectedListener{
        public void chapterId(int position);
    }*/

    public interface ChapterId
    {
        void chapterId(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

       /** This makes sure that the container activity has implemented
        * the callback interface. If not, it throws an exception */
        try {
            position_id = (ChapterId) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ChapterId");
        }

        /** Now the fragment can deliver messages to the activity by
         * calling the chapterId() method (or other methods in the interface)
         * using the position_id instance of the ChapterId interface.*/
    }

    /** The ClickListener for the List */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        /** initialising the created fragment with webview */
        fragment = new Chapter(uri[position]);
        /** getting the fragment manager */
        fragmentManager = getFragmentManager();
        /** replacing fragment from list view with the help of fragment manager */
        fragmentManager.beginTransaction().replace(R.id.main_container_fragment, fragment).commit();


        position_id.chapterId(position);
        //intent.putExtra("position", position);
        /** adopting the position */
        //position_id = position;
        System.out.println("position:" + position_id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //View view = inflater.inflate(R.layout.container_fragment, container, false);
        /** creatin and the initialisation of the adapter for the list*/
        adapter = new ArrayAdapter<String>(inflater.getContext(), R.layout.sections_part_of_list, chapters);
        /** setting the adapter for the list */
        setListAdapter(adapter);

        /*btnNextPage = (Button)view.findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button)view.findViewById(R.id.btnPreviousPage);*/

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
