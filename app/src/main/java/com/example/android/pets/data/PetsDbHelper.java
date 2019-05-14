package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetsDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="shelter";
    private static final int DB_VERSION=1;
    private static final String DB_CREATE_SCHEMA="CREATE TABLE "+PetContract.PetEntry.TABLE_NAME+
            " ("+PetContract.PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            PetContract.PetEntry.COLUMN_PET_NAME+" TEXT NOT NULL, "+
            PetContract.PetEntry.COLUMN_PET_BREED+" TEXT NOT NULL, "+
            PetContract.PetEntry.COLUMN_PET_GENDER+" INTEGER NOT NULL, "+
            PetContract.PetEntry.COLUMN_PET_WEIGHT+" INTEGER NOT NULL DEFAULT 0);";

    public PetsDbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE_SCHEMA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+PetContract.PetEntry.TABLE_NAME);
        onCreate(db);
    }
}
