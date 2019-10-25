package com.example.finalpro;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivityFragment extends Fragment {
    private WifiManager wifiManager;
    View v;
    private RecyclerView myrecyclerview;
    private List<Film> listFilm;
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        v = inflater.inflate(R.layout.home_activity_fragment,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.film_recycleview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),listFilm);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listFilm = new ArrayList<>();
        listFilm.add(new Film("Phantom Blood","Hirohiko Araki",R.drawable.jjba1));
        listFilm.add(new Film("Battle Tendency","Hirohiko Araki",R.drawable.jjba2));
        listFilm.add(new Film("Stardust Crusaders","Hirohiko Araki",R.drawable.jjba3));
        listFilm.add(new Film("Diamond is Unbreakable","Hirohiko Araki",R.drawable.jjba4));
        listFilm.add(new Film("Golden Wind","Hirohiko Araki",R.drawable.jjba5));
        listFilm.add(new Film("Avengers: Infinity War","Marvel Studios",R.drawable.infinity));
        listFilm.add(new Film("Avengers: Endgame","Marvel Studios",R.drawable.endgame));
        listFilm.add(new Film("Spider-Man: Homecoming","Marvel Studios",R.drawable.homecoming));
    }
}
