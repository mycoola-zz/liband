package com.libandexample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(v -> {
            Intent intent = new Intent("com.intsig.camscanner.ACTION_SCAN");
            // Or content uri picked from gallery

            Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath() + "/source.jpg"));
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.putExtra("scanned_image", Environment.getExternalStorageDirectory().getPath() + "/source.jpg");
//                intent.putExtra("pdf_path", Environment.getExternalStorageDirectory().getPath() + "/source.jpg");
//                intent.putExtra("org_image", Environment.getExternalStorageDirectory().getPath() + "/source.jpg");
            startActivityForResult(intent, 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            int responseCode = data.getIntExtra("RESULT_OK", -1);
            if (requestCode == Activity.RESULT_OK) {
                Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(imageBitmap);
            } else if (resultCode == Activity.RESULT_FIRST_USER) {
                // Fail
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // User canceled
            }
        }
    }
}
