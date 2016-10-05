package edu.sfsu.cs.orange.ocr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/**
 * Created by cenk.akdeniz on 06.04.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "sertifika.db";
    public static final String TABLE_NAME_SERT = "SERTIFIKA";
    public static final String TABLE_NAME_DIS = "HASTALIK";
    public static final String COL1_SERT = "ID";
    public static final String COL2_SERT = "TITLE";
    public static final String COL3_SERT = "APPLICATION_AREAS";
    public static final String COL4_SERT = "DISEASES";
    public static final String COL5_SERT = "BANNED_COUNTRIES";
    public static final String COL6_SERT = "CONDITION";
    public static final String COL7_SERT = "LANGUAGE";
   // SQLiteDatabase db = this.getWritableDatabase();
      SQLiteDatabase db;
      Cursor cursor;

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // NOTES Table - column nmaes
    private static final String KEY_TODO = "todo";
    private static final String KEY_STATUS = "status";

    // TAGS Table - column names
    private static final String KEY_TAG_NAME = "tag_name";

    // NOTE_TAGS Table - column names
    private static final String KEY_TODO_ID = "todo_id";
    private static final String KEY_TAG_ID = "tag_id";
    public static final String CREATE_SERTIFIKA_TABLE = "CREATE TABLE SERTIFIKA (ID INTEGER PRIMARY KEY AUTOINCREMENT , TITLE TEXT ," +
            " APPLICATION_AREAS TEXT , DISEASES TEXT , BANNED_COUNTRIES TEXT , CONDITION TEXT , LANGUAGE TEXT)";

    public static final String CREATE_HASTALIK_TABLE = "CREATE TABLE HASTALIK (ID INTEGER PRIMARY KEY AUTOINCREMENT , TITLE TEXT ," +
            " ECODES TEXT , LANGUAGE TEXT)";

    public static final String COL1_DIS = "ID";
    public static final String COL2_DIS = "TITLE";
    public static final String COL3_DIS = "ECODES";
    public static final String COL4_DIS = "LANGUAGE";
    private static DatabaseHelper instance = null;

    long result;

    public static DatabaseHelper getInstance(Context ctx) {
        if (instance == null) {
            instance = new DatabaseHelper(ctx.getApplicationContext());
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("OnCreate", "OnCreate invoked");
        db.execSQL(CREATE_SERTIFIKA_TABLE);
        db.execSQL(CREATE_HASTALIK_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME_SERT);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME_DIS);
        onCreate(db);
        db.close();
    }

    public boolean insertData(String title, String application_areas, String deseases, String banned_countries, String condition , String language) {
        try {
            db = this.getWritableDatabase();
        }
        catch (SQLException s){
            new Exception("Error with DB Open");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_SERT, title);
        contentValues.put(COL3_SERT, application_areas);
        contentValues.put(COL4_SERT, deseases);
        contentValues.put(COL5_SERT, banned_countries);
        contentValues.put(COL6_SERT, condition);
        contentValues.put(COL7_SERT, language);
        cursor = db.rawQuery("SELECT * "  + " FROM " + TABLE_NAME_SERT  + " WHERE " + COL2_SERT + " = ? ", new String[]{title});

        if(!cursor.moveToFirst()){
            result = db.insert(TABLE_NAME_SERT, null, contentValues);
        }
        else if (cursor.moveToFirst()) {
            String first = cursor.getString(1).toString();
            String en = cursor.getString(6).toString();
            if(first.equals(title) && language.equals("tr") && en.equals("en") && !cursor.moveToNext())  {
                result = db.insert(TABLE_NAME_SERT, null, contentValues);
            }
        }
        db.close();
        if (getResult() == -1) {
            return false;
        }
        else {
            return true;

        }

    }


    public boolean insertDataDis(String title, String ecodes ,String language) {
        try {
             db = this.getWritableDatabase();
        }
        catch (SQLException s){
            new Exception("Error with DB Open");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_DIS, title);
        contentValues.put(COL3_DIS, ecodes);
        contentValues.put(COL4_DIS, language);
        cursor = db.rawQuery("SELECT " + COL2_DIS + " FROM " + TABLE_NAME_DIS + " WHERE " + COL2_DIS + " = ? ", new String[]{title});
        if (!cursor.moveToFirst()) {
                result = db.insert(TABLE_NAME_DIS, null, contentValues);
            }
        db.close();
        if (getResult() == -1)
            return false;
        else
            return true;
    }


    public void deleteDatabase() {
        try {
            db = this.getWritableDatabase();
        }
        catch (SQLException s){
            new Exception("Error with DB Open");
        }
        db.execSQL("DROP TABLE sertifika");
        db.close();

    }

    public Cursor getAllData(String query) {
        try {
            db = this.getWritableDatabase();
        }
        catch (SQLException s){
            new Exception("Error with DB Open");
        }
         cursor = db.rawQuery(query , null);
        return cursor;
    }

    public void deleteData(String id, String tableName) {
        try {
            db = this.getWritableDatabase();
        }
        catch (SQLException s){
            new Exception("Error with DB Open");
        }
        db.execSQL("delete * from " + tableName + " where language ='" + id + "'");
        db.close();
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}
