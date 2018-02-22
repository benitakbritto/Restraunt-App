package com.example.android.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void starterClickListener(View view) {
        Intent i = new Intent(this, StarterMenu.class);
        startActivity(i);
    }

    public void mainCourseClickListener(View view) {
        Intent i = new Intent(this, mainCourseMenu.class);
        startActivity(i);
    }

    public void dessertClickListener(View view) {
        Intent i = new Intent(this, dessertMenu.class);
        startActivity(i);
    }
}
