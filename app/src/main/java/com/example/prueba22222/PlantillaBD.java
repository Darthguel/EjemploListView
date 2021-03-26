package com.example.prueba22222;

import android.provider.BaseColumns;

public class PlantillaBD {

    public static abstract class ProductoEntry implements BaseColumns {

        public static final String TABLE_NAME ="productos";
        public static final String NOMBRE  = "NOMBRE";
        public static final String PRECIO = "PRECIO";
    }
}
