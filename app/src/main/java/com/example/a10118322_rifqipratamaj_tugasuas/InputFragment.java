package com.example.a10118322_rifqipratamaj_tugasuas;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InputFragment extends Fragment {

//    private CatatanInterface catatanInterface;
    private EditText et_title, et_description, et_kategori;
    private Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        et_title = view.findViewById(R.id.et_title);
        et_description = view.findViewById(R.id.et_description);
        et_kategori = view.findViewById(R.id.et_kategori);

        Button btn_simpan = view.findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                create();
            }
        });
        return view;
    }

    //private void create() {
//        catatanInterface = new CatatanImp(getActivity().getApplicationContext());
//
//        Catatan catatan = new Catatan(
//                randomGeneratorId(),
//                getCurrentDate(),
//                et_title.getText().toString(),
//                et_description.getText().toString(),
//                et_kategori.getText().toString()
//        );
//
//        if(catatanInterface.create(catatan)) {
//            Toast.makeText(getActivity().getApplicationContext(),"Berhasil Disimpan",Toast.LENGTH_SHORT).show();
//            et_title.setText("");
//            et_kategori.setText("");
//            et_description.setText("");
//        } else {
//            Toast.makeText(getActivity().getApplicationContext(), "Gagal Disimpan", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private static String randomGeneratorId() {
//        byte[] array = new byte[5];
//        new Random().nextBytes(array);
//        return new String(array, Charset.forName("UTF-8"));
//    }
//
//    private String getCurrentDate() {
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
//        Date date = new Date();
//
//        return dateFormat.format(date);
//    }
}