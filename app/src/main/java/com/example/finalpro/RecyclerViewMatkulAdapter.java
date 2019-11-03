package com.example.finalpro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
public class RecyclerViewMatkulAdapter extends FirestoreRecyclerAdapter<Matakuliah, RecyclerViewMatkulAdapter.MatkulHolder> {

    public RecyclerViewMatkulAdapter(@NonNull FirestoreRecyclerOptions<Matakuliah> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MatkulHolder matkulHolder, int i, @NonNull Matakuliah matakuliah) {
            matkulHolder.namaMatkul.setText(matakuliah.getNamaMatakuliah());
            matkulHolder.sks.setText(String.valueOf(matakuliah.getSks()));
            matkulHolder.namaDosen.setText(matakuliah.getNamaDosen());
    }

    @NonNull
    @Override
    public MatkulHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.datamatakuliah_activity,parent,false);
        return new MatkulHolder(v);
    }

    class MatkulHolder extends RecyclerView.ViewHolder{
        TextView namaMatkul;
        TextView sks;
        TextView namaDosen;
        public MatkulHolder(View v){
            super(v);
            namaMatkul = v.findViewById(R.id.namaMatkul);
            sks = v.findViewById(R.id.sksMatkul);
            namaDosen = v.findViewById(R.id.dosenMatkul);
        }

    }

}
