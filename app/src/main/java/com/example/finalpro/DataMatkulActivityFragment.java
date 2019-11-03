package com.example.finalpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.Clock;
import java.util.ArrayList;

public class DataMatkulActivityFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private EditText namaMatkul,sks,namaDosen;
    private Button insertButton;

    private FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();

    private RecyclerViewMatkulAdapter adapter;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        v = inflater.inflate(R.layout.datamatakuliah_activity,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.matakuliah_recyclerview);

        namaMatkul = v.findViewById(R.id.inputmatkul);
        sks = v.findViewById(R.id.inputsks);
        namaDosen = v.findViewById(R.id.inputdosen);

        final ArrayList<Matakuliah> matkul = new ArrayList();
        Task<QuerySnapshot> docRef = firestoreDB.collection("DaftarMatakuliah").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>(){
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot doc : task.getResult()){
                                    Matakuliah mtk = new Matakuliah();
                                    mtk.setNamaMatakuliah(doc.get("namaMatakuliah").toString());
                                    mtk.setSks(((Long) doc.get("sks")).intValue());
                                    mtk.setNamaDosen(doc.get("namaDosen").toString());
                                    matkul.add(mtk);
                                }
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                                adapter = new RecyclerViewMatkulAdapter(matkul);
                                recyclerView.setAdapter(adapter);
                            }else{
                                System.out.println("gagal");
                            }
                        }
                });
        insertButton = v.findViewById(R.id.insertMatkul);
        insertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(namaMatkul.getText().toString().isEmpty()){
                    namaMatkul.setError("Masukan nama mata kuliah");
                    namaMatkul.requestFocus();
                }else if(sks.getText().toString().isEmpty()){
                    sks.setError("Masukan jumlah sks");
                    sks.requestFocus();
                }else if(namaDosen.getText().toString().isEmpty()){
                    namaDosen.setError("Masukan Dosen Pengampu");
                    namaDosen.requestFocus();
                }else{
                    tambahMatakuliah();
                }
            }
        });
        return v;
    }
    public void tambahMatakuliah(){
        namaMatkul = v.findViewById(R.id.inputmatkul);
        sks = v.findViewById(R.id.inputsks);
        namaDosen = v.findViewById(R.id.inputdosen);
        Matakuliah matkul = new Matakuliah(namaMatkul.getText().toString(),Integer.parseInt(sks.getText().toString()), namaDosen.getText().toString());
        firestoreDB.collection("DaftarMatakuliah").document().set(matkul).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                namaMatkul.getText().clear();
                sks.getText().clear();
                namaDosen.getText().clear();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                namaMatkul.setError("GAGAL UPLOAD");
            }
        });
    }

}
