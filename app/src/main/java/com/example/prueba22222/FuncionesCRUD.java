package com.example.prueba22222;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FuncionesCRUD {
    private ConexionBD Bdatos;
    private SQLiteDatabase db;
    private ContentValues values = new ContentValues();

    public FuncionesCRUD(Context context) {
        Bdatos = new ConexionBD(context);
    }

    public FuncionesCRUD() { }

    public void insertar(Producto n) {
        db = Bdatos.getWritableDatabase();
        values.clear();
        values.put(PlantillaBD.ProductoEntry.NOMBRE, n.getNombre());
        values.put(PlantillaBD.ProductoEntry.PRECIO, n.getPrecio());
        db.insert(PlantillaBD.ProductoEntry.TABLE_NAME, null, values);
        //  db.close();
    } // Fin Metodo Grabar

    public void modificar(Producto n) {
        db = Bdatos.getWritableDatabase();
        values.clear();
        values.put(PlantillaBD.ProductoEntry.NOMBRE, n.getNombre());
        values.put(PlantillaBD.ProductoEntry.PRECIO, n.getPrecio());
        String[] args = new String[]{n.getNombre()};
        db.update(PlantillaBD.ProductoEntry.TABLE_NAME, values, PlantillaBD.ProductoEntry.NOMBRE + "=?", args);
        // db.close();
    }  // Fin Metodo Modificar

    public void borrar(String n) {
        db = Bdatos.getWritableDatabase();
        String[] args1 = new String[]{n};
        db.delete(PlantillaBD.ProductoEntry.TABLE_NAME, PlantillaBD.ProductoEntry.NOMBRE + "=?", args1);
    }  //  Fin Metodo Borrar

    public ArrayList cargaNombre(){
        ArrayList<String> soloNombre = new ArrayList<>();
        db = Bdatos.getWritableDatabase();
        Cursor registros = db.rawQuery("SELECT * FROM " + PlantillaBD.ProductoEntry.TABLE_NAME, null);
        if (registros.moveToFirst()){
            do {
                soloNombre.add(registros.getString(0)); // + " " + registro.getString(1));
            }while(registros.moveToNext());
        }
        //db1.close();
        return soloNombre;
    }  // Fin Metodo que Rellena los Nombres

    public ArrayList<Producto> cargaTodo() {
        ArrayList<Producto> totProductos = new ArrayList<Producto>();
        db = Bdatos.getWritableDatabase();
        Cursor registros = db.rawQuery("select * from " + PlantillaBD.ProductoEntry.TABLE_NAME, null);
        if (registros.moveToFirst()) {
            do {
                totProductos.add(new Producto(registros.getString(0), registros.getInt(1)));
            } while(registros.moveToNext());
        }
        //db1.close();
        return totProductos;
    }  // Fin del metodo que carga todos los datos


}  //  Fin FuncionesCRUD
