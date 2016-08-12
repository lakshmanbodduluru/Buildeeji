package admi.buildeeji.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import admi.buildeeji.Util;
import admi.buildeeji.bin.Registration;

/**
 * Created by Admin on 7/20/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {
    Context context;
    String mPassword;
    String mReturnPassword;

    SQLiteDatabase sqLiteDatabase;
    ArrayList<Registration> myRegistrationList;
    private static final String DATABASE_NAME = "MyDatabase";
    public static final String TABLE_NAME_REGISTRATION = "REGISTRATION";
    private static final String NAME = "NAME";
    private static final String EMAIL = "EMAIL";
    private static final String MOBILE = "MOBILE";
    private static final String PASSWORD = "PASSWORD";
    private static final String CREATE_TABLE_REGISTRATION = "CREATE TABLE " + TABLE_NAME_REGISTRATION + " (NAME  VARCHAR(25),EMAIL VARCHAR(40),MOBILE VARCHAR(12),PASSWORD VARCHAR(200))";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_REGISTRATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIntoRegistration(Registration registration) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, registration.getName());
        contentValues.put(EMAIL, registration.getEmail());
        contentValues.put(MOBILE, registration.getMobile());
        contentValues.put(PASSWORD, registration.getPassword());
        long id = sqLiteDatabase.insert(TABLE_NAME_REGISTRATION, null, contentValues);
        Util.dataInsertionStatus(id, context);
    }

    public String retrievePassword(String name, String pass) {
        sqLiteDatabase = this.getReadableDatabase();
        try {
            String query = "" +
                    "SELECT * " +
                    "FROM     " + TABLE_NAME_REGISTRATION + " " +
                    "WHERE  EMAIL = " + name;
            Cursor c = sqLiteDatabase.rawQuery(query, null);
            if (c.moveToFirst()) {
                do {
                    String password = c.getString(c.getColumnIndex(PASSWORD));
                    Log.e("Database", "mPassword:" + password);
                    this.mPassword = password;
                }
                while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return mPassword;
        if (pass.equals(mPassword)) {
            mReturnPassword = mPassword;
        } else {
            try {
                String queryMobile = "" +
                        "SELECT * " +
                        "FROM     " + TABLE_NAME_REGISTRATION + " " +
                        "WHERE  MOBILE = " + name;
                Cursor c = sqLiteDatabase.rawQuery(queryMobile, null);
                if (c.moveToFirst()) {
                    do {
                        String password = c.getString(c.getColumnIndex(PASSWORD));
                        this.mPassword = password;
                        mReturnPassword = mPassword;
                    }
                    while (c.moveToNext());
                }
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(pass.equals(mPassword)){
                mReturnPassword = mPassword;
            }
            else {
                try {
                    String queryMobile = "" +
                            "SELECT * " +
                            "FROM     " + TABLE_NAME_REGISTRATION + " " +
                            "WHERE  NAME = " + name;
                    Cursor c = sqLiteDatabase.rawQuery(queryMobile, null);
                    if (c.moveToFirst()) {
                        do {
                            String password = c.getString(c.getColumnIndex(PASSWORD));
                            this.mPassword = password;
                            mReturnPassword = mPassword;
                        }
                        while (c.moveToNext());
                    }
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return mReturnPassword;
    }

}
