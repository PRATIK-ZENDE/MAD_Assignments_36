package com.example.assignmenthub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class IseActivity extends AppCompatActivity {

    private ImageView image;

    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getData() != null && result.getData().getExtras() != null) {
                    Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                    image.setImageBitmap(photo);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise);

        image = findViewById(R.id.imageCapture);
        RatingBar ratingBar = findViewById(R.id.ratingIse);
        TextView feedback = findViewById(R.id.txtIseFeedback);
        Button capture = findViewById(R.id.btnCapture);
        Button submitRating = findViewById(R.id.btnRate);

        capture.setOnClickListener(v -> cameraLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));

        submitRating.setOnClickListener(v -> {
            feedback.setText("Rating submitted: " + ratingBar.getRating());
            ratingBar.setRating(0F);
        });
    }
}
