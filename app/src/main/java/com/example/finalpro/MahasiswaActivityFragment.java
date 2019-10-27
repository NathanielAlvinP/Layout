package com.example.finalpro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class MahasiswaActivityFragment extends Fragment {
    private SQLiteDatabase mDatabase;
    View v;
    private RecyclerView myrecyclerview;
    private EditText nim,nama,email;
    private Button insertButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        final RecyclerViewMahasiswaAdapter recyclerAdapter = new RecyclerViewMahasiswaAdapter(getContext(),getAllItems());
        v = inflater.inflate(R.layout.mahasiswa_activity,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.mahasiswa_recyclerview);

        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        insertButton = (Button) v.findViewById(R.id.InsertButton);

        insertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ContentValues cv = new ContentValues();

                nim = (EditText) v.findViewById(R.id.inputnimmhs);
                nama = (EditText) v.findViewById(R.id.inputnamamhs);
                email = (EditText) v.findViewById(R.id.inputnohpmhs);

                if (nim.getText().toString().trim().length() == 0 &&
                nama.getText().toString().trim().length() == 0 &&
                email.getText().toString().trim().length() == 0){
                    return;
                }

                String NIM = nim.getText().toString();
                String NAMA = nama.getText().toString();
                String EMAIL = email.getText().toString();

                cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_NIM, NIM);
                cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_NAMA,NAMA);
                cv.put(MahasiswaContract.MahasiswaEntry.COLUMN_NO_HP,EMAIL);

                mDatabase.insert(MahasiswaContract.MahasiswaEntry.TABLE_NAME,null,cv);

                recyclerAdapter.swapCursor(getAllItems());

                nim.getText().clear();
                nama.getText().clear();
                email.getText().clear();
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MahasiswaDBHelper dbHelper = new MahasiswaDBHelper(getContext());
        mDatabase = dbHelper.getWritableDatabase();
    }


    public Cursor getAllItems(){
        return mDatabase.query(
                MahasiswaContract.MahasiswaEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
