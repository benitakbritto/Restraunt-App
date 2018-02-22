package com.example.android.restraunt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class TableBooking extends AppCompatActivity {
    Button chosenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booking);

        Button tableButton;
        int a, b;
        a = new Random().nextInt(9);
        while (a != 0) {
            b = new Random().nextInt(9);
            switch (b) {
                case 1:
                    tableButton = (Button) findViewById(R.id.A1);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 2:
                    tableButton = (Button) findViewById(R.id.A2);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 3:
                    tableButton = (Button) findViewById(R.id.A3);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;


                case 4:
                    tableButton = (Button) findViewById(R.id.B1);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 5:
                    tableButton = (Button) findViewById(R.id.B2);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 6:
                    tableButton = (Button) findViewById(R.id.B3);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;


                case 7:
                    tableButton = (Button) findViewById(R.id.C1);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 8:
                    tableButton = (Button) findViewById(R.id.C2);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

                case 9:
                    tableButton = (Button) findViewById(R.id.C3);
                    tableButton.setEnabled(false);
                    tableButton.setBackgroundColor(Color.RED);
                    break;

            }
            --a;
        }
    }

    public void onClickA1(View view) {
        chosenButton = (Button) findViewById(R.id.A1);
        if (chosenButton.isEnabled())

            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }

    public void onClickA2(View view) {
        chosenButton = (Button) findViewById(R.id.A2);
        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void onClickA3(View view) {
        chosenButton = (Button) findViewById(R.id.A3);
        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }

    public void onClickB1(View view) {
        chosenButton = (Button) findViewById(R.id.B1);
        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void onClickB2(View view) {
        chosenButton = (Button) findViewById(R.id.B2);

        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void onClickB3(View view) {
        chosenButton = (Button) findViewById(R.id.B3);

        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void onClickC1(View view) {
        chosenButton = (Button) findViewById(R.id.C1);

        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }

    public void onClickC2(View view) {
        chosenButton = (Button) findViewById(R.id.C2);

        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void onClickC3(View view) {
        chosenButton = (Button) findViewById(R.id.C3);

        if (chosenButton.isEnabled())
            chosenButton.setBackgroundColor(Color.GREEN);
        chosenButton.setEnabled(true);
        Toast.makeText(getBaseContext(), "Table has been selected.Proceed to the table.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }


}
