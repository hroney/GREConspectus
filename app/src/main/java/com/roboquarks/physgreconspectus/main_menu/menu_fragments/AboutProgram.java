package com.roboquarks.physgreconspectus.main_menu.menu_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roboquarks.physgreconspectus.R;

/**
 * Created by hroney on 08.05.16.
 */
public class AboutProgram extends Fragment
{
    TextView textView1, textView2, textView3, textView4;
    Spannable spannable;
    String s1, s2, s3, s4;

    public AboutProgram()
    {

    }

    /** Span for creating a links in TextView */
    public class URLSpanNoUnderline extends URLSpan
    {
        public URLSpanNoUnderline(String url) {
            super(url);
        }
        @Override public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.formulas_menu_about_program, container, false);

        Init(view);
        return view;
    }

    /** Main method of a class */
    private void Init(View view)
    {
        textView1 = (TextView)view.findViewById(R.id.about_textView1);
        s1 = "\nThis app is dedicated to those who want to prepare for GRE Subject (Physics) test, provided by ETS." +
                "\nThe authors tried to create and provide to the user the conspect of formulae, which will lighten up all topics included to the test";
        textView1.setText(s1);

        textView2 = (TextView)view.findViewById(R.id.about_textView2);
        s2 = "This is an open source application! The code can be found at: " +
                "<a href=\"http://github.com.\">github.com</a>" + "." +
                "\nIt was made by: hroney and Kryfer";
        textView2.setText(Html.fromHtml(s2));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(textView2);


        textView3 = (TextView)view.findViewById(R.id.about_textView3);
        s3 = "The icons were designed by " + "<a href=\"http://www.freepik.com\">Freepik</a>" + "." +
                " Authors are grateful to them.";
        textView3.setText(Html.fromHtml(s3));
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(textView3);


        textView4 = (TextView)view.findViewById(R.id.about_textView4);
        s4 = "The app is totally free!)";
        textView4.setText(s4);
    }

    /** For Span (to create a link inside the text) */
    private void stripUnderlines(TextView textView)
    {
        spannable = new SpannableString(textView.getText());
        URLSpan[] spans = spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = spannable.getSpanStart(span);
            int end = spannable.getSpanEnd(span);
            spannable.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            spannable.setSpan(span, start, end, 0);
        }
        textView.setAutoLinkMask(0);
        textView.setText(spannable);
    }
}
