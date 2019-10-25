package com.example.finalpro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.finalpro.MahasiswaContract.*;
import androidx.annotation.Nullable;

public class MahasiswaDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mhs.db";
    public static final int DATABASE_VERSION = 1;

    public MahasiswaDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MAHASISWA_TABLE = "create table "+MahasiswaEntry.TABLE_NAME+"("
                +MahasiswaEntry.COLUMN_NIM+" char(8) not null primary key, "
                +MahasiswaEntry.COLUMN_NAMA+" TEXT not null, "
                +MahasiswaEntry.COLUMN_EMAIL+" TEXT not null" + ");";
        db.execSQL(SQL_CREATE_MAHASISWA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
