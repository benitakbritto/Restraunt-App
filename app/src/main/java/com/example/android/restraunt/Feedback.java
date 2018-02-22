package com.example.android.restraunt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;


public class Feedback extends AppCompatActivity {

    private RatingBar ratingBar;

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        //addListenerOnRatingBar();
        //addListenerOnButton();

        TextView submit = (TextView) findViewById(R.id.btnSubmit);
        if (submit != null) {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(Feedback.this, R.raw.thankyou);
                    mediaPlayer.start();
                    Intent pageIntent = new Intent(Feedback.this, MainActivity.class);
                    startActivity(pageIntent);
                }
            });
        }

        Button send = (Button) findViewById(R.id.send);
        if (send != null) {
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "shravanisawant19@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Share your experience with us.");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
            });
        }


    }


}

