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

    private static final String COL5 = "pea_pequeno_rua";
    private static final String COL6 = "pea_medio_rua";
    private static final String COL7 = "pea_grande_rua";
    private static final String COL8 = "pena_pequeno_rua";
    private static final String COL9 = "pena_medio_rua";
    private static final String COL10 = "pena_grande_rua";
    private static final String COL11 = "pedacos_vidro_rua";
    private static final String COL12 = "garrafapeq_vidro_rua";
    private static final String COL13 = "garrafagra_vidro_rua";
    private static final String COL14 = "cigarros_rua";
    private static final String COL15 = "dejetos_rua";
    private static final String COL16 = "indiferenciados_rua";
    private static final String COL17 = "folhas_rua";
    private static final String COL18 = "rampequenas_rua";
    private static final String COL19 = "ramgrandes_rua";
    private static final String COL20 = "pastilhas_rua";
    private static final String COL21 = "past_ate500_rua";
    private static final String COL22 = "past_maior500_rua";
    private static final String COL23 = "ra_pequeno_rua";
    private static final String COL24 = "ra_medio_rua";
    private static final String COL25 = "ra_grande_rua";
    private static final String COL26 = "oro_pequeno_rua";
    private static final String COL27 = "oro_medio_rua";
    private static final String COL28 = "oro_grande_rua";
    private static final String COL29 = "latas_metais_rua";
    private static final String COL30 = "outros_metais_rua";

    private static final String COL31 = "pea_pequeno_pa";
    private static final String COL32 = "pea_medio_pa";
    private static final String COL33 = "pea_grande_pa";
    private static final String COL34 = "pena_pequeno_pa";
    private static final String COL35 = "pena_medio_pa";
    private static final String COL36 = "pena_grande_pa";
    private static final String COL37 = "pedacos_vidro_pa";
    private static final String COL38 = "garrafapeq_vidro_pa";
    private static final String COL39 = "garrafagra_vidro_pa";
    private static final String COL40 = "cigarros_pa";
    private static final String COL41 = "dejetos_pa";
    private static final String COL42 = "indiferenciados_pa";
    private static final String COL43 = "folhas_pa";
    private static final String COL44 = "rampequenas_pa";
    private static final String COL45 = "ramgrandes_pa";
    private static final String COL46 = "pastilhas_pa";
    private static final String COL47 = "past_ate500_pa";
    private static final String COL48 = "past_maior500_pa";
    private static final String COL49 = "ra_pequeno_pa";
    private static final String COL50 = "ra_medio_pa";
    private static final String COL51 = "ra_grande_pa";
    private static final String COL52 = "oro_pequeno_pa";
    private static final String COL53 = "oro_medio_pa";
    private static final String COL54 = "oro_grande_pa";
    private static final String COL55 = "latas_metais_pa";
    private static final String COL56 = "outros_metais_pa";

    private static final String COL57 = "pea_pequeno_cf";
    private static final String COL58 = "pea_medio_cf";
    private static final String COL59 = "pea_grande_cf";
    private static final String COL60 = "pena_pequeno_cf";
    private static final String COL61 = "pena_medio_cf";
    private static final String COL62 = "pena_grande_cf";
    private static final String COL63 = "pedacos_vidro_cf";
    private static final String COL64 = "garrafapeq_vidro_cf";
    private static final String COL65 = "garrafagra_vidro_cf";
    private static final String COL66 = "cigarros_cf";
    private static final String COL67 = "dejetos_cf";
    private static final String COL68 = "indiferenciados_cf";
    private static final String COL69 = "folhas_cf";
    private static final String COL70 = "rampequenas_cf";
    private static final String COL71 = "ramgrandes_cf";
    private static final String COL72 = "pastilhas_cf";
    private static final String COL73 = "past_ate500_cf";
    private static final String COL74 = "past_maior500_cf";
    private static final String COL75 = "ra_pequeno_cf";
    private static final String COL76 = "ra_medio_cf";
    private static final String COL77 = "ra_grande_cf";
    private static final String COL78 = "oro_pequeno_cf";
    private static final String COL79 = "oro_medio_cf";
    private static final String COL80 = "oro_grande_cf";
    private static final String COL81 = "latas_metais_cf";
    private static final String COL82 = "outros_metais_cf";

    private static final String COL83 = "bocalobolimpa_bl";
    private static final String COL84 = "bocalobosuja_bl";
    private static final String COL85 = "bocalobototal_bl";
    private static final String COL86 = "papeleirasvazia_bl";
    private static final String COL87 = "papeleirascheias_bl";
    private static final String COL88 = "papeleirastotal_bl";
    private static final String COL89 = "pa";
    private static final String COL90 = "cf";
    private static final String COL91 = "bl";
    private static final String COL92 = "data";
    private static final String COL93 = "ajardinadas_pa";
    private static final String COL94 = "caldeiras_cf";







    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        myContext = context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " INTEGER, " + COL6 + " INTEGER, " + COL7 + " INTEGER, "
                + COL8 + " INTEGER, " + COL9 + " INTEGER, "+ COL10 + " INTEGER, "+ COL11 + " INTEGER, "+ COL12 + " INTEGER, "+ COL13 + " INTEGER, "+ COL14 + " INTEGER, "+ COL15 + " INTEGER, "+ COL16 + " INTEGER, "
                + COL17 + " INTEGER, "+ COL18 + " INTEGER, "+ COL19 + " INTEGER, "+ COL20 + " INTEGER, "+ COL21 + " INTEGER, "+ COL22 + " INTEGER, "+ COL23 + " INTEGER, "+ COL24 + " INTEGER, "+ COL25 + " INTEGER, "
                + COL26 + " INTEGER, "+ COL27 + " INTEGER, "+ COL28 + " INTEGER, "+ COL29 + " INTEGER, "+ COL30 + " INTEGER, "+ COL31 + " INTEGER, "+ COL32 + " INTEGER, "+ COL33 + " INTEGER, "+ COL34 + " INTEGER, "
                + COL35 + " INTEGER, "+ COL36 + " INTEGER, "+ COL37 + " INTEGER, "+ COL38 + " INTEGER, "+ COL39 + " INTEGER, "+ COL40 + " INTEGER, "+ COL41 + " INTEGER, "+ COL42 + " INTEGER, "+ COL43 + " INTEGER, "
                + COL44 + " INTEGER, "+ COL45 + " INTEGER, "+ COL46 + " INTEGER, "+ COL47 + " INTEGER, "+ COL48 + " INTEGER, "+ COL49 + " INTEGER, "+ COL50 + " INTEGER, "+ COL51 + " INTEGER, "+ COL52 + " INTEGER, "
                + COL53 + " INTEGER, "+ COL54 + " INTEGER, "+ COL55 + " INTEGER, "+ COL56 + " INTEGER, "+ COL57 + " INTEGER, "+ COL58 + " INTEGER, "+ COL59 + " INTEGER, "+ COL60 + " INTEGER, "+ COL61 + " INTEGER, "
                + COL62 + " INTEGER, "+ COL63 + " INTEGER, "+ COL64 + " INTEGER, "+ COL65 + " INTEGER, "+ COL66 + " INTEGER, "+ COL67 + " INTEGER, "+ COL68 + " INTEGER, "+ COL69 + " INTEGER, "+ COL70 + " INTEGER, "
                + COL71 + " INTEGER, "+ COL72 + " INTEGER, "+ COL73 + " INTEGER, "+ COL74 + " INTEGER, "+ COL75 + " INTEGER, "+ COL76 + " INTEGER, "+ COL77 + " INTEGER, "+ COL78 + " INTEGER, "+ COL79 + " INTEGER, "
                + COL80 + " INTEGER, "+ COL81 + " INTEGER, "+ COL82 + " INTEGER, "+ COL83 + " INTEGER, "+ COL84 + " INTEGER, "+ COL85 + " INTEGER, "+ COL86 + " INTEGER, "+ COL87 + " INTEGER, "+ COL88 + " INTEGER, "
                + COL89 + " INTEGER, "+ COL90 + " INTEGER, "+ COL91 + " INTEGER, " + COL92 + " TEXT, " + COL93 + " INTEGER, "+ COL94 + " INTEGER)";


        db.execSQL(CreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String rua, String residuos, String area,int pea_pequeno_rua,int pea_medio_rua, int pea_grande_rua,int pena_pequeno_rua,int pena_medio_rua,int pena_grande_rua,int pedacos_vidro_rua,
                           int garrafapeq_vidro_rua,int garrafagra_vidro_rua, int cigarros_rua, int dejetos_rua, int indiferenciados_rua, int folhas_rua, int rampequenas_rua, int ramgrandes_rua,
                           int pastilhas_rua, int past_ate500_rua, int past_maior500_rua, int ra_pequeno_rua, int ra_medio_rua, int ra_grande_rua, int oro_pequeno_rua, int oro_medio_rua, int oro_grande_rua,
                           int latas_metais_rua, int outros_metais_rua, int pea_pequeno_pa, int pea_medio_pa, int pea_grande_pa, int pena_pequeno_pa, int pena_medio_pa, int pena_grande_pa,int pedacos_vidro_pa,
                           int garrafapeq_vidro_pa,int garrafagra_vidro_pa, int cigarros_pa,int dejetos_pa, int indiferenciados_pa, int folhas_pa, int rampequenas_pa, int ramgrandes_pa, int pastilhas_pa,
                           int past_ate500_pa, int past_maior500_pa, int ra_pequeno_pa,int ra_medio_pa, int ra_grande_pa, int oro_pequeno_pa, int oro_medio_pa, int oro_grande_pa, int latas_metais_pa,
                           int outros_metais_pa, int pea_pequeno_cf, int pea_medio_cf,int pea_grande_cf, int pena_pequeno_cf, int pena_medio_cf, int pena_grande_cf, int pedacos_vidro_cf, int garrafapeq_vidro_cf,
                           int garrafagra_vidro_cf, int cigarros_cf, int dejetos_cf,int indiferenciados_cf,int folhas_cf, int rampequenas_cf, int ramgrandes_cf, int pastilhas_cf, int past_ate500_cf,
                           int past_maior500_cf, int ra_pequeno_cf, int ra_medio_cf,int ra_grande_cf, int oro_pequeno_cf, int oro_medio_cf, int oro_grande_cf, int latas_metais_cf, int outros_metais_cf,
                           int bocalobolimpa_bl, int bocalobosuja_bl, int bocalobototal_bl, int papeleirasvazia_bl, int papeleirascheias_bl, int papeleirastotal_bl, int pa, int cf, int bl, String data, int ajardinadas_pa, int caldeiras_cf){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, rua);
        Log.d(TAG,"addData: Adding " + rua + " to Column " + COL2 + " in Table " + TABLE_NAME);
        contentValues.put(COL3,residuos);
        Log.d(TAG,"addData: Adding " + residuos + " to Column " + COL3 + " in Table " + TABLE_NAME);
        contentValues.put(COL4,area);
        Log.d(TAG,"addData: Adding " + area + " to Column " + COL4 + " in Table " + TABLE_NAME);
        contentValues.put(COL5,pea_pequeno_rua);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_pequeno_rua) + " to Column " + COL5 + " in Table " + TABLE_NAME);
        contentValues.put(COL6,pea_medio_rua);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_medio_rua) + " to Column " + COL6 + " in Table " + TABLE_NAME);
        contentValues.put(COL7,pea_grande_rua);
        Log.d(TAG,"addData: Adding " + Integer.toString(pea_grande_rua) + " to Column " + COL7 + " in Table " + TABLE_NAME);


        contentValues.put(COL8 , pena_pequeno_rua);
        contentValues.put(COL9 , pena_medio_rua);
        contentValues.put(COL10 , pena_grande_rua);
        contentValues.put(COL11 , pedacos_vidro_rua);
        contentValues.put(COL12 , garrafapeq_vidro_rua);
        contentValues.put(COL13 , garrafagra_vidro_rua);
        contentValues.put(COL14 , cigarros_rua);
        contentValues.put(COL15 , dejetos_rua);
        contentValues.put(COL16 , indiferenciados_rua);
        contentValues.put(COL17 , folhas_rua);
        contentValues.put(COL18 , rampequenas_rua);
        contentValues.put(COL19 , ramgrandes_rua);
        contentValues.put(COL20 , pastilhas_rua);
        contentValues.put(COL21 , past_ate500_rua);
        contentValues.put(COL22 , past_maior500_rua);
        contentValues.put(COL23 , ra_pequeno_rua);
        contentValues.put(COL24 , ra_medio_rua);
        contentValues.put(COL25 , ra_grande_rua);
        contentValues.put(COL26 , oro_pequeno_rua);
        contentValues.put(COL27 , oro_medio_rua);
        contentValues.put(COL28 , oro_grande_rua);
        contentValues.put(COL29 , latas_metais_rua);
        contentValues.put(COL30 , outros_metais_rua);

        contentValues.put(COL31 , pea_pequeno_pa);
        contentValues.put(COL32 , pea_medio_pa);
        contentValues.put(COL33 , pea_grande_pa);
        contentValues.put(COL34 , pena_pequeno_pa);
        contentValues.put(COL35 , pena_medio_pa);
        contentValues.put(COL36 , pena_grande_pa);
        contentValues.put(COL37 , pedacos_vidro_pa);
        contentValues.put(COL38 , garrafapeq_vidro_pa);
        contentValues.put(COL39 , garrafagra_vidro_pa);
        contentValues.put(COL40 , cigarros_pa);
        contentValues.put(COL41 , dejetos_pa);
        contentValues.put(COL42 , indiferenciados_pa);
        contentValues.put(COL43 , folhas_pa);
        contentValues.put(COL44 , rampequenas_pa);
        contentValues.put(COL45 , ramgrandes_pa);
        contentValues.put(COL46 , pastilhas_pa);
        contentValues.put(COL47 , past_ate500_pa);
        contentValues.put(COL48 , past_maior500_pa);
        contentValues.put(COL49 , ra_pequeno_pa);
        contentValues.put(COL50 , ra_medio_pa);
        contentValues.put(COL51 , ra_grande_pa);
        contentValues.put(COL52 , oro_pequeno_pa);
        contentValues.put(COL53 , oro_medio_pa);
        contentValues.put(COL54 , oro_grande_pa);
        contentValues.put(COL55 , latas_metais_pa);
        contentValues.put(COL56 , outros_metais_pa);

        contentValues.put(COL57 , pea_pequeno_cf);
        contentValues.put(COL58 , pea_medio_cf);
        contentValues.put(COL59 , pea_grande_cf);
        contentValues.put(COL60 , pena_pequeno_cf);
        contentValues.put(COL61 , pena_medio_cf);
        contentValues.put(COL62 , pena_grande_cf);
        contentValues.put(COL63 , pedacos_vidro_cf);
        contentValues.put(COL64 , garrafapeq_vidro_cf);
        contentValues.put(COL65 , garrafagra_vidro_cf);
        contentValues.put(COL66 , cigarros_cf);
        contentValues.put(COL67 , dejetos_cf);
        contentValues.put(COL68 , indiferenciados_cf);
        contentValues.put(COL69 , folhas_cf);
        contentValues.put(COL70 , rampequenas_cf);
        contentValues.put(COL71 , ramgrandes_cf);
        contentValues.put(COL72 , pastilhas_cf);
        contentValues.put(COL73 , past_ate500_cf);
        contentValues.put(COL74 , past_maior500_cf);
        contentValues.put(COL75 , ra_pequeno_cf);
        contentValues.put(COL76 , ra_medio_cf);
        contentValues.put(COL77 , ra_grande_cf);
        contentValues.put(COL78 , oro_pequeno_cf);
        contentValues.put(COL79 , oro_medio_cf);
        contentValues.put(COL80 , oro_grande_cf);
        contentValues.put(COL81 , latas_metais_cf);
        contentValues.put(COL82 , outros_metais_cf);

        contentValues.put(COL83 , bocalobolimpa_bl);
        contentValues.put(COL84 , bocalobosuja_bl);
        contentValues.put(COL85 , bocalobototal_bl);
        contentValues.put(COL86 , papeleirasvazia_bl);
        contentValues.put(COL87 , papeleirascheias_bl);
        contentValues.put(COL88 , papeleirastotal_bl);
        contentValues.put(COL89 , pa);
        contentValues.put(COL90 , cf);
        contentValues.put(COL91 , bl);
        contentValues.put(COL92 , data);
        contentValues.put(COL93 , ajardinadas_pa);
        contentValues.put(COL94 , caldeiras_cf);


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
