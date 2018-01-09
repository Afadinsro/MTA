package com.adino.mta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adino.mta.glide.GlideApp;
import com.adino.mta.models.Flame;
import com.adino.mta.town.TownCentersActivity;
import com.adino.mta.uncles_aunties.HighSchoolsActivity;
import com.adino.mta.uni.UniCentersActivity;

import java.util.ArrayList;

import static com.adino.mta.util.Constants.IMAGE_HEIGHT_PIXELS;
import static com.adino.mta.util.Constants.IMAGE_WIDTH_PIXELS;

/**
 * Created by afadinsro on 1/8/18.
 */

public class FlameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * For Flames (MainActivity)
     */
    private CardView cvFlame;
    private ImageView imgFlamePic;
    private TextView txtFlameName;
    private TextView txtFlameNumBranches;

    private Context context;
    private ArrayList<Flame> flames;
    private static final String TAG = "FlameViewHolder";


    public FlameViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        cvFlame = (CardView)itemView.findViewById(R.id.cv_flame);
        imgFlamePic = (ImageView)itemView.findViewById(R.id.img_flame_pic);
        txtFlameName = (TextView)itemView.findViewById(R.id.txt_flame_name);
        txtFlameNumBranches = (TextView)itemView.findViewById(R.id.txt_flame_num_branches);
        setContext(context);
        flames = new ArrayList<>();
    }

    public ImageView getImgFlamePic() {
        return imgFlamePic;
    }

    public TextView getTxtFlameName() {
        return txtFlameName;
    }

    public TextView getTxtFlameNumBranches() {
        return txtFlameNumBranches;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void addFlame(Flame flame){
        this.flames.add(flame);
    }

    public void bindViewHolder(Flame model){
        addFlame(model);
        getTxtFlameName().setText(model.getName());
        String num_branches = "" + (model.getNumBranches());
        getTxtFlameNumBranches().setText(num_branches);
        GlideApp.with(getContext())
                .load(model.getImgUrl())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS)
                .into(getImgFlamePic());

        Log.d(TAG, "onBindFlame: flame bound");
    }

    @Override
    public void onClick(View v) {
        Flame selectedFlame = flames.get(getAdapterPosition());
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
}
