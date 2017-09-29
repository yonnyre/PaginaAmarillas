package com.example.yonny.paginasamarillas;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yonny on 25/09/2017.
 */

public class EmpresaRepository {

    private static EmpresaRepository repository = new EmpresaRepository();
    private HashMap<String, Empresa> empresas = new HashMap<>();

    public static EmpresaRepository getInstance() {
        return repository;
    }

    private EmpresaRepository() {
        saveEmpresa(new Empresa("123456789",  "Seguridad", "G4s", "los Ebanistas 146", "comercial.peru@pe.g4s.com", "http://www.g4s.com.pe/", "LOGO", "G4S TRABAJA PARA EGUARADAR EL BIENESTAR"));


        saveEmpresa(new Empresa("987660634",  "Restaurante", "Raca Rumi Restaurante", "Direccion 1","comercial2.peru@pe.g4s.com", "http://www.g45s.com.pe/","LOGO1", "info1111111111111111111111111111111111111111111111111111111111"));
        saveEmpresa(new Empresa("123456785",  "Restaurante", "Zaca Rumi Restaurante2", "Direccion 2","comercial3.peru@pe.g4s.com", "http://www.g46s.com.pe/","LOGO2", "info2222222222222222222222222222222"));
        saveEmpresa(new Empresa("987660634",  "Restaurante", "Daca Rumi Restaurante3", "Direccion 3 ","comercial4.peru@pe.g4s.com", "http://www.g47s.com.pe/","LOGO3", "info33333333"));
        saveEmpresa(new Empresa("987660634",  "Restaurante", "Saca Rumi Restaurante4", "Direccion 4 ","comercial5.peru@pe.g4s.com", "http://www.g48s.com.pe/","LOGO4", "info4444444"));
        saveEmpresa(new Empresa("987660634",  "Restaurante", "Baca Rumi Restaurante5", "Direccion 5 ","comercial6.peru@pe.g4s.com", "http://www.g49s.com.pe/","LOGO5", "info5555555"));
        saveEmpresa(new Empresa("987660634",  "Restaurante", "Waca Rumi Restaurante6", "Direccion 6 ","comercial7.peru@pe.g4s.com", "http://www.g40s.com.pe/","LOGO6", "info6666666"));
        saveEmpresa(new Empresa("987660634",  "Restaurante", "Taca Rumi Restaurante7", "Direccion 7 ","comercial8.peru@pe.g4s.com", "http://www.g41s.com.pe/","LOGO7", "info77777777777777777777"));


    }

    private void saveEmpresa(Empresa empresa) {
        empresas.put(empresa.getId(), empresa);
    }

    public List<Empresa> getEmpresas() {
        return new ArrayList<>(empresas.values());
    }
}
