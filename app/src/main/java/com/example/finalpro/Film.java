package com.example.finalpro;

public class Film {
    private String judul;
    private String sutradara;
    private int Photo;
    public Film(){
    }
    public Film(String jdl, String stdr, int photo){
        judul = jdl;
        sutradara = stdr;
        Photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public String getSutradara() {
        return sutradara;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
