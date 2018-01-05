package com.adino.mta.member;

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
import com.adino.mta.models.Member;

import java.util.ArrayList;

/**
 * Created by afadinsro on 12/27/17.
 */

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {
    private ArrayList<Member> members;
    private Context context;
    public MemberAdapter(ArrayList<Member> members, Context context) {
        this.context = context;
        this.members = members;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        return new MemberViewHolder(view, members, context);
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
    public static class MemberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView cv_member;
        private ImageView img_member_pic;
        private TextView txt_member_name;
        private TextView txt_member_ministry;
        private ArrayList<Member> members;
        private Context context;

        public MemberViewHolder(View itemView, ArrayList<Member> members, Context context) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            this.members = members;
            cv_member = (CardView)itemView.findViewById(R.id.cv_member);
            img_member_pic = (ImageView)itemView.findViewById(R.id.img_member_pic);
            txt_member_name = (TextView)itemView.findViewById(R.id.txt_member_name);
            txt_member_ministry = (TextView)itemView.findViewById(R.id.txt_member_ministry);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Member selectedMember = this.members.get(position);
            Intent memberInfo = new Intent(this.context, MemberInfoActivity.class);
            memberInfo.putExtra("name", selectedMember.getName());
            memberInfo.putExtra("ministry", selectedMember.getMinistry().toString());
            this.context.startActivity(memberInfo);
        }
    }

}
