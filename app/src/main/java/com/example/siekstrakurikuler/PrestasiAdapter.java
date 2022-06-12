package com.example.siekstrakurikuler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PrestasiAdapter extends RecyclerView.Adapter<PrestasiAdapter.ListViewHolder>{
    private ArrayList<Prestasi> listPrestasi;


    public PrestasiAdapter(ArrayList<Prestasi> list){
        this.listPrestasi = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prestasi,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Prestasi prestasi = listPrestasi.get(position);
        Glide.with(holder.itemView.getContext())
                .load(prestasi.getPhoto())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgPhoto);
        holder.titlePrestasi.setText(prestasi.getName());
        holder.deskPrestasi.setText(prestasi.getDesk());
    }

    @Override
    public int getItemCount() {
        return listPrestasi.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView titlePrestasi, deskPrestasi;

        ListViewHolder(View itemview){
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_card);
            titlePrestasi = itemview.findViewById(R.id.titleCard);
            deskPrestasi = itemview.findViewById(R.id.deskCard);
        }

    }
}
