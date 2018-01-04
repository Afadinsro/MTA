package com.adino.mta.flame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adino.mta.R;
import com.adino.mta.glide.GlideApp;
import com.adino.mta.town.TownCentersActivity;
import com.adino.mta.uncles_aunties.HighSchoolsActivity;
import com.adino.mta.uni.UniCentersActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by afadinsro on 12/27/17.
 */

public class FlameAdapter extends RecyclerView.Adapter<FlameAdapter.FlameViewHolder> {
    private ArrayList<Flame> flames;
    private Context context;
    private static final String TAG = "FlameAdapter";

    public FlameAdapter(ArrayList<Flame> flames, Context context) {
        this.context = context;
        this.flames = flames;
    }

    @Override
    public FlameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flame, parent, false);
        return new FlameViewHolder(view, flames, context);
    }

    @Override
    public void onBindViewHolder(FlameViewHolder holder, int position) {
        holder.txt_flame_name.setText(flames.get(position).getName());
        //holder.txt_flame_num_branches.setText(flames.get(position).getNumBranches());
        GlideApp.with(context)
                .load("")
                .into(holder.img_flame_pic);
    }

    @Override
    public int getItemCount() {
        return flames.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /************************** CUSTOM VIEWHOLDER CLASS ****************************/
    public static class FlameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cv_flame;
        private ImageView img_flame_pic;
        private TextView txt_flame_name;
        private TextView txt_flame_num_branches;
        private ArrayList<Flame> flames;
        private Context context;

        public FlameViewHolder(View itemView, ArrayList<Flame> flames, Context context) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            this.flames = flames;
            cv_flame = (CardView)itemView.findViewById(R.id.cv_flame);
            img_flame_pic = (ImageView)itemView.findViewById(R.id.img_flame_pic);
            txt_flame_name = (TextView)itemView.findViewById(R.id.txt_flame_name);
            txt_flame_num_branches = (TextView)itemView.findViewById(R.id.txt_flame_num_branches);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Flame selectedFlame = this.flames.get(position);
            Intent flameInfo = null;
            switch (selectedFlame.getName()){
                case "University Centers":
                    flameInfo = new Intent(this.context, UniCentersActivity.class);
                    break;
                case "Town Centers":
                    flameInfo = new Intent(this.context, TownCentersActivity.class);
                    break;
                case "Uncles & Aunties":
                    flameInfo = new Intent(this.context, HighSchoolsActivity.class);
                    break;
            }
            if(flameInfo != null) {
                flameInfo.putExtra("name", selectedFlame.getName());
                flameInfo.putExtra("num_branches", selectedFlame.getNumBranches());
                this.context.startActivity(flameInfo);
            }
        }
    }

}
