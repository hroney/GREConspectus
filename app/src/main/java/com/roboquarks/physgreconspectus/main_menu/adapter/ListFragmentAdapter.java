package com.roboquarks.physgreconspectus.main_menu.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 09.05.16.
 */
public class ListFragmentAdapter extends BaseAdapter
{
    private Context context;
    private String[] partOfTheList;
    private static LayoutInflater inflater;

    public ListFragmentAdapter(Context context, String[] partOfTheList)
    {
        this.context = context;
        this.partOfTheList = partOfTheList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return partOfTheList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder
    {
        TextView textView;
        CheckBox checkBox;
        ImageButton imageButton;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {

        ViewHolder viewHolder = new ViewHolder();
        view = inflater.inflate(R.layout.formulas_menu_studyplan_singleplan, null);

        viewHolder.textView = (TextView)view.findViewById(R.id.formulas_studyplan_singleplan_textview);
        viewHolder.checkBox = (CheckBox)view.findViewById(R.id.formulas_studyplan_singleplan_checkbox);
        viewHolder.imageButton = (ImageButton)view.findViewById(R.id.formulas_studyplan_singleplan_imageButton);

        viewHolder.textView.setText(partOfTheList[position]);
        viewHolder.checkBox.setFocusable(false);
        viewHolder.checkBox.setFocusableInTouchMode(false);
        viewHolder.imageButton.setFocusable(false);
        viewHolder.imageButton.setFocusableInTouchMode(false);

        return view;
    }
}
