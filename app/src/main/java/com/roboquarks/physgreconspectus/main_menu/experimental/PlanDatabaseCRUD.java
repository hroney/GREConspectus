package com.roboquarks.physgreconspectus.main_menu.experimental;

/**
 * Created by hroney on 11.05.16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/** Class for implementing operations with the database */
public class PlanDatabaseCRUD
{
    private PlanDatabaseDBHelper dbhelper;

    /** Class constructor */
    public PlanDatabaseCRUD(Context context)
    {
        /** passing the context through the constructor of the class */
        dbhelper = new PlanDatabaseDBHelper(context);
    }

    /** Methods, which enables us to 'Create',
     * 'Retrieve', 'Update' and 'Delete' data in the database.
     *
     * Method for Inserting (Creating data) */
    public int insert(PlanDatabaseData data)
    {
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        /** Inserting values into the database */
        contentValues.put(PlanDatabaseData.PART_OF_PLAN_NAME, data.getPartOfPlanName);
        contentValues.put(PlanDatabaseData.PART_OF_PLAN_DESCRIPTION, data.getPartOfPlanDescription);

        /** Inserting row (all values) */
        long planId = database.insert(PlanDatabaseData.PLAN_TABLE_ONE, null, contentValues);
        /** Closing database connection */
        database.close();
        return (int) planId;
    }

    /** Method for deleting data */
    public void delete(int planId)
    {
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        /** It's a good practice to use parameter ?, instead of concatenate string */
        database.delete(PlanDatabaseData.PLAN_TABLE_ONE, PlanDatabaseData.TABLE_ONE_KEY_ID + "= ?",
                new String[]{String.valueOf(planId)});
        /** Closing database connection */
        database.close();
    }

    /** Method for updating data */
    public void update(PlanDatabaseData data)
    {
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        /** Inserting values into the database */
        contentValues.put(PlanDatabaseData.PART_OF_PLAN_NAME, data.getPartOfPlanName);
        contentValues.put(PlanDatabaseData.PART_OF_PLAN_DESCRIPTION, data.getPartOfPlanDescription);
        /** It's a good practice to use parameter ?, instead of concatenate string */
        database.update(PlanDatabaseData.PLAN_TABLE_ONE, contentValues, PlanDatabaseData.TABLE_ONE_KEY_ID + "= ?",
                new String[] { String.valueOf(data.getPlanTableId) });
        /** Closing database connection */
        database.close();
    }

    public ArrayList<HashMap<String, String>> getPlanList()
    {
        /** Open connection to read only */
        SQLiteDatabase database = dbhelper.getReadableDatabase();
        String selectQuery =  "SELECT   " +
                PlanDatabaseData.TABLE_ONE_KEY_ID + "," +
                PlanDatabaseData.PART_OF_PLAN_NAME + "," +
                PlanDatabaseData.PART_OF_PLAN_DESCRIPTION +
                " FROM " + PlanDatabaseData.PLAN_TABLE_ONE;

        ArrayList<HashMap<String, String>> planList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = database.rawQuery(selectQuery, null);

        /** looping through all rows and adding to list */
        if (cursor.moveToFirst())
        {
            do {
                HashMap<String, String> plan = new HashMap<String, String>();
                plan.put("id", cursor.getString(cursor.getColumnIndex(PlanDatabaseData.TABLE_ONE_KEY_ID)));
                plan.put("name", cursor.getString(cursor.getColumnIndex(PlanDatabaseData.PART_OF_PLAN_NAME)));
                plan.put("description", cursor.getString(cursor.getColumnIndex(PlanDatabaseData.PART_OF_PLAN_DESCRIPTION)));
                /** adding step to the list */
                planList.add(plan);

            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return planList;
    }

    /** Method for finding step in the list by its id */
    public PlanDatabaseData getPlanById(int Id)
    {
        /** It's a good practice to use parameter ?, instead of concatenate string */
        SQLiteDatabase database = dbhelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                PlanDatabaseData.TABLE_ONE_KEY_ID + "," +
                PlanDatabaseData.PART_OF_PLAN_NAME + "," +
                PlanDatabaseData.PART_OF_PLAN_DESCRIPTION +
                " FROM " + PlanDatabaseData.PLAN_TABLE_ONE
                + " WHERE " +
                PlanDatabaseData.TABLE_ONE_KEY_ID + "=?";

        PlanDatabaseData data = new PlanDatabaseData();

        Cursor cursor = database.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                data.getPlanTableId = cursor.getInt(cursor.getColumnIndex(PlanDatabaseData.TABLE_ONE_KEY_ID));
                data.getPartOfPlanName = cursor.getString(cursor.getColumnIndex(PlanDatabaseData.PART_OF_PLAN_NAME));
                data.getPartOfPlanDescription = cursor.getString(cursor.getColumnIndex(PlanDatabaseData.PART_OF_PLAN_DESCRIPTION));

            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return data;
    }
}
