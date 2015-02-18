package com.example.benet.restaurantapp.model;

import java.io.Serializable;

/**
 * Created by Benet on 17/02/15.
 */
public class Restaurant implements Serializable {

    private String name;
    private String zona;
    private String ciudad;
    private String web;
    private int img;

    public Restaurant(String name, String zona, String ciudad, String web, int img){

        setName(name);
        setZona(zona);
        setCiudad(ciudad);
        setWeb(web);
        setImg(img);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
