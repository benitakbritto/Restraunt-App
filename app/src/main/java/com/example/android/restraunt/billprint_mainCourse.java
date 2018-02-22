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

import static com.example.android.restraunt.mainCourseMenu.checkedInfom;


class MyCustomAdapterM extends ArrayAdapter<mainCourse_info> {

    ArrayList<mainCourse_info> checkedList;


    public MyCustomAdapterM(Context context, int imageViewResourceId,
                            ArrayList<mainCourse_info> checkedList) {
        super(context, imageViewResourceId, checkedList);
        this.checkedList = new ArrayList<>();
        this.checkedList.addAll(checkedList);
    }

    private class ViewHolder {

        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyCustomAdapterM.ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.billprint_main_course_row, null);
        }
        holder = new MyCustomAdapterM.ViewHolder();
        holder.img = (ImageView) convertView.findViewById(R.id.image);
        convertView.setTag(holder);
        mainCourse_info checkedList = checkedInfom.get(position);
        holder.img.setImageResource(checkedList.getImgid());

        return convertView;

    }

}


public class billprint_mainCourse extends Activity {
    static public int grandTotalM = 0;
    MyCustomAdapterM dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billprint_main_course);

        displayListView();
        getGrandTotal();
        TextView grandTotal = (TextView) findViewById(R.id.grandTotal);
        grandTotal.setText("Total for Main Course: " + getGrandTotal());

    }

    @Override
    public void onBackPressed() {
    }

    /* @Override
     protected void onStop() {
         super.onStop();
         for (int i = 0; i < checkedInfom.size(); i++)
             checkedInfom.remove(i);
     }

     @Override
     protected void onPause() {
         super.onPause();
         for (int i = 0; i < checkedInfom.size(); i++)
             checkedInfom.remove(i);
     }
 */
    public int getGrandTotal() {
        grandTotalM = 0;
        for (int i = 0; i < checkedInfom.size(); i++)
            grandTotalM += checkedInfom.get(i).price;
        return grandTotalM;

    }

    public void displayListView() {
        ArrayList<mainCourse_info> checkedList = new ArrayList<>();
        for (int i = 0; i < checkedInfom.size(); i++) {
            mainCourse_info country = new mainCourse_info(checkedInfom.get(i).getImgid(), checkedInfom.get(i).isSelected(), checkedInfom.get(i).price, checkedInfom.get(i).getItem());
            checkedList.add(country);
        }

        dataAdapter = new MyCustomAdapterM(this,
                R.layout.billprint_main_course_row, checkedList);
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

