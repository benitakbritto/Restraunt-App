package com.example.android.restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.restraunt.StarterMenu.checkedInfos;
import static com.example.android.restraunt.billprint_dessert.grandTotald;
import static com.example.android.restraunt.billprint_mainCourse.grandTotalM;
import static com.example.android.restraunt.billprint_starter.grandTotalS;
import static com.example.android.restraunt.dessertMenu.checkedInfod;
import static com.example.android.restraunt.mainCourseMenu.checkedInfom;

public class finalOrder extends AppCompatActivity {
    static ArrayList<String> checkedInfoF = new ArrayList<>();
    int subTotal = 0;
    double Tax = 0;
    double grandTotalF = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order);

        for (int i = 0; i < checkedInfos.size(); i++)
            checkedInfoF.add(checkedInfos.get(i).getItem());


        for (int i = 0; i < checkedInfom.size(); i++)
            checkedInfoF.add(checkedInfom.get(i).getItem());

        for (int i = 0; i < checkedInfod.size(); i++)
            checkedInfoF.add(checkedInfod.get(i).getItem());
        displayListView();

        TextView subTotal = (TextView) findViewById(R.id.subTotal);
        subTotal.setText("Sub Total:" + displaySubTotal());

        TextView tax = (TextView) findViewById(R.id.tax);
        tax.setText("Tax:" + displayTax());
        TextView grandTotal = (TextView) findViewById(R.id.grandTotal);
        grandTotal.setText("Grand Total:" + displayGrandTotalF());


    }


    public void displayListView() {

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, checkedInfoF);

        ListView listView = (ListView) findViewById(R.id.listt);
        listView.setAdapter(itemsAdapter);
    }

    public void proceedPayment(View v) {

        if (grandTotalF == 0.0) {
            Toast.makeText(getBaseContext(), "Redirecting to first page", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else {

            Intent i = new Intent(this, Payment.class);
            startActivity(i);
        }
    }

    public int displaySubTotal() {
        subTotal = 0;
        subTotal = grandTotalS + grandTotalM + grandTotald;
        return subTotal;
    }

    public double displayTax() {
        Tax = subTotal * 0.18;
        return Tax;
    }

    public double displayGrandTotalF() {
        grandTotalF = Tax + subTotal;
        return grandTotalF;
    }

}


