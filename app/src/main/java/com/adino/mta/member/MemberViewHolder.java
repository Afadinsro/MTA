package com.adino.mta.member;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adino.mta.R;
import com.adino.mta.glide.GlideApp;
import com.adino.mta.models.Flame;
import com.adino.mta.models.Member;
import com.adino.mta.town.TownCentersActivity;
import com.adino.mta.uncles_aunties.HighSchoolsActivity;
import com.adino.mta.uni.UniCentersActivity;

import java.util.ArrayList;

import static com.adino.mta.util.Constants.IMAGE_HEIGHT_PIXELS;
import static com.adino.mta.util.Constants.IMAGE_WIDTH_PIXELS;

/**
 * Created by afadinsro on 1/9/18.
 */

public class MemberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * For Members
     */
    private CardView cvMember;
    private ImageView imgMemberPic;
    private TextView txtMemberName;
    private TextView txtMemberMinistry;

    private Context context;
    private ArrayList<Member> members;
    private static final String TAG = "FlameViewHolder";


    public MemberViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        cvMember = (CardView)itemView.findViewById(R.id.cv_member);
        imgMemberPic = (ImageView)itemView.findViewById(R.id.img_member_pic);
        txtMemberName = (TextView)itemView.findViewById(R.id.txt_member_name);
        txtMemberMinistry = (TextView)itemView.findViewById(R.id.txt_member_ministry);
        setContext(context);
        members = new ArrayList<>();
    }

    public ImageView getImgMemberPic() {
        return imgMemberPic;
    }

    public TextView getTxtMemberName() {
        return txtMemberName;
    }

    public TextView getTxtMemberMinistry() {
        return txtMemberMinistry;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void addMember(Member member){
        this.members.add(member);
    }

    public void bindViewHolder(Member model){
        addMember(model);
        getTxtMemberName().setText(model.getName());
        String ministry = model.getMinistry().toString();
        getTxtMemberMinistry().setText(ministry);
        GlideApp.with(getContext())
                .load(model.getImgUrl())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS)
                .into(getImgMemberPic());

        Log.d(TAG, "onBindFlame: flame bound");
    }

    @Override
    public void onClick(View v) {
        Member selectedMember = members.get(getAdapterPosition());
        Intent toMemberInfoActivity = new Intent(this.context, MemberInfoActivity.class);
        toMemberInfoActivity.putExtra("name", selectedMember.getName());
        toMemberInfoActivity.putExtra("ministry", selectedMember.getMinistry().toString());
        this.context.startActivity(toMemberInfoActivity);
    }
}
