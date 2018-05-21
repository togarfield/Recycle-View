package com.example.togar.androidpemulasubmission;

/*
 * Created by Togar on 2/8/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewTeam extends RecyclerView.Adapter<CardViewTeam.CardViewViewHolder>{
    private ArrayList<Esport>listEsport;
    private Context context;

    CardViewTeam(Context context) { this.context = context;}

    private ArrayList<Esport> getListEsport() { return listEsport;}

    void setListEsport(ArrayList<Esport> listEsport) {
        this.listEsport = listEsport;
    }
    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        Esport e = getListEsport().get(position);

        Glide.with(context)
                .load(e.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(e.getName());
        holder.tvRemakrs.setText(e.getRemarks());

        holder.btnDetail.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Intent moveCard = new Intent(context, DetailActivity.class);
                moveCard.putExtra(DetailActivity.EXTRA_NAME, getListEsport().get(position).getName());
                moveCard.putExtra(DetailActivity.EXTRA_MARKS, getListEsport().get(position).getRemarks());
                moveCard.putExtra(DetailActivity.EXTRA_PHOTO, getListEsport().get(position).getPhoto());
                context.startActivity(moveCard);

            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListEsport().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemakrs;
        Button btnShare, btnDetail;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto    = itemView.findViewById(R.id.img_item_photo);
            tvName      = itemView.findViewById(R.id.tv_item_name);
            tvRemakrs   = itemView.findViewById(R.id.tv_item_remarks);
            btnShare    = itemView.findViewById(R.id.btn_set_share);
            btnDetail   = itemView.findViewById(R.id.btn_set_detail);
        }
    }

    private static class CustomOnItemClickListener implements View.OnClickListener {
        private int position;
        private OnItemClickCallback onItemClickCallback;
        CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
            this.position = position;
            this.onItemClickCallback = onItemClickCallback;
        }

        @Override
        public void onClick(View view) {
            onItemClickCallback.onItemClicked(view, position);
        }
        public interface OnItemClickCallback {
            void onItemClicked(View view, int position);
        }

    }
}
