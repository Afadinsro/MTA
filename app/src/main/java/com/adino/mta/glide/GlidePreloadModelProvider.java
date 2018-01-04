package com.adino.mta.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;

import java.util.List;

/**
 * Created by afadinsro on 1/4/18.
 */

@GlideModule
public class GlidePreloadModelProvider extends AppGlideModule implements ListPreloader.PreloadModelProvider {
    private Context context;

    public GlidePreloadModelProvider(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public List getPreloadItems(int position) {
        return null;
    }

    @Nullable
    @Override
    public RequestBuilder<?> getPreloadRequestBuilder(Object item) {
        String url = (String)item;

        return null;
    }
}
