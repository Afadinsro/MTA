package com.adino.mta.member;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adino.mta.R;

import java.util.ArrayList;

/**
 * Created by afadinsro on 12/27/17.
 */

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {
    private ArrayList<Member> members;
    public MemberAdapter(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
        holder.txt_member_name.setText(members.get(position).getName());
        holder.txt_member_ministry.setText(members.get(position).getMinistry().toString());
        holder.img_member_pic.setImageResource(R.drawable.ic_person);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /************************** CUSTOM VIEWHOLDER CLASS ****************************/
    public static class MemberViewHolder extends RecyclerView.ViewHolder {
        private CardView cv_member;
        private ImageView img_member_pic;
        private TextView txt_member_name;
        private TextView txt_member_ministry;

        public MemberViewHolder(View itemView) {
            super(itemView);
            cv_member = (CardView)itemView.findViewById(R.id.cv_member);
            img_member_pic = (ImageView)itemView.findViewById(R.id.img_member_pic);
            txt_member_name = (TextView)itemView.findViewById(R.id.txt_member_name);
            txt_member_ministry = (TextView)itemView.findViewById(R.id.txt_member_ministry);
        }
    }

}
