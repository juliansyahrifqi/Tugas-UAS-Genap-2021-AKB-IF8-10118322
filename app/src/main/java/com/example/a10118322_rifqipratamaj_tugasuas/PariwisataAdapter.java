// NIM : 10118322
// Nama: Rifqi Pratama Juliansyah
// Kelas: IF-8
// Tanggal Pengerjaan: 11 Agustus 2021

package com.example.a10118322_rifqipratamaj_tugasuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PariwisataAdapter extends RecyclerView.Adapter {

    private List<Pariwisata> pariwisataList;
    Context mContext;

    public PariwisataAdapter(List<Pariwisata> pariwisataList, Context context) {
        this.pariwisataList = pariwisataList;
        mContext = context;
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

        Glide.with(mContext).load(pariwisata.getImageUrl()).into(((PariwisataViewHolder) holder).iv_image);
    }

    @Override
    public int getItemCount() {
        return pariwisataList.size();
    }

    private class PariwisataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView iv_image;
        private TextView tv_nama;
        private TextView tv_alamat;
        private TextView tv_no_tlp;
        private TextView tv_keterangan;

        public PariwisataViewHolder(View itemView) {
            super(itemView);

            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
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
