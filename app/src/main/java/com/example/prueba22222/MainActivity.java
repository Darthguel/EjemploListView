package com.example.prueba22222;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPrecio;
    Button bGrabar, bModificar, bEliminar;
    ListView mostrarBase;

    public ArrayList<String> arrayNombres;
    public ArrayList<Producto> arrayTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.etNombre);
        txtPrecio = (EditText) findViewById(R.id.etPrecio);
        bGrabar = (Button) findViewById(R.id.btnGrabar);
        bModificar = (Button) findViewById(R.id.btnModificar);
        bEliminar = (Button) findViewById(R.id.btnEliminar);
        mostrarBase = (ListView) findViewById(R.id.lvDatos);

        desplegar();

        bGrabar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (txtNombre.length() > 0 && txtPrecio.length() > 0)
                {
                    Producto prod = new Producto();
                    FuncionesCRUD quehacer = new FuncionesCRUD(getApplicationContext());
                    prod.setNombre(txtNombre.getText().toString());
                    prod.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
                    quehacer.insertar(prod);
                    desplegar();
                }
            }
        });  // Fin BOTON Grabar

        bModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.length() > 0 && txtPrecio.length() > 0) {
                    Producto prod = new Producto();
                    FuncionesCRUD quehacer = new FuncionesCRUD(getApplicationContext());
                    prod.setNombre(txtNombre.getText().toString());
                    prod.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
                    quehacer.modificar(prod);
                    desplegar();
                }
            }
        });  // Fin BOTON Modificar

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x;
                FuncionesCRUD quehacer = new FuncionesCRUD( getApplicationContext());
                x = txtNombre.getText().toString();
                quehacer.borrar(x);
                desplegar();
            }
        });  // Fin BOTON Borrar

        mostrarBase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtNombre.setText(arrayTodo.get(position).getNombre());
                txtPrecio.setText(String.valueOf(arrayTodo.get(position).getPrecio()).toString());
            }
        });  // Fin Evento Click En List View
    } // FIN DEL METODO ONCREATE

    public void desplegar(){
        FuncionesCRUD quehacer = new FuncionesCRUD( getApplicationContext());
        arrayNombres = quehacer.cargaNombre();
        arrayTodo =quehacer.cargaTodo();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayNombres);
        mostrarBase.setAdapter(adp);
        limpiaET();
    } // Cierre Desplegar

    public void limpiaET(){
        txtNombre.setText(null);
        txtPrecio.setText(null);
    }



} // FIN DE LA CLASE