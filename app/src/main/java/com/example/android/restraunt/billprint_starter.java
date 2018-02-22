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

import static com.example.android.restraunt.StarterMenu.checkedInfos;


class MyCustomAdapterS extends ArrayAdapter<starter_info> {

    ArrayList<starter_info> checkedList;


    public MyCustomAdapterS(Context context, int imageViewResourceId,
                            ArrayList<starter_info> checkedList) {
        super(context, imageViewResourceId, checkedList);
        this.checkedList = new ArrayList<>();
        this.checkedList.addAll(checkedList);
    }

    private class ViewHolder {

        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyCustomAdapterS.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.billprint_starter_row, null);
        }
        holder = new MyCustomAdapterS.ViewHolder();
        holder.img = (ImageView) convertView.findViewById(R.id.image);
        convertView.setTag(holder);
        starter_info checkedList = checkedInfos.get(position);
        holder.img.setImageResource(checkedList.getImgid());

        return convertView;

    }

}


public class billprint_starter extends Activity {
    static public int grandTotalS = 0;
    MyCustomAdapterS dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billprint_starter);

        displayListView();
        getGrandTotal();
        TextView grandTotal = (TextView) findViewById(R.id.grandTotal);
        grandTotal.setText("Total for Starters: " + getGrandTotal());

    }

    @Override
    public void onBackPressed() {
    }
    /*
    @Override
    protected void onStop(){
        super.onStop();
        for(int i=0; i<checkedInfos.size(); i++)
            checkedInfos.remove(i);
    }
    @Override
    protected void onPause(){
        super.onPause();
        for(int i=0; i<checkedInfos.size(); i++)
            checkedInfos.remove(i);
    }*/

    public int getGrandTotal() {
        grandTotalS = 0;
        for (int i = 0; i < checkedInfos.size(); i++)
            grandTotalS += checkedInfos.get(i).price;
        return grandTotalS;

    }

    public void displayListView() {
        ArrayList<starter_info> checkedList = new ArrayList<>();
        for (int i = 0; i < checkedInfos.size(); i++) {
            starter_info country = new starter_info(checkedInfos.get(i).getImgid(), checkedInfos.get(i).isSelected(), checkedInfos.get(i).price, checkedInfos.get(i).getItem());
            checkedList.add(country);
        }

        dataAdapter = new MyCustomAdapterS(this,
                R.layout.billprint_starter_row, checkedList);
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

