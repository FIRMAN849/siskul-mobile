package com.example.siekstrakurikuler;

public class ModelDaftar {
    private String nama;
    private String kelas;
    private String alamat;
    private String ekskul;
    private String alasan;
    private String key;

    public ModelDaftar(){

    }

    public ModelDaftar(String nama, String kelas, String alamat, String ekskul, String alasan) {
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
        this.ekskul = ekskul;
        this.alasan = alasan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEkskul() {
        return ekskul;
    }

    public void setEkskul(String ekskul) {
        this.ekskul = ekskul;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
