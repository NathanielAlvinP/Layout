package com.example.finalpro;

public class Matakuliah {
    private String namadosen;
    private String namamatakuliah;
    private int sks;


    public String getNamaMatakuliah() {
        return namamatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namamatakuliah = namaMatakuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public String getNamaDosen() {
        return namadosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namadosen = namaDosen;
    }


    public Matakuliah(){
    }
    public Matakuliah(String namaMatakuliah, int sks, String namaDosen){
        this.namamatakuliah = namaMatakuliah;
        this.sks = sks;
        this.namadosen = namaDosen;
    }

}
