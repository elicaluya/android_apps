package edu.uoregon.ecaluya.tide_appv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elijahcaluya on 7/16/17.
 */

public class TideSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tide.sqlite";
    private static final int DATABASE_VERSION = 1;
    private Context context = null;

    public TideSQLiteHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Tide_Predictions"
                + "( _id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "Date TEXT,"
                + "Day TEXT,"
                + "Time TEXT,"
                + "PredFt TEXT,"
                + "PredCm TEXT,"
                + "HighLow TEXT,"
                + "StationName TEXT"
                + ")" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}
