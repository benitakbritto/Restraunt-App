package com.example.android.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int mFlipping = 0; // Initially flipping is off
        Button mButton; // Reference to button available in the layout to start and stop the flipper
        final ViewFlipper flipper;

        flipper = (ViewFlipper) findViewById(R.id.flipper1);


        /** Start Flipping */
        flipper.startFlipping();
        mFlipping = 1;

        Button nextButton = (Button) findViewById(R.id.next);
        if (nextButton != null) {
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    flipper.stopFlipping();

                    Intent nextButtonIntent = new Intent(MainActivity.this, login.class);
                    startActivity(nextButtonIntent);
                }
            });
        }
    }

}

