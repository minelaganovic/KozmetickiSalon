package com.example.kozmetickisalon.AppAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kozmetickisalon.R;
import com.example.kozmetickisalon.model.KozmetickiProzivod;

import java.util.List;

public class appadapter extends RecyclerView.Adapter<appadapter.ViewHolder> {

    private List<KozmetickiProzivod> kozmetickis;

    public appadapter(List<KozmetickiProzivod> kozmetickis) {
        this.kozmetickis = kozmetickis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kproizvod, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KozmetickiProzivod kozmeticki = kozmetickis.get(position);

        // Set data to views
        holder.imageViewProduct.setImageResource(R.drawable.slika1);
        holder.textviewId.setText("Product ID: " + String.valueOf(kozmeticki.getId()));
        holder.textviewNaziv.setText("Product Name: " + kozmeticki.getNaziv());
        holder.textviewDetalji.setText("Product Details: " + kozmeticki.getDetalji());
        holder.textviewCena.setText("Product Price: " + String.valueOf(kozmeticki.getCena()));
        Log.d("Adapter", "onBindViewHolder called for position: " + position);
    }


    @Override
    public int getItemCount() {
        return kozmetickis.size();
    }

    public void updateData(List<KozmetickiProzivod> newData) {
        kozmetickis.clear();
        kozmetickis.addAll(newData);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textviewId;
        TextView textviewNaziv;
        TextView textviewDetalji;
        TextView textviewCena;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textviewId = itemView.findViewById(R.id.textViewId);
            textviewNaziv = itemView.findViewById(R.id.textViewNaziv);
            textviewDetalji = itemView.findViewById(R.id.textViewDetalji);
            textviewCena = itemView.findViewById(R.id.textViewCena);
        }
    }
}
