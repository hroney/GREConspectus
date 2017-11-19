package com.roboquarks.physgreconspectus.main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.roboquarks.physgreconspectus.R;
import com.roboquarks.physgreconspectus.main_menu.FormulasMenuAbout;
import com.roboquarks.physgreconspectus.main_menu.FormulasMenuStudyPlan;
import com.roboquarks.physgreconspectus.main_menu.FormulasMenuAdditional;
import com.roboquarks.physgreconspectus.main_menu.FormulasMenuLiterature;
import com.roboquarks.physgreconspectus.main_menu.FormulasMenuTips;

/**
 * Created by Hroney on 10.04.2016.
 */

/** The main activity */
public class Formulas extends AppCompatActivity
{
    //Sections sections = new Sections();
    private static int sTheme;
    /** Creating an array for list parts and web pages */
    String[] chapters;
    String[] uri;
    /** the id of the position in menu */
    int menuPositionId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas_main_activity);
    }

    /** Methods for menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        /** Inflating the menu: this adds item
         * to the app bar if it is present */
        getMenuInflater().inflate(R.menu.formulas_menu, menu);
        return true;
    }

    /** Method for switching between menu parts */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = null;
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

    /** method for the "About" from the formulas menu */
    private void switchMenu(int position)
    {
        if (position == 0)
        {
            Intent intent = new Intent(Formulas.this, FormulasMenuAbout.class);
            startActivity(intent);
        }
        else if (position == 3)
        {
            Intent intent = new Intent(Formulas.this, FormulasMenuStudyPlan.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(Formulas.this, Formulas.class);
            /** sending the id of the position in menu to FormulasMenu */
            intent.putExtra("position", position);
            /** starting the activity: FormulasMenu  */
            startActivity(intent);
        }
    }
    /** the end for menu methods */

    /**
     * methods for setting custom themes
     */
    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(AppCompatActivity activity)
    {
        switch(sTheme)
        {
            case 0:
                activity.setTheme(R.style.MathematicsTheme);
                /** Setting title for the activity */
                activity.setTitle("Mathematics");
                break;
            case 1:
                activity.setTheme(R.style.MechanicsTheme);
                /** Setting title for the activity */
                activity.setTitle("Mechanics");
                break;
            case 2:
                activity.setTheme(R.style.ElectromagnetismTheme);
                /** Setting title for the activity */
                activity.setTitle("Electromagnetism");
                break;
            case 3:
                activity.setTheme(R.style.OpticsTheme);
                /** Setting title for the activity */
                activity.setTitle("Optics");
                break;
            case 4:
                activity.setTheme(R.style.ThermodynamicsTheme);
                /** Setting title for the activity */
                activity.setTitle("Thermodynamics");
                break;
            case 5:
                activity.setTheme(R.style.AtomicPhysTheme);
                /** Setting title for the activity */
                activity.setTitle("Atomic Physics");
                break;
            case 6:
                activity.setTheme(R.style.QuantumMechanicsTheme);
                /** Setting title for the activity */
                activity.setTitle("Quantum Mechanics");
                break;
            case 7:
                activity.setTheme(R.style.SpecialRelativityTheme);
                /** Setting title for the activity */
                activity.setTitle("Special Relativity");
                break;
            case 8:
                activity.setTheme(R.style.LaboratoryTheme);
                /** Setting title for the activity */
                activity.setTitle("Laboratory Methods");
                break;
            case 9:
                activity.setTheme(R.style.SpecializedTopicsTheme);
                /** Setting title for the activity */
                activity.setTitle("Specialized Topics");
                break;
        }
    }

    /** Defining a methods for buttons */
    public void toMathematics(View view)
    {
        /** Adding the content to the list and WebView */
        /** chapters */
        chapters = new String[]{"Coordinate Systems", "Vector Integral Transformations", "Progressions and Summations", "Complex Variables", "Probability and Statistics",
                "Differential Equations", "Power Series", "Perimeter, Area and Volume", "Random Walk"};
        /** web pages*/
        uri = new String[]{"file:///android_asset/mathscribe/mathematics_coordinate_systems.html",
                "file:///android_asset/mathscribe/mathematics_vector_integral_transformations.html",
                "file:///android_asset/mathscribe/mathematics_progressions_summations.html",
                "file:///android_asset/mathscribe/mathematics_complex_variables.html",
                "file:///android_asset/mathscribe/mathematics_probability_statistics.html",
                "file:///android_asset/mathscribe/mathematics_differential_equations.html",
                "file:///android_asset/mathscribe/mathematics_power_series.html",
                "file:///android_asset/mathscribe/mathematics_perimeter_area_volume.html",
                "file:///android_asset/mathscribe/mathematics_random_walk.html"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 0;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }


    public void toMechanics(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"Newtonian Mechanics" , "Lagrangian Mechanics", "Hamiltonian Mechanics"};
        uri = new String[]{"file:///android_asset/mathscribe/mechanics_newtonian_mechanics.html",
                "file:///android_asset/mathscribe/mechanics_lagrangean_mechanics.html",
                "file:///android_asset/mathscribe/mechanics_hamiltonian_mechanics.html"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 1;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toElectromagnetism(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"Static Fields" , "Electromagnetic Fields", "Fields Associated with Media", "Force, Torque and Energy", "LCR Circuits"};
        uri = new String[]{"file:///android_asset/mathscribe/electromagnetism_static_field.html",
                "file:///android_asset/mathscribe/electromagnetism_electromagnetic_field.html",
                "file:///android_asset/mathscribe/electromagnetism_fields_associated_with_media.html",
                "file:///android_asset/mathscribe/electromagnetism_force_torque_energy.html",
                "file:///android_asset/mathscribe/electromagnetism_LCR.html"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 2;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }
    public void toOpticsAndWaves(View view)
    {
        /** Adding the content to the list and WebView
         * chapters */
        chapters = new String[]{"Geometrical Optics", "Interference", "Fraunhofer Diffraction", "Fresnel Diffraction", "Waves in and out of Media"};
        /** web pages */
        uri = new String[]{"file:///android_asset/mathscribe/optics_geometrical_optics.html",
                "file:///android_asset/mathscribe/optics_interference.html",
                "file:///android_asset/mathscribe/optics_fraunhofer_diffraction.html",
                "file:///android_asset/mathscribe/optics_fresnel_diffraction.html",
                "file:///android_asset/mathscribe/optics_waves.html"};

        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 3;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toThermodynamics(View view)
    {
        /** Adding the content to the list and WebView
         * chapters */
        chapters = new String[]{"Classical Thermodynamics" , "Gas Laws", "Kinetic Theory", "Statistical Thermodynamics"};
        /** web pages */
        uri = new String[]{"file:///android_asset/mathscribe/thermodynamics_classical_thermodynamics.html",
                "file:///android_asset/mathscribe/thermodynamics_gas_laws.html",
                "file:///android_asset/mathscribe/thermodynamics_kinetic_theory.html",
                "file:///android_asset/mathscribe/thermodynamics_statistical_thermodynamics.html"};

        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 4;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toAtomicAndNuclearPhysics(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"Hydrogenic Atoms", "Angular Momentum", "Magnetic moments", "High Energy and Nuclear Physics"};
        uri = new String[]{"1", "2", "3", "4"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 5;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toQuantumMechanics(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"Quantum Uncertainty Relations" , "Operators, Wavefunctions and Expectation Value",
                "Dirac Notation", "Harmonic Oscillator", "Perturbation Theory", "Relativistic Wave Equations"};
        uri = new String[]{"file:///android_asset/mathscribe/quantmech_uncertainty_relations.html",
                "file:///android_asset/mathscribe/quantmech_operators.html",
                "file:///android_asset/mathscribe/quantmech_dirac_notation.html",
                "file:///android_asset/mathscribe/quantmech_harmonic_oscillator.html",
                "file:///android_asset/mathscribe/quantmech_perturbation_theory.html",
                "file:///android_asset/mathscribe/quantmech_relativistic_wave_equation.html"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 6;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toSpecialRelativity(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"1", "2", "3"};
        uri = new String[]{"1", "2", "3"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 7;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toLaboratoryMethods(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"1", "2", "3"};
        uri = new String[]{"1", "2", "3"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 8;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }

    public void toSpecializedTopics(View view)
    {
        /** Adding the content to the list and WebView */
        chapters = new String[]{"1", "2", "3"};
        uri = new String[]{"1", "2", "3"};
        /** creating the link between to activities */
        Intent intent = new Intent(Formulas.this, Sections.class);
        /** Setting theme of the activity */
        sTheme = 9;
        /** sending the information into Sections activity */
        intent.putExtra("chapters", chapters);
        intent.putExtra("uri", uri);
        /** Starting Sections activity */
        startActivity(intent);
    }
    /** The end of the methods definition */
}
/** The end of the main activity */