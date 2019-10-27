package com.example.finalpro;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewMahasiswaAdapter extends RecyclerView.Adapter<RecyclerViewMahasiswaAdapter.MyViewHolder>  {
    Context context;
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(!cursor.moveToPosition(position)){
            return;
        }
        holder.NIM_MHS.setText(cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_NIM)));
        holder.NAMA_MHS.setText(cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_NAMA)));
        holder.NOHP_MHS.setText(cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.COLUMN_NO_HP)));
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView NIM_MHS;
        private TextView NAMA_MHS;
        private TextView NOHP_MHS;

        public MyViewHolder(View mahasiswaView){
            super(mahasiswaView);
            NIM_MHS = (TextView) mahasiswaView.findViewById(R.id.nimmahasiswa);
            NAMA_MHS = (TextView) mahasiswaView.findViewById(R.id.namamahasiswa);
            NOHP_MHS = (TextView) mahasiswaView.findViewById(R.id.nohpmahasiswa);

        }
    }
    public void swapCursor(Cursor cursor){
        if(this.cursor!=null){
            this.cursor.close();
        }
        this.cursor = cursor;

        if(cursor!=null){
            notifyDataSetChanged();
        }
    }
}
