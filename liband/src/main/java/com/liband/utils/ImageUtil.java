package com.liband.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.liband.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;


public class ImageUtil {

    public static void loadImageFromPicasso(final Context activity, final String imageUrl,
                                            final AppCompatImageView imageView) {

        if (!TextUtils.isEmpty(imageUrl)) {
            final Target target = new Target() {
                @Override
                public void onPrepareLoad(Drawable arg0) {
                    imageView.setBackgroundDrawable(activity.getDrawable(R.drawable.safe_image));
                }

                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }

                @Override
                public void onBitmapFailed(Drawable arg0) {
                    imageView.setBackgroundDrawable(activity.getDrawable(R.drawable.safe_image));
                }
            };
            imageView.setTag(target);
            Picasso.with(activity).load(imageUrl).
                    into(target);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }
    }


    public static BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }



}
