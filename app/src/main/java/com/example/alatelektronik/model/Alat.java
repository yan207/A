package com.example.alatelektronik.model;



public class Alat {
    private String jenis;
    private String nama;
    private String harga;
    private String deskripsi;
    private int drawableRes;

    public Alat(String jenis, String nama, String harga, String deskripsi, int drawableRes) {
        this.jenis= jenis;
        this.nama= nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.drawableRes = drawableRes;
    }
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }

    public String getHarga() { return harga; }

    public void setHarga(String harga) { this.harga= harga; }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}