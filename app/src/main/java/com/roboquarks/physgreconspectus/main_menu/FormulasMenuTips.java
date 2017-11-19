package com.roboquarks.physgreconspectus.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_activity.Formulas;

/**
 * Created by hroney on 11.05.16.
 */
public class FormulasMenuTips extends AppCompatActivity
{
    ViewFlipper viewFlipper;
    TextView tip1, tip2, tip3, tip4, tip5, tip6,
            tip7, tip8, tip9, tip10, tip11, tip12,
            tip13, tip14, tip15, tip16, tip17, tip18;

    private float lastX;
    /** Variable to find out the position, which is need to change the text in TextView */
    private int screenId = 1;
    /** Variable to rewrite the text in TextView */
    private String tip;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_menu_tips);
        setTitle("Useful Tips");
        Init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.formulas_menu_tips, menu);
        return true;
    }

    /** Method for switching between menu parts */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(this, Formulas.class);
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            /** Finding the menu item from formulas_menu by id */
            case R.id.formulas_menu_about:
                intent = new Intent(this, FormulasMenuAbout.class);
                break;
            case R.id.formulas_menu_literature:
                intent = new Intent(this, FormulasMenuLiterature.class);
                break;
            case R.id.formulas_menu_tips:
                intent = new Intent(this, FormulasMenuTips.class);
                break;
            case R.id.formulas_menu_studyplan:
                intent = new Intent(this, FormulasMenuStudyPlan.class);
                break;
            case R.id.formulas_menu_additional:
                intent = new Intent(this, FormulasMenuAdditional.class);
                break;
        }
        /** Initialising the transition between activities */
        startActivity(intent);
        finish();
        return true;
    }

    /** Main custom method */
    private void Init()
    {
        /** Initialising the TextView */
        tip1 = (TextView)findViewById(R.id.tips_textView1);
        tip2 = (TextView)findViewById(R.id.tips_textView2);
        tip3 = (TextView)findViewById(R.id.tips_textView3);
        tip4 = (TextView)findViewById(R.id.tips_textView4);
        tip5 = (TextView)findViewById(R.id.tips_textView5);
        tip6 = (TextView)findViewById(R.id.tips_textView6);
        tip7 = (TextView)findViewById(R.id.tips_textView7);
        tip8 = (TextView)findViewById(R.id.tips_textView8);
        tip9 = (TextView)findViewById(R.id.tips_textView9);
        tip10 = (TextView)findViewById(R.id.tips_textView10);
        tip11 = (TextView)findViewById(R.id.tips_textView11);
        tip12 = (TextView)findViewById(R.id.tips_textView12);
        tip13 = (TextView)findViewById(R.id.tips_textView13);
        tip14 = (TextView)findViewById(R.id.tips_textView14);
        tip15 = (TextView)findViewById(R.id.tips_textView15);
        tip16 = (TextView)findViewById(R.id.tips_textView16);
        tip17 = (TextView)findViewById(R.id.tips_textView17);
        tip18 = (TextView)findViewById(R.id.tips_textView18);
        /** Initialising the ViewFlipper and working with it */
        viewFlipper = (ViewFlipper)findViewById(R.id.tips_viewFlipper);
        /** Set in/out flipping animations */
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
        /** Using the following method, we will handle all screen swaps.*/
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    /** MotionEvent.ACTION_DOWN activates when we pressed on screen (by finger) */
                    case MotionEvent.ACTION_DOWN:

                        lastX = motionEvent.getX();
                        return true;
                    /** MotionEvent.ACTION_DOWN activates when we released screen */
                    case MotionEvent.ACTION_UP:

                        float currentX = motionEvent.getX();

                        if(lastX < currentX)
                        {
                            viewFlipper.showNext();
                        }
                        else if (lastX > currentX)
                        {
                            viewFlipper.showPrevious();
                        }
                        return true;
                }
                return false;
            }
        });

        setTip();
    }

    /** Method for setting text to the textView */
    private void setTip()
    {
        /** Setting text to TextViews */
        tip1.setText("Tip 1: Take this test seriously! ETS is not going to treat you special, because of your " +
                "name, status, gender (or other thing you (possibly) proud of). " +
                "If you want to be admitted to the top universities, you need to get about 900+ on the exam.");

        tip2.setText("Tip 2: Test consists of 100 multiple choice questions, " +
                "which you need to accomplish in 170 minutes. Applying some calculations we get (170/100)*60s=102 seconds " +
                "per question, which means that you need to be fast enough to end this test in time. " +
                "Don't waste too much time for a question: " +
                "if you don't know the answer you'd better skip it and go right to the next one.");


        tip3.setText("Tip 3: Always remember that wrong answers will lower your scores! " +
                "Therefore, consider guessing only when you can exclude at least 2 wrong choices. " +
                "However, the test obligates you to think fast; thus, It is not so complicated " +
                "(as it may look from the first glance): just try to relax and concentrate. " +
                "As a consequence, you will find the right answer!");


        tip4.setText("Tip 4: Don't underestimate the power of dimensional analysis! " +
                "Sometimes, the wrong answers may be eliminated by comparison of dimensions in the formulas. " +
                "If it is not working then try to make the partial calculation: " +
                "sometimes the correct answer can be determined with appropriate estimation, " +
                "rather than proper calculation.");

        tip5.setText("Tip 5: First, trace questions, which are easy for you to answer and answer them. " +
                " The test usually consists of a couple of theoretical questions " +
                "(such as the consequences of experiments or some tricky definitions), which you can quickly determine " +
                "and complete!");

        tip6.setText("Tip 6: GRE covers almost every main aspect of bachelor's topics " +
                "(variations depend on each particular university's program). Hence, It is not so easy to handle " +
                "without having a couple of additional weeks in your pocket. Use your time-management skills " +
                "and start your preparation at least one (better two) months before the test");

        tip7.setText("Tip 7: Create your own study plan regardless your schedule! " +
                "The later you start the lesser will be your chances to review all of the material." +
                "Eventually, this will end in the lower scores!");


        tip8.setText("Tip 8: Try to waste at least 3 (solid) hours on the preparation. " +
                "Moreover, Each week try to increase its value, so " +
                "in the last week you should spend something like 8 hours on the preparation " +
                "(don't be shocked - find some time for your future).");

        tip9.setText("Tip 9: Take your first preparation exam without any preparation at all and do it under the test conditions" +
                "(i.e. for 3 hours you need to forget about everything, except the test). " +
                "After that you will be able to specify, which part was the most difficult one; " +
                "thus, to review the necessary information.");

        tip10.setText("Tip 10: Don't forget to rest properly: " +
                "you need to sleep well in order to struggle with unknown another day. " +
                "The average person needs to sleep something like 8-9 hours per day. " +
                "So, create your own sleep schedule.\n" +
                "P.S.: Remember that pGRe starts at 8:30 each morning; thus, you need to arrive there at least 30 minutes before the beginning." +
                "Therefore, you'll be needed to get up at 6-7 AM. Be prepared for that!");

        tip11.setText("Tip 11: To remember formulas, you need to create your own handwritten notes. " +
                "It is great to use notes presented here or somewhere else. " +
                "But the material prepared on your own are much better!");

        tip12.setText("Tip 12: While it is good for review to solve problems of each particular physics section, " +
                "in general, it is a bad practice to calculate only specific problems. " +
                "Try to combine the different sections in order to achieve maximum equality with a test. " +
                "Ideally is to take every available practice exam under the real test conditions (for 3 hours, without disturbance).");

        tip13.setText("Tip 13");

        tip14.setText("Tip 14");

        tip15.setText("Tip 15");

        tip16.setText("Tip 16");

        tip17.setText("Tip 17");

        tip18.setText("Tip 18");
    }
}
