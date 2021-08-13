package com.example.a10118322_rifqipratamaj_tugasuas;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PariwisataAdapter extends RecyclerView.Adapter {

    private List<Pariwisata> pariwisataList;

    public PariwisataAdapter(List<Pariwisata> pariwisataList) {
        this.pariwisataList = pariwisataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        return new PariwisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pariwisata pariwisata = pariwisataList.get(position);

        ((PariwisataViewHolder) holder).bindView(pariwisata);
    }

    @Override
    public int getItemCount() {
        return pariwisataList.size();
    }

    private class PariwisataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_nama;
        private TextView tv_alamat;
        private TextView tv_no_tlp;
        private TextView tv_keterangan;

        public PariwisataViewHolder(View itemView) {
            super(itemView);

            tv_nama = (TextView) itemView.findViewById(R.id.tv_nama);
            tv_alamat = (TextView) itemView.findViewById(R.id.tv_alamat);
            tv_no_tlp = (TextView) itemView.findViewById(R.id.tv_no_tlp);
            tv_keterangan = (TextView) itemView.findViewById(R.id.tv_keterangan);

            itemView.setOnClickListener(this);
        }

        public void bindView(Pariwisata pariwisata) {
            tv_nama.setText(pariwisata.getNama());
            tv_alamat.setText(pariwisata.getAlamat());
            tv_no_tlp.setText(pariwisata.getNo_tlp());
            tv_keterangan.setText(pariwisata.getKeterangan());
        }

        @Override
        public void onClick(View v) {
            System.out.println(tv_nama.getText());
        }
    }
}