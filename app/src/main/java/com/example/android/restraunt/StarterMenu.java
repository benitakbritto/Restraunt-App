package com.example.android.restraunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class StarterMenu extends Activity {

    MyCustomAdapter dataAdapter = null;
    static ArrayList<starter_info> checkedInfos = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_menu);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < checkedInfos.size(); i++)
            checkedInfos.remove(i);
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<starter_info> starterList = new ArrayList<>();
        starter_info country = new starter_info(R.drawable.soup_1, false, 600, "Roasted Tomato Soup");
        starterList.add(country);
        country = new starter_info(R.drawable.soup_2, false, 600, "Bhune hue Bhutte and Gajar ka Shorba");
        starterList.add(country);
        country = new starter_info(R.drawable.app_1, false, 900, "Spinach and Lentil Soup");
        starterList.add(country);
        country = new starter_info(R.drawable.app_2, false, 650, "Sprout Salad");
        starterList.add(country);
        country = new starter_info(R.drawable.app_3, false, 1000, "Vegetarian Sushi Assortment");
        starterList.add(country);


        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.starter_row, starterList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                starter_info country = (starter_info) parent.getItemAtPosition(position);

            }
        });

    }

    public class MyCustomAdapter extends ArrayAdapter<starter_info> {

        private ArrayList<starter_info> starterList;


        public MyCustomAdapter(Context context, int imageViewResourceId,
                               ArrayList<starter_info> starterList) {
            super(context, imageViewResourceId, starterList);
            this.starterList = new ArrayList<>();
            this.starterList.addAll(starterList);
        }

        private class ViewHolder {

            CheckBox name;
            ImageView img;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.starter_row, null);

                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                holder.img = (ImageView) convertView.findViewById(R.id.image);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        starter_info country = (starter_info) cb.getTag();

                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            starter_info country = starterList.get(position);
            holder.name.setText(country.getName());
            holder.img.setImageResource(country.getImgid());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);


            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                ArrayList<starter_info> starterList = dataAdapter.starterList;
                for (int i = 0; i < starterList.size(); i++) {
                    starter_info country = starterList.get(i);
                    if (country.isSelected()) {

                        checkedInfos.add(starterList.get(i));

                    }
                }


                Intent i = new Intent(StarterMenu.this, billprint_starter.class);
                startActivity(i);


            }
        });

    }

}
