package com.example.finalpro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class RecyclerViewMatkulAdapter extends RecyclerView.Adapter<RecyclerViewMatkulAdapter.MatkulHolder> {
    private List<Matakuliah> matkul;
    private FirebaseFirestore db;
    public RecyclerViewMatkulAdapter(List<Matakuliah> matkul) {
        this.matkul = matkul;
    }


    @NonNull
    @Override
    public MatkulHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.datamatakuliah_recycler,parent,false);
        db = FirebaseFirestore.getInstance();
        return new MatkulHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatkulHolder holder, int position) {
        holder.namaMatkul.setText(matkul.get(position).getNamaMatakuliah());
        holder.sks.setText("Sks: "+Integer.toString(matkul.get(position).getSks()));
        holder.namaDosen.setText("Dosen: "+matkul.get(position).getNamaDosen());
    }

    @Override
    public int getItemCount() {
        return matkul.size();
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
