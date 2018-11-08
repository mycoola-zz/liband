package com.liband.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;




public class IntentUtils {
    /*
    static String url;
    static Intent intent;


    public static void openFacebook(Context context, Object username) {
        url = "https://www.facebook.com/" + username;
        intent = getFacebookIntent(context, url);
        context.startActivity(intent);
    }

    public static void openTwitter(Context context, Object username) {
        intent = getTwitterIntent(context, String.valueOf(username));
        context.startActivity(intent);
    }

    public static void openInstagram(Context context, Object username) {
        openInstagramPage(context, String.valueOf(username));
    }

    public static Intent getFacebookIntent(Context context, String url) {

        PackageManager pm = context.getPackageManager();
        Uri uri = Uri.parse(url);

        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {

        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public static Intent getTwitterIntent(Context context, String username) {

        intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/" + username));

        return intent;
    }

    public static void openInstagramPage(Context context, String username) {
        Uri uri = Uri.parse("http://instagram.com/_u/" + username);
        intent = new Intent(Intent.ACTION_VIEW, uri);

        intent.setPackage("com.instagram.android");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/" + username)));
        }
    }
    */

    private static void openWebPage(Activity activity, String url) {
        try {
            Uri webpage = Uri.parse(url);
            Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
            activity.startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, "No application can handle this request.",  Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public static void openFacebook(Activity activity, String username) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + username));
            activity.startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            openWebPage(activity, "https://www.facebook.com/" + username);
            e.printStackTrace();
        }
    }

    public static void openInstagram(Activity activity, String username) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("instagram://user?username=" + username));
            activity.startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            openWebPage(activity, "https://instagram.com/" + username);
            e.printStackTrace();
        }
    }

    public static void openTwitter(Activity activity, String username) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + username));
            activity.startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            openWebPage(activity, "https://twitter.com/" + username);
            e.printStackTrace();
        }
    }
}
