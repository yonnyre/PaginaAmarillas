package com.example.yonny.paginasamarillas;

import java.util.UUID;

/**
 * Created by Yonny on 25/09/2017.
 */

public class Empresa {


    String id,telefono,rubro,nombre,direccion,correo,url,logo,info;

    public Empresa() {
        super();
    }

    public Empresa(String telefono, String rubro, String nombre, String direccion, String correo, String url, String logo, String info) {
        id = UUID.randomUUID().toString();
        this.telefono = telefono;
        this.rubro = rubro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.url = url;
        this.logo = logo;
        this.info = info;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", telefono=" + telefono +
                ", rubro='" + rubro + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
