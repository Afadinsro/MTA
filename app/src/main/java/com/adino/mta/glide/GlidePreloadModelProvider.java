package com.adino.mta.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.adino.mta.MainActivity;
import com.adino.mta.R;
import com.adino.mta.models.Bacenta;
import com.adino.mta.bacenta.BacentasActivity;
import com.adino.mta.models.Center;
import com.adino.mta.models.Flame;
import com.adino.mta.models.Member;
import com.adino.mta.member.MembersActivity;
import com.adino.mta.town.TownCentersActivity;
import com.adino.mta.uni.UniCentersActivity;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.adino.mta.util.Constants.IMAGE_HEIGHT_PIXELS;
import static com.adino.mta.util.Constants.IMAGE_WIDTH_PIXELS;

/**
 * Created by afadinsro on 1/4/18.
 */

public class GlidePreloadModelProvider implements ListPreloader.PreloadModelProvider {
    private Context context;
    private ArrayList<Flame> flames;
    private ArrayList<Member> members;
    private ArrayList<Bacenta> bacentas;
    private ArrayList<Center> centers;

    private static final String TAG = "GPreloadModelProvider";

    public GlidePreloadModelProvider(Context context, ArrayList<Object> objects){
        this.context = context;
        for (Object object: objects) {
            if(this.context.getClass() == MainActivity.class) {
                flames.add((Flame) object);
            }else if(this.context.getClass() == MembersActivity.class) {
                members.add((Member) object);
            }else if(this.context.getClass() == UniCentersActivity.class ||
                    this.context.getClass() == TownCentersActivity.class) {
                centers.add((Center) object);
            }else if(this.context.getClass() == BacentasActivity.class) {
                if(this.context.getClass() == null)
                bacentas.add((Bacenta) object);


            }
        }

    }
    @NonNull
    @Override
    public List getPreloadItems(int position) {
        return flames.subList(position, position + 1);
    }

    @Nullable
    @Override
    public RequestBuilder<?> getPreloadRequestBuilder(Object item) {
        Flame current = (Flame)item;
        String url = current.getImgUrl();
        Log.d(TAG, "getPreloadRequestBuilder: " + url);
        return GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS);
    }
}
