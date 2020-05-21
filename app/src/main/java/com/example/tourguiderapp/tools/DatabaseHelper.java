package com.example.tourguiderapp.tools;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


/**
 * This class will manage our SQLite database by creating the different tables.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "PROFILE";
    private static final String COLUMN_USER_ID = "USER_ID";
    private static final String COLUMN_USER_NAME = "USER_NAME";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_PASSWORD = "PASSWORD";
    private static final String COLUMN_CONFIRM_PASSWORD = "CONFIRM_PASSWORD";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }


    // this is called the first time a database is accessed. There should be code in here to create a new database.

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProfileStatement = String.format("CREATE TABLE %s (%s TEXT" +
                " PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, COLUMN_USER_ID,
                COLUMN_USER_NAME, COLUMN_EMAIL, COLUMN_PASSWORD, COLUMN_CONFIRM_PASSWORD);
        db.execSQL(createProfileStatement);
    }

    // this is called id database version number changes. It prevents previous users apps from breaking when you change database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnUserName() {
        return COLUMN_USER_NAME;
    }

    public static String getColumnEmail() {
        return COLUMN_EMAIL;
    }

    public static String getColumnPassword() {
        return COLUMN_PASSWORD;
    }

    public static String getColumnConfirmPassword() {
        return COLUMN_CONFIRM_PASSWORD;
    }

    public static String getTAG() {
        return TAG;
    }
}
