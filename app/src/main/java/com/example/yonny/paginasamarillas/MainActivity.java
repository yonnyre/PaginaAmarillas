package com.example.yonny.paginasamarillas;
55
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    SearchView buscador;
    ListView lista;

    public String rubro,nombre,direccion,telefono,correo,url,info,logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = (ListView) findViewById(R.id.ContenlistView);
        buscador = (SearchView) findViewById(R.id.buscador);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);

        final ArrayAdapter<String> adapter1 = (ArrayAdapter<String>)lista.getAdapter();

        adapter1.clear();

        EmpresaRepository empresaRepository = EmpresaRepository.getInstance();
        final List<Empresa> empresas = empresaRepository.getEmpresas();
        for (Empresa empresa1 : empresas) {
            adapter1.add(empresa1.getNombre());

        }



        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id) {
                Empresa empresa = empresas.get(position);

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                    intent.putExtra("nombre",empresa.getNombre());
                    intent.putExtra("direccion",empresa.getDireccion());
                    intent.putExtra("telefono",empresa.getTelefono());
                    intent.putExtra("rubro",empresa.getRubro());
                    intent.putExtra("url",empresa.getUrl());
                    intent.putExtra("correo",empresa.getCorreo());
                    intent.putExtra("info",empresa.getInfo());
                    startActivity(intent);

            }
        });

    }


}
