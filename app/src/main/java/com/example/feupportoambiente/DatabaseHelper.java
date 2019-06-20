package com.example.feupportoambiente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static Context myContext;

    //creating a public variable for the database name
    public static final String DATABASE_NAME = "residuos.db";

    private static final String TABLE_NAME = "residuos_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "rua";
    private static final String COL3 = "residuos";
    private static final String COL4 = "area";
    private static final String COL5 = "pea_pequeno_1";
    private static final String COL6 = "pea_medio_1";
    private static final String COL7 = "pea_grande_1";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        myContext = context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + COL6 + " INTEGER, " + COL7 + " INTEGER)";

        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String rua, String residuos, String area, int pea_pequeno_1, int pea_medio_1, int pea_grande_1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, rua);
        Log.d(TAG,"addData: Adding " + rua + " to Column " + COL2 + " in Table " + TABLE_NAME);
        contentValues.put(COL3,residuos);
        Log.d(TAG,"addData: Adding " + residuos + " to Column " + COL3 + " in Table " + TABLE_NAME);
        contentValues.put(COL4,area);
        Log.d(TAG,"addData: Adding " + area + " to Column " + COL4 + " in Table " + TABLE_NAME);
        contentValues.put(COL5,pea_pequeno_1);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_pequeno_1) + " to Column " + COL5 + " in Table " + TABLE_NAME);
        contentValues.put(COL6,pea_medio_1);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_medio_1) + " to Column " + COL6 + " in Table " + TABLE_NAME);
        contentValues.put(COL7,pea_grande_1);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_grande_1) + " to Column " + COL7 + " in Table " + TABLE_NAME);


        long result = db.insert(TABLE_NAME,null,contentValues);

        //Se a data for inserida incorretamente na base de dados
        if (result == -1){
            return false;
        }else{
            return true;
        }


    }



    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " ",
                null);
        return res;
    }

    public boolean deleteRow(int rowId){
        SQLiteDatabase db = this.getReadableDatabase();
        String onde = COL1 + "=" + rowId;
        return db.delete(TABLE_NAME,onde,null) != 0;
    }


    public void deleteData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor del = db.rawQuery("select * from " + TABLE_NAME + " ",
                null);
        int rowId = del.getColumnIndexOrThrow(COL1);
        if(del.moveToFirst()){
            do {
               deleteRow(del.getInt(rowId));
            }while(del.moveToNext());
        }
            del.close();

    }




}
