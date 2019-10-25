package com.example.finalpro;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewMahasiswaAdapter extends RecyclerView.Adapter<RecyclerViewMahasiswaAdapter.MyViewHolder>  {
    Context context;
    //List<Mahasiswa> data;
    Cursor cursor;
    public RecyclerViewMahasiswaAdapter(Context context, Cursor cursor){
        this.context = context;
        this.cursor = cursor;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.mahasiswa_recycler,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMahasiswaAdapter.MyViewHolder holder, int position) {
        if(cursor.move(position)){
            return;
        }
        String NIM = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_NIM));
        String NAMA = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_NAMA));
        String EMAIL = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_EMAIL));

        holder.nim.setText(NIM);
        holder.nama.setText(NAMA);
        holder.email.setText(EMAIL);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nim;
        private TextView nama;
        private TextView email;

        public MyViewHolder(View mahasiswaView){
            super(mahasiswaView);
            nim = (TextView) mahasiswaView.findViewById(R.id.nim);
            nama = (TextView) mahasiswaView.findViewById(R.id.nama);
            email = (TextView) mahasiswaView.findViewById(R.id.emailmahasiswa);

        }
    }
    public void swapCursor(Cursor cursor){
        if(cursor!=null){
            this.cursor.close();
        }
        this.cursor = cursor;

        if(cursor!=null){
            Toast.makeText(context, "Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
