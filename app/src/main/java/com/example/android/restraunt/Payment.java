package com.example.android.restraunt;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        TextView cash = (TextView) findViewById(R.id.cash);
        if (cash != null) {
            cash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Payment.this, Feedback.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), "Payment done by Cash", Toast.LENGTH_SHORT).show();
                }
            });
        }

        TextView credit = (TextView) findViewById(R.id.credit);
        if (credit != null) {
            credit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pageIntent = new Intent(Payment.this, verify_payment.class);
                    startActivity(pageIntent);
                }
            });
        }


        TextView net = (TextView) findViewById(R.id.net);

        if (net != null) {
            net.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pageIntent = new Intent(Payment.this, verify_payment.class);
                    startActivity(pageIntent);
                }
            });
        }

        TextView debit = (TextView) findViewById(R.id.debit);
        if (debit != null) {
            debit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pageIntent = new Intent(Payment.this, verify_payment.class);
                    startActivity(pageIntent);
                }
            });
        }
    }
}
