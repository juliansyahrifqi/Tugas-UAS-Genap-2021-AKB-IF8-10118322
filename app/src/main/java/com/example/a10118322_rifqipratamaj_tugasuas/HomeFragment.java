package com.example.a10118322_rifqipratamaj_tugasuas;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HomeFragment extends Fragment {

    private List<Pariwisata> pariwisataList;
    private PariwisataAdapter pariwisataAdapter;
    private RecyclerView rv_pariwisata;
    DatabaseReference database;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rv_pariwisata = (RecyclerView) view.findViewById(R.id.rv_pariwisata);

        read();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_pariwisata.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        read();
    }

    private void read() {
        pariwisataList = new ArrayList<>();

        database = FirebaseDatabase.getInstance("https://akb-travelahka-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Pariwisata");

        System.out.println("test: " + database);

        pariwisataAdapter = new PariwisataAdapter(pariwisataList);
        rv_pariwisata.setAdapter(pariwisataAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    try {
                        Pariwisata pariwisata = dataSnapshot.getValue(Pariwisata.class);
                        pariwisataList.add(pariwisata);
                        System.out.println(pariwisata);
                    } catch(Exception error) {
                        System.out.println("error" + error);
                    }
                }
                pariwisataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}
