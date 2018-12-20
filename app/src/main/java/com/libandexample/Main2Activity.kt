package com.libandexample

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageView

import java.io.File


class Main2Activity : Activity() {
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.button)
        imageView = findViewById(R.id.imageView)
        button.setOnClickListener {
            val intent = Intent("com.intsig.camscanner.ACTION_SCAN")
            // Or content uri picked from gallery

            val uri = Uri.fromFile(File(Environment.getExternalStorageDirectory().path + "/source.jpg"))
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.putExtra("scanned_image", Environment.getExternalStorageDirectory().path + "/source.jpg")
            //                intent.putExtra("pdf_path", Environment.getExternalStorageDirectory().getPath() + "/source.jpg");
            //                intent.putExtra("org_image", Environment.getExternalStorageDirectory().getPath() + "/source.jpg");
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            data!!.getIntExtra("RESULT_OK", -1)
            if (resultCode == Activity.RESULT_FIRST_USER) {
                // Fail
            }
        }
    }
}
