package com.example.finalpro;

import android.provider.BaseColumns;

public class MahasiswaContract {
    public MahasiswaContract(){}

    public static final class MahasiswaEntry implements BaseColumns{
        public static final String TABLE_NAME = "Mahasiswa";
        public static final String COLUMN_NIM = "nim";
        public static final String COLUMN_NAMA = "nama";
        public static final String COLUMN_NO_HP = "nohp";
    }
}
