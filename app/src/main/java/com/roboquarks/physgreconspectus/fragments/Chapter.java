package com.roboquarks.physgreconspectus.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by Hroney on 10.04.2016.
 */
public class Chapter extends Fragment implements ChaptersList.ChapterId
{
    Button btnNextPage, btnPreviousPage;
    /** For WebView */
    WebView webView;
    WebSettings webSettings;
    /** Creating the variable for the web path */
    private String uri;
    /**
     * For identifying the position
     */
    int position_id;

    /** constructor of the fragment */
    public Chapter(String uri)
    {
        this.uri = uri;
    }

    /** getting the position */
    @Override
    public void chapterId(int position)
    {
        /** passing the position */
        position_id = position;
        System.out.println("position:" + position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.container_fragment, container, false);

        /** Initialising buttons */
        btnNextPage = (Button)view.findViewById(R.id.btnNextPage);
        btnPreviousPage = (Button)view.findViewById(R.id.btnPreviousPage);
        /** Changing the text of the buttons */
        /*if (position_id == 0)
        {
            btnPreviousPage.setText("To Contents");
        }
        else if (position_id != 0)
        {
            btnPreviousPage.setText("Previous");
        }*/
        /** Initialising the webView from a container */
        webView = (WebView) view.findViewById(R.id.web_fragment);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        /** Loading a custom url */
        webView.loadUrl(uri);

        return view;
    }
}
