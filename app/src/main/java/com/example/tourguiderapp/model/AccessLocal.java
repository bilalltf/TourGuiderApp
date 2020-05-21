package com.example.tourguiderapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.tourguiderapp.tools.DatabaseHelper;

public class AccessLocal {

    private static final String DATABASE_NAME = "TourGuider.db";
    private static final Integer DATABASE_VERSION = 1;
    private DatabaseHelper accessBD;


    public AccessLocal(Context context){
        accessBD = new DatabaseHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public boolean addProfile(ProfileRegister profileRegister) {
        SQLiteDatabase sqLiteDatabase = accessBD.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.getColumnUserName(), profileRegister.getUserName());
        cv.put(DatabaseHelper.getColumnEmail(), profileRegister.getEmail());
        cv.put(DatabaseHelper.getColumnPassword(), profileRegister.getPassword());
        cv.put(DatabaseHelper.getColumnConfirmPassword(), profileRegister.getConfirmPassword());
        Log.d(DatabaseHelper.getTAG(), "AddData : " + profileRegister.getUserName() + " to " + DatabaseHelper.getTableName());
        Log.d(DatabaseHelper.getTAG(), "AddData : " + profileRegister.getEmail() + " to " + DatabaseHelper.getTableName());
        Log.d(DatabaseHelper.getTAG(), "AddData : " + profileRegister.getPassword() + " to " + DatabaseHelper.getTableName());
        Log.d(DatabaseHelper.getTAG(), "AddData : " + profileRegister.getConfirmPassword() + " to " + DatabaseHelper.getTableName());
        long result = sqLiteDatabase.insert(DatabaseHelper.getTableName(), null, cv);
        return result != -1;
    }
}
