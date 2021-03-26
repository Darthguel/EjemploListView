package com.example.prueba22222;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Productos.db";

    private ConexionBD datos;
    private SQLiteDatabase db;

    public ConexionBD (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + PlantillaBD.ProductoEntry.TABLE_NAME + " ("
                + PlantillaBD.ProductoEntry.NOMBRE + " TEXT NOT NULL,"
                + PlantillaBD.ProductoEntry.PRECIO + " INTEGER NOT NULL)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}