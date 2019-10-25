package com.example.finalpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaActivityFragment extends Fragment {
    private SQLiteDatabase mDatabase;
    private WifiManager wifiManager;
    View v;
    private RecyclerView myrecyclerview;
    private List<Mahasiswa> listMahasiswa;
    private EditText    nim,nama,email;
    private Button insertButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        v = inflater.inflate(R.layout.mahasiswa_activity,container,false);

        insertButton = (Button) v.findViewById(R.id.InsertButton);
        nim = (EditText) v.findViewById(R.id.inputnimmhs);
        nama = (EditText) v.findViewById(R.id.inputnamamhs);
        email = (EditText) v.findViewById(R.id.inputemailmhs);

        insertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String NIM = nim.getText().toString();
                String NAMA = nama.getText().toString();
                String EMAIL = email.getText().toString();
                addItem(NIM,NAMA,EMAIL);
            }
        });

        myrecyclerview = (RecyclerView) v.findViewById(R.id.mahasiswa_recyclerview);
        RecyclerViewMahasiswaAdapter recyclerAdapter = new RecyclerViewMahasiswaAdapter(getContext(),getAllItems());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MahasiswaDBHelper dbHelper = new MahasiswaDBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();
    }
    private void addItem(String NIM, String NAMA, String EMAIL){
        ContentValues cv = new ContentValues();
        cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_NIM, NIM);
        cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_NAMA,NAMA);
        cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_EMAIL,EMAIL);

        mDatabase.insert(MahasiswaContract.MahasiswaEntry.TABLE_NAME,null,cv);

        nim.getText().clear();
        nama.getText().clear();
        email.getText().clear();
    }

    public Cursor getAllItems(){
        return mDatabase.query(
                MahasiswaContract.MahasiswaEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                MahasiswaContract.MahasiswaEntry.COLUMN_NIM + " ASC"
        );
    }
}
