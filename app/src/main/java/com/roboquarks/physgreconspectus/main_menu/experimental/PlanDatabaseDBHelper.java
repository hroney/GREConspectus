package com.roboquarks.physgreconspectus.main_menu.experimental;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hroney on 11.05.16.
 */
public class PlanDatabaseDBHelper extends SQLiteOpenHelper
{
    /** version number to upgrade database version each time
     * if you Add, Edit table, you need to change the version number */
    private static final int PLAN_DATABASE_VERSION = 1;

    /** Database name */
    private static final String PLAN_DATABASE_NAME = "plan.db";

    /** Database constructor */
    public PlanDatabaseDBHelper(Context context)
    {
        super (context, PLAN_DATABASE_NAME, null, PLAN_DATABASE_VERSION);
    }

    /** We are creating a database, which can contain infinite number of tables */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        /** All necessary tables you like to create will create here */
        /** This SQL string used to create the database for the first time */
        String CREATE_TABLE_PLAN = "CREATE_TABLE" + PlanDatabaseData.PLAN_TABLE_ONE +
                "(" + PlanDatabaseData.TABLE_ONE_KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT ," +
                PlanDatabaseData.PART_OF_PLAN_NAME + "TEXT" +
                PlanDatabaseData.PART_OF_PLAN_DESCRIPTION + " TEXT )";
        /** Executing the creation of database */
        sqLiteDatabase.execSQL(CREATE_TABLE_PLAN);
    }

    /** The onUpgrade() method is called only when the database version is changed.
     * Database version is an integer value which is specified inside the DBHelper constructor. */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        /** Drop older table if existed, all data will be gone */
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + PlanDatabaseData.PLAN_TABLE_ONE);
        /** Create tables again */
        onCreate(sqLiteDatabase);
    }
}
