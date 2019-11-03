package com.example.finalpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<Film> data;
    public RecyclerViewAdapter(Context context,List<Film> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.film_recycler,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.judul.setText((data.get(position).getJudul()));
        holder.sutradara.setText(data.get(position).getSutradara());
        holder.poster.setImageResource(data.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView judul;
        private TextView sutradara;
        private ImageView poster;

        public MyViewHolder(View filmView){
            super(filmView);
            judul = (TextView) filmView.findViewById(R.id.film_judul);
            sutradara = (TextView) filmView.findViewById(R.id.film_sutradara);
            poster = (ImageView) filmView.findViewById(R.id.film_gambar);

        }
    }
}
