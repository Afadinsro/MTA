package com.adino.mta.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.adino.mta.R;
import com.adino.mta.flame.Flame;
import com.bumptech.glide.Glide;
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
                .load(url)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_broken_image)
                .fallback(R.drawable.ic_person)
                .override(IMAGE_WIDTH_PIXELS, IMAGE_HEIGHT_PIXELS);
    }
}
