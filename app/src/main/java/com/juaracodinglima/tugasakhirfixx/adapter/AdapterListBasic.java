package com.juaracodinglima.tugasakhirfixx.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracodinglima.tugasakhirfixx.ListActivity;
import com.juaracodinglima.tugasakhirfixx.R;
import com.juaracodinglima.tugasakhirfixx.model.ListModel;
import com.juaracodinglima.tugasakhirfixx.model.Result;

import java.util.List;

public class AdapterListBasic extends RecyclerView.Adapter<RecyclerView.ViewHolder> { //interface

    private List<Result> items;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public AdapterListBasic(ListActivity context, List<Result> results) {
    }

    public void setBiodataList(List<ListModel> biodataList) {
    }

    public interface OnItemClickListener {
        void onItemClick(View view, ListModel obj, int position);
    }

    OnItemClickListener listener;

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterListBasic(Context context, final List<Result> items) {
        this.items = items;
        ctx = context;

//        db = Room.databaseBuilder(context.getApplicationContext(),
//        AppDatabase.class, "biodata_db").allowMainThreadQueries().build();
       // mOnItemClickListener=(ListModel)context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView txtNama;
        public TextView txtHarga;
        public TextView txtStok;
        public TextView txtUrl;
        public TextView txtRating;
        public CardView parentLayout;


        public OriginalViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.imgPhoto);
            txtNama = v.findViewById(R.id.txtNama);
            txtHarga = v.findViewById(R.id.txtHarga);
            txtStok = v.findViewById(R.id.txtStok);
            txtUrl = v.findViewById(R.id.txtUrl);
            txtRating = v.findViewById(R.id.txtRating);
            parentLayout = v.findViewById(R.id.parentLayout);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        vh = new OriginalViewHolder(v); //ngambil dari layout listitem
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
//            mDatabase= FirebaseDatabase.getInstance().getReference();
            OriginalViewHolder view = (OriginalViewHolder) holder;

            final Result data = items.get(position);
            view.txtNama.setText(data.getNameProduk());
            view.txtHarga.setText(data.getHarga());
            view.txtStok.setText(data.getStok());
            view.txtUrl.setText(data.getUrl());
            view.txtRating.setText(data.getRating());

        }
        }

    @Override
    public int getItemCount() {
        return 0;
    }
}