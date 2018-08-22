package com.login_signup_screendesign_demo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;
import java.io.File;
import android.os.Environment;

public class TemparyActitvity extends AppCompatActivity implements View.OnClickListener {
    public Button btnCam;
    public Button btnVideo;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    static final int ID_ACT_CAMERA = 20001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempary_actitvity);
        btnCam = (Button) findViewById(R.id.BtnCamCheck);
        btnVideo = (Button) findViewById(R.id.BtnStartVideo);

         btnCam.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btnCam) {
            Intent cameraIntent = new Intent
                    (MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, ID_ACT_CAMERA);
        } else if (v == btnVideo) {
            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);

            }
        }

    }
}

