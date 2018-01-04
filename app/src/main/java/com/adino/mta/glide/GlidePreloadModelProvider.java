package com.adino.mta.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.adino.mta.flame.Flame;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by afadinsro on 1/4/18.
 */

public class GlidePreloadModelProvider implements ListPreloader.PreloadModelProvider {
    private Context context;
    private ArrayList<Flame> flames;

    public GlidePreloadModelProvider(Context context, ArrayList<Flame> flames){
        this.context = context;
        this.flames = flames;
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
        return GlideApp.with(context)
                .load(url);
    }
}
