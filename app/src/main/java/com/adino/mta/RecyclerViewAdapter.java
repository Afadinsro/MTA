package com.adino.mta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adino.mta.bacenta.BacentasActivity;
import com.adino.mta.glide.GlideApp;
import com.adino.mta.member.MemberInfoActivity;
import com.adino.mta.member.MembersActivity;
import com.adino.mta.models.Flame;
import com.adino.mta.models.Member;
import com.adino.mta.town.TownCentersActivity;
import com.adino.mta.uncles_aunties.HighSchoolsActivity;
import com.adino.mta.uni.UniCentersActivity;

import java.util.ArrayList;

import static com.adino.mta.util.Constants.IMAGE_HEIGHT_PIXELS;
import static com.adino.mta.util.Constants.IMAGE_WIDTH_PIXELS;

/**
 * Created by afadinsro on 1/5/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private ArrayList<Object> objects;
    private Context context;
    private View view;

    private static final String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter(ArrayList<Object> objects, Context context) {
        this.context = context;
        this.objects = objects;
    }
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        objects = new ArrayList<>();
    }

    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Check the activity for this context and create view holder
        if (context.getClass() == MainActivity.class){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flame, parent, false);
        }else if(this.context.getClass() == MembersActivity.class) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_member, parent, false);
        }else if(this.context.getClass() == UniCentersActivity.class ||
                this.context.getClass() == TownCentersActivity.class) {

        }else if(this.context.getClass() == BacentasActivity.class) {

        }


        Log.d(TAG, "onCreateViewHolder: ViewHolder created");
        return new RecyclerViewAdapter.CustomViewHolder(view, objects, context);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.CustomViewHolder holder, int position) {

        // Check the activity for this context and bind view holder
        if (context.getClass() == MainActivity.class){
            onBindFlame(holder, position);
        }else if(this.context.getClass() == MembersActivity.class) {
            onBindMember(holder, position);
        }else if(this.context.getClass() == UniCentersActivity.class ||
                this.context.getClass() == TownCentersActivity.class) {

        }else if(this.context.getClass() == BacentasActivity.class) {

        }

        Log.d(TAG, "onBindViewHolder: ViewHolder bound");
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /************************** CUSTOM METHODS ****************************/

    /********** HELPER METHODS TO BIND VIEWS ************/
    public void onBindFlame(RecyclerViewAdapter.CustomViewHolder holder, int position){
        holder.txt_flame_name.setText(((Flame)objects.get(position)).getName());
        String num_branches = "" + ((Flame)objects.get(position)).getNumBranches();
        holder.txt_flame_num_branches.setText(num_branches);
        GlideApp.with(context)
                .load(((Flame)objects.get(position)).getImgUrl())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS)
                .into(holder.img_flame_pic);
        Log.d(TAG, "onBindFlame: flame bound");
    }

    private void onBindMember(RecyclerViewAdapter.CustomViewHolder holder, int position){
        String name = ((Member)objects.get(position)).getName();
        holder.txt_member_name.setText(name);
        String ministry = ((Member)objects.get(position)).getMinistry().toString();
        holder.txt_member_ministry.setText(ministry);
        GlideApp.with(context)
                .load(((Member)objects.get(position)).getImgUrl())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS)
                .into(holder.img_member_pic);
        Log.d(TAG, "onBindMember: member bound");
    }

    private void onBindCenter(RecyclerViewAdapter.CustomViewHolder holder, int position){

    }

    private void onBindBacenta(RecyclerViewAdapter.CustomViewHolder holder, int position){

    }

    public void addFlame(Flame flame){
        Log.d(TAG, "addFlame: " + flame);
        this.objects.add(flame);
    }



    /************************** CUSTOM VIEWHOLDER CLASS ****************************/
    public static class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * General
         */
        private ArrayList<Object> objects;
        private Context context;
        /**
         * For Flames (MainActivity)
         */
        private CardView cv_flame;
        private ImageView img_flame_pic;
        private TextView txt_flame_name;
        private TextView txt_flame_num_branches;

        /**
         * For Members
         */
        private CardView cv_member;
        private ImageView img_member_pic;
        private TextView txt_member_name;
        private TextView txt_member_ministry;


        public CustomViewHolder(View itemView, ArrayList<Object> objects, Context context) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            this.objects = objects;
            // Check the activity for this context and instantiate views
            if (context.getClass() == MainActivity.class){
                setMainActivityViews();
            }else if(this.context.getClass() == MembersActivity.class) {
                setMembersActivityViews();
            }else if(this.context.getClass() == UniCentersActivity.class ||
                    this.context.getClass() == TownCentersActivity.class) {
                setCentersActivityViews();
            }else if(this.context.getClass() == BacentasActivity.class) {

            }

        }

        @Override
        public void onClick(View v) {
            // Check the activity for this context and call appropriate function
            if (context.getClass() == MainActivity.class){
                fromMainActivity();
            }else if(this.context.getClass() == MembersActivity.class) {
                fromMembersActivity();
            }else if(this.context.getClass() == UniCentersActivity.class ||
                    this.context.getClass() == TownCentersActivity.class) {
                fromCentersActivity();
            }else if(this.context.getClass() == BacentasActivity.class) {


                fromBacentasActivity();
            }

        }

        /********** HELPER METHODS TO NAVIGATE TO RIGHT ACTIVITY ************/
        private void fromMainActivity(){
            Flame selectedFlame = (Flame)this.objects.get(getAdapterPosition());
            Intent flameInfo = null;
            switch (selectedFlame.getName()) {
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
            if (flameInfo != null) {
                flameInfo.putExtra("name", selectedFlame.getName());
                flameInfo.putExtra("num_branches", selectedFlame.getNumBranches());
                this.context.startActivity(flameInfo);
            }
        }

        private void fromMembersActivity(){
            Member selectedMember = (Member) this.objects.get(getAdapterPosition());
            Intent toMemberInfoActivity = new Intent(this.context, MemberInfoActivity.class);
            toMemberInfoActivity.putExtra("name", selectedMember.getName());
            toMemberInfoActivity.putExtra("ministry", selectedMember.getMinistry().toString());
            this.context.startActivity(toMemberInfoActivity);
        }

        private void fromCentersActivity(){

        }

        private void fromBacentasActivity(){

        }

        /********** HELPER METHODS TO SET VIEWS UP ************/
        private void setMainActivityViews(){
            cv_flame = (CardView)itemView.findViewById(R.id.cv_flame);
            img_flame_pic = (ImageView)itemView.findViewById(R.id.img_flame_pic);
            txt_flame_name = (TextView)itemView.findViewById(R.id.txt_flame_name);
            txt_flame_num_branches = (TextView)itemView.findViewById(R.id.txt_flame_num_branches);
        }

        private void setMembersActivityViews(){
            cv_member = (CardView)itemView.findViewById(R.id.cv_member);
            img_member_pic = (ImageView)itemView.findViewById(R.id.img_member_pic);
            txt_member_name = (TextView)itemView.findViewById(R.id.txt_member_name);
            txt_member_ministry = (TextView)itemView.findViewById(R.id.txt_member_ministry);
        }

        private void setCentersActivityViews(){

        }

        private void setBacentasActivityViews(){

        }

    }
}
