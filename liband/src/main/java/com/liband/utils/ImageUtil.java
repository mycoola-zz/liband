package com.liband.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class ImageUtil {

    public static void loadImageFromPicasso(final Context activity, final String imageUrl, final AppCompatImageView imageView, final AppCompatImageView placeholder) {

        if (!TextUtils.isEmpty(imageUrl)) {
            final Target target = new Target() {
                @Override
                public void onPrepareLoad(Drawable arg0) {
                    placeholder.setVisibility(View.VISIBLE);
                }

                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                    if (bitmap != null) {
                        //imageView.setBackground(new BitmapDrawable(activity.getResources(), bitmap));
                        imageView.setImageBitmap(bitmap);
                        placeholder.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onBitmapFailed(Drawable arg0) {
                    placeholder.setVisibility(View.VISIBLE);
                }
            };
            imageView.setTag(target);
            Picasso.with(activity).load(imageUrl).
                    into(target);
        } else {
            placeholder.setVisibility(View.VISIBLE);
        }
    }

}
