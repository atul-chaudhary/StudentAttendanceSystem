package com.example.atulchaudhary.studentattendancesystem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;

import io.github.armcha.coloredshadow.ShadowImageView;


public class MainActivity extends AppCompatActivity {

    CameraView cameraView;
    ImageView previewImage;
    ShadowImageView retakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = (CameraView) findViewById(R.id.camera);
        ImageView cross = (ImageView) findViewById(R.id.cross);
        final ImageView arrow = (ImageView) findViewById(R.id.arrow);
        final ImageView clickButton = (ImageView) findViewById(R.id.clickButton);
        previewImage = (ImageView) findViewById(R.id.previewImage);
        retakeButton = (ShadowImageView) findViewById(R.id.retakeButton1);

        retakeButton.setVisibility(View.INVISIBLE);
        arrow.setEnabled(false);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cameraView.capturePicture();
                clickButton.setEnabled(false);
                arrow.setImageResource(R.drawable.blackarrow);
                retakeButton.setVisibility(View.VISIBLE);
                arrow.setEnabled(true);

            }
        });


        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onCameraOpened(CameraOptions options) {
                super.onCameraOpened(options);
            }

            @Override
            public void onPictureTaken(byte[] data) {
                super.onPictureTaken(data);

               // retakeButton.setVisibility(View.VISIBLE);
                Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                previewImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, previewImage.getWidth(), previewImage.getHeight(), false));
                previewImage.setVisibility(View.VISIBLE);

                cameraView.setVisibility(View.GONE);
                retakeButton.setVisibility(View.VISIBLE);


            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudentCountActivity.class);
                startActivity(intent);

            }
        });

        retakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                previewImage.setVisibility(View.INVISIBLE);
                cameraView.setVisibility(View.VISIBLE);
                clickButton.setEnabled(true);
                retakeButton.setVisibility(View.INVISIBLE);
                arrow.setImageResource(R.drawable.arrow);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraView.destroy();
    }
}
