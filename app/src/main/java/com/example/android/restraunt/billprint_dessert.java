package com.example.android.restraunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.restraunt.dessertMenu.checkedInfod;

class MyCustomAdapterD extends ArrayAdapter<dessert_info> {

    ArrayList<dessert_info> checkedList;


    public MyCustomAdapterD(Context context, int imageViewResourceId,
                            ArrayList<dessert_info> checkedList) {
        super(context, imageViewResourceId, checkedList);
        this.checkedList = new ArrayList<>();
        this.checkedList.addAll(checkedList);
    }

    private class ViewHolder {

        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyCustomAdapterD.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.billprint_dessert_row, null);
        }
        holder = new MyCustomAdapterD.ViewHolder();
        holder.img = (ImageView) convertView.findViewById(R.id.image);
        convertView.setTag(holder);
        dessert_info checkedList = checkedInfod.get(position);
        holder.img.setImageResource(checkedList.getImgid());

        return convertView;

    }

}

public class billprint_dessert extends Activity {
    static public int grandTotald = 0;
    MyCustomAdapterD dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billprint_dessert);

        displayListView();
        getGrandTotal();
        TextView grandTotal = (TextView) findViewById(R.id.grandTotal);
        grandTotal.setText("Total for Dessert: " + getGrandTotal());

    }

    @Override
    public void onBackPressed() {
    }

   /* @Override
    protected void onStop() {
        super.onStop();
        for (int i = 0; i < checkedInfod.size(); i++)
            checkedInfod.remove(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < checkedInfod.size(); i++)
            checkedInfod.remove(i);
    }*/

    public int getGrandTotal() {
        grandTotald = 0;
        for (int i = 0; i < checkedInfod.size(); i++)
            grandTotald += checkedInfod.get(i).price;
        return grandTotald;

    }

    public void displayListView() {
        ArrayList<dessert_info> checkedList = new ArrayList<>();
        for (int i = 0; i < checkedInfod.size(); i++) {
            dessert_info country = new dessert_info(checkedInfod.get(i).getImgid(), checkedInfod.get(i).isSelected(), checkedInfod.get(i).price, checkedInfod.get(i).getItem());
            checkedList.add(country);
        }

        dataAdapter = new MyCustomAdapterD(this,
                R.layout.billprint_dessert_row, checkedList);
        ListView listView = (ListView) findViewById(R.id.listView2);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

    }

    public void selectMoreClickListener(View view) {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }

    public void finalOrderClickListener(View view) {
        Intent intent = new Intent(this, finalOrder.class);
        startActivity(intent);
    }
}
